package drawLab;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 * Created by Олег on 01.11.2014.
 */
public class GraphicsDisplay extends JPanel {

    private Double[][] graphicsData;
    private Double[][] graphicsData1;
    //ArrayList<Double> graphicsData = new ArrayList<Double>();

    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double scale;

    private boolean showAxis = true;
    private boolean showMarkers = true;
    private boolean rotate90 = false;

    private boolean showAxis1 = true;
    private boolean showMarkers1 = true;
    private boolean rotate901 = false;

    private Font axisFont;
    BasicStroke axisStroke;
    BasicStroke markerStroke;
    BasicStroke graphicsStroke;

    public GraphicsDisplay() {
        setBackground(Color.WHITE);
        graphicsStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{3, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1}, 0.0f);
        axisStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        markerStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        axisFont = new Font("Serif", Font.BOLD, 36);
    }

    public void showGraphics(Double[][] graphicsData) {
        this.graphicsData = graphicsData;
        repaint();
    }

    public void setShowAxis(boolean showAxis) {
        this.showAxis = showAxis;
        repaint();
    }

    public void setShowMarkers(boolean showMarkers) {
        this.showMarkers = showMarkers;
        repaint();
    }
///////
    public void showGraphics1(Double[][] graphicsData1) {
        this.graphicsData1 = graphicsData1;
        repaint();
    }

    public void setShowAxis1(boolean showAxis1) {
        this.showAxis1 = showAxis1;
        repaint();
    }

    public void setShowMarkers1(boolean showMarkers1) {
        this.showMarkers1 = showMarkers1;
        repaint();
    }

    protected Point2D.Double xyToPoint(double x, double y) {
        double deltaX = x - minX;
        double deltaY = maxY - y;
        return new Point2D.Double(deltaX * scale, deltaY * scale);
    }

    protected Point2D.Double shiftPoint(Point2D.Double src, double deltaX, double deltaY) {
        Point2D.Double dest = new Point2D.Double();
        dest.setLocation(src.getX() + deltaX, src.getY() + deltaY);
        return dest;
    }

    public void rotate() {
        for (int i = 0; i < this.graphicsData.length; i++) {
            Double tmp0 = this.graphicsData[i][0];
            Double tmp1 = this.graphicsData[i][1];
            this.graphicsData[i][0] = -tmp1;
            this.graphicsData[i][1] = tmp0;
        }
        repaint();
    }

    public void rotateBack() {
        for (int i = 0; i < this.graphicsData.length; i++) {
            Double tmp0 = this.graphicsData[i][0];
            Double tmp1 = this.graphicsData[i][1];
            this.graphicsData[i][0] = tmp1;
            this.graphicsData[i][1] = -tmp0;
        }
        repaint();
    }

    public void rotate1() {
        for (int i = 0; i < this.graphicsData1.length; i++) {
            Double tmp0 = this.graphicsData1[i][0];
            Double tmp1 = this.graphicsData1[i][1];
            this.graphicsData1[i][0] = -tmp1;
            this.graphicsData1[i][1] = tmp0;
        }
        repaint();
    }

    public void rotateBack1() {
        for (int i = 0; i < this.graphicsData1.length; i++) {
            Double tmp0 = this.graphicsData1[i][0];
            Double tmp1 = this.graphicsData1[i][1];
            this.graphicsData1[i][0] = tmp1;
            this.graphicsData1[i][1] = -tmp0;
        }
        repaint();
    }

    protected void paintGraphics(Graphics2D canvas) {
        canvas.setStroke(graphicsStroke);
        canvas.setColor(Color.RED);
        GeneralPath graphics = new GeneralPath();
        for (int i = 0; i < graphicsData.length; i++) {
            Point2D.Double point = xyToPoint(graphicsData[i][0], graphicsData[i][1]);
            /*if (rotate90) point = rotate90Point(point);*/
            if (i > 0) {
                graphics.lineTo(point.getX(), point.getY());
            } else {
                graphics.moveTo(point.getX(), point.getY());
            }
        }
        canvas.draw(graphics);
    }

    protected void paintGraphics1(Graphics2D canvas) {
        canvas.setStroke(graphicsStroke);
        canvas.setColor(Color.BLACK);
        GeneralPath graphics1 = new GeneralPath();
        for (int i = 0; i < graphicsData1.length; i++) {
            Point2D.Double point1 = xyToPoint(graphicsData1[i][0], graphicsData1[i][1]);
            /*if (rotate90) point = rotate90Point(point);*/
            if (i > 0) {
                graphics1.lineTo(point1.getX(), point1.getY());
            } else {
                graphics1.moveTo(point1.getX(), point1.getY());
            }
        }
        canvas.draw(graphics1);
    }

    protected void paintAxis(Graphics2D canvas) {
        canvas.setStroke(axisStroke);
        canvas.setColor(Color.BLACK);
        canvas.setPaint(Color.BLACK);
        canvas.setFont(axisFont);
        FontRenderContext context = canvas.getFontRenderContext();
        if (minX <= 0.0 && maxX >= 0.0) {
            canvas.draw(new Line2D.Double(xyToPoint(0, maxY), xyToPoint(0, minY)));
            GeneralPath arrow = new GeneralPath();
            Point2D.Double lineEnd = xyToPoint(0, maxY);
            arrow.moveTo(lineEnd.getX(), lineEnd.getY());
            arrow.lineTo(arrow.getCurrentPoint().getX() + 5, arrow.getCurrentPoint().getY() + 20);
            arrow.lineTo(arrow.getCurrentPoint().getX() - 10, arrow.getCurrentPoint().getY());
            arrow.closePath();
            canvas.draw(arrow);
            canvas.fill(arrow);
            Rectangle2D bounds = axisFont.getStringBounds("y", context);
            Point2D.Double labelPos = xyToPoint(0, maxY);
            canvas.drawString("y", (float) labelPos.getX() + 10, (float) (labelPos.getY() - bounds.getY()));
        }
        if (minY <= 0.0 && maxY >= 0.0) {
            canvas.draw(new Line2D.Double(xyToPoint(minX, 0), xyToPoint(maxX, 0)));
            GeneralPath arrow = new GeneralPath();
            Point2D.Double lineEnd = xyToPoint(maxX, 0);
            arrow.moveTo(lineEnd.getX(), lineEnd.getY());
            arrow.lineTo(arrow.getCurrentPoint().getX() - 20, arrow.getCurrentPoint().getY() - 5);
            arrow.lineTo(arrow.getCurrentPoint().getX(), arrow.getCurrentPoint().getY() + 10);
            arrow.closePath();
            canvas.draw(arrow);
            canvas.fill(arrow);
            Rectangle2D bounds = axisFont.getStringBounds("x", context);
            Point2D.Double labelPos = xyToPoint(maxX, 0);
            canvas.drawString("x", (float) (labelPos.getX() - bounds.getWidth() - 10), (float) (labelPos.getY() + bounds.getY()));
        }

    }

    public boolean isRotate90() {
        return rotate90;
    }

    public boolean isRotate901() {
        return rotate901;
    }

    protected void paintMarkers(Graphics2D canvas) {
        canvas.setStroke(markerStroke);

        canvas.setColor(Color.RED);
        canvas.setPaint(Color.RED);
        for (Double[] point : graphicsData) {
            if (Math.round(point[1]) <= 10) {
                canvas.setColor(Color.GREEN);
            } else canvas.setColor(Color.RED);
            Ellipse2D.Double marker = new Ellipse2D.Double();
            Point2D.Double center = xyToPoint(point[0]/*x*/, point[1]/*y*/);
            Point2D.Double corner = shiftPoint(center, 11, 11);

            marker.setFrameFromCenter(center, corner);

            Point2D.Double xPlusY = shiftPoint(center, 11, 0);
            Point2D.Double xMinusY = shiftPoint(center, -11, 0);
            Point2D.Double yPlusX = shiftPoint(center, 0, 11);
            Point2D.Double yMinusX = shiftPoint(center, 0, -11);
            canvas.draw(marker);

            GeneralPath arrow = new GeneralPath();
            arrow.moveTo(xPlusY.getX(), xPlusY.getY());
            arrow.lineTo(xMinusY.getX(), xPlusY.getY());
            arrow.moveTo(yPlusX.getX(), yPlusX.getY());
            arrow.lineTo(yMinusX.getX(), yMinusX.getY());
            arrow.closePath();
            canvas.draw(arrow);

        }
    }

    protected void paintMarkers1(Graphics2D canvas) {
        canvas.setStroke(markerStroke);

        canvas.setColor(Color.BLACK);
        canvas.setPaint(Color.BLACK);
        for (Double[] point : graphicsData1) {
            if (Math.round(point[1]) <= 10) {
                canvas.setColor(Color.GREEN);
            } else canvas.setColor(Color.BLACK);
            Ellipse2D.Double marker = new Ellipse2D.Double();
            Point2D.Double center = xyToPoint(point[0]/*x*/, point[1]/*y*/);
            Point2D.Double corner = shiftPoint(center, 11, 11);
            marker.setFrameFromCenter(center, corner);

            Point2D.Double xPlusY = shiftPoint(center, 11, 0);
            Point2D.Double xMinusY = shiftPoint(center, -11, 0);
            Point2D.Double yPlusX = shiftPoint(center, 0, 11);
            Point2D.Double yMinusX = shiftPoint(center, 0, -11);

            canvas.draw(marker);

            GeneralPath arrow = new GeneralPath();
            arrow.moveTo(xPlusY.getX(), xPlusY.getY());
            arrow.lineTo(xMinusY.getX(), xPlusY.getY());
            arrow.moveTo(yPlusX.getX(), yPlusX.getY());
            arrow.lineTo(yMinusX.getX(), yMinusX.getY());
            arrow.closePath();
            canvas.draw(arrow);

        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ((graphicsData == null) && (graphicsData1 == null))
            return;

        if ((graphicsData != null) && (graphicsData1 == null)) {
            minX = graphicsData[0][0];
            maxX = minX;
            minY = graphicsData[0][1];
            maxY = minY;
            for (int i = 1; i < graphicsData.length; i++) {
                if (graphicsData[i][0] < minX) {
                    minX = graphicsData[i][0];
                }
                if (graphicsData[i][1] < minY) {
                    minY = graphicsData[i][1];
                }
                if (graphicsData[i][0] > maxX) {
                    maxX = graphicsData[i][0];
                }
                if (graphicsData[i][1] > maxY) {
                    maxY = graphicsData[i][1];
                }
            }
        } else if ((graphicsData == null) && (graphicsData1 != null)) {
            minX = graphicsData1[0][0];
            maxX = minX;
            minY = graphicsData1[0][1];
            maxY = minY;
            for (int i = 1; i < graphicsData1.length; i++) {
                if (graphicsData1[i][0] < minX) {
                    minX = graphicsData1[i][0];
                }
                if (graphicsData1[i][1] < minY) {
                    minY = graphicsData1[i][1];
                }
                if (graphicsData1[i][0] > maxX) {
                    maxX = graphicsData1[i][0];
                }
                if (graphicsData1[i][1] > maxY) {
                    maxY = graphicsData1[i][1];
                }
            }
        }
        else if ((graphicsData != null) && (graphicsData1 != null))
        {
            minX = graphicsData[0][0];
            maxX = minX;
            minY = graphicsData[0][1];
            maxY = minY;
            for (int i = 1; i < graphicsData.length; i++) {
                if (graphicsData[i][0] < minX) {
                    minX = graphicsData[i][0];
                }
                if (graphicsData[i][1] < minY) {
                    minY = graphicsData[i][1];
                }
                if (graphicsData[i][0] > maxX) {
                    maxX = graphicsData[i][0];
                }
                if (graphicsData[i][1] > maxY) {
                    maxY = graphicsData[i][1];
                }
            }
            for (int i = 1; i < graphicsData1.length; i++) {
                if (graphicsData1[i][0] < minX) {
                    minX = graphicsData1[i][0];
                }
                if (graphicsData1[i][1] < minY) {
                    minY = graphicsData1[i][1];
                }
                if (graphicsData1[i][0] > maxX) {
                    maxX = graphicsData1[i][0];
                }
                if (graphicsData1[i][1] > maxY) {
                    maxY = graphicsData1[i][1];
                }
            }
        }

        double scaleX = getSize().getWidth() / (maxX - minX);
        double scaleY = getSize().getHeight() / (maxY - minY);
        scale = Math.min(scaleX, scaleY);
        if (scale == scaleX) {
            double yIncrement = (getSize().getHeight() / scale - (maxY - minY)) / 2;
            maxY += yIncrement;
            minY -= yIncrement;
        }

        if (scale == scaleY) {
            double xIncrement = (getSize().getWidth() / scale - (maxX - minX)) / 2;
            maxX += xIncrement;
            minX -= xIncrement;
        }

        Graphics2D canvas = (Graphics2D) g;
        Stroke oldStroke = canvas.getStroke();
        Color oldColor = canvas.getColor();
        Paint oldPaint = canvas.getPaint();
        Font oldFont = canvas.getFont();
        if (showAxis || showAxis1) paintAxis(canvas);

        if (graphicsData != null) {
            paintGraphics(canvas);
        }
        if (graphicsData1 != null) {
            paintGraphics1(canvas);
        }

        if (showMarkers && graphicsData!=null) paintMarkers(canvas);
        if (showMarkers1 && graphicsData1!=null) paintMarkers1(canvas);
        canvas.setFont(oldFont);
        canvas.setPaint(oldPaint);
        canvas.setColor(oldColor);
        canvas.setStroke(oldStroke);
    }

    public void setRotate90(boolean rotate90) {
        this.rotate90 = rotate90;
    }

    public void setRotate901(boolean rotate901) {
        this.rotate901 = rotate901;
    }
}

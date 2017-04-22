package ImageConverter;

import org.apache.commons.cli.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by olegb on 17.09.2016 at 11:57 pm
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since JDK 1.6
 */
public class ImageConverter {

    private Options options = new Options();
    private CommandLine cmd;
    private BufferedImage bufferedImage;

    private ImageConverter(String[] args) {
        InitParser(this.options);


    }

    /**
     * Parse args, check they are fit requirements
     *
     * @param args args array from console to parse.
     * @throws ParseException if <code>args</code> didn't match
     *                        right option names and params
     * @throws IOException    if <code>args</code> contains wrong
     *                        format for input image or worn compression quality options.
     */
    private void ParseArgs(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();
        try {
            cmd = commandLineParser.parse(options, args);
            if (!this.IsSupportedFormat(this.cmd)) {
                throw new IOException(Messages.WRONG_FORMAT);
            }
            if (!this.IsSupportedQuality(this.cmd)) {
                throw new IOException(Messages.WRONG_QUALITY);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            helpFormatter.printHelp("Converter app", options);

            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());

            System.exit(1);
        }
    }

    /**
     * Loads image into bufferedImage variable
     *
     * @param cmd not null parsed <code>CommandLine</code> var,
     *            that contains converting options
     * @throws IOException if problems with <code>input</code> image occured
     */
    private void LoadImage(CommandLine cmd) {
        if (cmd != null) {
            try {
                bufferedImage = ImageIO.read(new File(cmd.getOptionValue(StringVarNames.filenameOptionName)));
            } catch (IOException e) {
                System.out.println(Messages.FILE_ERROR);

                System.exit(1);
            }
        } else {
            System.out.println(Messages.ERR_NULL_CMD);
            return;
        }
    }

    /**
     * Proceed converting with params
     *
     * @param cmd not null parsed <code>CommandLine</code> var,
     *            that contains converting options
     * @throws IOException if problems with <code>output</code> image occured.
     */
    private void ConvertImage(CommandLine cmd) {
        if (cmd != null) {
            File outputFile = new File(cmd.getOptionValue(StringVarNames.filenameOptionName).split("[.]")[0] +
                    "." + cmd.getOptionValue(StringVarNames.outputOptionName));

            Iterator iter = ImageIO.getImageWritersByFormatName(cmd.getOptionValue(StringVarNames.outputOptionName));
            if (iter.hasNext()) {
                ImageWriter writer = (ImageWriter) iter.next();
                ImageWriteParam iwp = writer.getDefaultWriteParam();
                if (iwp.canWriteCompressed()) {
                    iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

                    iwp.setCompressionQuality(Float.parseFloat(cmd.getOptionValue(StringVarNames.qualityOptionName)) / StringVarNames.maxCompressionSize);
                } else {
                    System.out.println("Compression isn't supported");
                }

                IIOImage iioImage = new IIOImage(bufferedImage, null, null);
                try {
                    ImageOutputStream imageOutputStream = new FileImageOutputStream(outputFile);
                    writer.setOutput(imageOutputStream);
                    writer.write(null, iioImage, iwp);

                    imageOutputStream.flush();
                    writer.dispose();
                    imageOutputStream.close();
                } catch (IOException e) {
                    System.out.println("troubles writing into file");
                }
            }
        } else {
            System.out.println(Messages.ERR_NULL_CMD);
        }
    }

    /**
     * Check if i\o formats aren't supported
     *
     * @param cmd not null parsed <code>CommandLine</code> var,
     *            that contains converting options
     * @return true, if i\o formats are supported by app
     */
    private boolean IsSupportedFormat(CommandLine cmd) {
        String filename = cmd.getOptionValue(StringVarNames.filenameOptionName);
        String outputFormat = cmd.getOptionValue(StringVarNames.outputOptionName);

        String[] temp = filename.split("[.]");
        if (temp.length > 1) {
            String patternString = "^.+\\.(png|jpg|JPG|jpeg|gif|bmp|wbmp){1,255}$";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(filename);
            if (!matcher.matches()) {
                System.out.println("input format: " + temp[1]);
                return false;
            }

            patternString = "^(png|jpg|JPG|jpeg|gif|bmp|wbmp)$";
            pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(outputFormat);
            if (!matcher.matches()) {
                return false;
            }
        } else {
            System.out.println(Messages.WARN_NO_FORMAT);
        }

        return true;
    }

    /**
     * Check if set quality is supported
     *
     * @param cmd not null parsed <code>CommandLine</code> var,
     *            that contains converting options
     * @return true, if quality is supported
     */
    private boolean IsSupportedQuality(CommandLine cmd) {
        float quality = (Float.parseFloat(cmd.getOptionValue(StringVarNames.qualityOptionName))) / StringVarNames.maxCompressionSize;
        return !(quality <= 0 || quality > StringVarNames.minCompressionSize);
    }

    /**
     * Initialise parse options
     *
     * @param options <code>Options</code> variable for saving parse options into it
     */
    private void InitParser(Options options) {

        Option outputOption = new Option("o", StringVarNames.outputOptionName, true, StringVarNames.outputOptionText);
        outputOption.setRequired(true);
        options.addOption(outputOption);

        Option filenameOption = new Option("f", StringVarNames.filenameOptionName, true, StringVarNames.getFilenameOptionText);
        filenameOption.setRequired(true);
        options.addOption(filenameOption);

        Option qualityOption = new Option("q", StringVarNames.qualityOptionName, true, StringVarNames.qualityOptionText);
        qualityOption.setRequired(false);
        options.addOption(qualityOption);
    }

    /**
     * Prints params values into console
     *
     * @param cmd not null parsed <code>CommandLine</code> var,
     *            that contains converting options
     */
    private void PrintParams(CommandLine cmd) {
        String outputFormatValue = cmd.getOptionValue(StringVarNames.outputOptionName);
        System.out.println("Output format: " + outputFormatValue);

        String filenameValue = cmd.getOptionValue(StringVarNames.filenameOptionName);
        System.out.println("Input file: " + filenameValue);

        String qualityValue = cmd.getOptionValue(StringVarNames.qualityOptionName);
        if (qualityValue != null) {
            System.out.println("Compression quality: " + qualityValue + " %");
        }

    }

    public static void main(String[] args) {
        ImageConverter imageConverter = new ImageConverter(args);
        imageConverter.ParseArgs(args);
        if (imageConverter.cmd != null) {
            imageConverter.LoadImage(imageConverter.cmd);
            imageConverter.ConvertImage(imageConverter.cmd);
        } else {
            System.out.println(Messages.ERR_NULL_CMD);
        }
        System.out.println("Done!");

    }


    private class StringVarNames {
        static final String outputOptionName = "output";
        static final String outputOptionText = "output format";

        static final String filenameOptionName = "filename";
        static final String getFilenameOptionText = "filename";

        static final String qualityOptionName = "quality";
        static final String qualityOptionText = "quality";

        static final float maxCompressionSize = 100f;
        static final float minCompressionSize = 1f;
    }

    private class NullCmdException extends Exception {

        public NullCmdException(){
            super(Messages.ERR_NULL_CMD);
        }

    }

}

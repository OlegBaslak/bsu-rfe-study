using Detectors;

namespace UserInterface
{
    partial class frmMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmMain));
            this.mainMenu = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.printToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.quitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.patientsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addPatientToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.patientsBaseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.medicalCheckupsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addNewMedicalCheckupToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItem = new System.Windows.Forms.ToolStripSeparator();
            this.medicalCheckupsBaseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.startMedicalCheckupToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutProgramToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.panel1 = new System.Windows.Forms.Panel();
            this.medicalChecupStatusPanel = new System.Windows.Forms.Panel();
            this.groupBoxStatusPatient = new System.Windows.Forms.GroupBox();
            this.groupBoxSensors = new System.Windows.Forms.GroupBox();
            this.panel3 = new System.Windows.Forms.Panel();
            this.portraitPanel = new System.Windows.Forms.Panel();
            this.labelDetector5 = new System.Windows.Forms.Label();
            this.labelDetector4 = new System.Windows.Forms.Label();
            this.labelDetector3 = new System.Windows.Forms.Label();
            this.labelDetector2 = new System.Windows.Forms.Label();
            this.labelDetector1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.detectorsInfoPanel = new System.Windows.Forms.Panel();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.button3 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.StatusBar = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel = new System.Windows.Forms.ToolStripStatusLabel();
            this.mainMenu.SuspendLayout();
            this.panel1.SuspendLayout();
            this.medicalChecupStatusPanel.SuspendLayout();
            this.groupBoxSensors.SuspendLayout();
            this.panel3.SuspendLayout();
            this.portraitPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.detectorsInfoPanel.SuspendLayout();
            this.panel2.SuspendLayout();
            this.StatusBar.SuspendLayout();
            this.SuspendLayout();
            // 
            // mainMenu
            // 
            this.mainMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.patientsToolStripMenuItem,
            this.medicalCheckupsToolStripMenuItem,
            this.helpToolStripMenuItem});
            this.mainMenu.Location = new System.Drawing.Point(0, 0);
            this.mainMenu.Name = "mainMenu";
            this.mainMenu.Size = new System.Drawing.Size(784, 24);
            this.mainMenu.TabIndex = 0;
            this.mainMenu.Text = "mainMenu";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.printToolStripMenuItem,
            this.quitToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(48, 20);
            this.fileToolStripMenuItem.Text = "Файл";
            // 
            // printToolStripMenuItem
            // 
            this.printToolStripMenuItem.Name = "printToolStripMenuItem";
            this.printToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.P)));
            this.printToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
            this.printToolStripMenuItem.Text = "Печать";
            // 
            // quitToolStripMenuItem
            // 
            this.quitToolStripMenuItem.Name = "quitToolStripMenuItem";
            this.quitToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.F4)));
            this.quitToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
            this.quitToolStripMenuItem.Text = "Выход";
            this.quitToolStripMenuItem.Click += new System.EventHandler(this.quitToolStripMenuItem_Click);
            // 
            // patientsToolStripMenuItem
            // 
            this.patientsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addPatientToolStripMenuItem,
            this.toolStripSeparator1,
            this.patientsBaseToolStripMenuItem});
            this.patientsToolStripMenuItem.Name = "patientsToolStripMenuItem";
            this.patientsToolStripMenuItem.Size = new System.Drawing.Size(75, 20);
            this.patientsToolStripMenuItem.Text = "Пациенты";
            // 
            // addPatientToolStripMenuItem
            // 
            this.addPatientToolStripMenuItem.Name = "addPatientToolStripMenuItem";
            this.addPatientToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.addPatientToolStripMenuItem.Text = "Добавить пациента";
            this.addPatientToolStripMenuItem.Click += new System.EventHandler(this.addPatientToolStripMenuItem_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(177, 6);
            // 
            // patientsBaseToolStripMenuItem
            // 
            this.patientsBaseToolStripMenuItem.Name = "patientsBaseToolStripMenuItem";
            this.patientsBaseToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.patientsBaseToolStripMenuItem.Text = "База пациентов";
            this.patientsBaseToolStripMenuItem.Click += new System.EventHandler(this.patientsBaseToolStripMenuItem_Click);
            // 
            // medicalCheckupsToolStripMenuItem
            // 
            this.medicalCheckupsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addNewMedicalCheckupToolStripMenuItem,
            this.ToolStripMenuItem,
            this.medicalCheckupsBaseToolStripMenuItem,
            this.startMedicalCheckupToolStripMenuItem});
            this.medicalCheckupsToolStripMenuItem.Name = "medicalCheckupsToolStripMenuItem";
            this.medicalCheckupsToolStripMenuItem.Size = new System.Drawing.Size(99, 20);
            this.medicalCheckupsToolStripMenuItem.Text = "Обследования";
            // 
            // addNewMedicalCheckupToolStripMenuItem
            // 
            this.addNewMedicalCheckupToolStripMenuItem.Name = "addNewMedicalCheckupToolStripMenuItem";
            this.addNewMedicalCheckupToolStripMenuItem.Size = new System.Drawing.Size(243, 22);
            this.addNewMedicalCheckupToolStripMenuItem.Text = "Добавить новое обследование";
            this.addNewMedicalCheckupToolStripMenuItem.Click += new System.EventHandler(this.addNewMedicalCheckupToolStripMenuItem_Click);
            // 
            // ToolStripMenuItem
            // 
            this.ToolStripMenuItem.Name = "ToolStripMenuItem";
            this.ToolStripMenuItem.Size = new System.Drawing.Size(240, 6);
            // 
            // medicalCheckupsBaseToolStripMenuItem
            // 
            this.medicalCheckupsBaseToolStripMenuItem.Name = "medicalCheckupsBaseToolStripMenuItem";
            this.medicalCheckupsBaseToolStripMenuItem.Size = new System.Drawing.Size(243, 22);
            this.medicalCheckupsBaseToolStripMenuItem.Text = "База обследований";
            this.medicalCheckupsBaseToolStripMenuItem.Click += new System.EventHandler(this.medicalCheckupsBaseToolStripMenuItem_Click);
            // 
            // startMedicalCheckupToolStripMenuItem
            // 
            this.startMedicalCheckupToolStripMenuItem.Name = "startMedicalCheckupToolStripMenuItem";
            this.startMedicalCheckupToolStripMenuItem.Size = new System.Drawing.Size(243, 22);
            this.startMedicalCheckupToolStripMenuItem.Text = "Начать сеанс обследования";
            this.startMedicalCheckupToolStripMenuItem.Click += new System.EventHandler(this.startMedicalCheckupToolStripMenuItem_Click);
            // 
            // helpToolStripMenuItem
            // 
            this.helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.aboutProgramToolStripMenuItem});
            this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            this.helpToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.helpToolStripMenuItem.Text = "Справка";
            // 
            // aboutProgramToolStripMenuItem
            // 
            this.aboutProgramToolStripMenuItem.Name = "aboutProgramToolStripMenuItem";
            this.aboutProgramToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.aboutProgramToolStripMenuItem.Text = "О программе";
            this.aboutProgramToolStripMenuItem.Click += new System.EventHandler(this.aboutProgramToolStripMenuItem_Click);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.medicalChecupStatusPanel);
            this.panel1.Controls.Add(this.panel2);
            this.panel1.Controls.Add(this.StatusBar);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 24);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(784, 537);
            this.panel1.TabIndex = 1;
            // 
            // medicalChecupStatusPanel
            // 
            this.medicalChecupStatusPanel.Controls.Add(this.groupBoxStatusPatient);
            this.medicalChecupStatusPanel.Controls.Add(this.groupBoxSensors);
            this.medicalChecupStatusPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.medicalChecupStatusPanel.Location = new System.Drawing.Point(0, 0);
            this.medicalChecupStatusPanel.Name = "medicalChecupStatusPanel";
            this.medicalChecupStatusPanel.Size = new System.Drawing.Size(784, 469);
            this.medicalChecupStatusPanel.TabIndex = 0;
            // 
            // groupBoxStatusPatient
            // 
            this.groupBoxStatusPatient.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBoxStatusPatient.Location = new System.Drawing.Point(396, 0);
            this.groupBoxStatusPatient.Name = "groupBoxStatusPatient";
            this.groupBoxStatusPatient.Size = new System.Drawing.Size(388, 469);
            this.groupBoxStatusPatient.TabIndex = 3;
            this.groupBoxStatusPatient.TabStop = false;
            this.groupBoxStatusPatient.Text = "Состояние пациента";
            this.groupBoxStatusPatient.Enter += new System.EventHandler(this.patientStatusGroupBox_Enter);
            // 
            // groupBoxSensors
            // 
            this.groupBoxSensors.Controls.Add(this.panel3);
            this.groupBoxSensors.Controls.Add(this.detectorsInfoPanel);
            this.groupBoxSensors.Dock = System.Windows.Forms.DockStyle.Left;
            this.groupBoxSensors.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.groupBoxSensors.Location = new System.Drawing.Point(0, 0);
            this.groupBoxSensors.Name = "groupBoxSensors";
            this.groupBoxSensors.Size = new System.Drawing.Size(396, 469);
            this.groupBoxSensors.TabIndex = 2;
            this.groupBoxSensors.TabStop = false;
            this.groupBoxSensors.Text = "Информация о датчиках";
            this.groupBoxSensors.Enter += new System.EventHandler(this.sensorsGroupBox_Enter);
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.portraitPanel);
            this.panel3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel3.Location = new System.Drawing.Point(3, 16);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(390, 315);
            this.panel3.TabIndex = 4;
            // 
            // portraitPanel
            // 
            this.portraitPanel.Controls.Add(this.labelDetector5);
            this.portraitPanel.Controls.Add(this.labelDetector4);
            this.portraitPanel.Controls.Add(this.labelDetector3);
            this.portraitPanel.Controls.Add(this.labelDetector2);
            this.portraitPanel.Controls.Add(this.labelDetector1);
            this.portraitPanel.Controls.Add(this.pictureBox1);
            this.portraitPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.portraitPanel.Location = new System.Drawing.Point(0, 0);
            this.portraitPanel.Name = "portraitPanel";
            this.portraitPanel.Size = new System.Drawing.Size(390, 315);
            this.portraitPanel.TabIndex = 1;
            // 
            // labelDetector5
            // 
            this.labelDetector5.AutoSize = true;
            this.labelDetector5.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelDetector5.Location = new System.Drawing.Point(87, 168);
            this.labelDetector5.Name = "labelDetector5";
            this.labelDetector5.Size = new System.Drawing.Size(53, 13);
            this.labelDetector5.TabIndex = 5;
            this.labelDetector5.Text = "Датчик 5";
            // 
            // labelDetector4
            // 
            this.labelDetector4.AutoSize = true;
            this.labelDetector4.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelDetector4.Location = new System.Drawing.Point(202, 217);
            this.labelDetector4.Name = "labelDetector4";
            this.labelDetector4.Size = new System.Drawing.Size(53, 13);
            this.labelDetector4.TabIndex = 4;
            this.labelDetector4.Text = "Датчик 4";
            // 
            // labelDetector3
            // 
            this.labelDetector3.AutoSize = true;
            this.labelDetector3.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelDetector3.Location = new System.Drawing.Point(229, 87);
            this.labelDetector3.Name = "labelDetector3";
            this.labelDetector3.Size = new System.Drawing.Size(53, 13);
            this.labelDetector3.TabIndex = 3;
            this.labelDetector3.Text = "Датчик 3";
            // 
            // labelDetector2
            // 
            this.labelDetector2.AutoSize = true;
            this.labelDetector2.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelDetector2.Location = new System.Drawing.Point(211, 55);
            this.labelDetector2.Name = "labelDetector2";
            this.labelDetector2.Size = new System.Drawing.Size(53, 13);
            this.labelDetector2.TabIndex = 2;
            this.labelDetector2.Text = "Датчик 2";
            // 
            // labelDetector1
            // 
            this.labelDetector1.AutoSize = true;
            this.labelDetector1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelDetector1.Location = new System.Drawing.Point(229, 136);
            this.labelDetector1.Name = "labelDetector1";
            this.labelDetector1.Size = new System.Drawing.Size(53, 13);
            this.labelDetector1.TabIndex = 1;
            this.labelDetector1.Text = "Датчик 1";
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.pictureBox1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pictureBox1.Image = global::Lab1Tren.Properties.Resources.man;
            this.pictureBox1.Location = new System.Drawing.Point(0, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(390, 315);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // detectorsInfoPanel
            // 
            this.detectorsInfoPanel.Controls.Add(this.tableLayoutPanel1);
            this.detectorsInfoPanel.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.detectorsInfoPanel.Location = new System.Drawing.Point(3, 331);
            this.detectorsInfoPanel.Name = "detectorsInfoPanel";
            this.detectorsInfoPanel.Size = new System.Drawing.Size(390, 135);
            this.detectorsInfoPanel.TabIndex = 3;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 3;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 124F));
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(390, 135);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.button3);
            this.panel2.Controls.Add(this.button1);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel2.Location = new System.Drawing.Point(0, 469);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(784, 46);
            this.panel2.TabIndex = 4;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(93, 4);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(75, 37);
            this.button3.TabIndex = 2;
            this.button3.Text = "button3";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(12, 4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 37);
            this.button1.TabIndex = 0;
            this.button1.Text = "button1";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // StatusBar
            // 
            this.StatusBar.BackColor = System.Drawing.SystemColors.Highlight;
            this.StatusBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel});
            this.StatusBar.Location = new System.Drawing.Point(0, 515);
            this.StatusBar.Name = "StatusBar";
            this.StatusBar.Size = new System.Drawing.Size(784, 22);
            this.StatusBar.TabIndex = 0;
            this.StatusBar.Text = "statusBar";
            this.StatusBar.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.statusStrip1_ItemClicked);
            // 
            // toolStripStatusLabel
            // 
            this.toolStripStatusLabel.Name = "toolStripStatusLabel";
            this.toolStripStatusLabel.Size = new System.Drawing.Size(45, 17);
            this.toolStripStatusLabel.Text = "Готово";
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 561);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.mainMenu);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.mainMenu;
            this.MinimumSize = new System.Drawing.Size(800, 600);
            this.Name = "frmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "iFitness";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.mainMenu.ResumeLayout(false);
            this.mainMenu.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.medicalChecupStatusPanel.ResumeLayout(false);
            this.groupBoxSensors.ResumeLayout(false);
            this.panel3.ResumeLayout(false);
            this.portraitPanel.ResumeLayout(false);
            this.portraitPanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.detectorsInfoPanel.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.StatusBar.ResumeLayout(false);
            this.StatusBar.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

            // Detecotors decleared
            this.bloodPresureDetector = new BloodPresure();
            this.heartRhythmDetector = new HeartRhythm();
            this.skinElectricalConductivityDetector = new SkinElectricalConductivity();
            this.skinHumidityDetector = new SkinHumidity();
            this.skinTemperatureDetector = new SkinTemperature();
            //

        }

    #endregion

    private System.Windows.Forms.MenuStrip mainMenu;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem quitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aboutProgramToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem patientsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem medicalCheckupsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem medicalCheckupsBaseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem startMedicalCheckupToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem patientsBaseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addPatientToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem addNewMedicalCheckupToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem printToolStripMenuItem;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.StatusStrip StatusBar;
        private System.Windows.Forms.GroupBox groupBoxSensors;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.GroupBox groupBoxStatusPatient;
        private System.Windows.Forms.Panel medicalChecupStatusPanel;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel portraitPanel;
        private System.Windows.Forms.Panel detectorsInfoPanel;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label labelDetector1;
        private System.Windows.Forms.Label labelDetector5;
        private System.Windows.Forms.Label labelDetector4;
        private System.Windows.Forms.Label labelDetector3;
        private System.Windows.Forms.Label labelDetector2;

        // Detecotors decleared
        public BloodPresure bloodPresureDetector;
        public HeartRhythm heartRhythmDetector;
        public SkinElectricalConductivity skinElectricalConductivityDetector;
        public SkinHumidity skinHumidityDetector;
        public SkinTemperature skinTemperatureDetector;
        //

        /* Detecotors decleared
            this.bloodPresureDetector = new BloodPresure();
            this.heartRhythmDetector = new HeartRhythm();
            this.skinElectricalConductivityDetector = new SkinElectricalConductivity();
            this.skinHumidityDetector = new SkinHumidity();
            this.skinTemperatureDetector = new SkinTemperature();
        */

    }
}


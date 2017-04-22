namespace UserInterface
{
    partial class frmMedicalCheckupsList
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmMedicalCheckupsList));
            this.listView1 = new System.Windows.Forms.ListView();
            this.FIO = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Date = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Status = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.btnDeleteCheckup = new System.Windows.Forms.Button();
            this.btnAddCheckup = new System.Windows.Forms.Button();
            this.btnCancelCheckup = new System.Windows.Forms.Button();
            this.btnStartCheckup = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // listView1
            // 
            this.listView1.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.FIO,
            this.Date,
            this.Status});
            this.listView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.listView1.FullRowSelect = true;
            this.listView1.HideSelection = false;
            this.listView1.Location = new System.Drawing.Point(0, 0);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(624, 441);
            this.listView1.TabIndex = 1;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.Details;
            this.listView1.SelectedIndexChanged += new System.EventHandler(this.listView1_SelectedIndexChanged);
            this.listView1.Click += new System.EventHandler(this.listView1_Click);
            // 
            // FIO
            // 
            this.FIO.Text = "Пациент";
            this.FIO.Width = 402;
            // 
            // Date
            // 
            this.Date.Text = "Дата обследования";
            this.Date.Width = 116;
            // 
            // Status
            // 
            this.Status.Text = "Статус";
            this.Status.Width = 102;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.listView1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(624, 441);
            this.panel1.TabIndex = 1;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.btnDeleteCheckup);
            this.panel2.Controls.Add(this.btnAddCheckup);
            this.panel2.Controls.Add(this.btnCancelCheckup);
            this.panel2.Controls.Add(this.btnStartCheckup);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel2.Location = new System.Drawing.Point(0, 395);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(624, 46);
            this.panel2.TabIndex = 2;
            // 
            // btnDeleteCheckup
            // 
            this.btnDeleteCheckup.Enabled = false;
            this.btnDeleteCheckup.Location = new System.Drawing.Point(93, 5);
            this.btnDeleteCheckup.Name = "btnDeleteCheckup";
            this.btnDeleteCheckup.Size = new System.Drawing.Size(75, 31);
            this.btnDeleteCheckup.TabIndex = 3;
            this.btnDeleteCheckup.Text = "Удалить";
            this.btnDeleteCheckup.UseVisualStyleBackColor = true;
            this.btnDeleteCheckup.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // btnAddCheckup
            // 
            this.btnAddCheckup.Location = new System.Drawing.Point(12, 5);
            this.btnAddCheckup.Name = "btnAddCheckup";
            this.btnAddCheckup.Size = new System.Drawing.Size(75, 31);
            this.btnAddCheckup.TabIndex = 2;
            this.btnAddCheckup.Text = "Добавить";
            this.btnAddCheckup.UseVisualStyleBackColor = true;
            this.btnAddCheckup.Click += new System.EventHandler(this.AddButton_Click);
            // 
            // btnCancelCheckup
            // 
            this.btnCancelCheckup.Location = new System.Drawing.Point(537, 5);
            this.btnCancelCheckup.Name = "btnCancelCheckup";
            this.btnCancelCheckup.Size = new System.Drawing.Size(75, 31);
            this.btnCancelCheckup.TabIndex = 1;
            this.btnCancelCheckup.Text = "Закрыть";
            this.btnCancelCheckup.UseVisualStyleBackColor = true;
            this.btnCancelCheckup.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // btnStartCheckup
            // 
            this.btnStartCheckup.Location = new System.Drawing.Point(456, 5);
            this.btnStartCheckup.Name = "btnStartCheckup";
            this.btnStartCheckup.Size = new System.Drawing.Size(75, 31);
            this.btnStartCheckup.TabIndex = 0;
            this.btnStartCheckup.Text = "Начать";
            this.btnStartCheckup.UseVisualStyleBackColor = true;
            this.btnStartCheckup.Click += new System.EventHandler(this.startChecupButton_Click);
            // 
            // frmMedicalCheckupsList
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(624, 441);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximumSize = new System.Drawing.Size(640, 480);
            this.MinimumSize = new System.Drawing.Size(640, 480);
            this.Name = "frmMedicalCheckupsList";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "База обследований";
            this.panel1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.ColumnHeader FIO;
        private System.Windows.Forms.ColumnHeader Date;
        private System.Windows.Forms.ColumnHeader Status;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Button btnCancelCheckup;
        private System.Windows.Forms.Button btnStartCheckup;
        private System.Windows.Forms.Button btnDeleteCheckup;
        private System.Windows.Forms.Button btnAddCheckup;
    }
}
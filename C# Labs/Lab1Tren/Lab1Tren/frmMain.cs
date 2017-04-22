using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using DB;

namespace UserInterface
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
            labelDetector1.Text = heartRhythmDetector.Name;
            labelDetector2.Text = skinTemperatureDetector.Name;
            labelDetector3.Text = bloodPresureDetector.Name;
            labelDetector4.Text = skinHumidityDetector.Name;
            labelDetector5.Text = skinElectricalConductivityDetector.Name;
                       
        }

        private void toolStripTextBox1_Click(object sender, EventArgs e)
        {

        }

        private void statusStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void sensorsGroupBox_Enter(object sender, EventArgs e)
        {

        }

        private void patientStatusGroupBox_Enter(object sender, EventArgs e)
        {

        }

        private void quitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void patientsBaseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmPatientsList formPatientsList = new frmPatientsList();
            formPatientsList.ShowDialog();
        }

        private void medicalCheckupsBaseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmMedicalCheckupsList formMedicalCheckupsList = new frmMedicalCheckupsList();
            formMedicalCheckupsList.ShowDialog();
        }

        private void aboutProgramToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmAboutBox formAboutBox = new frmAboutBox();
            formAboutBox.ShowDialog();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            DataBase dataBase = new DataBase();
        }

        private void addPatientToolStripMenuItem_Click(object sender, EventArgs e)
        {
            dlgAddPatient dialogAddPatient = new dlgAddPatient();
            dialogAddPatient.ShowDialog();
        }

        private void addNewMedicalCheckupToolStripMenuItem_Click(object sender, EventArgs e)
        {
            dlgAddMedicalCheckup dialogAddMedicalCheckup = new dlgAddMedicalCheckup();
            dialogAddMedicalCheckup.ShowDialog();
        }

        private void startMedicalCheckupToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}

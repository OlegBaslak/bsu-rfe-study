using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Lab1Tren;
using Detectors;
using DB;

namespace UserInterface
{
    public partial class frmMedicalCheckupsList : Form
    {
        public frmMedicalCheckupsList()
        {
            InitializeComponent();
            listView1.Items.Clear();
            initTable();
        }

        public void initTable()
        {
            //DataBase dataBase = new DataBase();
            for (int i = 0; i < DataBase.getMedicalCheckupsCount(); i++)
            {
                MedicalCheckup currentMedicalCheckup = DataBase.getMedicalCheckup(i);
                listView1.Items.Add(new ListViewItem(new string[] { currentMedicalCheckup.Patient.getFullName(), currentMedicalCheckup.Date.Date.ToString(), currentMedicalCheckup.Status }));

            }


            Patient currentPatient = DataBase.getPatient(0);
            listView1.Items.Add(new ListViewItem(new string[] {currentPatient.getFullName(), new DateTime(2015,12,21, 16, 30, 00).ToString(), MedicalCheckup.RECORDED}));

        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void startChecupButton_Click(object sender, EventArgs e)
        {

            // код начала обследования

            this.Close();

        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            dlgAddMedicalCheckup dialogAddMedicalCheckupDialog = new dlgAddMedicalCheckup();
            dialogAddMedicalCheckupDialog.ShowDialog();
        }

        private void listView1_Click(object sender, EventArgs e)
        {
            btnDeleteCheckup.Enabled = true;
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count == 0) btnDeleteCheckup.Enabled = false;
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            string caption = "Вы уверены, что хотите удалить выбранные обследования?";
            var result = MessageBox.Show(caption, "Удаление обследования", 
                MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                int index;
                int selectedCount = listView1.SelectedIndices.Count;
                for (int j = 0; j < selectedCount; j++)
                {
                    if ((index = listView1.SelectedIndices[0]) >= 0)
                    {
                        DataBase.deleteMedicalCheckup(index);
                        Console.WriteLine("index " + index);
                        listView1.SelectedItems[0].Remove();
                        listView1.Refresh();
                    }
                    else
                        Console.WriteLine("smt is wrong");
                }
            }

            
        }
    }
}

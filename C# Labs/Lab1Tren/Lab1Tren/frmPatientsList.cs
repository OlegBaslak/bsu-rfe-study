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
    public partial class frmPatientsList : Form
    {
        public frmPatientsList()
        {
            InitializeComponent();
            listView1.Items.Clear();
            initTable();
            
        }

        public void initTable()
        {
            // тут почему-то добавляются новые 4 пациента при открытии формы поверх старых (каждый раз их больше и больше)
            // пофиксил добавлением статического поля isInited
           
            for (int i=0; i < DataBase.getPatientsCount(); i++)
            {
                Patient currentPatient = DataBase.getPatient(i);
                listView1.Items.Add(new ListViewItem(new string[] { currentPatient.getFullName(), currentPatient.Sex.ToString(), currentPatient.Age.ToString() }));

            }
        }

        private void patientsBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void addPatientButton_Click(object sender, EventArgs e)
        {
            dlgAddPatient dialogAddPatient = new dlgAddPatient();
            dialogAddPatient.ShowDialog();
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count == 0) btnDeletePatient.Enabled = false;
        }

        private void listView1_Click(object sender, EventArgs e)
        {
            btnDeletePatient.Enabled = true;
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            string caption = "Вы уверены, что хотите удалить выбраных пациентов?";
            var result = MessageBox.Show(caption, "Удаление пациентов",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                int index;
                int selectedCount = listView1.SelectedIndices.Count;
                for (int j = 0; j < selectedCount; j++)
                {
                    if ((index = listView1.SelectedIndices[0]) >= 0)
                    {
                        DataBase.deletePatient(index);
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

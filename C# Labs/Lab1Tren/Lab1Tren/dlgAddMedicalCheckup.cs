using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Detectors;
using Lab1Tren;

namespace UserInterface
{
    public partial class dlgAddMedicalCheckup : Form
    {
        public dlgAddMedicalCheckup()
        {
            InitializeComponent();
        }

        private void CancelButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            // код добавления обследования

            this.Close();


        }
    }
}

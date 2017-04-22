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

namespace UserInterface
{
    public partial class dlgAddPatient : Form
    {
        public dlgAddPatient()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void addButton_Click(object sender, EventArgs e)
        {

            // код добавления пациента

            this.Close();


        }
    }
}

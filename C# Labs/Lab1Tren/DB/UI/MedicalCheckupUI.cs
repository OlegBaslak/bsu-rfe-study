using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB
{
    public partial class MedicalCheckup
    {
        public string getName()
        {
            return Patient.getFullName() + ", дата " + Date + " со статусом " + Status;
        }
    }
}

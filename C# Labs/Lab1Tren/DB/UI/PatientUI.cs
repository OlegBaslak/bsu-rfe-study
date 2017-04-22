using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB
{
    public partial class Patient
    {
        public string getFullName()
        {
            return LastName + " " + FirstName + " " + MiddleName;
        }


    }
}

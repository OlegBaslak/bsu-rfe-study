using System.Linq;

namespace DB
{
    public partial class DataBase
    {

        public static Patient getPatient(int number)   // возвращает пациента из базы по номеру int nubmer
        {
            return patients.ElementAt(number);
        }

        public static int getPatientsCount()   // возвращает количестов пациентов в базе
        {
            return patients.Count;
        }

        public static MedicalCheckup getMedicalCheckup(int number) // возвращает обследование из базы по номеру int number
        {
            return medicalCheckups.ElementAt(number);
        }

        public static int getMedicalCheckupsCount()    // возвращает количестов обследований в базе
        {
            return medicalCheckups.Count();
        }

        public static void deletePatient(int index)
        {
            if (index >= 0 && index < getPatientsCount())
            {
                System.Console.WriteLine("Patient " + getPatient(index).getFullName() + " deleted");
                patients.RemoveAt(index);              
            }
        }

        public static void deleteMedicalCheckup(int index)
        {
            if (index >= 0 && index < getMedicalCheckupsCount())
            {
                System.Console.WriteLine("med. checkup " + getMedicalCheckup(index).getName() + " deleted");
                medicalCheckups.RemoveAt(index);
            }
        }
    }
}

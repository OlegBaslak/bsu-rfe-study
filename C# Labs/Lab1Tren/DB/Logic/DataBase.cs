using System;
using System.Collections.Generic;
using System.Linq;

namespace DB
{
    public partial class DataBase // искусственная база. В перспективе, работа проводится с внешними базами данных
    {
        private static List<Patient> patients = new List<Patient>();    // база пациентов
        private static List<MedicalCheckup> medicalCheckups = new List<MedicalCheckup>();   // база обследований
        private static bool isInited = false;

        public DataBase()
        {
            if (!isInited)
            {
                initPatients();
                initMedicalCheckups();
                IsInited = true;
            }
        }

        public static void initPatients()  // инициализация тестовых пациентов
        {
            patients.Add(new Patient("Oleg", "Baslak", "Viktorovich", Patient.MAN, 19));
            patients.Add(new Patient("Dmitry", "Evenkov", "Aleksandrovich", Patient.MAN, 22));
            patients.Add(new Patient("Pavel", "Gvardiyan", "Bat'kavich", Patient.MAN, 19));
            patients.Add(new Patient("Nastasya", "Samburskaya", "Anislavovna", Patient.WOMAN, 27));
            patients.Add(new Patient("Stas", "Mukchin", "Bat'kavich", Patient.MAN, 19));
        }

        public static void initMedicalCheckups()   // инициализация тестовых обследований
        {
            medicalCheckups.Add(new MedicalCheckup(patients.ElementAt(0), new DateTime(2015, 12, 21, 15, 00, 00)));
            medicalCheckups.Add(new MedicalCheckup(patients.ElementAt(1), new DateTime(2015, 12, 22, 15, 00, 00)));
            medicalCheckups.Add(new MedicalCheckup(patients.ElementAt(2), new DateTime(2015, 12, 23, 17, 30, 00)));
            medicalCheckups.Add(new MedicalCheckup(patients.ElementAt(3), new DateTime(2015, 12, 24, 16, 00, 00)));
            medicalCheckups.Add(new MedicalCheckup(patients.ElementAt(4), new DateTime(2015, 12, 25, 18, 00, 00)));
        }

        public static bool IsInited
        {
            get
            {
                return isInited;
            }

            set
            {
                isInited = value;
            }
        }

        //TO-DO:
        // методы добавления и удаление пациента
        // я подумываю о введении id для более удобной навигации по базе
        // (при работе с реальными базами, Id нужны для связи, ну ты знаешь)
    }
}
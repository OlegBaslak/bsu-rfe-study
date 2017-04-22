using System;

namespace DB
{
    public partial class MedicalCheckup
    {
        public const string STARTED = "Начато";
        public const string FINISHED = "Пройдено";
        public const string CANCELLED = "Отменено";
        public const string RECORDED = "Назначено";

        private const int RUN = 0;      // бег
        private const int WALK = 1;     // ходьба
        private const int BICYCLE = 2;  // велотренажер
        private const int FORCE = 3;    // силовые упражнения
        private const int SWIM = 4;     // плавание

        private Patient patient;        // пациент, проходивший обследование
        private DateTime date;          // дата прохождения обследования
        private string status;          // статус обследования (начато, пройдено, отменено, назначено)
        private int checkupType;        // тип обследования

        public MedicalCheckup(Patient patient, DateTime date)
        {
            Patient = patient;
            Date = date;
            Status = RECORDED;          
        }

        public Patient Patient
        {
            get
            {
                return patient;     // получить пациента проходящего обследование
            }

            set
            {
                patient = value;    // выбрать пациента проходящего обследование
            }
        }

        public DateTime Date
        {
            get
            {
                return date;        // получить дату обследования
            }

            set
            {
                date = value;       // установить дату обследования
            }
        }

        public int CheckupType
        {
            get
            {
                return checkupType;  // получить тип обследования
            }

            set
            {
                checkupType = value; // установить тип обследования
            }
        }

        public string Status
        {
            get
            {
                return status;  // получить текущий статус
            }

            set
            {
                status = value; // изменить статус
            }
        }
    }

}
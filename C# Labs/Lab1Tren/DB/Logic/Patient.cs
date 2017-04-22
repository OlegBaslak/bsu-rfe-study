namespace DB
{
    public partial class Patient
    {
        public const string MAN = "Мужской";           // пол - мужской
        public const string WOMAN = "Женский";         // пол - женский

        private string firstName = null;    // Имя
        private string lastName = null;     // Фамилия
        private string middleName = null;   // Отчество
        private string sex;                    // Пол
        private int age;                    // Возраст

        public string FirstName
        {
            get
            {
                return firstName;           // получить имя
            }

            set
            {
                firstName = value;          // установить имя
            }
        } 

        public string LastName
        {
            get
            {
                return lastName;            // получить фамилию
            }

            set
            {
                lastName = value;           // установить фамилию
            }
        }

        public string MiddleName
        {
            get
            {
                return middleName;          // получить отчество
            }

            set
            {
                middleName = value;         // установить отчество
            }
        }

        public string Sex
        {
            get  // получить пол
            {
                return sex;          
            }

            set // установить пол
            {
                sex = value;              
            }
        }

        public int Age
        {
            get
            {
                return age;                 // получит возраст
            }

            set
            {
                age = value;                //установить возраст
            }
        }

        public Patient(string _firstName, string _lastName, string _middleName, string _sex, int _age)
        {
            this.FirstName = _firstName;
            this.LastName = _lastName;
            this.MiddleName = _middleName;
            this.Sex = _sex;
            this.Age = _age;
        }

    }

}
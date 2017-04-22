namespace Detectors
{
    public abstract class Detector : ISwitchable, ICheckupSettings
    {

        private static byte CheckupTime = 60;      // время обследования

        public const byte ON = 1;           // работает
        public const byte OFF = 0;          // не работает (простаивает)
        public const byte BROKEN = 2;       // неисправен

        private byte status;                // отображает текущее состояние датчика
        private string name = "Датчик";     // название датчика

        public string Name
        {
            get
            {
                return name;    // возвращает имя датчика
            }

            set
            {
                name = value;   // устаналивает имя датчика
            }
        }

        public static byte CHECKUP_TIME
        {
            get
            {
                return CheckupTime;         // получить время проведения обследования
            }

            set
            {
                CheckupTime = value;        // изменить время проведения обследования
            }
        }

        public abstract void switchOn();    // включить датчик
        public abstract void switchOff();   // выключить датчик (если не задействован в обследовании)
        public abstract void checkUp();     // проверить состояние датчика
        public abstract void start();       // начать измерения
        public abstract void stop();        // остановить измерения
        public abstract int[] transfer();    // передать данные датчика
    }
}
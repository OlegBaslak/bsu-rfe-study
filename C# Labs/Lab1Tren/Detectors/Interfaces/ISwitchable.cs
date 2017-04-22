namespace Detectors
{
    public interface ISwitchable
    {
        void switchOn();    // включить датчик
        void switchOff();   // выключить датчик
        void checkUp();     // проверить состояние
    }


}
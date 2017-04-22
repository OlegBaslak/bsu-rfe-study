namespace Detectors
{
    public partial interface ICheckupSettings
    {
        void start();   // начать замеры
        void stop();    // остановить замеры
        int[] transfer();   // передать результаты измерений датчика
    }
}
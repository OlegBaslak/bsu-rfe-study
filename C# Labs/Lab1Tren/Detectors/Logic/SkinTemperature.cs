using System;

namespace Detectors
{
    public partial class SkinTemperature : Detector
    {

        private int[] temperature = new int[CHECKUP_TIME];  // массив измерений датчика

        public SkinTemperature()
        {
            Name = "Температура кожи";
        }

        public override void checkUp()  // проверить работоспособность
        {
            throw new NotImplementedException();
        }

        public override void start()    //начать замеры
        {
            throw new NotImplementedException();
        }

        public override void stop()    // остановить замеры
        {
            throw new NotImplementedException();
        }

        public override void switchOff()    // деактивировать датчик
        {
            throw new NotImplementedException();
        }

        public override void switchOn() // активировать датчик
        {
            throw new NotImplementedException();
        }

        public override int[] transfer()    // передать данные с датчика
        {
            throw new NotImplementedException();
        }
    }
}
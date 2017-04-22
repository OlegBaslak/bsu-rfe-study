using System;

namespace Detectors
{
    public partial class SkinHumidity : Detector
    {

        private int[] humidity = new int[CHECKUP_TIME]; // массив измерений датчика

        public SkinHumidity()
        {
            Name = "Влажность кожи";
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
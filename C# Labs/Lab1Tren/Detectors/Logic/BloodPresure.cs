using System;

namespace Detectors
{
    public partial class BloodPresure : Detector
    {
        private int[] pressure = new int[CHECKUP_TIME*2];   // массив давлений. нечетные - систола (верхнее), четные - диастола (нижнее)

        public BloodPresure()
        {
            Name = "Кровяное давление";
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
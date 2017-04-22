using System;

namespace Detectors
{
    public partial class SkinElectricalConductivity : Detector
    {

        private int[] conductivity = new int[CHECKUP_TIME]; // массив измерений датчика

        public SkinElectricalConductivity()
        {
            Name = "Эл. проводимость кожи";
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
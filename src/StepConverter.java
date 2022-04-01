public  class StepConverter {
    double stepEnergy=0.05;
    double stepDistance=0.00075;

     void findDistance(double distanceMax){
         System.out.println("Пройдено расстояние: " + distanceMax*stepDistance+ " км");
        }
    void findEnergy(double distanceMax) {
        System.out.println("Потраченные каллории: " + distanceMax * stepEnergy + " кКал");
    }
    }
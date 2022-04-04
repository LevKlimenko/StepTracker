import java.util.Formatter;
public  class StepConverter {

   private final double STEP_DISTANCE = 0.00075;
   private final double STEP_ENERGY = 0.05;


    public void findDistance(double distanceMax){
        double dist=distanceMax* STEP_DISTANCE;
        System.out.println("Пройдено расстояние: " + String.format("%.2f",dist) + " км");//количество точек после запятой
        }
    public void findEnergy(double distanceMax) {
        double energy=distanceMax * STEP_ENERGY;
        System.out.println("Потраченные каллории: " + String.format("%.2f",energy) + " кКал");
    }
    }
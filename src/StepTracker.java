import java.util.Scanner;

public class StepTracker {
    private int[][] stepByDay = new int[30][12];
    private final Scanner scanner;
    private String [] monthName =  {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    private int STEP_TARGET =10000;
    StepConverter convert=new StepConverter();

    public void printMonth(){
        for (int i=0; i<monthName.length;i++){
            System.out.print(i+ "-" + monthName[i]+ " ");
        }
        System.out.println();
    }

    public  StepTracker(Scanner scanner){
     this.scanner=scanner;
    }

    public void saveStep() {
        System.out.println("За какой месяц вы хотите ввести данные?" );
        printMonth();
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            System.out.println("Введите число от 0 до 11");
            for (int i=0; i<monthName.length;i++){
                System.out.print(i+ "-" + monthName[i]+ " ");
            }
            System.out.println();
            month = scanner.nextInt();
        }
        {
            System.out.println("За какой день вы хотите ввести данные?");
            int day = scanner.nextInt();
            while (day <= 0 || day > 30) {
                System.out.println("Введите номер дня от 1 до 30");
                day=scanner.nextInt();
            }
            {
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Количество шагов должно быть больше или равно 0.");
                    System.out.println("Введите количество шагов:");
                    steps = scanner.nextInt();}
                {
                    System.out.println("Данные за день <"+ day + "> <"  + monthName[month]  + "> сохранены.");
                    System.out.println("Пройдено: " + steps + " шагов");
                    stepByDay[day - 1][month] = steps;
                }
            }
            }
            }

    public void showStatistic(int monthShow) {
        while (monthShow < 0 || monthShow > 11) {
        System.out.println("Неверный ввод. Введите число от 0 до 11");
        printMonth();
        monthShow = scanner.nextInt();
    }
    {
        printAllStep(monthShow);
        System.out.println("Сумма шагов за месяц: " + sumStepMonth(monthShow));
        System.out.println("Максимальное количество шагов за месяц: " + findMaxStep(monthShow));
        findStepAverage(monthShow);
        convert.findDistance(sumStepMonth(monthShow));
        convert.findEnergy(sumStepMonth(monthShow));
        System.out.println("Лучшая серия: " + findBestSeries(monthShow) + " дня(ей)");
    }
}

  private  void printAllStep(int monthShow) {
        int dayInMonth = 30;
        for (int i = 0; i < stepByDay.length - 1; i++) {
            System.out.print((i + 1) + " день: " + stepByDay[i][monthShow] + ", ");
        }
        System.out.println(dayInMonth + " день: " + stepByDay[dayInMonth - 1][monthShow] + ". ");
    }

  private int sumStepMonth(int monthShow) {
        int stepSumm=0;
       for (int[] ints : stepByDay) {
           stepSumm += ints[monthShow];
       }
       return stepSumm;
        }

  private  int findMaxStep(int monthshow){
        int maxStep=0;
        for (int[] ints : stepByDay) {
            if (ints[monthshow] > maxStep) {
                maxStep = ints[monthshow];
            }
        }
        return maxStep;
    }

   private void findStepAverage(int monthShow){
        int stepAverage=sumStepMonth(monthShow)/stepByDay.length;
        System.out.println("Среднее количество шагов за месяц: " + stepAverage);
         }

    private  int findBestSeries(int monthShow) {
            int count = 0;
            int maxSeries = 0;
            for (int[] ints : stepByDay) {
                if (ints[monthShow] >= STEP_TARGET) {
                    count++;
                    if (count > maxSeries) {
                        maxSeries = count;
                    }
                } else {
                    count = 0;
                }
            }
                      return maxSeries;
            }


   public int changeStepTarget() {
       System.out.println("Текущая цель: " + STEP_TARGET + " шагов.");
       System.out.println("Введите новую цель:");
       STEP_TARGET = scanner.nextInt();
       while (STEP_TARGET < 0) {
            System.out.println("Ошибка. Количество шагов должно быть больше или равно 0");
            System.out.println("Введите новую цель:");
            STEP_TARGET = scanner.nextInt();
        }
        return STEP_TARGET;
    }
}
import java.util.Scanner;

public class StepTracker {
    int[][] stepByDay = new int[30][12];
    Scanner scanner = new Scanner(System.in);
    String [] monthName =  {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        void printMonth(){
        for (int i=0; i<monthName.length;i++){
            System.out.print(i+ "-" + monthName[i]+ " ");
        }
        System.out.println();
    }

    void saveStep() {
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


    void printAllStep(int monthShow) {
        int dayInMonth = 30;
        for (int i = 0; i < stepByDay.length - 1; i++) {
            System.out.print((i + 1) + " день: " + stepByDay[i][monthShow] + ", ");
        }
        System.out.println(dayInMonth + " день: " + stepByDay[dayInMonth - 1][monthShow] + ". ");
    }

   int sumStepMonth(int monthShow) {
        int stepSumm=0;
       for (int[] ints : stepByDay) {
           stepSumm += ints[monthShow];
       }
       return stepSumm;
        }

    int findMaxStep(int monthshow){
        int maxStep=0;
        for (int[] ints : stepByDay) {
            if (ints[monthshow] > maxStep) {
                maxStep = ints[monthshow];
            }
        }
        return maxStep;
    }

    void findStepAverage(int monthShow){
        int stepAverage=sumStepMonth(monthShow)/stepByDay.length;
        System.out.println("Среднее количество шагов за месяц: " + stepAverage);
         }

        int findBestSeries(int monthShow, int stepsTarget) {
            int count = 0;
            int maxSeries = 0;
            for (int[] ints : stepByDay) {
                if (ints[monthShow] >= stepsTarget) {
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



    int changeStepTarget(int oldStepTarget) {
            if (oldStepTarget < 0) {
            System.out.println("Ошибка. Количество шагов должно быть больше или равно 0");
            System.out.println("Введите новую цель:");
            oldStepTarget = scanner.nextInt();
        }
        return oldStepTarget;
    }
}
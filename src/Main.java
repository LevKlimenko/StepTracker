import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker tracker = new StepTracker();
        StepConverter convert = new StepConverter();
        int stepTarget=10000;
        while (userInput != 4) {
            if (userInput == 1) {
                tracker.saveStep();
               System.out.println();
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца: ");
                tracker.printMonth();
                int monthShow=scanner.nextInt();
                while (monthShow<0 || monthShow>11){
                    System.out.println("Неверный ввод. Введите число от 0 до 11");
                    tracker.printMonth();
                    monthShow=scanner.nextInt();
                }

                {   monthShow=monthShow - 1;
                    tracker.printAllStep(monthShow);
                    System.out.println("Сумма шагов за месяц: " + tracker.sumStepMonth(monthShow));
                    System.out.println("Максимальное количество шагов за месяц: " + tracker.findMaxStep(monthShow));
                    tracker.findStepAverage(monthShow);
                    convert.findDistance(tracker.sumStepMonth(monthShow));
                    convert.findEnergy(tracker.sumStepMonth(monthShow));
                    System.out.println("Лучшая серия: " + tracker.findBestSeries(monthShow, tracker.changeStepTarget(stepTarget)) + " дня(ей).");
                }
            } else if (userInput == 3) {
                System.out.println("Текущая цель: " + stepTarget + " шагов.");
                System.out.println("Введите новую цель:");
                int newStepTarget = scanner.nextInt();
                stepTarget = tracker.changeStepTarget(newStepTarget);
                System.out.println("Текущая цель - " + stepTarget + " шагов");
            }
               else{
                   System.out.println("Нет такого пункта меню.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
   private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Показать статистику за месяц");
        System.out.println("3 - Изменить цель шагов");
        System.out.println("4 - Выход");
    }
}

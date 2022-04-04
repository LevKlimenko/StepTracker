import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker tracker = new StepTracker(scanner);
        while(true) {
              switch (scanner.nextInt()) {
                case 1:
                    tracker.saveStep();
                    System.out.println();
                    printMenu();
                    break;
                case 2:
                    System.out.print("Введите номер месяца: ");
                    tracker.printMonth();
                    int monthShow = scanner.nextInt();
                    tracker.showStatistic(monthShow);
                    printMenu();
                break;
                case 3:
                    System.out.println("Цель изменена\nТекущая цель - " + tracker.changeStepTarget() + " шагов");
                    printMenu();
                    break;
                case 4:
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                default:
                    System.out.println("Нет такого пункта меню.");
                    printMenu();
             }
        }

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Показать статистику за месяц");
        System.out.println("3 - Изменить цель шагов");
        System.out.println("4 - Выход");
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            switch (i){
                case (1): stepTracker.addNewNumberStepsPerDay();
                    break;
                case (2): stepTracker.changeStepGoal();
                    break;
                case (3): stepTracker.printStatistic();
                    break;
                case (4): System.out.println("Пока!");
                    scanner.close();
                    return;
                default: System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите один из пунктов: " +
                "\n 1 - ввести количество шагов за определённый день " +
                "\n 2 - изменить цель по количеству шагов в день " +
                "\n 3 - напечатать статистику за определённый месяц " +
                "\n 4 - выйти из приложения");
    }
}

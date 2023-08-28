import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = checkTheInput(scanner, 1, 12, "Введите номер месяца от 1 до 12 (включительно)");

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = checkTheInput(scanner, 1, 30, "Введите день от 1 до 30 (включительно)");

        System.out.println("Введите количество шагов");
        int steps = checkTheInput(scanner, 1, Integer.MAX_VALUE, "Введите количество шагов от 1");

        MonthData monthData = monthToData[month - 1];

        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите количество шагов отвечающее за цель шагов в день");
        goalByStepsPerDay = checkTheInput(scanner, 1, Integer.MAX_VALUE, "Введите количество шагов отвечающее за цель шагов в день от 1");
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int monthData = checkTheInput(scanner, 1, 12, "Введите число месяца от 1 до 12 (включительно)");
        monthData = monthData - 1;

        int sumSteps = monthToData[monthData].sumStepsFromMonth();
        monthToData[monthData].printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимально пройденное количество шагов за месяц: " + monthToData[monthData].maxSteps());
        System.out.println("Среднее пройденного количества шагов за месяц: " + (sumSteps / 30));
        System.out.println("Пройденной за месяц дистанции в км: " + converter.convertToKm(sumSteps));
        System.out.println("Количества сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия за месяц: " + monthToData[monthData].bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    /**
     * Дополнительный метод для валидации введенных значений.
     *
     * @param scan - сканер
     * @param min  - минимальный порог
     * @param max  - максимальный порог
     * @param text - текст в случии провала проверки
     * @return - возвращаемое значение int
     */
    private int checkTheInput(Scanner scan, int min, int max, String text) {
        while (true) {
            int inputNumber = scan.nextInt();
            if (inputNumber >= min && inputNumber <= max) {
                return inputNumber;
            }
            System.out.println(text);
        }
    }
}

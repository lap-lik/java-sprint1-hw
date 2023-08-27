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
        int month = checkTheInput(scanner, 1, 12, "Введите номер месяца от 1 до 12 (включительно)");    // ввод и проверка номера месяца

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = checkTheInput(scanner, 1, 30, "Введите день от 1 до 30 (включительно)");  // ввод и проверка дня

        System.out.println("Введите количество шагов");
        int steps = checkTheInput(scanner, 1, Integer.MAX_VALUE, "Введите количество шагов от 1");  // ввод и проверка количества шагов

        MonthData monthData = monthToData[month - 1];   // Получение соответствующего объекта MonthData из массива

        monthData.days[day - 1] = steps;    // Сохранение полученных данных
    }

    void changeStepGoal() {
        System.out.println("Введите количество шагов отвечающее за цель шагов в день");
        goalByStepsPerDay = checkTheInput(scanner, 1, Integer.MAX_VALUE, "Введите количество шагов отвечающее за цель шагов в день от 1");  // ввод и проверка количества шагов
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int monthData = checkTheInput(scanner, 1, 12, "Введите число месяца от 1 до 12 (включительно)");    // ввод и проверка номера месяца
        monthData = monthData - 1;    // получение соответствующего месяца

        int sumSteps = monthToData[monthData].sumStepsFromMonth();  // получение суммы шагов за месяц
        monthToData[monthData].printDaysAndStepsFromMonth();    // вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц: " + sumSteps);    // вывод суммы шагов за месяц
        System.out.println("Максимально пройденное количество шагов за месяц: " + monthToData[monthData].maxSteps());   // вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее пройденного количества шагов за месяц: " + (sumSteps / 30));    // вывод среднего пройденного количества шагов за месяц
        System.out.println("Пройденной за месяц дистанции в км: " + converter.convertToKm(sumSteps));     // вывод пройденной за месяц дистанции в км
        System.out.println("Количества сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));  // вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия за месяц: " + monthToData[monthData].bestSeries(goalByStepsPerDay));   // вывод лучшей серии
        System.out.println();   //дополнительный перенос строки
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

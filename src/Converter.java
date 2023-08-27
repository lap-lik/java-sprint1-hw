public class Converter {
    double stepToSm = 75;
    double stepToCalories = 50;

    int convertToKm(int steps) {
        return (int) Math.round(steps * stepToSm / 100000);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) Math.round(steps * stepToCalories / 1000);
    }
}

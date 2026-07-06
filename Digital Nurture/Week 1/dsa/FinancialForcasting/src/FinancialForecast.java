public class FinancialForecast {

    // Recursive method
    public static double futureValue(double presentValue, double rate, int years) {

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        return futureValue(presentValue, rate, years - 1) * (1 + rate);
    }
}
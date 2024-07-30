public class FinancialForecasting {

    // Recursive method to calculate future value
    public double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: when years is 0, future value is the present value
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: apply growth rate for one year and reduce the problem
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double presentValue = 1000.0; // Initial investment
        double growthRate = 0.05; // Annual growth rate (5%)
        int years = 10; // Number of years into the future

        double futureValue = forecasting.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}

public class TaxUtil {
    double rate = 0.15;

    public double calculateTax(double amount) {
       return amount * rate;
    }
    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }
}



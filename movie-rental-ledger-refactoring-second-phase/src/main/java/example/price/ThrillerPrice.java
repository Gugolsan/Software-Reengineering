package example.price;

public class ThrillerPrice extends Price{
    @Override
    public double getPrice(int daysRented) {
        if (daysRented > 5) {
            return 3.5 + (daysRented - 5) * 1.5;
        }
        return 3.5;
    }

    @Override
    public int getFrequentRenterPointsIncrement(int daysRented) {
        if (daysRented > 2) {
            return 2;
        }
        return 1;
    };
}

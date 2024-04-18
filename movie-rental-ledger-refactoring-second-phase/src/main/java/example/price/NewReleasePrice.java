package example.price;

public class NewReleasePrice extends Price{
    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPointsIncrement(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    };
}

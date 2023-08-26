public class Gold extends Tier {
    //returns toString
    @Override
    public String toString() {
        return "Gold";
    }

    //returns total miles
    public int getMiles() {
        int multiplier = 1000;
        return this.cancelledFlights * multiplier;
    }

    //constructor
    Gold(int TF, int CF) {
        super(TF, CF);
    }
}

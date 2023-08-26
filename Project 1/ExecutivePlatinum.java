public class ExecutivePlatinum extends Tier{
    //returns toString
    @Override
    public String toString() {
        return "Executive Platinum";
    }

    //returns total miles
    public int getMiles() {
        int multiplier = 1000;
        return this.cancelledFlights * multiplier;
    }

    //constructor
    ExecutivePlatinum(int TF, int CF) {
        super(TF, CF);
    }
}

public class PlatinumPro extends Platinum{
    //returns toString
    @Override
    public String toString() {
        return "Platinum Pro";
    }

    //returns total miles
    @Override
    public int getMiles() {
        int multiplier = 2000;
        return this.cancelledFlights * multiplier;
    }

    //constructor
    PlatinumPro(int TF, int CF) {
        super(TF, CF);
    }
}

public class Platinum extends Tier{
    //returns toString
    @Override
    public String toString() {
        return "Platinum";
    }

    //returns total miles
    public int getMiles() {
        int multiplier = 1000;
        return this.cancelledFlights * multiplier;
    }
    
    //constructor
    Platinum(int TF, int CF) {
        super(TF, CF);
    }
}

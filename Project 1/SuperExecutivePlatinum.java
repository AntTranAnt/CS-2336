public class SuperExecutivePlatinum extends Tier{
    //returns toString
    @Override
    public String toString() {
        return "Super Executive Platinum";
    }

    //returns total miles
    @Override
    public int getMiles() {
        int multiplier = 2000;
        return this.cancelledFlights * multiplier;
    }
    
    //constructor
    SuperExecutivePlatinum(int TF, int CF) {
        super(TF, CF);
    }
}

public abstract class Tier {
    public int miles;
    public int cancelledFlights;
    public int totalFlights;

    //returns total miles earned so far to be implemented in each tier
    public abstract int getMiles();

    //returns toString method to be implemented in each Tier
    public abstract String toString();

    //returns current number of cancelled flights
    public int getCancelledFlights() {
        return cancelledFlights;
    }

    //returns total number of flights, including cancelled flights
    public int getFlights() {
        return totalFlights;
    }

    //adds new flight to total, cancelled is also added
    //overrided in higher tiers
    public void addFlight(boolean isCancelled) {
        totalFlights++;
        if (isCancelled) {
            cancelledFlights++;
        }
    }

    //constructor for Tier class
    Tier(int TF, int CF) {
        this.totalFlights = TF;
        this.cancelledFlights = CF;
    }

}

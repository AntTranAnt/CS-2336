public class Passenger {
    private Tier myTier;
    private int ID;
    private int totalFlights;
    private int cancelledFlights;
    private boolean hasMultiplier;
    private boolean complained;

    //constructor
    Passenger(int ID) {
        this.ID = ID;
        myTier = null;
        cancelledFlights = 0;
        totalFlights = 0;
        hasMultiplier = false;
        complained = false;
    }

    //constructor for test cases
    Passenger(int ID, int totalFlights, int cancelledFlights, boolean complained, Tier newTier) {
        this.ID = ID;
        this.totalFlights = totalFlights;
        this.cancelledFlights = cancelledFlights;
        this.complained = complained;
        this.myTier = newTier;
    }

    //getter for ID
    public int getID() {
        return ID;
    }

    //setter for ID
    public void setID(int ID) {
        this.ID = ID;
    }

    //returns string representation of tier
    public String getTier() {
        return myTier.toString();
    }

    //returns getMiles from tier object
    public int getMiles() {
        return myTier.getMiles();
    }

    //returns number of cancelled flights
    public int getCancelledFlights() {
        return cancelledFlights;
    }

    //returns false throughout year
    //at end, determines if passenger has earned mileage multiplier.
    public boolean hasMultiplier() {
        return hasMultiplier;
    }

    //upgrades platinum or exe plat if customer hasn't complained
    public void upgrade() {
        hasMultiplier = !complained;
        if (hasMultiplier && myTier != null) {
            String currentTier = myTier.toString();
            if (currentTier.compareTo("Platinum") == 0) {
                myTier = new PlatinumPro(totalFlights, cancelledFlights);
            } else if (currentTier.compareTo("Executive Platinum") == 0) {
                myTier = new SuperExecutivePlatinum(totalFlights, cancelledFlights);
            }
        }
    }

    //method to add flight to records
    public void addFlight(boolean isCancelled) {
        int gold = 25;
        int platinum = 50;
        int exePlat = 100;
        totalFlights++;
        if (isCancelled) {
            cancelledFlights++;
        }
        
        //addFlight to tier class
        if (myTier != null) {
            myTier.addFlight(isCancelled);
        }

        //check to see if eligible for tier upgrade
        if (cancelledFlights == gold) {
            myTier = new Gold(totalFlights, cancelledFlights);
        } else if (cancelledFlights == platinum) {
            myTier = new Platinum(totalFlights, cancelledFlights);
        } else if (cancelledFlights == exePlat) {
            myTier = new ExecutivePlatinum(totalFlights, cancelledFlights);
        }
    }
    //method to add flight to record when customer complained
    public void addFlight(boolean isCancelled, boolean complained) {
        addFlight(isCancelled);
        if (complained) {
            this.complained = true;
        }
    }

    //toString for passenger
    @Override
    public String toString() {
        String result = "ID: " + ID + "\tTier: ";
        if (myTier != null) {
            result += myTier.toString() + "\t";
        } else {
            result += "None\t";
        }

        if (myTier != null) {
            result += "Total Miles: " + myTier.getMiles() + "\tCancelled Flights: " + cancelledFlights;
            result += "\tMileage Multiplier: ";
            String check = myTier.toString();
            if (check.compareTo("Platinum Pro") == 0) {
                result += "True";
            } else if (check.compareTo("Super Executive Platinum") == 0) {
                result += "True";
            } else {
                result += "False";
            }
        } else {
            result += "Total Miles: 0" + "\tCancelled Flights: " + cancelledFlights;
            result += "\tMileage Multiplier: False";
        }
        
        
        return result;
    }
}


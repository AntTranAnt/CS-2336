/* Anthony Tran
 * CS 2336
 * Program to read inputed file and upgrade passenger in real time.
 * Enter name of txt file, then input desired Passenger ID, or -1 to cancel
 * Program assumes all Passenger numbers are >= 0
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class MainClass {
    public static void main(String args[]) throws IOException {
        ArrayList<Passenger> records = new ArrayList<Passenger>();
        Scanner keyboard = new Scanner(System.in);
        String inputFile = getInput(keyboard);
        Scanner input = new Scanner(new File(inputFile));


        scanFile(input, records);
        upgrade(records);
        
        boolean newPrompt = true;
        do {
            System.out.print("Enter Passenger ID (-1 to cancel): ");
            int check = keyboard.nextInt();
            //search array if -1 is not entered
            if (check != -1) {
                int arrayIndex = searchArray(records, check);
                //if passenger found, print out records
                if (arrayIndex != -1) {
                    System.out.println(records.get(arrayIndex).toString());
                } else {
                    System.out.println("Not a Valid ID");
                }
            } else {
                newPrompt = false;
            }
        }
        while (newPrompt);
        keyboard.close();
    }

    //method to get inputfile, return as string
    public static String getInput(Scanner keyboard) {
        System.out.print("Enter file name: ");
        File file = new File(keyboard.nextLine());
        while (!file.exists()) {
            System.out.println("Sorry, that file does not exist");
            System.out.print("Enter the file name: ");
            file = new File(keyboard.nextLine());
        }
        return file.getName();
    }

    //method to scan flight data and input into arraylist of passengers
    public static void scanFile(Scanner input, ArrayList<Passenger> records) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);

            int ID = lineScan.nextInt();
            boolean cancelled = trueFalse(lineScan.next().charAt(0));
            boolean complained = false; //only matters if complained is true
            if (!cancelled && lineScan.hasNext()) {
                complained = trueFalse(lineScan.next().charAt(0));
            }

            int found = searchArray(records, ID); //found is index of Passenger with matching id
            if (found >= 0) {
                if (complained) {
                    records.get(found).addFlight(cancelled, complained);
                } else {
                    records.get(found).addFlight(cancelled);
                }
            } else { //if this is new passenger
                Passenger newPassenger = new Passenger(ID);
                if (complained) {
                    newPassenger.addFlight(cancelled, complained);
                } else {
                    newPassenger.addFlight(cancelled);
                }
                records.add(newPassenger);
            }
            lineScan.close();

        }
    }

    //searches arraylist for id, returns index of array if found, -1 if not found
    public static int searchArray(ArrayList<Passenger> records, int id) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    //upgrades all members at end of year if they didn't complain
    public static void upgrade(ArrayList<Passenger> records) {
        for (int i = 0; i < records.size(); i++) {
            records.get(i).upgrade();
        }
    }

    //returns boolean representation of 'Y' or 'N'
    public static boolean trueFalse(char test) {
        if (test == 'Y') {
            return true;
        } else {
            return false;
        }
    }
}

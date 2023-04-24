package Objects;

import java.util.ArrayList;
import java.util.Random;


public class Passenger {
    private String name;
    private String passport;
    private Flight flightinfo;
    
    public Passenger(String name, String passport, Flight flightinfo) {
        this.name = name;
        this.passport = passport;
        this.flightinfo = flightinfo;
    }

    public Passenger() {

	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Flight getFlightinfo() {
        return flightinfo;
    }

    public void setFlightinfo(Flight flightinfo) {
        this.flightinfo = flightinfo;
    }

    @Override
    public String toString() {
        return "Passenger:\n" + "  " + name + "\nPassport number:" +"\n  " + passport + "\nFlightinfo: " + flightinfo + "\n" ;
    }

    // genrates random passaport number that resembles a US passaport.
    public static String randomPassaport(){
        String passportNumber = "";
        Random rand = new Random();
        
        passportNumber += "US";

        for (int i = 0; i < 7; i++) {
            passportNumber += rand.nextInt(10);
        }
        
        return passportNumber;
    }

    // compares names and if names are the same compares passport numbers.
    public int compareTo(Passenger other) {
        int nameComparison = name.compareTo(other.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return passport.compareTo(other.getPassport());
    }

    public static ArrayList createPassengers(){
        ArrayList<Passenger> myList = new ArrayList<Passenger>();
        /* 
        Passenger p1 = new Passenger(" Ava Patel", randomPassaport(),
        Passenger p2 = new Passenger("Joshua Kim", randomPassaport(), 
        Passenger p3 = new Passenger("Isabella Nguyen", randomPassaport(),
        Passenger p4 = new Passenger("Sophia Garcia", randomPassaport(), 
        Passenger p5 = new Passenger("Michael Rodriguez", randomPassaport(), 
        Passenger p6 = new Passenger("Emily Leer", randomPassaport(),
        Passenger p7 = new Passenger("Benjamin Davis", randomPassaport(),
        Passenger p8 = new Passenger("Victoria Hernandez", randomPassaport(),
        Passenger p9 = new Passenger("William Baker", randomPassaport(),
        Passenger p10 = new Passenger("Gabriella Chavez", randomPassaport(),
        Passenger p11 = new Passenger("Christopher Green", randomPassaport(),
        Passenger p12 = new Passenger("Olivia Taylor", randomPassaport(),
        Passenger p13 = new Passenger("Daniel Wong", randomPassaport(),
        */

        myList.add(p1);
        myList.add(p2);
        myList.add(p3);
        myList.add(p4);
        myList.add(p5);
        myList.add(p6);
        myList.add(p7);
        myList.add(p8);
        myList.add(p9);
        myList.add(p10);
        myList.add(p11);
        myList.add(p12);
        myList.add(p13);

        return myList;

    }

    
}

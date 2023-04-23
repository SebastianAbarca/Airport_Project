package Objects;

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

}

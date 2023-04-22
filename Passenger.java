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
        return "Passenger [name=" + name + ", passport=" + passport + ", flightinfo=" + flightinfo + "]";
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

    // method to generate random names.
    public static String RandomName() {
        return null;
    }

}

import java.util.*;
import java.io.*;
public class Startup
{
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input;
        FileOutputStream output =  new FileOutputStream("AirportInformation.txt");
        PrintWriter writer = new PrintWriter(output);
        File Info = new File("AirportInformation.txt");
    if(!Info.exists())
    {
        System.out.println("Hello new user what is your first name.");
        String name = scnr.next();
        writer.print(name + " ");
        System.out.println("What is your last name?");
        name = scnr.next();
        writer.println(name);
        writer.println("Eren");
    }
    }
}

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.*;
public class Startup
{
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        boolean exists = Files.exists(Path.of("AirportInformation147.txt"));
    if(!exists)
    {
        File info = new File("AirportInformation147.txt");
        FileWriter writer = new FileWriter(info);
        Scanner scan = new Scanner(info);
        System.out.println("Hello new user what is your first name.");
        String name = scnr.next();
        writer.write(name + " ");
        System.out.println("What is your last name?");
        name = scnr.next();
        writer.write(name);
        writer.close();
    }
        FileInputStream info = new FileInputStream("AirportInformation147.txt");
        Scanner scan = new Scanner(info);
        System.out.println("Hello " + scan.nextLine());
    }
}

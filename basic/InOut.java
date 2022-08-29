import java.io.Console;
import java.util.Scanner;

public class InOut {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Name:");
//        String name = in.next();
//        System.out.println("Age:");
//        int age = in.nextInt();
//        System.out.println("Hello " + name + " you are " + age);

        Console cons = System.console();
        String username = cons.readLine("User name:");
        char[] password = cons.readPassword("Password:");
        System.out.println("Hello " + username);
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Program arguments: " + Arrays.toString(args));
        if (args.length != 2) {
            System.out.println("Invalid input! (incorrect number of parameters; MUST have 2 parameters ONLY!)");
            System.out.println("The ONLY valid arguments are as follows:  -A 1");
            System.out.println("                                          -A 2");
            System.out.println("                                          -A 3");
            System.out.println("Ending program...");
            return;
        }
        else if (!args[0].equals("-A")) {
            System.out.println("Invalid input! (incorrect first parameter; first parameter MUST be \"-A\" ONLY!)");
            System.out.println("The ONLY valid arguments are as follows:  -A 1");
            System.out.println("                                          -A 2");
            System.out.println("                                          -A 3");
            System.out.println("Ending program...");
            return;
        }
        else if (!args[1].equals("1") && !args[1].equals("2") && !args[1].equals("3")) {
            System.out.println("Invalid input! (incorrect second parameter; second parameter MUST be either \"1\", \"2\", or \"3\" ONLY!)");
            System.out.println("The ONLY valid arguments are as follows:  -A 1");
            System.out.println("                                          -A 2");
            System.out.println("                                          -A 3");
            System.out.println("Ending program...");
            return;
        }
        if (args[1].equals("2")){
            System.out.println("----------------------------Access Matrix----------------------------");
        }
        if (args[1].equals("2")){
            System.out.println("----------------------------Access List----------------------------");
        }
        if (args[1].equals("3")) {
            System.out.println("----------------------------Capability List----------------------------");
            int domains = Use.randNum(3, 7);
            int objects = Use.randNum(3, 7);

            System.out.println("Domain count: " + domains);
            System.out.println("Object count: " + objects);
            CL list = new CL(domains, objects);

            // there are domain # of threads
            for (int i = 0; i < list.domains; i++) {
                DomainCl cList = new DomainCl(String.valueOf(i), list);
                cList.start();                                                   // Start user thread
            }
        }
    }
}



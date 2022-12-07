import java.util.*;

public class PDA
{
    private Scanner scanner = new Scanner(System.in);
    private int age;
    private int LOWER_BOUND = 14;
    private int ADULT = 18;
    private boolean shouldContinue = true;
    
    /**
     * Constructor for objects of class PDA
     */
    public PDA()
    {
        // We don't need to do anything in the constructor for
        // our program.
    }
    
    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (shouldContinue) {
            System.out.println("How old are you? Type 0 to quit.");
            try {
                age = scanner.nextInt();
                if (age == 0) {
                    shouldContinue = false;
                    System.out.println("Closing...");
                } else if (age < LOWER_BOUND) {
                    System.out.println(age + " is too young!");         
                } else {
                    System.out.println("Your acceptable dating range is " + getYounger(age) + " to " + getOlder(age) + " years old.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Please enter an integer!");
                scanner.next();
            } 
        }  
    }
    
    public int getYounger(int age) {
        if (Math.ceil(0.5 * age + 7) < ADULT && age >= ADULT) {
            return ADULT;
        }
        return (int)Math.ceil(0.5 * age + 7);
    }
    
    public int getOlder(int age) {
        if (2 * (age - 7) >= ADULT && age < ADULT) {
            return ADULT - 1;
        }
        return 2 * (age - 7);
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}
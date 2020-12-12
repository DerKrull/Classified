import java.util.Scanner;

public class JavaAdventures {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String playerName;
    int playerChoice;

    System.out.println("You stranded on an island.");
    System.out.println("What is your name?");
    String name = scanner.nextLine();
    System.out.println("Welcome, " + name);
    System.out.println("Nice to meet you!");
  }
}

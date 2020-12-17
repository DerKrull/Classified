
import java.util.Scanner;

public class Game{

  public static void main(String[] args){
		
    Scanner in = new Scanner(System.in);
		
	//TODO add all Questions
    LiveStep[] steps = new LiveStep[10];
	steps[0] = new LiveStep(1, "Das ist die erste Frage", new LiveChoice[]{
	  new LiveChoice("1 - Antwort 1", 2),
	  new LiveChoice("2 - Antwort 2", 1)
	});
    steps[1] = new LiveStep(1, "Ergebnis 1", new LiveChoice[]{
	  new LiveChoice("1 - weiter", 3)
	});
	steps[2] = new LiveStep(1, "Ergebnis 2", new LiveChoice[]{
	  new LiveChoice("1 - weiter", 3)
	});
  steps[3] = new LiveStep(1, "Nächste Frage", new LiveChoice[]{
	  new LiveChoice("1 - Antwort 1", 4),
	  new LiveChoice("2 - Antwort 2", 5)
	});


	int id = 0;
	LiveStep currentStep = steps[id];
	boolean gameOver = true;

	clearScreen();
	
    while(gameOver){
	  System.out.println(currentStep.getDescription());
	  LiveChoice[] choices = currentStep.getChoices();

	  for(int i = 0; i < choices.length; i++){
		  System.out.println(choices[i].getDescription());
	  }

	  int answer = in.nextInt();

	  id = choices[answer - 1].getNextStep();
	  currentStep = steps[id];

	  if(id == 9){
		System.out.println("Game Over");
		gameOver = false;
	  }
	  clearScreen();
    }
  }

	//https://stackoverflow.com/questions/2979383/java-clear-the-console
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  } 

}

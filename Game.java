
import java.util.Scanner;

public class Game{

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
/*
		for(int i = 0; i < frage.length; i++){
			for(int j = 0; j < frage[i].length; j++){
				if(frage[i][j] != null){
					System.out.print(frage[i][j]);
				}
				System.out.print(" | ");
			}
			System.out.print(" \n");
		}


		String[][] frage = fragen();

		String[][][] antwort = antworten();
*/

		clearScreen();

		int x = 0;
		int y = 0;
		int z = 0;

		while(true){

			
			
			
				
			

			System.out.println(fragen(x,y));
			if(antworten(x,y,z) != null) System.out.println(antworten(x,y,z));
			z++;
			if(antworten(x,y,z) != null) System.out.println(antworten(x,y,z));
			z++;
			if(antworten(x,y,z) != null) System.out.println(antworten(x,y,z));
			z++;
			if(antworten(x,y,z) != null) System.out.println(antworten(x,y,z));
			z = 0;
			System.out.println(""+ x + "|" + y );

			int a = in.nextInt();

			if(x == 0){
				if(a == 1){
					x += 1;
					y = 0;
				}
				if(a == 2){
					x += 1;
					y = 1;
				}
			}

			else if(x == 1){
				if(a == 1){
					x += 1;
					y = 0;
				}
				if(a == 2){
					x += 1;
					y = 1;
				}
				if(a == 3){
					x += 1;
					y = 2; 
				}
			}

			else if(x == 2){
				if(y == 2){
					if(a == 1){
						x = 1;
						y = 0;
					}
					else if(a == 2){
						x = x;
						y = 1;
					}
				}
				else{
					if(a == 1){
						x += 1;
						y = 0;
					}
					if(a == 2){
						x += 1;
						y = 1;
					}
				}
			}

			else if(x == 3){
				if(a == 1){
					x += 1;
					y = 0;
				}
				if(a == 2){
					x += 1;
					y = 1;
				}
			}

			else if(x == 4){
				if(a == 1){
					x += 1;
					y = 0;
				}
				if(a == 2){
					x += 1;
					y = 1;
				}
			}

			else if(x == 5){
				if(a == 1){
					x += 1;
					y = 0;
				}
				if(a == 2){
					x += 1;
					y = 1;
				}
			}
			
			else if(x == 6){
				if(a == 1){
					clearScreen();
					System.out.println("\nGAME OVER\n");
					break;
				}
				if(a == 2){
					x = 0;
					y = 0;
				}
			}
			

			z = 0;
		

			
			
			clearScreen();

			
		}

	}

	public static String fragen(int x, int y){
		String[][] frage = new String[7][4];
		frage[0][0] = "Willkommen in unserem Spiel\n\nWählen sie \n\n 1 - um in der Uni zu starten \noder \n 2 - um zu Hause zu starten ";
		frage[1][0] = "S 1 - F 1 \n Die Antwortmöglichkeiten:";
		frage[1][1] = "S 1 - F 2 \n Die Antwortmöglichkeiten:";  

		frage[2][0] = "S 2 - F 1 \n Die Antwortmöglichkeiten:";
		frage[2][1] = "S 2 - F 2 \n Die Antwortmöglichkeiten:";
		frage[2][2] = "S 2 - F 3 \n Die Antwortmöglichkeiten:";

		frage[3][0] = "S 3 - F 1 \n Die Antwortmöglichkeiten:";
		frage[3][1] = "S 3 - F 2 \n Die Antwortmöglichkeiten:";

		frage[4][0] = "S 4 - F 1 \n Die Antwortmöglichkeiten:";
		frage[4][1] = "S 4 - F 2 \n Die Antwortmöglichkeiten:";

		frage[5][0] = "S 5 - F 1 \n Die Antwortmöglichkeiten:";
		frage[5][1] = "S 5 - F 2 \n Die Antwortmöglichkeiten:";

		frage[6][0] = "ENDE 1";
		frage[6][1] = "ENDE 2";

		String result = frage[x][y];
		return result;
	}

	public static String antworten(int x, int y, int z){
		String[][][] antwort = new String[7][4][4];
		antwort[1][0][0] = " 1 = S 1 - F 1 - A 1";
		antwort[1][0][1] = " 2 = S 1 - F 1 - A 2";

		antwort[1][1][0] = " 1 = S 1 - F 2 - A 1";
		antwort[1][1][1] = " 2 = S 1 - F 2 - A 2";
		antwort[1][1][2] = " 3 = S 1 - F 2 - A 3";


		antwort[2][0][0] = " 1 = S 2 - F 1 - A 1";
		antwort[2][0][1] = " 2 = S 2 - F 1 - A 2";

		antwort[2][1][0] = " 1 = S 2 - F 2 - A 1";
		antwort[2][1][1] = " 2 = S 2 - F 2 - A 2";

		antwort[2][1][0] = " 1 = S 2 - F 3 - A 1";
		antwort[2][1][1] = " 2 = S 2 - F 3 - A 2";		


		antwort[3][0][0] = " 1 = S 3 - F 1 - A 1";
		antwort[3][0][1] = " 2 = S 3 - F 1 - A 2";
		antwort[3][0][2] = " 3 = S 3 - F 1 - A 3";

		antwort[3][1][0] = " 1 = S 3 - F 2 - A 1";
		antwort[3][1][1] = " 2 = S 3 - F 2 - A 2";


		antwort[4][0][0] = " 1 = S 4 - F 1 - A 1";
		antwort[4][0][1] = " 2 = S 4 - F 1 - A 2";

		antwort[4][1][0] = " 1 = S 4 - F 2 - A 1";
		antwort[4][1][1] = " 2 = S 4 - F 2 - A 2";
		antwort[4][1][2] = " 3 = S 4 - F 2 - A 3";


		antwort[5][0][0] = " 1 = S 5 - F 1 - A 1";
		antwort[5][0][1] = " 2 = S 5 - F 1 - A 2";

		antwort[5][1][0] = " 1 = S 5 - F 2 - A 1";
		antwort[5][1][1] = " 2 = S 5 - F 2 - A 2";

		antwort[6][0][0] = "Sie haben das Ende 1 erreicht\n\nZum Beenden drücken sie die \"1\"\n\nZum Neustarten drücken sie die \"2\" ";

		antwort[6][1][0] = "Sie haben das Ende 2 erreicht\n\nZum Beenden drücken sie die \"1\"\n\nZum Neustarten drücken sie die \"2\" ";

		String result = antwort[x][y][z];
		return result;
	}

	//https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	} 

}

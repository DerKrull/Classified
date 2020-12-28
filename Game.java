
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);    
    //TODO add all Questions
    int sumQuestions = 30;
    LiveStep[] steps = new LiveStep[sumQuestions];
    String weiter = "1 - Weiter";
	//1. Stage
    steps[0] = new LiveStep(0, "Das ist die vorrübergehende Einleitung", new LiveChoice[]{
      new LiveChoice(weiter, 1)
      });
    steps[1] = new LiveStep(1, "Wie viele Stunden investierst du pro Woche für Mathe?",
        new LiveChoice[]{
          new LiveChoice("1 - Weniger als 5 Std.", 2),
          new LiveChoice("2 - Mehr als 5 Std.", 3)
          });
    steps[2] = new LiveStep(2, "Mathe läuft schlecht!", new LiveChoice[]{
      new LiveChoice(weiter, 4)
      });
    steps[3] = new LiveStep(3, "Mathe läugt sehr gut", new LiveChoice[]{
      new LiveChoice(weiter, 7)
      });
    steps[4] = new LiveStep(4, "Suchst du bereits eine Lerngruppe?", new LiveChoice[]{
      new LiveChoice("1 - Ja, ich suche eine Lerngruppe", 3),
      new LiveChoice("2 - Nein, ich suche mir keine Lerngruppe", 5)
      });
    steps[5] = new LiveStep(5, "TIPP: Eine Lerngruppe hilft den Stoff nocheinmal zu wiederholen" 
    + "und in der Gruppe zu besprechen", new LiveChoice[]{
      new LiveChoice(weiter, 6)
      });
    steps[6] = new LiveStep(6, "Willst du deine Entscheidung überdenken", new LiveChoice[]{
      new LiveChoice("1 - Ja, ich werde mir doch eine Lerngruppe suchen", 3),
      new LiveChoice("2 - Nein, ich schaffe das ohne Lerngruppe", 7)
      });
    steps[7] = new LiveStep(7, "Nun zum nächsten Modul. Hast du bereits Vorkenntnisse in Java?",
        new LiveChoice[]{
          new LiveChoice("1 - Ja, ich habe bereits Vorkenntnisse in Java", 8),
          new LiveChoice("2 - Nein, ich habe noch nichts mit Java zu tun gehabt", 9)
          });
    steps[8] = new LiveStep(8, "JAVA-QUIZ HIER EINFÜGEN", new LiveChoice[]{
      new LiveChoice("1 - Antwort -> bestanden", 10),
      new LiveChoice("2 - Antwort -> durchgefallen", 9)
      });
    steps[9] = new LiveStep(9, "Du musst viel Zeit investieren um in Prog1 am Ball zu bleiben. Du"
    + " hast weniger Zeit für andere Dinge", new LiveChoice[]{
      new LiveChoice(weiter, 10)
      });
    steps[10] = new LiveStep(10, "Du hast es geschafft und die Prüfung bestanden.\nUnd jetzt"
    + " geht's weg von der Uni ab nach Hause ins Privatleben",
        new LiveChoice[]{
          new LiveChoice(weiter, 11)
          });
    steps[11] = new LiveStep(11, "Bist du von zu Hause ausgezogen ", new LiveChoice[]{
      new LiveChoice("1 - Ja", 12),
      new LiveChoice("2 - Nein", 13)
      });
    steps[12] = new LiveStep(12, "Wohnst du  in einer WG oder alleine?", new LiveChoice[]{
      new LiveChoice("1 - Ich wohne in einer WG", 14),
      new LiveChoice("2 - Ich wohne alleine", 15)
      });
    steps[13] = new LiveStep(13, "Da du zu Hause wohnst hast du weniger Ausgaben, aber deine"
    + " Geschwister lassen dich einfach nicht in Ruhe lernen!", new LiveChoice[]{
      new LiveChoice(weiter, 16)
      });
    steps[14] = new LiveStep(14, "Du hast coole Mitbewohner, aber auch deine Ruhe, wenn du lernen"
    + " musst. Allerdigns sind deine Ausgaben höher", new LiveChoice[]{
      new LiveChoice(weiter, 16)
      });
    steps[15] = new LiveStep(15, "Du wohnst alleine und kannst machen was du willst, in Ruhe" 
    + " lernen, feiern gehen, worauf du Lust hast! Allerdings ist die Wohnung nicht ganz günstig!",
         new LiveChoice[]{
           new LiveChoice(weiter, 16)
           });
    //TODO Frage abhängig von Antwort bei steps[7]
    steps[16] = new LiveStep(16, "Du hast die Möglichkeit einen Nebenjob zu machen um deine" 
    + " Haushaltskasse etwas aufzubessern", new LiveChoice[]{
      new LiveChoice("1 - Das hört sich vernünftig an, dann bin ich maximal selbstständig", 17),
      new LiveChoice("2 - Ach, das passt schon ich hab andere Quellen die mich unterstützen, da"
      + " muss ich selbst nicht arbeiten gehen", 18)
      });
    steps[17] = new LiveStep(17,  "Falls du Vorkenntnisse in Programmierung hast, kannst du dich"
    + " jetzt nach einem Nebenjob in diesem Bereich umsehen", new LiveChoice[]{
      new LiveChoice("1 - Da kann ich auch gleich noch Praxiserfahrung sammeln, das klingt gut",
       19), //TODO 100% GELD
      new LiveChoice("2 - Ich suche mir lieber einen \"normalen\" Nebenjob und gehe kellnern",
       19) //TODO 50% GELD
      });
    steps[18] = new LiveStep(18, "Aus welchen Quellen kommt denn das Geld", new LiveChoice[]{
      new LiveChoice("1 - Meine Eltern", 19), //TODO 40% GELD
      new LiveChoice("2 - Bafög", 19), //TODO 30% GELD
      new LiveChoice("3 - Ich hab meine Eltern und Bafög", 19) //TODO 70% GELD
      });
    steps[19] = new LiveStep(19, "In der Uni steht die erste Prüfung kurz vor der Tür,"
    + " gleichzeitig hat aber auch dein bester Freund seinen 18. Geburtstag. Was machst du?",
        new LiveChoice[]{
          new LiveChoice("1 - Gar keine Frage, man wird nur einmal 18. Das kann ich nicht"
          + " verpassen!", 20),
          new LiveChoice("2 - Das Studium hat auf jeden Fall Priorität, sonst wäre ja das ganze"
          + " Semester umsonst gewesen!", 22)
          });
    steps[20] = new LiveStep(20, "Du warst feiern und wachst am Morgen der Prüfung in einem Regio"
    + " in Erfurt auf und wunderst dich wie du es soweit geschafft hast", new LiveChoice[]{
      new LiveChoice("1 - Was soll man machen. Immer nach vorne schauen", 21)
      });
    //TODO vielleicht noch eine zweite Antwort für eine Art Kreislauf
    steps[21] = new LiveStep(21, "Du hast aufgrund deiner ungeplanten Reise nicht mehr rechtzeitig" 
    + " zur Prüfung geschafft und musst sie wiederholen!", new LiveChoice[]{
      new LiveChoice("1 - Dann mach ich das dieses mal aber richtig", 22)
      });
    steps[22] = new LiveStep(22, "Du hast die Prüfung geschrieben und bestanden herzlichen"
    + " Glückwunsch.\n Auf gehts ins nächste Semester", new LiveChoice[]{
      new LiveChoice("1 -Und los!", 23)
      });
    //2. Stage
    steps[23] = new LiveStep(23, "Herzlich Willkommen im 3.Semester!", 
	  new LiveChoice[]{
        new LiveChoice("1 -Auf zur Wahl deiner Spezialisierung!",24)
      });
    steps[24] = new LiveStep(24, "Wähle eine der Spezialisierungen.", 
      new LiveChoice[]{
        new LiveChoice("1 -Embedded Systems", 25),
        new LiveChoice("2 -Internet Engineering", 25),
        new LiveChoice("3 -Medieninformatik", 25),
        new LiveChoice("4 -Wirtschaftsinformatik", 25),
        new LiveChoice("5 -keine Spezialisierung", 25)
	  });
    steps[25] = new LiveStep(25, "Du belegst 3 Fächer deiner Spezialisierung.", //TODO vielleicht Spezialisierungsvar einfügen
      new LiveChoice[]{
        new LiveChoice("1 -Weiter", 26)
      });
    int id = 0;
    LiveStep currentStep = steps[id];
    boolean gameOver = true;
    clearScreen();

    while (gameOver) {
      System.out.println(currentStep.getDescription());
      LiveChoice[] choices = currentStep.getChoices();

      for (int i = 0; i < choices.length; i++) {
        System.out.println(choices[i].getDescription());
      }

      int answer = in.nextInt();
      id = choices[answer - 1].getNextStep();
      currentStep = steps[id];
      if (id == sumQuestions) {
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

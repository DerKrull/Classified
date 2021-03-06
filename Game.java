import java.util.Scanner;

public class Game {
  public static void main(String[] args) {   
    int sumQuestions = 58;
    LiveStep[] steps = new LiveStep[sumQuestions];
    String weiter = "1 - Weiter";
    //Stage1
    steps[0] = new LiveStep(0, "Willkommen bei Classified!\nDieses Spiel soll den Aufstieg eines "
    + "Informatikers simulieren.\nJe nach dem, welche Entscheidungen du im Spiel triffst, wird "
    + "sich deine Zukunft ändern.\nJetzt viel Spaß bei unserem Spiel!", new LiveChoice[]{
      new LiveChoice(weiter, 56)
      });
    steps[1] = new LiveStep(1, "Du beginnst im ersten Semester mit Mathematische Grundalagen "
    + "der Informatik. \nWie viele Stunden investierst du pro Woche für Mathe?",
        new LiveChoice[]{
          new LiveChoice("1 - Weniger als 5 Std.", 2),
          new LiveChoice("2 - Mehr als 5 Std.", 3)
          });
    steps[2] = new LiveStep(2, "Mathe läuft schlecht!", new LiveChoice[]{
      new LiveChoice(weiter, 4)
      });
    steps[3] = new LiveStep(3, "Mathe läuft sehr gut", new LiveChoice[]{
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
    steps[8] = new LiveStep(8, "Was ist die Ausgabe?\n\nint i = 2;\nint total = 0;\nwhile"
    + " (i < 9) {\n  i++\n  total = total + i;\n}\nSystem.out.println(total);\n", 
        new LiveChoice[]{
          new LiveChoice("1 - 42", 10),
          new LiveChoice("2 - 39", 9)
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
    
    steps[16] = new LiveStep(16, "Du hast die Möglichkeit einen Nebenjob zu machen um deine" 
    + " Haushaltskasse etwas aufzubessern", new LiveChoice[]{
      new LiveChoice("1 - Das hört sich vernünftig an, dann bin ich maximal selbstständig", 17),
      new LiveChoice("2 - Ach, das passt schon ich hab andere Quellen die mich unterstützen, da"
      + " muss ich selbst nicht arbeiten gehen", 18)
      });
    steps[16].getChoices()[0].setChangeCredit(1600);
    steps[17] = new LiveStep(17,  "Da du Vorkenntnisse in Java hast, kannst du nach einem"
    + " entsprechenden Nebenjob suchen", new LiveChoice[]{
      new LiveChoice("1 - Da kann ich auch gleich noch Praxiserfahrung sammeln, das klingt gut",
       19), 
      new LiveChoice("2 - Ich suche mir lieber einen \"normalen\" Nebenjob und gehe kellnern",
       19)
      });
    steps[17].getChoices()[0].setChangeCredit(600);
    steps[17].setNeededPreviousStep(7);
    steps[17].setNeededPreviousAnswer(1);
    steps[17].setAlternativeStep(19);

    steps[18] = new LiveStep(18, "Aus welchen Quellen kommt denn das Geld", new LiveChoice[]{
      new LiveChoice("1 - Meine Eltern", 19), 
      new LiveChoice("2 - Bafög", 19), 
      new LiveChoice("3 - Ich hab meine Eltern und Bafög", 19)
      });
    steps[18].getChoices()[0].setChangeCredit(1000);
    steps[18].getChoices()[1].setChangeCredit(700);
    steps[18].getChoices()[2].setChangeCredit(1500);
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
    steps[21] = new LiveStep(21, "Du hast aufgrund deiner ungeplanten Reise nicht mehr rechtzeitig" 
    + " zur Prüfung geschafft und musst sie wiederholen!", new LiveChoice[]{
      new LiveChoice("1 - Dann mach ich das dieses mal aber richtig", 22)
      });
    steps[22] = new LiveStep(22, "Du hast die Prüfung geschrieben und bestanden herzlichen"
    + " Glückwunsch.\n Auf gehts ins nächste Semester", new LiveChoice[]{
      new LiveChoice("1 -Und los!", 23)
      });
    //Stage2
    steps[23] = new LiveStep(23, "Herzlich Willkommen im 3.Semester!", 
        new LiveChoice[]{
          new LiveChoice("1 -Auf zur Wahl deiner Spezialisierung!", 24)
          });
    steps[24] = new LiveStep(24, "Wähle eine der Spezialisierungen.", 
        new LiveChoice[]{
          new LiveChoice("1 -Embedded Systems", 25),
          new LiveChoice("2 -Internet Engineering", 25),
          new LiveChoice("3 -Medieninformatik", 25),
          new LiveChoice("4 -Wirtschaftsinformatik", 25)
          //new LiveChoice("5 -keine Spezialisierung", 25)
          });
    steps[25] = new LiveStep(25, "Du belegst 3 Fächer von ",
        new LiveChoice[]{ 
          new LiveChoice(weiter, 26)
          });
    steps[25].setUsesSpecialization(true);
    steps[26] = new LiveStep(26, "Besuchst du regelmäßig die Veranstalltungen (Vorlesungen, etc.)",
        new LiveChoice[]{
          new LiveChoice("1 -Ja", 27),
          new LiveChoice("2 -Nein", 28)
          });
    steps[27] = new LiveStep(27, "Wie findest du das Studium bis zu diesem Punkt?",
        new LiveChoice[]{
          new LiveChoice("1 -Gut!", 29),
          new LiveChoice("2 -Anstrengend, wird aber schon!", 30),
          new LiveChoice("3 -Schlecht!", 31)
          });
    steps[28] = new LiveStep(28, "Dir fehlen wichtige Vorkenntnisse, die dir später zum Nachteil"
    + " werden könnten!",
        new LiveChoice[]{
          new LiveChoice(weiter, 27)
          });
    steps[29] = new LiveStep(29, "Läuft!",
        new LiveChoice[]{
          new LiveChoice(weiter, 33)
          });
    steps[30] = new LiveStep(30, "Na dann, aber immer dran bleiben!", 
        new LiveChoice[]{
          new LiveChoice(weiter, 33)
          });
    steps[31] = new LiveStep(31, "Ändere deine Spezialisierung oder wechsel den Studiengang?",
        new LiveChoice[]{
          new LiveChoice("1 -Spezialisierung ändern!", 24),
          new LiveChoice("2 -Studiengang wechseln!", 32)
          });
    steps[32] = new LiveStep(32, "Du wechseltst den Studiengang!\nDieser Weg endet hier!",
        new LiveChoice[]{
          new LiveChoice("1 -Spiel beenden!", 55) //TODO eleganteres Ende
          });
    steps[33] = new LiveStep(33, "Du hast die nächsten Semester soweit gemeistert!\nDie "
    + "Semesterferien stehen an! Ab ins Privatleben!",
        new LiveChoice[]{
          new LiveChoice(weiter, 34)
          });
    steps[34] = new LiveStep(34, "Willst du mit deinen Kumpels nach Mallorca? (Kosten: 250€)",
        new LiveChoice[]{
          new LiveChoice("1 -Na Klar!", 35),
          new LiveChoice("2 -Nein ich muss mich auf mein Studium konzentrieren.", 36)
          });
    steps[34].getChoices()[0].setChangeCredit(-250);
    steps[34].setNeededPreviousStep(27);
    steps[34].setNeededPreviousAnswer(1);
    steps[34].setAlternativeStep(36);
    steps[35] = new LiveStep(35, "Nach ein paar Tagen feiern wird ein Freund festgenommen "
    + "und\nihr teilt euch die Kosten (jeder 750€)!",
        new LiveChoice[]{
          new LiveChoice(weiter, 43)
          });
    steps[35].getChoices()[0].setChangeCredit(-750); 
    steps[36] = new LiveStep(36, "Nach erfolgreichem Lernen gehst du in eine Kneipe/Kirmes/Club "
    + "und lernst\njemanden kennen.\nHast du Interesse an einer Beziehung",
        new LiveChoice[]{
          new LiveChoice("1 -Ja!", 38),  
          new LiveChoice("2 -Nein!", 43)
          });
    steps[38] = new LiveStep(38, "Ihr hattet ein paar Dates.\nDu bist nun in einer festen "
    + "Beziehung.",
        new LiveChoice[]{
          new LiveChoice(weiter, 40)
          });
    steps[38].setNeededPreviousStep(27);
    steps[38].setNeededPreviousAnswer(1);
    steps[38].setAlternativeStep(39);

    steps[39] = new LiveStep(39, "Du musst deinen Partner mehrfach, wegen des Studiums versetzen!"
    + "\nAus der Beziehung wird leider nichts!",
        new LiveChoice[]{
          new LiveChoice(weiter, 43)
          });
    steps[40] = new LiveStep(40, "Dein Partner fragt, ob ihr zusammenziehen wollt.\n"
    + " Der Umzug kostet 150€",
        new LiveChoice[]{
          new LiveChoice("1 -Ja!", 41),
          new LiveChoice("2 -Nein!", 42)
          });
    steps[40].getChoices()[0].setChangeCredit(-150);
    steps[41] = new LiveStep(41, "Der Umzug in eure Wohnung hat etwas Geld gekostet, aber "
    + "die Haushaltskasse wird das schon verkraften.",
        new LiveChoice[]{
          new LiveChoice(weiter, 43)
          });
    steps[42] = new LiveStep(42, "Sie sieht keine Zukunft für eure Beziehung!\nDiese "
    + "Beziehung endet!",
        new LiveChoice[]{
          new LiveChoice(weiter, 43)
          });
    steps[43] = new LiveStep(43, "Du bekommst ein Jobangebot im Bereich ",
        new LiveChoice[]{
          new LiveChoice("1 -Jobangebot annehmen und Studium abbrechen!", 44),
          new LiveChoice("2 -Jobangebot ablehnen und Studium fortsetzen!", 45)
          });
    steps[43].setUsesSpecialization(true);
    steps[44] = new LiveStep(44, "Du begibst dich ins Berufsleben!",
        new LiveChoice[]{
          new LiveChoice(weiter, 55)
          });
    steps[45] = new LiveStep(45, "Du machst das Studium fertig, aber verlierst das Jobangebot!",
        new LiveChoice[]{
          new LiveChoice(weiter, 46)
          });
    //Stage3
    steps[46] = new LiveStep(46, "Hast du schon ein Thema für deine Bachelorarbeit?",
        new LiveChoice[]{
          new LiveChoice("1 - Ja", 47),
          new LiveChoice("2 - Nein", 47)
          });
    steps[47] = new LiveStep(47, "Deine Freunde laden dich zu einem spontanen Studie-Trip ein"
    + "  Gehst du mit? (Kosten: 500€)",
        new LiveChoice[]{
          new LiveChoice("1 - Ja, ich habe ja noch Zeit", 48),
          new LiveChoice("2 - Nein, ich muss mich auf andere Sachen konzentrieren", 50)
          });
    steps[47].getChoices()[0].setChangeCredit(-500);
    steps[48] = new LiveStep(48, "Du hast dich verschätzt und hast nicht geschafft dich"
    + " rechtzeitig anzumelden", 
        new LiveChoice[]{
          new LiveChoice(weiter, 54)
          });
    steps[48].setNeededPreviousStep(46);
    steps[48].setNeededPreviousAnswer(2);
    steps[48].setAlternativeStep(49);

    steps[49] = new LiveStep(49, "Abwechslung tut gut, du hast dich ja bereits rechtzeitig"
    + " angemeldet", 
        new LiveChoice[]{
          new LiveChoice(weiter, 52)
          });
    steps[50] = new LiveStep(50, "Du bist ein sehr vorbildlicher Student, die Zeichen stehen gut",
        new LiveChoice[]{
          new LiveChoice(weiter, 53)
          });
    steps[50].setNeededPreviousStep(46);
    steps[50].setNeededPreviousAnswer(1);
    steps[50].setAlternativeStep(51);

    steps[51] = new LiveStep(51, "Du hast noch rechtzeitig ein Thema gefunden und dich"
    + " angemeldet!", 
        new LiveChoice[]{
          new LiveChoice(weiter, 52)
          });
    steps[52] = new LiveStep(52, "Du hast eine durchschnittliche Bachelorarbeit geschrieben, du"
    + " hast das Studium soweit abgeschlossen",
        new LiveChoice[]{
          new LiveChoice(weiter, 55)
          });
    steps[53] = new LiveStep(53, "Du hast eine sehr gute Bachelorarbeit geschrieben, Du hast"
    + " dein Bachelor-Studium abgeschlossen",
        new LiveChoice[]{
          new LiveChoice(weiter, 55)
          });
    steps[54] = new LiveStep(54, "Da du die Anmeldung zur Bachelorarbeit verpasst hast, endet"
    + " dein Weg hier!", 
        new LiveChoice[]{
          new LiveChoice(weiter, 55)
          });
    steps[55] = new LiveStep(55, "Hier endet dein Aufstieg als Informatiker.\nVielen Dank fürs "
    + "spielen!",
        new LiveChoice[]{
          new LiveChoice("1- Spiel beenden", 57),
          new LiveChoice("2- Spiel neustarten", 0)
          });
    steps[56] = new LiveStep(56, "Steuerung\n \nDie Steuerung ist sehr einfach.\nDir werden "
    + "verschiedene Wahlmöglichkeiten gegeben.\nDu entscheidest dich mit Zahlen von 1 - 5.\n"
    + "Mit q beendest du das Spiel.\n"
    + "Manchmal werden Ergebnisse geschehen auf die du keinen Einfluss drauf hast.\nEs werden "
    + "auch größere Entscheidungen getroffen, wo du bis zu 5 Wahlmöglichkeiten hast.",
        new LiveChoice[]{
          new LiveChoice(weiter, 1)
          });

    int id = 0;
    LiveStep currentStep = steps[id];
    Scanner in = new Scanner(System.in); 
    clearScreen();


    System.out.println("Bitte geben sie einen Namen ein:");
    String name = in.nextLine();
    clearScreen(); 

    
    Player user = new Player(name);
    clearScreen(); 
    
    boolean gameOver = true;

    gameloop:
    while (gameOver) {
      currentStep = checkGivenAnswer(currentStep, steps);
      currentStep = checkUsesSpecialization(currentStep, steps);

      if (id > 10 && id < 55) {
        System.out.println("Kontostand: " + user.getCredit() + "€");
      }

      System.out.println(currentStep.getDescription());
      LiveChoice[] choices = currentStep.getChoices();
     
      for (int i = 0; i < choices.length; i++) {
        System.out.println(choices[i].getDescription());
      }

      String input = in.nextLine();
      if (isQuitConfirmed(input)) {
        break gameloop;
      }
      int answer = checkInput(input, currentStep);

      while (answer == -1) {
        System.out.println("Fehler bei der Eingabe. Bite erneut versuchen:");
        input = in.nextLine();
        if (isQuitConfirmed(input)) {
          break gameloop;
        }
        answer = checkInput(input, currentStep);
      }

      steps[id].setChoiceTaken(answer);
      id = choices[answer - 1].getNextStep();

      user = checkChangeCredit(choices, user, answer);

      if (id == sumQuestions - 1) {
        gameOver = false;
      }
      currentStep = steps[id];
      clearScreen(); 
    }
  }

  public static Player checkChangeCredit(LiveChoice[] choices, Player user, int answer) {
    int creditChange = choices[answer - 1].getChangeCredit();
    if (creditChange < 0) {
      user.removeMoney(Math.abs(creditChange));
      return user;
    } else if (creditChange > 0) {
      user.addMoney(creditChange);
      return user;
    }
    return user;
  }
  
  public static boolean isQuitConfirmed(String input) {
    if (input.charAt(0) == 'q') {
      System.out.println("\u001B[31m\nMöchten sie das Spiel wirklich beenden?\n1 - Ja\n2 - Nein"
          + " \u001B[0m");
      Scanner in = new Scanner(System.in);
      

      while (true) {
        input = in.nextLine();
        if (input.length() == 1) {
          if (input.startsWith("1")) {
            clearScreen();
            return true;
          }
          if (input.startsWith("2")) {
            System.out.print('\b');
            System.out.print("\033[4A\033[0J");
            return false;
          }
        }
        System.out.println("Fehler bei der Eingabe. Bitte erneut versuchen:");
      }
    }
    return false;
  }

  public static int checkInput(String input, LiveStep currentStep) {
    if (input.length() > 1) {
      return -1;
    } else {
      int answer = 0;
      try {
        answer = Integer.parseInt(input);
        LiveChoice testStep = currentStep.getChoices()[answer - 1];
        return answer;
      } catch (Exception e) {
        return -1;
      }
    }
  }
    
  public static LiveStep checkUsesSpecialization(LiveStep currentStep, LiveStep[] steps) {
    if (currentStep.getUsesSpecialization()) {
      String description = currentStep.getDescription();
      description += " " 
        + steps[24].getChoices()[steps[24].getChoiceTaken() - 1].getDescription().substring(3);
      currentStep.setDescription(description);
      return currentStep;
    } else {
      return currentStep;
    }
  }

  public static LiveStep checkGivenAnswer(LiveStep currentStep, LiveStep[] steps) {
    if (currentStep.getNeededPreviousStep() != 0) {
      int id = currentStep.getNeededPreviousStep();
      LiveStep checkedStep = steps[id]; 

      if (checkedStep.getChoiceTaken() == currentStep.getNeededPreviousAnswer()) {
        return currentStep;
      } else {
        int nextStep = currentStep.getAlternativeStep();
        return steps[nextStep];
      }
    } else {
      return currentStep;
    }

  }

  //https://stackoverflow.com/questions/2979383/java-clear-the-console
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}

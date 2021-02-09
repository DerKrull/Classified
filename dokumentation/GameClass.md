# Game Class Dokumentation

## Main-Methode

### Variablen Dekleration

```java
    Scanner in = new Scanner(System.in);
    int sumQuestions = 58;
    LiveStep[] steps = new LiveStep[sumQuestions];
    String weiter = "1 - Weiter";
```

+ Scanner wird erstellt
+ die Anzahl der Fragen wird festgelegt
+ Das Array `steps` wird mit der Anzahl der Fragen `sumQuestions`initialisiert
+ Für späteren Fragen wird eine Antwort als Variable definiert  

### Initialisierung des LiveStep Arrays

Als Beispiel dient die erste Frage:

```java
    steps[1] = new LiveStep(1, "Du beginnst im ersten Semester mit Mathematische Grundalagen "
    + "der Informatik. \nWie viele Stunden investierst du pro Woche für Mathe?",
        new LiveChoice[]{
          new LiveChoice("1 - Weniger als 5 Std.", 2),
          new LiveChoice("2 - Mehr als 5 Std.", 3)
          });
```

Entsprechend dem Konstruktor der LiveStep Klasse wird jedes Objekt von `steps[]` erstellt.
Zur LiveStep-Klasse: [LiveStep Dokumentation](LiveStepClass.md)

Bei ausgewählten Fragen, werden weitere Attribute des `steps[]` gesetzt, wobei hier die *setter* der [LiveStep](LiveStepClass.md) Klasse benutzt werden.
Zum Beispiel die folgende Frage:

```java
    steps[17] = new LiveStep(17,  "Da du Vorkenntnisse in Java hast, kannst du nach einem"
    + " entsprechenden Nebenjob suchen", new LiveChoice[]{
      new LiveChoice("1 - Da kann ich auch gleich noch Praxiserfahrung sammeln, das klingt gut",
       19),
      new LiveChoice("2 - Ich suche mir lieber einen \"normalen\" Nebenjob und gehe kellnern",
       19)
      });
    steps[17].setNeededPreviousStep(7);
    steps[17].setNeededPreviousAnswer(1);
    steps[17].setAlternativeStep(19);
```

Diese Attribute werden jedoch erst später z.B. in der **[checkGivenAnswer](GameClass.md#checkgivenanswer)**-Methode benötigt.

### Gameloop

#### Initialisierung vor der While-Schleife

```java
    int id = 0;
    LiveStep currentStep = steps[id];
    Scanner in = new Scanner(System.in); 
    clearScreen();
```

1. Die Variable `id` wird verwendet um durch das [LiveStep](LiveStepClass.md) Array zu navigieren, zu Beginn wird sie auf **0** gesetzt.
2. Die Variable `currentStep` enthält immer die aktuelle Frage und wird zu Beginn auf die erste Frage `steps[0]` gesetzt.
3. Der *Scanner* `in` wird auf Basis von **System.in** erstellt.
Danach wird das Konsolenfenster zurückgesetzt, dies kommt dem Befehl `clear` gleich und wird durch die [clearScreen](GameClass.md#clearscreen)-Methode umgesetzt.

```java
    System.out.println("Bitte geben sie einen Namen ein:");
    String name = in.nextLine();
    clearScreen(); 

    
    Player user = new Player(name);
    clearScreen(); 
    
    boolean gameOver = true;
```

Darauf folgend wird der Nutzer über die Ausgabe *"Bitte geben sie einen Namen ein:"* dazu aufgefordert einen Namen einzugeben. Dieser wird dann im `String name` durch den Scanner
eingelesen und gespeichert.
Der Name wird im dann benutzt um einen **User** vom Typ `Player` zu erstellen. ([Dokumentation Player-Klasse](PlayerClass.md))
Zuletzt wird mit der Variable `gameOver` die Abbruchbedingung für die folgende ***while-Schleife*** intialisiert und auf `true` gesetzt.

#### Die While-Schleife

```java
  gameloop:
  while (gameOver) {
    currentStep = checkGivenAnswer(currentStep, steps);
    currentStep = checkUsesSpecialization(currentStep, steps);
```

Zuerst werden in der ***While-Schleife*** die zwei Methoden [checkGivenAnswer](GameClass.md#checkgivenanswer) und [checkUsesSpecialization](GameClass.md#checkusesspecialization)
auf `currentStep` ausgeführt, da sie diesen beeinflussen.

```java
    if (id > 10 && id < 55) {
      System.out.println("Kontostand: " + user.getCredit() + "€");
    }
```
Danach kommt eine kurze Ausgabe, die für alle Fragen mit einer **ID** zwischen **10** und **55** den Kontostand des Spielers ausgibt. Dieser wird durch den ***Getter*** `.getCredit()`
aus der Instanz der ***[Player-Klasse](PlayerClass.md)*** geholt.

```java
    System.out.println(currentStep.getDescription());
    LiveChoice[] choices = currentStep.getChoices();
     
    for (int i = 0; i < choices.length; i++) {
      System.out.println(choices[i].getDescription());
    }
```
In diesem Abschnitt wird zuerst die Frage, also die Description des [LiveSteps](LiveStepClass.md) mittels `currentStep.getDescription` Danach wird ein **[LiveChoice[]](LiveChoiceClass.md)**
angelegt, in das mittels `currentStep.getChoices()` die im [LiveStep](LiveStepClass.md) gespeicherten Antworten übergeben werden. Die for-schleife geht dann jedes Element des `choices` Array durch
und gibt auch von diesen [LiveChoices](LiveChoiceClass.md) die Beschreibung mittels **.getDescription** aus.


```java
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
```
Der nächste Abschnitt betrifft die Eingabe der Antwort. Diese wird zunächst als **String** über `.nextLine()` von der Konsole eingelesen.
Zunächst wird innerhalb einer ***if-Bedingung*** geprüft, ob der Spieler das Spiel stoppen und verlassen möchte, dazu wird der String an die **[isQuitConfirmed](GameClass.md#isquitconfirmed)**
übergeben und entsprechend ausgewertet. Will der Spieler das Spiel verlassen, tritt die ***if-Verzweigung*** in Kraft und der **Gameloop** wird mittels `break gameloop` beendet.
Will der Spieler das Spiel nicht verlassen geht es weiter und es wird eine Variable `int answer` initialisiert, und auf den Rückgabewert der [checkInput](GameClass.md/checkInput)-Methode gesetzt.

Für den Rückgabewert -1, hat die [checkInput](GameClass.md/checkInput)-Methode den Input als eine nicht zulässige Antwort indentifiziert. In diesem Fall, wird eine kurze
Fehlermeldung ausgegeben und erneut auf eine Eingabe gewartet, auch hier wird für jede Eingabe geprüft, ob der Spieler das Spiel verlassen will. Ist das nicht der Fall
wird die Eingabe dann wieder durch die Methode [checkInput](GameClass.md/checkInput) geprüft, dies geschieht solange bis eine Gültige Eingabe vorliegt.

```java
      steps[id].setChoiceTaken(answer);
      id = choices[answer - 1].getNextStep();

      user = checkChangeCredit(choices, user, answer);

      if (id == sumQuestions - 1) {
        gameOver = false;
      }
      currentStep = steps[id];
      clearScreen(); 
```

Dieser letzte Abschnitt dient der Speicherung der Antwort, sowie der Auswahl der nächsten Frage für den nächsten Schleifendurchlauf.
In der ersten Zeile wird die gegebene antwort `answer` im Attribut ChoiceTaken des `steps` mit der aktuellen `id` gespeichert.
Im zweiten Schritt wird die Id der nächsten Frage ermittelt. Hierzu wird die Id der folgenden Frage, die als Attribut in der [LiveChoice](LiveChoiceClass.md)-Klasse gespeichert ist ausgelesen.
Dazu wird das Element aus dem Array genommen, das der gegebenen Antwort entspricht. Jedoch sind Antwort und Stelle des Elements um 1 verschoben (answer = 1 => choices[0])

Danach wird mit der [checkChangeCredit](GameClass.md#checkChangeCredit)-Methode überprüft, ob die gewählte Antwort Auswirkungen auf den `user` hat, ist dies der Fall, wird der User entsprechend
geändert und für das weitere Spiel übernommen.

Darauf folgt eine **if-Verzweigung**. Diese dient dazu, die ***While-Schleife*** abzubrechen, sobald die letzte Frage erreicht ist, dabei ist `sumQuestions` die Länge des Arrays
und `sumQuestions - 1` die Stelle des letzten Elements.

Nach der Verzweigung wird der `currentStep` auf die Frage aus dem `steps` Array an der Stelle der neuen `id` gesetzt.

Zum Schluss des Gameloops wird die Methode [clearScreen] aufgerufen, dabei löscht die Methode die gesamte Ausgabe die aktuell auf der Konsole steht. So wird jede Frage auf einem
"neuen" und freien Bildschirm angezeigt.

## Die weiteren Methoden

### checkChangeCredit

```java
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
```

Dieser Methode wird das aktuelle Antworten-Array bzw- ***LiveChoice-Array*** der aktuellen Frage, sowie die eingegebene Antwort und der ***user*** übergeben. Zurück  gibt die Methode
nur ein Objekt vom Typ **[Player](PlayerClass.md)**.

Innerhalb der Methode wird in den **Integer** `creditChange` das LiveChoice-Attribut `ChangeCredit` übernommen, ist dieser Wert kleiner 0, wird der Betrag des Integer mittels der Objektmethode
`removeMoney` der Betrag vom *Kontostand* des Spielers abgezogen. Ist der Wert größer 0, wird der Wert mittels der Objektmethode `.addMoney` auf den Kontostand des Spielers addiert.
Die Methode gibt dann immer den möglicherweise bearbeiteten `user` zurück.

### isQuitConfirmed

```java
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
```

Diese Methode überprüft den String `input`, ob ein **q** eingegeben wurde. In diesem Fall wird der Rest der Methode aktiv und es wird die Frage ausgegeben, ob der
Spieler das Spiel wirklich beenden will. Danach wird ein Scanner erstellt und auf eine Eingabe gewartet. Gibt der Nutzer eine **1**, wird die Konsole zurückgesetzt
und die Methode gibt den Wert **true** zurück. In diesem Fall tritt in der **[Main-Methode](GameClass.md#diewhileSchleife)** eine ***if-Verzweigung*** in Kraft die
dann den **GameLoop** beendet. Ist die Eingabe nach der Frage **2**, wird die Frage gelöscht und die Methode gibt ***false*** zurück, sodass das Spiel weiter läuft
und der Nutzer mit der ursprünglichen Frage aus dem Spiel fortfahren kann. Sollte der Nutzer weder eine **1** noch eine **2** sein wird eine Fehlermeldung ausgegeben
und die ***while(true)-Schleife*** wird erneut ausgeführt, sodass man aus dieser Endlosschleife nur durch eine valide Eingabe herauskommt.


### checkInput

```java
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
```

An diese Methode wird der `String input` sowie der aktuelle `LiveStep currentStep` weitergegeben. Der Rückgabewert der Methode ist ein Integer, der dann in der Main-Methode als Antwort weiter benutzt wird.

Die Methode hat die Funktion zu prüfen, ob die eingegebene Antwort einer der gültigen Antworten auf die Frage entspricht. Ist dies der Fall entspricht der Rückgabewert der gegebenen
Antwort, jedoch wird diese von einem **String** zu einem **Integer** umgewandelt. Ist die eingegeben Antwort nicht gültig, gibt die Methode **-1** zurück, dieser Wert wird in der
Main-Methode als Fehlercode gewertet.  
Geprüft wird die Eingabe, indem zuerst festgestellt wird, ob die Antwort die Länge 1 hat, da nur solche als gültige Antworten vorkommen. Ist dies der Fall, wird im Rahmen des ***try-Blocks***
getestet, ob der Input eine Zahl ist und somit zu einem **Integer** konvertiert werden kann. Ist auch dies der Fall, wird als nächstes und letztes getestet, ob die Antwort einer Antwort
der Frage entspricht, indem versucht wird, den [LiveChoice](LiveChoiceClass.md) an der eingegebenen Stelle aus dem [LiveChoice](LiveChoiceClass.md)-Array des currentStep in die Variable `testStep` zu speichern.
Wenn alle diese Bedingungen erfüllt sind, wird der zu einem Integer konvertierte `Input` zurück gegeben.

### checkUsesSpecialization

```java
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
```

Dieser Methode werden die aktuelle Frage `currentStep` und das gesamte Fragen-Array `steps` übergeben. Der Rückgabewert der Methode ist die aktuelle Frage in ergänzter Form.  
Die Methode überprüft zunächst, ob das Attribut **usesSpecialization** auf ***true*** gesetzt ist. In diesem Fall wird dem Fragentext am Ende die vorher gewählte Spezialisierung
angefügt. Die Methode wird nur nach der Frage der Wahl einer Spezialisierung verwendet, da sie vorher keinen Sinn.


### checkGivenAnswer

```java
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
```

Dieser Methode werden die aktuelle Frage `currentStep` und das gesamte Fragen-Array `steps` übergeben. Der Rückgabewert der Methode ist die entweder die aktuelle Frage oder
eine andere Frage.

Die Methode überprüft zuerst, ob die aktuelle Frage von einer vorigen Frage bzw. Antwort abhängt. Dies ist der Fall, wenn das Attribut **neededPreviousStep** gesetzt und damit
nicht 0 ist. Ist das Attribut nicht gesetzt, wird die aktuelle Frage zurückgegeben, da in diesem Fall keine vorigen Antworten relevant sind.
Ist das Attribut gesetzt, wird in `id` die ID der zuüberprüfenden Frage gespeichert. Mit dieser ID wird dann die entsprechende Frage aus dem Fragen-Array `steps` an der Stelle
`id` ausgewählt und in `checkedStep` gespeichert.  
Dann wird überprüft, ob die Antwort die bei `checkedStep` gegeben wurde und über die Objektmethode `.getChoiceTaken()` abgerufen wird, der für die aktuelle Frage `currentStep`
benötigten Antwort `currentStep.getNeededPreviousAnswer` entspricht. Sind diese beiden Antworten gleich, wird die aktuelle Frage `currentStep` zurückgegeben und die Frage in
Folge dessen dargestellt.  
Sind die Antworten nicht gleich, geht die Methode in den inneren **Else-Block**. Hier wird dann in `nextStep` die ID der alternativen Frage gespeichert. Anschließend wird die
Frage mit dieser Id aus dem Fragen-Array `steps` ausgewählt und zurückgegeben.


### clearScreen

```java
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
```

Diese Methode dient dazu, den Bildschirm zu "reseten" und ihn für die nächste Frage neuzuladen. Dies geschieht über ANSI Escape Codes.  
Die Methode ist in der Wirkung vergleichbar mit dem Konsolenbefehl ***clear***.



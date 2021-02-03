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

Bei ausgewählten Fragen, werden weitere Attribute des `steps[]` gesetzt, wobei hier die *setter* der LiveStep Klasse benutzt werden.
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

Diese Attribute werden jedoch erst später z.B. in der **checkGivenAnswer**-Methode benötigt.

### Gameloop

#### Initialisierung vor der While-Schleife

```java
    int id = 0;
    LiveStep currentStep = steps[id];
    boolean gameOver = true;
```

1. Die Variable `id` wird verwendet um durch das LiveStep Array zu navigieren, zu Beginn wird sie auf **0** gesetzt.
2. Die Variable `currentStep` enthält immer die aktuelle Frage und wird zu Beginn auf die erste Frage `steps[0]` gesetzt.
3. Die Variable `gameOver` stellt die Bedingung für die ***while-Schleife*** und wird zu Beginn auf **true** gesetzt.

#### Die While-Schleife

```java
    currentStep = checkGivenAnswer(currentStep, steps);
    currentStep = checkUsesSpecialization(currentStep, steps);
```

Zuerst werden in der ***While-Schleife*** die zwei Methoden [checkGivenAnswer](GameClass.md/checkGivenAnswer) und [checkUsesSpecialization](GameClass.md/checkUsesSpecialization) 
auf `currentStep` ausgeführt, da sie diesen beeinflussen.

```java
    System.out.println(currentStep.getDescription());
    LiveChoice[] choices = currentStep.getChoices();
     
    for (int i = 0; i < choices.length; i++) {
      System.out.println(choices[i].getDescription());
    }
```
In diesem Abschnitt wird zuerst die Frage, also die Description des LiveSteps mittels `currentStep.getDescription` Danach wird ein **Livechoice[]** angelegt, in das mittels
´currentStep.getChoices()` die im [LiveStep](LiveStepClass.md) gespeicherten Antworten übergeben werden. Die for-schleife geht dann jedes Element des `choices` Array durch
und gibt auch von diesen [LiveChoices](LiveChoiceClass.md) die Beschreibung mittels **.getDescription** aus.


```java
    String input = in.nextLine();
    int answer = checkInput(input, currentStep);

    while (answer == -1) {
      System.out.println("Fehler bei der Eingabe. Bite erneut versuchen:");
      input = in.nextLine();
      answer = checkInput(input, currentStep);
    }
```
Der nächste Abschnitt betrifft die Eingabe der Antwort. Diese wird zunächst als **String** über `.nextLine()` von der Konsole eingelesen.
Danach wird eine Variable `int answer` initialisiert, und auf den Rückgabewert der [checkInput](GameClass.md/checkInput)-Methode gesetzt.

Für den Rückgabewert -1, hat die [checkInput](GameClass.md/checkInput)-Methode den Input als eine nicht zulässige Antwort indentifiziert. In diesem Fall, wird eine kurze
Fehlermeldung ausgegeben und erneut auf eine Eingabe gewartet. Diese Eingabe wird dann wieder durch die Methode geprüft, dies geschieht solange bis eine Gültige Eingabe
vorliegt.

```java
      steps[id].setChoiceTaken(answer);
      id = choices[answer - 1].getNextStep();
      if (id == sumQuestions - 1) {
        gameOver = false;
      }
      currentStep = steps[id];
      clearScreen(); 
```

Dieser letzte Abschnitt dient der Speicherung der Antwort, sowie der Auswahl der nächsten Frage für den nächsten Schleifendurchlauf.
In der ersten Zeile wird die gegebene antwort `answer` im Attribut ChoiceTaken des `steps` mit der aktuellen `id` gespeichert.
Im zweiten Schritt wird die Id der nächsten Frage ermittelt. Hierzu wird die Id der folgenden Frage, die als Attribut in der LiveChoice-Klasse gespeichert ist ausgelesen.
Dazu wird das Element aus dem Array genommen, das der gegebenen Antwort entspricht. Jedoch sind Antwort und Stelle des Elements um 1 verschoben (answer = 1 => choices[0])

Darauf folgt eine **if-Verzweigung**. Diese dient dazu, die ***While-Schleife*** abzubrechen, sobald die letzte Frage erreicht ist, dabei ist `sumQuestions` die Länge des Arrays
und `sumQuestions - 1` die Stelle des letzten Elements.

Nach der Verzweigung wird der `currentStep` auf die Frage aus dem `steps` Array an der Stelle der neuen `id` gesetzt.

Zum Schluss des Gameloops wird die Methode [clearScreen] aufgerufen, dabei löscht die Methode die gesamte Ausgabe die aktuell auf der Konsole steht. So wird jede Frage auf einem
"neuen" und freien Bildschirm angezeigt.

## Die weiteren Methoden

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
der Frage entspricht, indem versucht wird, den LiveChoice an der eingegebenen Stelle aus dem LiveChoice-Array des currentStep in die Variable `testStep` zu speichern.
Wenn alle diese Bedingungen erfüllt sind, wird der zu einem Integer konvertierte `Input` zurück gegeben.

### checkUsesSpecialization

### checkGivenAnswer

### clearScreen



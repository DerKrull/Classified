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

Zuerst werden in der ***While-Schleife*
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
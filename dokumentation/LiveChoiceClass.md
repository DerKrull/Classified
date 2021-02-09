# LiveChoice Class Dokumentation

## Attribute

```java
  private String description;
  private int nextStep;
  private int changeCredit;
```

+ In ***description*** wird der Text der Antwortmöglichkeit gespeichert
+ In ***nextStep*** wird die, der auf die Antwort folgenden Frage gespeichert
+ In ****changeCredit*** wird, wenn benötigt, ein "Geld"-Wert gespeichert, der dann Einfluss auf den Kontostand des Spielers hat.

## Konstruktor

```java
  public LiveChoice(String description, int nextStep) {
    this.description = description;
    this.nextStep = nextStep;
  }
```

Im Konstruktor werden die beiden Attribute der Klasse gesetzt.

Das ***changeCredit***-Attribut wird nur bei Fragen gesetzt, wenn die entsprechende Antwort einen Einfluss auf den Kontostand des Spielers haben soll.
Zum Beispiel:
```java
    steps[40] = new LiveStep(40, "Dein Partner fragt, ob ihr zusammenziehen wollt.\n"
    + " Der Umzug kostet 150€",
        new LiveChoice[]{
          new LiveChoice("1 -Ja!", 41),
          new LiveChoice("2 -Nein!", 42)
          });
    steps[40].getChoices()[0].setChangeCredit(-150);
```

## Objektmethoden

Alle Objektmethoden sind ***Getter*** und ***Setter*** für die Attribute der Klasse.
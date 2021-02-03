# LiveChoice Class Dokumentation

## Attribute

```java
  private String description;
  private int nextStep;
```

+ In ***description*** wird der Text der Antwortmöglichkeit gespeichert
+ In ***nextStep*** wird die, der auf die Antwort folgenden Frage gespeichert

## Konstruktor

```java
  public LiveChoice(String description, int nextStep) {
    this.description = description;
    this.nextStep = nextStep;
  }
```

Im Konstruktor werden die beiden Attribute der Klasse gesetzt.

## Objektmethoden

Alle Objektmethoden sind ***Getter*** und ***Setter*** für die Attribute der Klasse.
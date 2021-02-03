# LiveStep Class Dokumentation

## Attribute

```java
  private int id;
  private String description;
  private LiveChoice[] choices;
  private int choiceTaken;
  private int neededPreviousStep;
  private int neededPreviousAnswer;
  private int alternativeStep;
  private boolean usesSpecialization;
```

+ ***id*** dient der exakten Identifizierung der einzelnen LiveSteps beispielsweise im Array
+ In ***description*** wird der Text der Frage gespeichert
+ In ***choices*** werden die Antwortmöglichkeiten mit dem Typ LiveChoice gespeichert
+ In ***choiceTaken*** wird die Antwort gespeichert, die auf die Frage gegeben wurde
+ Die Attribute ***neededPreviousStep***, ***neededPreviousAnswer*** sowie ***alternativeStep*** werden für die Methode [checkGivenAnswer](GameClass.md/checkGivenAnswer)
  benötigt. Hierzu wird in ***neededPreviousStep*** die ID der Frage gespeichert, welche in der Methode überprüft wird. In ***neededPreviousAnswer*** wird dann die Antwort gespeichert,
  die für das Auftauchen der aktuellen Frage benötigt wird. Ist die entsprechend benötigte Antwort nicht bei der zu überprüfenden Frage gegeben worden, wird ***alternativeStep***
  relevant, da in diesem Fall direkt auf die Frage gesprungen wird, deren Id in ***alternativeStep*** gespeichert wird.
+ ***usesSpecialization*** ist für die Methode [checkUsesSpecialization](GameClass.md/checkUsesSpecialization) wichtig, da diese nur aktiv wird, sobald ***usesSpecialization*** den
  Wert **true** hat.
  
## Konstruktor

```java
  public LiveStep(int id, String description, LiveChoice[] choices) {
    this.id = id;
    this.description = description;
    this.choices = choices;
  }
```

Im Konstruktor der LiveStep-Klasse wird die ***id***, die ***description*** und die Antwortmöglichkeiten ***choices*** definiert

Alle anderen Attribute werden nur dann gesetzt, sollten sie für die jeweilige Frage relevant sein, da diese auf der Logik bestimmter Methoden basiert.

## Objektmethoden

Alle Objektmethoden sind ***Getter*** und ***Setter*** für alle Attribute:

```java
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LiveChoice[] getChoices() {
    return choices;
  }

  public void setChoices(LiveChoice[] choices) {
    this.choices = choices;
  }

  public int getChoiceTaken() {
    return choiceTaken;
  }

  public void setChoiceTaken(int choiceTaken) {
    this.choiceTaken = choiceTaken;
  }

  public int getNeededPreviousStep() {
    return neededPreviousStep;
  }

  public void setNeededPreviousStep(int neededPreviousStep) {
    this.neededPreviousStep = neededPreviousStep;
  }

  public int getNeededPreviousAnswer() {
    return neededPreviousAnswer;
  }

  public void setNeededPreviousAnswer(int neededPreviousAnswer) {
    this.neededPreviousAnswer = neededPreviousAnswer;
  }

  public int getAlternativeStep() {
    return alternativeStep;
  }

  public void setAlternativeStep(int alternativeStep) {
    this.alternativeStep = alternativeStep;
  }

  public boolean getUsesSpecialization() {
    return usesSpecialization;
  }
 
  public void setUsesSpecialization(boolean usesSpecialization) {
    this.usesSpecialization = usesSpecialization;
  }
```
public class LiveStep {
  private int id;
  private String description;
  private LiveChoice[] choices;
  private int choiceTaken;
  private int neededPreviousStep;
  private int neededPreviousAnswer;
  private int alternativeStep;

  public LiveStep(int id, String description, LiveChoice[] choices) {
    this.id = id;
    this.description = description;
    this.choices = choices;
  }

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


 
}
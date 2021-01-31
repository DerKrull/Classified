public class LiveChoice {
  private String description;
  private int nextStep;

  public LiveChoice(String description, int nextStep) {
    this.description = description;
    this.nextStep = nextStep;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getNextStep() {
    return nextStep;
  }

  public void setNextStep(int nextStep) {
    this.nextStep = nextStep;
  }

}
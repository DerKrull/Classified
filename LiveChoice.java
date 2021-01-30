public class LiveChoice {
  private String description;
  private int nextStep;
  private int addMoney;
  private int removeMoney;

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

  public int getAddMoney() {
    return addMoney;
  }

  public void setAddMoney(int addMoney) {
    this.addMoney = addMoney;
  }

  public int getRemoveMoney() {
    return removeMoney;
  }

  public void setRemoveMoney(int removeMoney) {
    this.removeMoney = removeMoney;
  }

}
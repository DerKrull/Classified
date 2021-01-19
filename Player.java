public class Player {
  private String name;
  private int credit = 0;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }

  public void addMoney(int amount) {
    this.credit += amount;
  }

  public void removeMoney(int amount) {
    this.credit -= amount;
  }
}

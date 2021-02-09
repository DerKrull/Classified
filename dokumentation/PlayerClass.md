# Player Class Dokumentation

## Attribute

```java
  private String name;
  private int credit = 0;
```
+ In ***name*** wird der Name des "Player" bzw. Spielers gespeichert.
+ In ***credit*** wird der Kontostand des Spielers gespeichert.

## Konstruktor

```java
  public Player(String name) {
    this.name = name;
  }
```

Ein Objekt der Klasse ***Player*** wird nur mit einem **Namen** erstellt, der Kontostand wird zu Beginn auf **0** belassen.

## Objektmethoden

Außer den ***Getter*** und ***Setter***'n besitzt diese Klasse über zwei weitere Methoden

### addMoney

```java
  public void addMoney(int amount) {
    this.credit += amount;
  }
```

Mit dieser Methode kann ein beliebiger Wert `amount` zu dem bestehenden Kontostand addiert werden.

### removeMoney

```java
  public void removeMoney(int amount) {
    this.credit -= amount;
  }
```

Mit dieser Methode kann ein beliebiger Wert `amount` von dem bestehenden Kontostand subtrahiert werden.
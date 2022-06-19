package no.edvardsen.wargameapi.models;

/**
 * An abstract class representing the common features of a unit
 * in the war game
 */
public abstract class Unit {
  private String name;
  private int health;
  private int attack;
  private int armor;

  public Unit(String name, int health, int attack, int armor) {
    if (name.isEmpty() || health < 0 || attack < 0 || armor < 0) {
      throw new IllegalArgumentException("One or more of the fields in the constructor " +
      "are invalid");
    }
    this.name = name;
    this.health = health;
    this.attack = attack;
    this.armor = armor;
  }

  /**
   * Attacks a unit
   * @param unit the unit to attack
   */
  public void attach(Unit opponent) {
    int healthOpponent = opponent.getHealth();
    opponent.setHealth(healthOpponent - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus()));
  }

  // TODO
  public int getAttackBonus() {
    return 0;
  }
  
  // TODO
  public int getResistBonus() {
    return 0;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getArmor() {
    return this.armor;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", health='" + getHealth() + "'" +
      ", attack='" + getAttack() + "'" +
      ", armor='" + getArmor() + "'" +
      "}";
  }
}

package no.edvardsen.wargameapi.models.units;

import no.edvardsen.wargameapi.models.Terrain;

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
   * @param terrain the terrain they are currently fighting in
   * @return {@code true} if the unit attacked died during the attack, {@code false} otherwise
   */
  public boolean attack(Unit opponent, Terrain terrain) {
    int healthOpponent = opponent.getHealth();
    opponent.setHealth(healthOpponent - (this.getAttack() + this.getAttackBonus(terrain)) + (opponent.getArmor() + opponent.getResistBonus(terrain)));
    return (opponent.getHealth() > 0) ? false : true;
  }

  /**
   * Returns the attack bonus of the unit
   * @param terrain, the terrain they are currently fighting in
   * @return the attack bonus of the unit
   */
  public abstract int getAttackBonus(Terrain terrain);

  /**
   * Returns the default resistance bonus of the unit
   * @return the default resistance bonus
   */
  public abstract int getResistBonus();
  
  /**
   * Returns the resistance bonus of the unit based on the terrain
   * @param terrain, the terrain they are currently fighting in
   * @return the resistance bonus of the unit
   */
  public abstract int getResistBonus(Terrain terrain);

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

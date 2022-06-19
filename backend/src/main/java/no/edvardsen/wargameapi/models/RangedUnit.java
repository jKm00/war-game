package no.edvardsen.wargameapi.models;

public class RangedUnit extends Unit {

  private final int STRENGTH = 3;
  private final int RESISTANCE_LOWER_BOUND = 2;
  private int resistance = 6;

  public RangedUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  public RangedUnit(String name, int health) {
    super(name, health, 15, 8);
  }

  @Override
  public int getAttackBonus() {
    return this.STRENGTH;
  }

  @Override
  public int getResistBonus() {
    int resistanceValue = this.resistance;
    if (this.resistance > RESISTANCE_LOWER_BOUND) {
      this.resistance -= 2;
    }
    return resistanceValue;
  }
}

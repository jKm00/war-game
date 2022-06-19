package no.edvardsen.wargameapi.models.units;

public class InfantryUnit extends Unit {

  private final int STRENGTH = 2;
  private final int RESISTANCE = 1;

  public InfantryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  public InfantryUnit(String name, int health) {
    super(name, health, 15, 10);
  }

  @Override
  public int getAttackBonus() {
    return this.STRENGTH;
  }

  @Override
  public int getResistBonus() {
    return this.RESISTANCE;
  }
}

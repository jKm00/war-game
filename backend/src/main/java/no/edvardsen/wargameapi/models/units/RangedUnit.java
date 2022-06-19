package no.edvardsen.wargameapi.models.units;

import no.edvardsen.wargameapi.models.Terrain;

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
  public int getAttackBonus(Terrain terrain) {
    if (terrain.getTerrain().equals("HILL")) {
      return this.STRENGTH + 2;
    } else if (terrain.getTerrain().equals("FOREST")) {
      return this.STRENGTH - 2;
    }
    return this.STRENGTH;
  }

  @Override
  public int getResistBonus(Terrain terrain) {
    int resistanceValue = this.resistance;
    if (this.resistance > RESISTANCE_LOWER_BOUND) {
      this.resistance -= 2;
    }
    return resistanceValue;
  }
}

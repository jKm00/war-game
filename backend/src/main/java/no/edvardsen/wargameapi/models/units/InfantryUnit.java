package no.edvardsen.wargameapi.models.units;

import no.edvardsen.wargameapi.models.Terrain;

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
  public int getAttackBonus(Terrain terrain) {
    if (terrain.getTerrain().equals("FOREST")) {
      return this.STRENGTH + 2;
    }
    return this.STRENGTH;
  }

  @Override
  public int getResistBonus(Terrain terrain) {
    if (terrain.getTerrain().equals("FOREST")) {
      return this.RESISTANCE + 2;
    }
    return this.RESISTANCE;
  }
}

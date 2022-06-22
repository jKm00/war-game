package no.edvardsen.wargameapi.models.units;

import no.edvardsen.wargameapi.models.Terrain;

public class CavalryUnit extends Unit {

  private boolean attacked = false;

  public CavalryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  public CavalryUnit(String name, int health) {
    super(name, health, 20, 12);
  }

  @Override
  public int getAttackBonus(Terrain terrain) {
    int bonus = 0;
    if (terrain == Terrain.PLAINS) {
      bonus = 2;
    }
    if (!attacked) {
      this.attacked = !this.attacked;
      return 6 + bonus;
    } else {
      return 2 + bonus;
    }
  }

  @Override
  public int getResistBonus() {
    return 1;
  }

  @Override
  public int getResistBonus(Terrain terrain) {
    if (terrain == Terrain.FOREST) {
      return 0;
    }
    return 1;
  }
}

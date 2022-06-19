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

  // TODO: Implement terrain advantages
  @Override
  public int getAttackBonus(Terrain terrain) {
    if (!attacked) {
      this.attacked = !this.attacked;
      return 6;
    } else {
      return 2;
    }
  }

  // TODO: This cant be right, read the discription again
  @Override
  public int getResistBonus() {
    return 1;
  }
}

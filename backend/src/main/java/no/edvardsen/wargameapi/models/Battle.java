package no.edvardsen.wargameapi.models;

import java.util.Random;

import no.edvardsen.wargameapi.models.units.Unit;

/**
 * Represents a battle between two armys
 */
public class Battle {
  private Army armyOne;
  private Army armyTwo;
  private Terrain terrain;
  private final Random rand = new Random();

  public Battle(Army armyOne, Army armyTwo) {
    if (armyOne == null || armyTwo == null) {
      throw new IllegalArgumentException("One or both armys are null");
    }
    this.armyOne = armyOne;
    this.armyTwo = armyTwo;
    this.terrain = Terrain.FOREST;
  }

  public Army simulate() {
    Army winner = null;
    while (winner == null) {
      int armyToAttack = this.rand.nextInt(2);
      if (armyToAttack == 0) {
        winner = this.fight(armyOne, armyTwo);
      } else {
        winner = this.fight(armyTwo, armyOne);
      }
    }
    return winner;
  }

  /**
   * Simulates a single fight between two armys.
   * @param attackingArmy the army that is attacking
   * @param defendingArmy the army that is getting attacked
   * @return if an army won the army is returned, if not {@code null} is returned
   */
  private Army fight(Army attackingArmy, Army defendingArmy) {
    Unit attackingUnit = attackingArmy.getRandom();
    Unit defendingUnit = defendingArmy.getRandom();
    if (attackingUnit.attack(defendingUnit, this.terrain)) {
      defendingArmy.remove(defendingUnit);
    }
    if (!defendingArmy.hasUnits()) {
      return attackingArmy;
    }
    return null;
  }

  private Army getArmyOne() {
    return this.armyOne;
  }

  private Army getArmyTwo() {
    return this.armyTwo;
  }

  public Terrain getTerrain() {
    return this.terrain;
  }

  @Override
  public String toString() {
    return "{" +
      " armyOne='" + getArmyOne() + "'" +
      ", armyTwo='" + getArmyTwo() + "'" +
      "}";
  }
}

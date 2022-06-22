package no.edvardsen.wargameapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.edvardsen.wargameapi.factories.UnitFactory;
import no.edvardsen.wargameapi.models.Army;
import no.edvardsen.wargameapi.models.Battle;

@Service
public class BattleService {

  @Autowired
  private UnitFactory unitFactory;

  /**
   * Starts the simulation of the battle
   * @return the winner of the battle
   */
  public Army simulateBattle() {
    Army armyOne = new Army("Human army");
    armyOne.addAll(unitFactory.getUnits(500, "infantry", "Footman", 100));
    armyOne.addAll(unitFactory.getUnits(100, "cavalry", "Knight", 100));
    armyOne.addAll(unitFactory.getUnits(200, "ranged", "Archer", 100));
    armyOne.addAll(unitFactory.getUnits(1, "commander", "Mountain King", 180));

    Army armyTwo = new Army("Orcish horde");
    armyTwo.addAll(unitFactory.getUnits(500, "infantry", "Grunt", 100));
    armyTwo.addAll(unitFactory.getUnits(100, "cavalry", "Raider", 100));
    armyTwo.addAll(unitFactory.getUnits(200, "ranged", "Spearman", 100));
    armyTwo.addAll(unitFactory.getUnits(1, "commander", "Gul'dan", 180));
    
    Battle battleField = new Battle(armyOne, armyTwo);
    return battleField.simulate();
  }
}

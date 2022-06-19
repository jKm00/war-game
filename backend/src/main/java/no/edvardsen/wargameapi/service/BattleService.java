package no.edvardsen.wargameapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import no.edvardsen.wargameapi.models.Army;
import no.edvardsen.wargameapi.models.Battle;
import no.edvardsen.wargameapi.models.units.CavalryUnit;
import no.edvardsen.wargameapi.models.units.CommanderUnit;
import no.edvardsen.wargameapi.models.units.InfantryUnit;
import no.edvardsen.wargameapi.models.units.RangedUnit;
import no.edvardsen.wargameapi.models.units.Unit;

@Service
public class BattleService {

  /**
   * Starts the simulation of the battle
   * @return the winner of the battle
   */
  public Army simulateBattle() {
    Army armyOne = this.initializeArmy("Human army", "Footman", 1, "Knight", 1, "Archer", 1, "Mountain King", 1);
    Army armyTwo = this.initializeArmy("Orcish horde", "Grunt", 1, "Raider", 1, "Spearman", 1, "Gul'dan", 1);

    Battle battleField = new Battle(armyOne, armyTwo);
    return battleField.simulate();
  }

  /**
   * Initializes an army
   * @param armyName name of the army
   * @param infantryName the of the infantries
   * @param infantryAmount how many infantries there should be in the army
   * @param cavalryName name of the cavalries
   * @param cavalryAmount how many cavalries there should be in the army
   * @param rangedName name of the rangers
   * @param rangedAmount how many rangers there should be in the army
   * @param commanderName name of the commanders
   * @param commanderAmount how many commanders there should be in the army
   * @return an army with all units
   */
  private Army initializeArmy(String armyName, String infantryName, int infantryAmount, String cavalryName, int cavalryAmount, String rangedName, int rangedAmount, String commanderName, int commanderAmount) {
    List<Unit> units = new ArrayList<>();
    for (int i = 0; i < infantryAmount; i++) {
      units.add(new InfantryUnit(infantryName, 100));
    }
    for (int i = 0; i < cavalryAmount; i++) {
      units.add(new CavalryUnit(cavalryName, 100));
    }
    for (int i = 0; i < rangedAmount; i++) {
      units.add(new RangedUnit(rangedName, 100));
    }
    for (int i = 0; i < commanderAmount; i++) {
      units.add(new CommanderUnit(commanderName, 180));
    }
    return new Army(armyName, units);
  }
}

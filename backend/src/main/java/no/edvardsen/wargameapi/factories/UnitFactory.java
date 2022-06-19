package no.edvardsen.wargameapi.factories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import no.edvardsen.wargameapi.models.units.CavalryUnit;
import no.edvardsen.wargameapi.models.units.CommanderUnit;
import no.edvardsen.wargameapi.models.units.InfantryUnit;
import no.edvardsen.wargameapi.models.units.RangedUnit;
import no.edvardsen.wargameapi.models.units.Unit;

@Service
public class UnitFactory {
  /**
   * Creates a unit
   * @param type of unit, "infantry", "ranged", "cavalry" or "commander"
   * @param name of unit
   * @param health the unit should have
   * @return the created unit
   */
  public Unit createUnit(String type, String name, int health) {
    Unit unit;
    switch(type.toLowerCase()) {
      case "infantry":
        unit = new InfantryUnit(name, health);
        break;
      case "ranged":
        unit = new RangedUnit(name, health);
        break;
      case "cavalry":
        unit = new CavalryUnit(name, health);
        break;
      case "commander":
        unit = new CommanderUnit(name, health);
        break;
      default:
        throw new IllegalArgumentException(type + " is not a valid unit");
    }
    return unit;
  }

  /**
   * Returns a list of n number of units based on unit type, name and health points
   * @param amount the amount of units the create
   * @param type the type of units to create
   * @param name the name of the units
   * @param health the health of the units
   * @return a list with n number of units
   */
  public List<Unit> getUnits(int amount, String type, String name, int health) {
    List<Unit> units = new ArrayList<>();
    for (int i = 0; i < amount; i++) {
      units.add(this.createUnit(type, name, health));
    }
    return units;
  }
}

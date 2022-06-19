package no.edvardsen.wargameapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import no.edvardsen.wargameapi.models.units.CavalryUnit;
import no.edvardsen.wargameapi.models.units.CommanderUnit;
import no.edvardsen.wargameapi.models.units.InfantryUnit;
import no.edvardsen.wargameapi.models.units.RangedUnit;
import no.edvardsen.wargameapi.models.units.Unit;

/**
 * Represents an army on the battlefield
 */
public class Army {
  private String name;
  @JsonIgnore
  private List<Unit> units;

  public Army(String name) {
    this.name = name;
    this.units = new ArrayList<>();
  }
  
  public Army(String name, List<Unit> units) {
    this.name = name;
    this.units = units;
  }

  /**
   * Returns a list of infantry units only
   * @return a list of all infantry units in the army
   */
  public List<Unit> getInfantryUnits() {
    return this.units
    .stream()
    .filter(unit -> unit instanceof InfantryUnit)
    .collect(Collectors.toList());
  }

  /**
   * Retusn a list of all cavalries in the army
   * @return a list of all cavalries
   */
  public List<Unit> getCavalryUnits() {
    return this.units
    .stream()
    .filter(unit -> unit instanceof CavalryUnit && !(unit instanceof CommanderUnit))
    .collect(Collectors.toList());
  }

  /**
   * Returns a list with all ranged units in the army
   * @return a list with all ranged units
   */
  public List<Unit> getRangeUnits() {
    return this.units
    .stream()
    .filter(unit -> unit instanceof RangedUnit)
    .collect(Collectors.toList());
  }

  /**
   * Returns a list of all commander units in the army
   * @return a list of all commander units
   */
  public List<Unit> getCommanderUnits() {
    return this.units
    .stream()
    .filter(unit -> unit instanceof CommanderUnit)
    .collect(Collectors.toList());
  }

  /**
   * Returns the name of the army
   * @return the name of the army
   */
  public String getName() {
    return this.name;
  }

  /**
   * Adds a single unit to the army
   * @param unit the unit to be added
   */
  public void add(Unit unit) {
    this.units.add(unit);
  }

  /**
   * Adds a list of units to the army
   * @param units the list of units to be added to the army
   */
  public void addAll(List<Unit> units) {
    units.forEach(unit -> this.units.add(unit));
  }

  /**
   * Removes a unit from the army
   * @param unit the unit to be removed
   * @return {@code true} if unit was remove, {@code false} otherwise
   */
  public boolean remove(Unit unit) {
    return this.units.remove(unit);
  }

  /**
   * Returns {@code true} if there are units in the army, {@code false} otherwise
   * @return {@code true} if there are units in the army, {@code false} otherwise
   */
  public boolean hasUnits() {
    return this.units.size() != 0;
  }

  /**
   * Returns a radnom unit from the army
   * @return a random unit from the army
   */
  public Unit getRandom() {
    Random rand = new Random();
    return this.units.get(rand.nextInt(this.units.size()));
  }

  private List<Unit> getUnits() {
    return this.units;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", units='" + getUnits() + "'" +
      "}";
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Army)) {
            return false;
        }
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, units);
  }

}

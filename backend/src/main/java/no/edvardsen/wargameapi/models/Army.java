package no.edvardsen.wargameapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    this.units = units;
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

package no.edvardsen.wargameapi.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import no.edvardsen.wargameapi.models.units.CavalryUnit;
import no.edvardsen.wargameapi.models.units.CommanderUnit;
import no.edvardsen.wargameapi.models.units.InfantryUnit;
import no.edvardsen.wargameapi.models.units.RangedUnit;
import no.edvardsen.wargameapi.models.units.Unit;

@SpringBootTest
public class UnitTest {

  @Test
  public void testCreation() {
    Unit infantryUnit = new InfantryUnit("Infantry", 100, 10, 10);
    Unit cavalryUnit = new CavalryUnit("Cavalry", 100, 20, 10);
    Unit rangedUnit = new RangedUnit("Ranged", 60, 15, 20);
    Unit commanderUnit = new CommanderUnit("Commander", 50, 5, 5);

    assertEquals(infantryUnit.getName(), "Infantry");
    assertEquals(cavalryUnit.getName(), "Cavalry");
    assertEquals(rangedUnit.getName(), "Ranged");
    assertEquals(commanderUnit.getName(), "Commander");

    assertEquals(infantryUnit.getHealth(), 100);
    assertEquals(cavalryUnit.getHealth(), 100);
    assertEquals(rangedUnit.getHealth(), 60);
    assertEquals(commanderUnit.getHealth(), 50);
  }

  @Test
  public void testFalseCreation() {
    try {
      new InfantryUnit("Infantry", -100);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testAttack() {
    Unit infantryUnit = new InfantryUnit("Infantry", 100, 10, 10);
    Unit rangedUnit = new RangedUnit("Ranged", 70, 20, 5);

    infantryUnit.attack(rangedUnit);

    assertEquals(rangedUnit.getHealth(), 69);

    infantryUnit.attack(rangedUnit);

    assertEquals(rangedUnit.getHealth(), 66);
  }

  @Test
  public void testRangedResistance() {
    Unit rangedUnit = new RangedUnit("Ranged", 100);
    assertEquals(rangedUnit.getResistBonus(), 6);
    assertEquals(rangedUnit.getResistBonus(), 4);
    assertEquals(rangedUnit.getResistBonus(), 2);
    assertEquals(rangedUnit.getResistBonus(), 2);
  }

  @Test
  public void testCavalryAttack() {
    Unit cavalry = new CavalryUnit("Cavalry", 100);
    
    assertEquals(cavalry.getAttackBonus(), 6);
    assertEquals(cavalry.getAttackBonus(), 2);
    assertEquals(cavalry.getAttackBonus(), 2);
  }
  
}

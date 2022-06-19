package no.edvardsen.wargameapi.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnitTest {

  @Test
  void testCreation() {
    InfantryUnit infantryUnit = new InfantryUnit("Infantry", 100, 10, 10);
    CavalryUnit cavalryUnit = new CavalryUnit("Cavalry", 100, 20, 10);
    RangedUnit rangedUnit = new RangedUnit("Ranged", 60, 15, 20);
    CommanderUnit commanderUnit = new CommanderUnit("Commander", 50, 5, 5);

    assertEquals(infantryUnit.getName(), "Infantry");
    assertEquals(cavalryUnit.getName(), "Cavalry");
    assertEquals(rangedUnit.getName(), "Ranged");
    assertEquals(commanderUnit.getName(), "commander");

    assertEquals(infantryUnit.getHealth(), 100);
    assertEquals(cavalryUnit.getHealth(), 100);
    assertEquals(rangedUnit.getHealth(), 60);
    assertEquals(commanderUnit.getHealth(), 50);
  }

  @Test
  void testAttack() {
    InfantryUnit infantryUnit = new InfantryUnit("Infantry", 100, 10, 10);
    RangedUnit rangedUnit = new RangedUnit("Ranged", 70, 20, 5);

    infantryUnit.attack(rangedUnit);

    int infantryAttack = infantryUnit.getAttack() + infantryUnit.getAttackBonus();
    int rangedResist = rangedUnit.getArmor() + rangedUnit.getResistBonus();
    assertEquals(rangedUnit.getHealth(), rangedUnit.getHealth() - infantryAttack + rangedResist);
  }
  
}

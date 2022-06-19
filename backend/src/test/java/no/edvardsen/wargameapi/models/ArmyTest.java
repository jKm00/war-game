package no.edvardsen.wargameapi.models;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import no.edvardsen.wargameapi.models.units.CavalryUnit;
import no.edvardsen.wargameapi.models.units.CommanderUnit;
import no.edvardsen.wargameapi.models.units.Unit;

@SpringBootTest
public class ArmyTest {
  @Test
  public void testCreation() {
    Army armyOne = new Army("My army");

    List<Unit> units = new ArrayList<>();
    units.add(new CommanderUnit("Commander", 100));
    units.add(new CavalryUnit("Cavalry", 50));

    Army armyTwo = new Army("My army two", units);

    assertEquals("My army", armyOne.getName());
    assertEquals("My army two", armyTwo.getName());

    assertTrue(!armyOne.hasUnits());
    assertTrue(armyTwo.hasUnits());
  }
}

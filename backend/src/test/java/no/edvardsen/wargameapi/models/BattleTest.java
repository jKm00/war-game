package no.edvardsen.wargameapi.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BattleTest {
  @Test
  public void createFalseBattle() {
    try {
      new Battle(null, null);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    } 
  }

  @Test
  public void createBattle() {
    try {
      new Battle(new Army("Army one"), new Army("Army two"));
      assertTrue(true);
    } catch (Exception e) {
      assertTrue(false);
    }
  }
}

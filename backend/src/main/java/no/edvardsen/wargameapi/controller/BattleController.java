package no.edvardsen.wargameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.edvardsen.wargameapi.service.BattleService;

@RestController
@RequestMapping("/battle")
public class BattleController {
  @Autowired
  private BattleService battleService;

  @GetMapping()
  public String simulateBattle() {
    return battleService.simulateBattle().getName();
  }
}

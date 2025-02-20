package ch.samt.collectionGame.controller;

import ch.samt.collectionGame.domain.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;


@Controller
public class GameHashController {
    private static final Map<Integer, Game> games = new HashMap<>();

    static {
        Game zelda = new Game(1,"zelda","action",15);
        games.put(zelda.getId(),zelda);
        Game packman = new Game(2,"packman","arcade",20);
        games.put(packman.getId(), packman);
        Game ageOfEmpries = new Game(3,"age of empries","stategy",25);
        games.put(ageOfEmpries.getId(),ageOfEmpries);
        Game spaceInvaders = new Game(4,"space invaders","stategy",50);
        games.put(spaceInvaders.getId(), spaceInvaders);
    }


    @GetMapping("/newgamelist")
    public String newGameList(Model model, @RequestParam(value = "gameId", required = false) Integer gameId) {
        if (gameId != null) {
            for (Game game : games.values()) {
                if (gameId.equals(game.getId())) {
                    model.addAttribute("game", games.values());
                }
            }
        } else {
            model.addAttribute("game", games.values());
        }
        return "gameList";
    }

}

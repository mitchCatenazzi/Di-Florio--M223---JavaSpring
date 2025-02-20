package ch.samt.collectionGame.controller;

import ch.samt.collectionGame.domain.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GamesController {

    private static List<Game> games = new ArrayList<Game>();

    static {
        Game zelda = new Game(1,"zelda","action",15);
        games.add(zelda);
        Game packman = new Game(2,"packman","arcade",20);
        games.add(packman);
        Game ageOfEmpries = new Game(3,"age of empries","stategy",25);
        games.add(ageOfEmpries);
        Game spaceInvaders = new Game(4,"space invaders","stategy",50);
        games.add(spaceInvaders);
    }

    @GetMapping("/games")
    public String name() {
        //model.addAttribute("Michele Catenazzi's game collection");
        System.out.println("Michele Catenazzi's game collection");
        return "games";
    }


    @GetMapping("/games/list")
    public String gameList(Model model, @RequestParam(value = "gameId", required = false) Integer gameId) {
        if (gameId != null) {
            for (Game game : games) {
                if (gameId.equals(game.getId())) {
                    model.addAttribute("games", game);
                }
                else{
                    model.addAttribute("game", new Game());
                }
            }
        } else {
            model.addAttribute("games", games);
        }
        return "gameList";
    }

    @GetMapping("/games/list/{type}")
    public String gameType(Model model, @PathVariable(value = "type", required = false) String gameType) {
        if (gameType != null) {
            for (Game game : games) {
                if (gameType.equals(game.getType())) {
                    model.addAttribute("games", game);
                }
                else{
                    model.addAttribute("game", new Game());
                }
            }
        } else {
            model.addAttribute("games", games);
        }
        return "gameList";
    }

    @GetMapping("/games/list/add")
    public String addGui(Model model) {
        model.addAttribute("game", new Game());
        return "saveGames";
    }

    @PostMapping("/games/list/add")
    public String addGame(@ModelAttribute Game game) {
        games.add(game);
        return "redirect:/games/list";
    }


}

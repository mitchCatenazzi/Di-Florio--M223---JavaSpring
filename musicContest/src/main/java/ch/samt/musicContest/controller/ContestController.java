package ch.samt.musicContest.controller;

import ch.samt.musicContest.data.JudgeRepository;
import ch.samt.musicContest.data.SingerRepository;
import ch.samt.musicContest.domain.Singer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContestController {

    private JudgeRepository judgeRepository;
    private SingerRepository singerRepository;

    @Autowired
    public ContestController(JudgeRepository judgeRepository, SingerRepository singerRepository) {
        this.judgeRepository = judgeRepository;
        this.singerRepository = singerRepository;
    }


    @GetMapping("/contest/ranking")
    public String loadSingers(Model model) {
        model.addAttribute("singers", singerRepository.findAll());
        return "singerList";
    }

    @GetMapping("/contest/judges")
    public String loadJudges(Model model) {
        model.addAttribute("judges", judgeRepository.findAll());
        return "judgeList";
    }

    @GetMapping("/contest/add-artist")
    public String openInsertSinger(@ModelAttribute Singer singer) {
        return "addSinger";
    }

    @PostMapping("/contest/add-artist")
    public String saveSinger(@Valid Singer singer, Errors errors) {
        if (errors.hasErrors()) {
            return "addSinger";
        }
        singer.setVotes(0);
        // customers.add(customer);
        singerRepository.save(singer);
        return "redirect:/contest/ranking";
    }


    @GetMapping("/contest/judgeId")
    public String like(@ModelAttribute Singer singer, Model model, @RequestParam(value = "judgeId", required = false) Integer judgeId) {
        return "likeSomeSinger";
    }

    @GetMapping("/contest/addLike")
        public String likeAdd(@ModelAttribute Singer singer, Model model) {
            return "likeSomeSinger";
        }
    }




}

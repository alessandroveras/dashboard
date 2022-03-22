package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping(value = "/aulas")
    public String obterLista(Model model) {

        model.addAttribute("listagem", aulaService.obterLista());

        return "lista/aulas";
    }
}
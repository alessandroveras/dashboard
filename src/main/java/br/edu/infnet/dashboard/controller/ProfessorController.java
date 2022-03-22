package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.domain.Professor;
import br.edu.infnet.dashboard.model.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping(value = "/professores")
    public String obterLista(Model model) {

		model.addAttribute("listagem", professorService.obterLista());

        return "lista/professores";
    }
}
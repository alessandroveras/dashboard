package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.dashboard.model.exceptions.IntensidadeInvalidException;
import br.edu.infnet.dashboard.model.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping(value = "/atividades")
    public String obterLista(Model model) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {

        model.addAttribute("listagem", atividadeService.obterLista());

        return "lista/atividades";
    }
}

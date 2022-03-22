package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.dashboard.model.exceptions.IntensidadeInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.AtividadeService;

@Controller
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;

	@GetMapping(value = "/produtos")
	public String obterLista(Model model) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {
		
		model.addAttribute("listagem", atividadeService.obterLista());

		return "lista/produtos";
	}
}

package br.edu.infnet.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.MusculacaoService;
import br.edu.infnet.dashboard.model.service.AerobicoService;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.AulaService;
import br.edu.infnet.dashboard.model.service.AlongamentoService;
import br.edu.infnet.dashboard.model.service.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AulaService aulaService;
	
	@Autowired
	private MusculacaoService musculacaoService;

	@Autowired
	private AerobicoService aerobicoService;

	@Autowired
	private AlongamentoService alongamentoService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//produtos e pedidos por usuário
		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("pedidosPorUsuario", usuarios);		
		model.addAttribute("produtosPorUsuario", usuarios);
		
		//quantidade de pedidos
		model.addAttribute("qtdePedidos", aulaService.obterQuantidade());
		
		//valor de vendos dos produtos
		model.addAttribute("valorVendaBebida", musculacaoService.calcularValorVenda());
		model.addAttribute("valorVendaComida", aerobicoService.calcularValorVenda());
		model.addAttribute("valorVendaSobremsa", alongamentoService.calcularValorVenda());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}
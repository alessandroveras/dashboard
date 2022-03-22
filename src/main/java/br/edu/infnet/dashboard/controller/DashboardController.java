package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    private LogService logService;

    @GetMapping(value = "/")
    public String index(Model model) {

        //Aulas e Atividades por usuário
        List<Usuario> usuarios = usuarioService.obterLista();
        model.addAttribute("aulasPorUsuario", usuarios);
        model.addAttribute("atividadesPorUsuario", usuarios);

        //quantidade de aulas
        model.addAttribute("qtdeAulas", aulaService.obterQuantidade());

        //valor de vendos dos produtos
        model.addAttribute("valorCaloriasMusculacao", musculacaoService.calcularCaloriasQueimadas());
        model.addAttribute("valorCaloriasAerobico", aerobicoService.calcularCaloriasQueimadas());
//        model.addAttribute("valorVendaSobremsa", alongamentoService.calcularValorVenda());

        //recuperar o log
        model.addAttribute("listaLog", logService.obterLista());
        model.addAttribute("qtdeLog", logService.obterQuantidade());

        return "index";
    }
}
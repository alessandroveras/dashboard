package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Aerobico;
import br.edu.infnet.dashboard.model.domain.Atividade;
import br.edu.infnet.dashboard.model.domain.Musculacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "localhost:8083/api/atividade", name = "atividadeClient")
public interface IAtividadeClient {

    @GetMapping(value = "/listar/musculacao")
    public List<Musculacao> obterMusculacaoLista();

    @GetMapping(value = "/listar/aerobico")
    public List<Aerobico> obterAerobicoLista();

    @GetMapping(value = "/listar")
    public List<Atividade> obterLista();
}
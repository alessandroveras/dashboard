package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Aula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "localhost:8082/api/aula", name = "aulaClient")
public interface IAulaClient {

    @GetMapping(value = "/listar")
    public List<Aula> obterLista();

    @GetMapping(value = "/qtde")
    public long obterQuantidade();
}
package br.edu.infnet.dashboard.clients;

import java.util.List;

import br.edu.infnet.dashboard.model.domain.Aula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "localhost:8082/api/aula", name = "aulaClient")
public interface IAulaClient {

	@GetMapping(value = "/listar")
	public List<Aula> obterLista();

	@GetMapping(value = "/qtde")
	public long obterQuantidade();
}
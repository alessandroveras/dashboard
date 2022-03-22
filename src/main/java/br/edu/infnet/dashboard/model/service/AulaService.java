package br.edu.infnet.dashboard.model.service;

import java.util.List;

import br.edu.infnet.dashboard.model.domain.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IAulaClient;

@Service
public class AulaService {
	
	@Autowired
	private IAulaClient pedidoClient;
	
	public List<Aula> obterLista() {
		return pedidoClient.obterLista();
	}
	
	public long obterQuantidade() {
		return pedidoClient.obterQuantidade();
	}		
}

package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IAtividadeClient;
import br.edu.infnet.dashboard.model.domain.Musculacao;

@Service
public class MusculacaoService {
	
	@Autowired
	private IAtividadeClient produtoClient;
	
	public List<Musculacao> obterLista() {
		return produtoClient.obterMusculacaoLista();
	}
	
	public float calcularValorVenda() {
		
		float caloriasQueimadas = 0;
		
		for(Musculacao musculacao : produtoClient.obterMusculacaoLista()) {
			caloriasQueimadas = caloriasQueimadas + musculacao.calcularCaloriasQueimadas();
		}
		
		return caloriasQueimadas;
	}
}
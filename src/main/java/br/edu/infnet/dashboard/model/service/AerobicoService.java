package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IAtividadeClient;
import br.edu.infnet.dashboard.model.domain.Aerobico;

@Service
public class AerobicoService {
	
	@Autowired
	private IAtividadeClient produtoClient;
	
	public List<Aerobico> obterLista() {
		return produtoClient.obterAerobicoLista();
	}
	
	public float calcularValorVenda() {
		
		float caloriasQueimadas = 0;
		
		for(Aerobico aerobico : produtoClient.obterAerobicoLista()) {
			caloriasQueimadas = caloriasQueimadas + aerobico.calcularCaloriasQueimadas();
		}
		
		return caloriasQueimadas;
	}
}
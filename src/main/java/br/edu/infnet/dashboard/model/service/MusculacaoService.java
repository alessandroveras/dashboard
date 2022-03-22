package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IAtividadeClient;
import br.edu.infnet.dashboard.model.domain.Musculacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculacaoService {

    @Autowired
    private IAtividadeClient atividadeClient;

    public List<Musculacao> obterLista() {
        return atividadeClient.obterMusculacaoLista();
    }

    public float calcularCaloriasQueimadas() {

        float caloriasQueimadas = 0;

        for (Musculacao musculacao : atividadeClient.obterMusculacaoLista()) {
            caloriasQueimadas = caloriasQueimadas + musculacao.calcularCaloriasQueimadas();
        }

        return caloriasQueimadas;
    }
}
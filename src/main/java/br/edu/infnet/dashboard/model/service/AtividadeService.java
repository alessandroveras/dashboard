package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IAtividadeClient;
import br.edu.infnet.dashboard.model.domain.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private IAtividadeClient atividadeClient;

    public List<Atividade> obterLista() {
        return atividadeClient.obterLista();
    }
}
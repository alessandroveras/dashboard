package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IAulaClient;
import br.edu.infnet.dashboard.model.domain.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private IAulaClient aulaClient;

    public List<Aula> obterLista() {
        return aulaClient.obterLista();
    }

    public long obterQuantidade() {
        return aulaClient.obterQuantidade();
    }
}

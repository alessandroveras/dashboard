package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.ILogClient;
import br.edu.infnet.dashboard.model.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    public ILogClient logClient;

    public List<Log> obterLista() {
        return logClient.obterLista();
    }

    public Long obterQuantidade() {
        return logClient.obterQuantidade();
    }

    public void incluir(Log log) {
        logClient.incluir(log);
    }

    public void excluir(Integer id) {
        logClient.excluir(id);
    }
}
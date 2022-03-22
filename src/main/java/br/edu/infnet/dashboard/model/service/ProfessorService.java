package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IProfessorClient;
import br.edu.infnet.dashboard.model.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    public IProfessorClient professorClient;

    public List<Professor> obterLista() {
        return professorClient.obterLista();
    }
}
package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "localhost:8084/api/professor", name = "professorClient")
public interface IProfessorClient {

    @GetMapping(value = "/listar")
    public List<Professor> obterLista();
}
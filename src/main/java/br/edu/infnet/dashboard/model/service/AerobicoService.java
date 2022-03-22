package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IAtividadeClient;
import br.edu.infnet.dashboard.model.domain.Aerobico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerobicoService {

    @Autowired
    private IAtividadeClient atividadeClient;

    public List<Aerobico> obterLista() {
        return atividadeClient.obterAerobicoLista();
    }

    public float calcularCaloriasQueimadas() {

        float caloriasQueimadas = 0;

        for (Aerobico aerobico : atividadeClient.obterAerobicoLista()) {
            caloriasQueimadas = caloriasQueimadas + aerobico.calcularCaloriasQueimadas();
        }

        return caloriasQueimadas;
    }
}
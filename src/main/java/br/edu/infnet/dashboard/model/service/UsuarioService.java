package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.IUsuarioClient;
import br.edu.infnet.dashboard.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    public IUsuarioClient usuarioClient;

    public List<Usuario> obterLista() {
        return usuarioClient.obterLista();
    }
}
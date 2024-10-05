package unam.diplomado.pixup.usuario_service.service;

import unam.diplomado.pixup.usuario_service.domain.Domicilio;
import unam.diplomado.pixup.usuario_service.domain.Usuario;

public interface UsuarioService {
	
	Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}

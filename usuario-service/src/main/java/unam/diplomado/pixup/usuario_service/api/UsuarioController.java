package unam.diplomado.pixup.usuario_service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuario_service.domain.Usuario;
import unam.diplomado.pixup.usuario_service.dto.RegistroUsuarioRequest;
import unam.diplomado.pixup.usuario_service.service.UsuarioService;

@RestController
public class UsuarioController implements UsuarioApi {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public Usuario registrarUsuario(
			RegistroUsuarioRequest request) {
		return usuarioService.registrarUsuario(
			request.getUsuario(), request.getDomicilio());
	}

}

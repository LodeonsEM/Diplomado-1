package unam.diplomado.pixup.usuario_service.domain;

public class UsuarioAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -4575106698172398574L;

	public UsuarioAlreadyExistsException(String email) {
		super("Ya existe un usuario registrado con email: " + email);
	}

}

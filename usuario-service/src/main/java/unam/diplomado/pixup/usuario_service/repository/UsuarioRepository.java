package unam.diplomado.pixup.usuario_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import unam.diplomado.pixup.usuario_service.domain.Usuario;

@Repository
public interface UsuarioRepository 
	extends MongoRepository<Usuario, String>{
	
	Optional<Usuario> findByEmail(String email);

}

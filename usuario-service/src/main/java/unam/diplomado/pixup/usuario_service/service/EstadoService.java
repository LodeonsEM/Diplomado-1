package unam.diplomado.pixup.usuario_service.service;

import java.util.List;
import java.util.Optional;

import unam.diplomado.pixup.usuario_service.domain.Estado;

public interface EstadoService {
	
	List<Estado> findAllEstados(); 
	
	Estado createEstado(Estado estado);
	
	Optional<Estado> findEstadoById(String id);
	
	Estado actualizarEstado(String id, Estado estado);
	
	void deleteEstado (String id);

}

package unam.diplomado.pixup.usuario_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.usuario_service.domain.Estado;
import unam.diplomado.pixup.usuario_service.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> findAllEstados() {
		return estadoRepository.findAll();
	}
	
	@Override
	public Estado createEstado(Estado estado) {
		return estadoRepository.save(estado);
	}
		
	@Override
	public Estado actualizarEstado(String id, Estado estado) {
		Optional<Estado> estadoExistente = estadoRepository.findById(id);
		if (estadoExistente.isPresent()) {
			Estado estadoActualizar = estadoExistente.get();
			estadoActualizar.setNombre(estado.getNombre());
			estadoRepository.save(estadoActualizar);
			return estadoActualizar;
		}
		return null;
	}

	@Override
	public Optional<Estado> findEstadoById(String id) {
		return estadoRepository.findById(id);
	}

	@Override
	public void deleteEstado(String id) {
		estadoRepository.deleteById(id);
	}

}

package unam.diplomado.pixup.usuario_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import unam.diplomado.pixup.usuario_service.domain.Estado;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String>{

}

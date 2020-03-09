package br.ufsc.ine.ppgcc.repository;

import br.ufsc.ine.ppgcc.model.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntityRepository extends MongoRepository<Entity, Long> {
}

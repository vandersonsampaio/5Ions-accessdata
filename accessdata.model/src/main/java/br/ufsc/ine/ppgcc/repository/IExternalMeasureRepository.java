package br.ufsc.ine.ppgcc.repository;

import br.ufsc.ine.ppgcc.model.ExternalMeasure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExternalMeasureRepository extends MongoRepository<ExternalMeasure, Long> {
}

package br.ufsc.ine.ppgcc.repository;

import br.ufsc.ine.ppgcc.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentRepository extends MongoRepository<Document, Long> {
}

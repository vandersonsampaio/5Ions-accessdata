package br.ufsc.ine.ppgcc.repository;

import br.ufsc.ine.ppgcc.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IDocumentRepository extends MongoRepository<Document, String> {

    List<Document> findAllByAnnotatedFalse();
    List<Document> findAllByTimestampBetweenAndAnnotatedTrue(LocalDateTime timestamp, LocalDateTime timestamp2);
}

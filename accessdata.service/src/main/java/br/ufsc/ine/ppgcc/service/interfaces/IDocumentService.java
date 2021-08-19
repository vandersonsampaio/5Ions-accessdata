package br.ufsc.ine.ppgcc.service.interfaces;

import br.ufsc.ine.ppgcc.model.Document;

import java.time.LocalDateTime;
import java.util.List;

public interface IDocumentService {

    List<Document> getNoAnnotatedDocuments();
    List<Document> getAnnotatedDocumentsBetween(LocalDateTime startTime, LocalDateTime endTime);
    boolean saveDocumentSentiment(List<Document> documents);
    boolean saveDocumentMentions(List<Document> documents);
    boolean saveDocumentSentences(List<Document> documents);
}

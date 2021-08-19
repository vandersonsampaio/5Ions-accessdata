package br.ufsc.ine.ppgcc.service.implementation;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.repository.IDocumentRepository;
import br.ufsc.ine.ppgcc.service.interfaces.IDocumentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService implements IDocumentService {

    private final IDocumentRepository repository;

    public DocumentService(IDocumentRepository repository){
        this.repository = repository;
    }

    public List<Document> getNoAnnotatedDocuments() {
        return repository.findAllByAnnotatedFalse();
    }

    public List<Document> getAnnotatedDocumentsBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return repository.findAllByTimestampBetweenAndAnnotatedTrue(startTime, endTime);
    }

    public boolean saveDocumentSentiment(List<Document> documents) throws IllegalArgumentException{
        for(Document doc : documents){
            Document originalDoc = repository.findById(doc.getId()).orElseThrow(IllegalArgumentException::new);

            originalDoc.setScoreSentiment(doc.getScoreSentiment());

            repository.save(originalDoc);
        }

        return true;
    }

    public boolean saveDocumentMentions(List<Document> documents) throws IllegalArgumentException{
        for(Document doc : documents){
            Document originalDoc = repository.findById(doc.getId()).orElseThrow(IllegalArgumentException::new);

            originalDoc.setMentions(doc.getMentions());

            repository.save(originalDoc);
        }

        return true;
    }

    public boolean saveDocumentSentences(List<Document> documents) throws IllegalArgumentException{
        for(Document doc : documents){
            Document originalDoc = repository.findById(doc.getId()).orElseThrow(IllegalArgumentException::new);

            originalDoc.setSentenceSentiments(doc.getSentenceSentiments());

            repository.save(originalDoc);
        }

        return true;
    }
}

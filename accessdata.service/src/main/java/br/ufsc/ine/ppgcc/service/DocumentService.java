package br.ufsc.ine.ppgcc.service;

import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.repository.IDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private IDocumentRepository documentRepository;

    public DocumentService(IDocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    public long count(){
        return documentRepository.count();
    }

    public List<Document> getDocumentsUnprocessed(){
        return getDocumentsUnprocessed(null);
    }

    public List<Document> getDocumentsUnprocessed(Integer limit) {
        return documentRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}

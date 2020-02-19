package br.ufsc.ine.ppgcc.service;

import br.ufsc.ine.ppgcc.repository.IDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private IDocumentRepository documentRepository;

    public DocumentService(IDocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    public long count(){
        return documentRepository.count();
    }

}

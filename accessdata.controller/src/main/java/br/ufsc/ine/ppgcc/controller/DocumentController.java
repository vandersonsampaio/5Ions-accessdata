package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import br.ufsc.ine.ppgcc.model.Document;

import java.util.List;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

    private DocumentService documentService;

    public DocumentController(DocumentService documentService){
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getAllDocuments(){
        return documentService.getDocumentsUnprocessed(1000);
    }
}

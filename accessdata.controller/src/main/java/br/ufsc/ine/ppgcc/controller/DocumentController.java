package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.DocumentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.ufsc.ine.ppgcc.model.Document;

import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "withoutentities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, String> getDocumentsWithoutAnnotationEntities(long startTime, long endTime){
        return documentService.getDocumentsWithoutAnnotationEntities(startTime, endTime);
    }

    @GetMapping(value = "withoutsentiments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, String> getDocumentsWithoutSentiments(long startTime, long endTime){
        return documentService.getDocumentsWithoutSentiments(startTime, endTime);
    }

    @GetMapping(value = "withoutsentimententities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, String> getDocumentsWithoutEntitiesSentiment(long startTime, long endTime){
        return documentService.getDocumentsWithoutEntitiesSentiment(startTime, endTime);
    }
}

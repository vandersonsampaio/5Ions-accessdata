package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.dto.DocumentMentionRequest;
import br.ufsc.ine.ppgcc.dto.DocumentSentimentRequest;
import br.ufsc.ine.ppgcc.dto.SentenceSentimentRequest;
import br.ufsc.ine.ppgcc.mapper.DocumentMapper;
import br.ufsc.ine.ppgcc.service.interfaces.IDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufsc.ine.ppgcc.model.Document;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/documents", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DocumentController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
    private final DocumentMapper mapper;
    private final IDocumentService service;

    public DocumentController(IDocumentService service, DocumentMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "no-annotated")
    public ResponseEntity<List<Document>> getNoAnnotated(){
        return ResponseEntity.ok(service.getNoAnnotatedDocuments());
    }

    @GetMapping(value = "annotated/{startTime}/{endTime}")
    public ResponseEntity<List<Document>> getAnnotated(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                       @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime){

        return ResponseEntity.ok(service.getAnnotatedDocumentsBetween(
                startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
    }

    @PostMapping(value = "annotate-mentions")
    public ResponseEntity<Boolean> postMentions(@RequestBody List<DocumentMentionRequest> mentionsByDocument){
        try{
            List<Document> documents = mapper.toListMentions(mentionsByDocument);
            return ResponseEntity.ok(service.saveDocumentMentions(documents));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "annotate-sentiment-document")
    public ResponseEntity<Boolean> postDocumentSentiment(@RequestBody List<DocumentSentimentRequest> sentimentByDocument) {
        try {
            List<Document> documents = mapper.toListScore(sentimentByDocument);
            return ResponseEntity.ok(service.saveDocumentSentiment(documents));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "annotate-sentiment-sentences")
    public ResponseEntity<Boolean> postSentimentSentences(@RequestBody List<SentenceSentimentRequest> sentencesByDocument){
        try {
            List<Document> documents = mapper.toListSentences(sentencesByDocument);
            return ResponseEntity.ok(service.saveDocumentSentences(documents));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}

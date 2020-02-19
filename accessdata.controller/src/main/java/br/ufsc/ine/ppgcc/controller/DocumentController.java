package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.DocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

    private DocumentService documentService;

    public DocumentController(DocumentService documentService){
        this.documentService = documentService;
    }

    @GetMapping
    public String helloDocument(){
        return "Hey " + documentService.count() + " documents";
    }
}

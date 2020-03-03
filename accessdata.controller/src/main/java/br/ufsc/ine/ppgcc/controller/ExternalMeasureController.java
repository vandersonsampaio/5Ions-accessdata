package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.ExternalMeasureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/measures")
public class ExternalMeasureController {

    private final ExternalMeasureService service;

    public ExternalMeasureController(ExternalMeasureService service){
        this.service = service;
    }

    @GetMapping
    public String getAllMeasure(){
        return "Count: " + service.count();
    }
}

package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.ExternalMeasureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/entities")
public class EntityController {

    private ExternalMeasureService externalMeasureService;

    public EntityController(ExternalMeasureService externalMeasureService){
        this.externalMeasureService = externalMeasureService;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World Entity " + externalMeasureService.count();
    }
}

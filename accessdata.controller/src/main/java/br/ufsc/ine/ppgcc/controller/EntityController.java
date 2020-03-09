package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.EntityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/entities")
public class EntityController {

    private EntityService entityService;

    public EntityController(EntityService entityService){
        this.entityService = entityService;
    }

    @PutMapping(value = "save/annotations", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putAnnotationEntities(){
        entityService.saveAnnotationEntities();
    }

    @PutMapping(value = "save/sentiments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putSentiments(Map<Long, Map<Long, Double>> sentiments){
        entityService.saveSentiments(sentiments);
    }

    @PutMapping(value = "save/entitiessentiment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putEntitiesSentiment(){
        entityService.saveEntitiesSentiment();
    }
}

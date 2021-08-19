package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.service.interfaces.IEntityService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/entities")
public class EntityController {

    private IEntityService entityService;

    public EntityController(IEntityService entityService){
        this.entityService = entityService;
    }

    @PutMapping(value = "save/annotations", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putAnnotationEntities(){
        throw new NotYetImplementedException();
    }

    @PutMapping(value = "save/sentiments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putSentiments(){
        throw new NotYetImplementedException();
    }

    @PutMapping(value = "save/entities-sentiment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putEntitiesSentiment(){
        throw new NotYetImplementedException();
    }
}

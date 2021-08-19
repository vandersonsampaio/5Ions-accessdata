package br.ufsc.ine.ppgcc.service.implementation;

import br.ufsc.ine.ppgcc.repository.IEntityRepository;
import br.ufsc.ine.ppgcc.service.interfaces.IEntityService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EntityService implements IEntityService {

    private final IEntityRepository iEntityRepository;

    public EntityService(IEntityRepository iEntityRepository){
        this.iEntityRepository = iEntityRepository;
    }

    public void saveAnnotationEntities(){

    }

    public void saveSentiments(Map<Long, Map<Long, Double>> sentiments){

    }

    public void saveEntitiesSentiment(){

    }
}

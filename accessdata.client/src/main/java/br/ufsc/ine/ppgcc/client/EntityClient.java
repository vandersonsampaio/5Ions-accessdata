package br.ufsc.ine.ppgcc.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient
public interface EntityClient {

    @PutMapping(value = "entities/save/annotations", consumes = MediaType.APPLICATION_JSON_VALUE)
    void putAnnotationEntities();

    @PutMapping(value = "entities/save/sentiments", consumes = MediaType.APPLICATION_JSON_VALUE)
    void putSentiments(Map<Long, Map<Long, Double>> sentiments);

    @PutMapping(value = "entities/save/entitiessentiment", consumes = MediaType.APPLICATION_JSON_VALUE)
    void putEntitiesSentiment();
}

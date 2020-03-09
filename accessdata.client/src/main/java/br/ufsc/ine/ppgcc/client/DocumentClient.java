package br.ufsc.ine.ppgcc.client;

import br.ufsc.ine.ppgcc.model.Document;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient
public interface DocumentClient {

    @GetMapping(value = "documents", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Document> getAllDocuments();

    @GetMapping(value = "documents/withoutentities", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<Long, String> getDocumentsWithoutAnnotationEntities(long startTime, long endTime);

    @GetMapping(value = "documents/withoutsentiments", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<Long, String> getDocumentsWithoutSentiments(long startTime, long endTime);

    @GetMapping(value = "documents/withoutsentimententities", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<Long, String> getDocumentsWithoutEntitiesSentiment(long startTime, long endTime);
}

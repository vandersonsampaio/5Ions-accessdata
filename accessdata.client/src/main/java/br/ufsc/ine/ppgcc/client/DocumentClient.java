package br.ufsc.ine.ppgcc.client;

import br.ufsc.ine.ppgcc.model.Document;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("documents")
public interface DocumentClient {

    @GetMapping(value = "documents", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Document> getAllDocuments();
}

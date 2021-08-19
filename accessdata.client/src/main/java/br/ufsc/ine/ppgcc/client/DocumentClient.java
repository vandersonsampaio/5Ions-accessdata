package br.ufsc.ine.ppgcc.client;

import br.ufsc.ine.ppgcc.model.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "document-client")
public interface DocumentClient {

    @GetMapping(value = "no-annotated", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Document>> getNoAnnotated();

    @GetMapping(value = "annotated/{startTime}/{endTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Document>> getAnnotated(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime startTime,
                                                       @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime endTime);
}

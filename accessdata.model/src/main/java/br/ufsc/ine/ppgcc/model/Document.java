package br.ufsc.ine.ppgcc.model;

import java.util.List;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document(collection = "ProcessedData_Document")
public class Document {

    private long id;
    private long timestamp;
    private String content;
    private String source;
    private String url;
    private boolean isAnnotated;

    private List<Mention> mentions;
}
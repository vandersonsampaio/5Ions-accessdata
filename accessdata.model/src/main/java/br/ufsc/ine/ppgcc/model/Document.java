package br.ufsc.ine.ppgcc.model;

import br.ufsc.ine.ppgcc.enums.DocumentType;
import br.ufsc.ine.ppgcc.enums.Language;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document(collection = "documents")
public class Document {

    @Id
    private String id;
    private String title;
    private LocalDateTime timestamp;
    private String content;
    private String source;
    private String url;
    private DocumentType type;

    @Field("isAnnotated")
    private boolean annotated;
    private Language language;

    private ScoreSentiment scoreSentiment;

    private List<SentenceSentiment> sentenceSentiments;
    private List<Mention> mentions;
}
package br.ufsc.ine.ppgcc.mapper;

import br.ufsc.ine.ppgcc.dto.DocumentMentionRequest;
import br.ufsc.ine.ppgcc.dto.DocumentSentimentRequest;
import br.ufsc.ine.ppgcc.dto.SentenceSentimentRequest;
import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.model.Mention;
import br.ufsc.ine.ppgcc.model.SentenceSentiment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "scoreSentiment.score", source = "score"),
            @Mapping(target = "scoreSentiment.magnitude", source = "magnitude"),
            @Mapping(target = "title", ignore = true),
            @Mapping(target = "timestamp", ignore = true),
            @Mapping(target = "content", ignore = true),
            @Mapping(target = "source", ignore = true),
            @Mapping(target = "url", ignore = true),
            @Mapping(target = "type", ignore = true),
            @Mapping(target = "annotated", ignore = true),
            @Mapping(target = "language", ignore = true),
            @Mapping(target = "sentenceSentiments", ignore = true),
            @Mapping(target = "mentions", ignore = true),
    })
    Document toModel(DocumentSentimentRequest dto);

    @Mappings({
            @Mapping(target = "name", source = "mention"),
            @Mapping(target = "type", source = "type"),
    })
    Mention toModel(DocumentMentionRequest.MentionRequest dto);
    List<Mention> toListMention(List<DocumentMentionRequest.MentionRequest> dto);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "scoreSentiment", ignore = true),
            @Mapping(target = "title", ignore = true),
            @Mapping(target = "timestamp", ignore = true),
            @Mapping(target = "content", ignore = true),
            @Mapping(target = "source", ignore = true),
            @Mapping(target = "url", ignore = true),
            @Mapping(target = "type", ignore = true),
            @Mapping(target = "annotated", ignore = true),
            @Mapping(target = "language", ignore = true),
            @Mapping(target = "sentenceSentiments", ignore = true),
            @Mapping(target = "mentions", source = "mentions"),
    })
    Document toModel(DocumentMentionRequest dto);


    @Mappings({
            @Mapping(target = "number", source = "number"),
            @Mapping(target = "scoreSentiment.score", source = "score"),
            @Mapping(target = "scoreSentiment.magnitude", source = "magnitude"),
            @Mapping(target = "offset", source = "offset"),
    })
    SentenceSentiment toModel(SentenceSentimentRequest.SentimentRequest dto);
    List<SentenceSentiment> toListSentencesSentiment(List<SentenceSentimentRequest.SentimentRequest> dto);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "scoreSentiment", ignore = true),
            @Mapping(target = "title", ignore = true),
            @Mapping(target = "timestamp", ignore = true),
            @Mapping(target = "content", ignore = true),
            @Mapping(target = "source", ignore = true),
            @Mapping(target = "url", ignore = true),
            @Mapping(target = "type", ignore = true),
            @Mapping(target = "annotated", ignore = true),
            @Mapping(target = "language", ignore = true),
            @Mapping(target = "sentenceSentiments", source = "sentiments"),
            @Mapping(target = "mentions", ignore = true),
    })
    Document toModel(SentenceSentimentRequest dto);

    List<Document> toListScore(List<DocumentSentimentRequest> dto);
    List<Document> toListMentions(List<DocumentMentionRequest> dto);
    List<Document> toListSentences(List<SentenceSentimentRequest> dto);
}

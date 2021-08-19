package br.ufsc.ine.ppgcc.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentSentimentRequest {

    private String id;
    private double magnitude;
    private double score;
}

package br.ufsc.ine.ppgcc.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentenceSentiment {

    private int number;
    private ScoreSentiment scoreSentiment;
    private long offset;
}

package br.ufsc.ine.ppgcc.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreSentiment {

    private double score;
    private double magnitude;
}

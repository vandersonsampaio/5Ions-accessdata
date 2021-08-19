package br.ufsc.ine.ppgcc.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SentenceSentimentRequest {

    private String id;
    private List<SentimentRequest> sentiments;

    public class SentimentRequest {

        public int number;
        public double magnitude;
        public double score;
        public long offset;

        public SentimentRequest(int number, double magnitude, double score, long offset){
            this.number = number;
            this.magnitude = magnitude;
            this.score = score;
            this.offset = offset;
        }

    }
}

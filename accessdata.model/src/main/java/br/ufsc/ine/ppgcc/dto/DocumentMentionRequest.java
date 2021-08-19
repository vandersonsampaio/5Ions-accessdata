package br.ufsc.ine.ppgcc.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMentionRequest {

    private String id;
    private List<MentionRequest> mentions;

    public class MentionRequest {

        public String mention;
        public String type;

        public MentionRequest(String mention, String type) {
            this.mention = mention;
            this.type = type;
        }
    }

}

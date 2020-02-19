package br.ufsc.ine.ppgcc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mention {

    private long id;
    private long idDocument;
    private String mention;

    private Entity entity;
    private Sentiment sentiment;
}

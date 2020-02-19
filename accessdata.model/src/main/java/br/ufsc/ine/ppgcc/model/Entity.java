package br.ufsc.ine.ppgcc.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Entity {

    private long id;
    private String name;
    private String type;
    private String source;
    private List<Mention> mentions;
}

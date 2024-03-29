package br.ufsc.ine.ppgcc.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mention {

    private String name;
    private String type;
}

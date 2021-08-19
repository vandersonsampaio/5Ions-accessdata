package br.ufsc.ine.ppgcc.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class ExternalMeasure {

    @Id
    private long id;
    private Entity entity;
    private Map<Long, Double> measures;

    /*public Map<Long, Double> sortMeasures(){
        Map<Long, Double> sortedMeasures = new TreeMap<Long, Double>(
                Comparator.reverseOrder()
        );

        sortedMeasures.putAll(measures);

        return sortedMeasures;
    }*/
}

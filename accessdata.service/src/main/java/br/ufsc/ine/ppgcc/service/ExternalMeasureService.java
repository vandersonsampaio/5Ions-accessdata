package br.ufsc.ine.ppgcc.service;

import br.ufsc.ine.ppgcc.repository.IExternalMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalMeasureService {

    @Autowired
    private IExternalMeasureRepository iRepository;

    public long count(){
        return iRepository.count();
    }
}

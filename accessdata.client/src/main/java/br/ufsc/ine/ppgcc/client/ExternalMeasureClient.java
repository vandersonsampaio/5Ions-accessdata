package br.ufsc.ine.ppgcc.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("externalMeasure")
public interface ExternalMeasureClient {

    @GetMapping("measures")
    String getAllMeasure();
}

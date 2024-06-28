package com.ocr.client_service.proxies;

import com.ocr.client_service.bean.Risk;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment-service", url = "${gateway-service.url}", path = "assessment-service")
public interface RiskProxy {
    @GetMapping("/analysis/{id}")
    Risk getPatientRisk(@PathVariable("id") Integer id);
}

package com.devops.gestion_etablissement.client;

import com.devops.gestion_etablissement.dto.ClasseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "classe-service", url = "http://localhost:8082/api/classe")
public interface ClasseClient {

    @GetMapping
    List<ClasseResponse> getAllClassesApi();

}

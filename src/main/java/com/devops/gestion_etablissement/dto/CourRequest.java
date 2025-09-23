package com.devops.gestion_etablissement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourRequest {

    private String libelle;

    private String description;

    private Long classeId;

}

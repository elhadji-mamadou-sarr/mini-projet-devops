package com.devops.gestion_etablissement.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursResponse {

    private Long id;

    private String libelle;

    private String description;

    private Long classeId;

}

package com.devops.gestion_etablissement.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Cours {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String libelle;

    private String description;

    private Long classeId;


}

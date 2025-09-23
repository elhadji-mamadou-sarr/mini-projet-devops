package com.devops.gestion_etablissement.repository;

import com.devops.gestion_etablissement.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    List<Cours> findByClasseId(Long classeId);
}

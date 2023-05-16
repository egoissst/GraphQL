package com.adobe.dao;

import com.adobe.entity.Vet;
import com.adobe.entity.Visit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

  @Query("from Visit where pet.id = :pid")
  List<Visit> getPetVisits(@Param("pid") Integer petId);

  @Query("from Visit where vet.id = :vid")
  List<Visit> getVetVisits(@Param("vid") Integer vetId);
}

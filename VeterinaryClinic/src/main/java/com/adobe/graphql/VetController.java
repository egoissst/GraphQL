package com.adobe.graphql;

import com.adobe.dao.VetRepository;
import com.adobe.dao.VisitRepository;
import com.adobe.entity.Vet;
import com.adobe.entity.Visit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VetController {

  @Autowired
  VetRepository vetRepository;

  @Autowired
  VisitRepository visitRepository;

  @QueryMapping
  public List<Vet> vets() {
    return vetRepository.findAll();
  }

  @QueryMapping
  public Vet vet(@Argument Integer id) {
    System.out.println(id);
    return vetRepository.findById(id).get();
  }

  @SchemaMapping
  public List<Visit> visits(Vet vet) {
    System.out.println("Called " + vet.getId());
    var visits = visitRepository.getVetVisits(vet.getId());
    return visits;
  }
}

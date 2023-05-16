package com.adobe.graphql;

import com.adobe.dao.PetRepository;
import com.adobe.dao.VisitRepository;
import com.adobe.entity.Pet;
import com.adobe.entity.Visit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

  @Autowired
  PetRepository petRepository;

  @Autowired
  VisitRepository visitRepository;

  @QueryMapping
  public List<Pet> pets(){
    return petRepository.findAll();
  }

  @QueryMapping
  public Pet pet(@Argument Integer id){
    return petRepository.findById(id).get();
  }

  @SchemaMapping
  public List<Visit>  visits(Pet pet) {
    System.out.println("pet " + pet.getId());
    return visitRepository.getPetVisits(pet.getId());
  }
}

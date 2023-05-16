package com.adobe.graphql;

import com.adobe.dao.PetTypeRepository;
import com.adobe.entity.PetType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PetTypeController {

  @Autowired
  PetTypeRepository petTypeRepository;

  @QueryMapping
  public List<PetType> petTypes(){
    return petTypeRepository.findAll();
  }
}

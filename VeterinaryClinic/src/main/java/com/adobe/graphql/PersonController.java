package com.adobe.graphql;

import com.adobe.dao.OwnerRepository;
import com.adobe.dao.VetRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

  @Autowired
  VetRepository vetRepository;

  @Autowired
  OwnerRepository ownerRepository;

  @QueryMapping
  public List<Object> people(){
    List<Object> list = new ArrayList<>();
    list.addAll(vetRepository.findAll());
    list.addAll(ownerRepository.findAll());
    return list;
  }
}

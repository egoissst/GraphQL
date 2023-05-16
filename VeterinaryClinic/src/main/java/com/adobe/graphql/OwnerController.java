package com.adobe.graphql;

import com.adobe.dao.OwnerRepository;
import com.adobe.entity.Owner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OwnerController {

  @Autowired
  OwnerRepository ownerRepository;

  @QueryMapping
  public List<Owner> owners(){
    return ownerRepository.findAll();
  }
}

package com.adobe.graphql;

import com.adobe.dao.VisitRepository;
import com.adobe.entity.Visit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VisitController {

  @Autowired
  VisitRepository visitRepository;

  @QueryMapping
  public List<Visit> visits(){
    return visitRepository.findAll();
  }
}

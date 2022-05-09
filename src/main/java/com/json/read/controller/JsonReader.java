package com.json.read.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.read.models.AllPersonResponseBO;
import com.json.read.models.Person;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonReader {

  private ResourceLoader loader;
  @Value("classpath:personList.json")
  private Resource jsonResource;

  @GetMapping("/get-persons")
  public AllPersonResponseBO getAllPerson() throws IOException {
    AllPersonResponseBO responseBO = new AllPersonResponseBO();
    Person[] person = new ObjectMapper().readValue(jsonResource.getInputStream(),Person[].class);
    responseBO.setPerson(person);
    return responseBO;
  }


}


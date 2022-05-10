package com.json.read.controller;

import com.json.read.AbstractTest;
import com.json.read.models.AllPersonResponseBO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class JsonReaderTest extends AbstractTest {

  @Override
  @Before
  public void setUp() {
    super.setUp();
  }

  @Test
  public void testGetAllPersons() throws Exception {
    String uri = "/get-persons";

    MvcResult mvcResult = mvc
        .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(200,status);

    String content = mvcResult.getResponse().getContentAsString();
    AllPersonResponseBO persons = super.mapFromJson(content,AllPersonResponseBO.class);
    Assertions.assertTrue(persons!=null);
  }
}
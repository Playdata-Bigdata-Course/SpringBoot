package io.playdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.playdata.controller.Controller;

@SpringBootTest
class Step09UnitTestApplicationTests {

   @Autowired
   private Controller controller;
    
   private MockMvc mock;
   
   @BeforeEach
   public void init() {
      mock = MockMvcBuilders.standaloneSetup(controller).build();
   }
   
   @Test
   void controllerTest() throws Exception {
//      mock.perform(get("/")).andExpect(status().isOk()).andDo(print());
//      mock.perform(get("/param").param("id", "0712023")).andDo(print());
//      mock.perform(post("/customer").param("name","kom").param("age","27")).andDo(print());
      mock.perform(get("/validate")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("kom2")).andDo(print());
   }

}
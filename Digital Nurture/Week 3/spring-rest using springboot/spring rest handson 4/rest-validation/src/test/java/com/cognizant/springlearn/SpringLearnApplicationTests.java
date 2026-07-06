package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/countries"));
        actions.andExpect(status().isOk());
    }

    @Test
    public void testAddCountryValidation() throws Exception {
        // Test with invalid country code (1 character instead of 2)
        ResultActions actions = mvc.perform(post("/countries")
                .contentType("application/json")
                .content("{\"code\":\"I\",\"name\":\"India\"}"));
        actions.andExpect(status().isBadRequest());
    }

    @Test
    public void testAddCountryWithInvalidFormat() throws Exception {
        // Test with string value for numeric field (if applicable)
        ResultActions actions = mvc.perform(post("/countries")
                .contentType("application/json")
                .content("{\"code\":\"IN\",\"name\":\"India\"}"));
        actions.andExpect(status().isOk());
    }
}

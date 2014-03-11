package com.backbonerestapp.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:test-spring-configuration.xml")
public class APIControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void testInit() {
        assertTrue("Application Context Not Set", webApplicationContext != null);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        assertTrue("mockMvc Not Set", mockMvc != null);
    }

    @Test
    public void testGetCustomer() throws Exception {
        MvcResult readResponse = mockMvc.perform(get("/customer")
                .param("imsi", "100000000000001")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andReturn();

        assertEquals("Test", readResponse.getResponse().getContentAsString());
    }

    @Test
    public void testGetCustomerNotFound() throws Exception {
        MvcResult readResponse = mockMvc.perform(get("/customer")
                .param("imsi", "22")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andReturn();

        assertEquals("Not Found", readResponse.getResponse().getContentAsString());
    }
}
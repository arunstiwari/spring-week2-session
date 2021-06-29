package com.sapient.springsession.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homePage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void greetingPage() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                get("/greeting")
                        .param("mood", "sad")
        ).andReturn();
        Map<String, Object> model = mvcResult.getModelAndView().getModel();
        assertEquals("Things will be better", model.get("msg"));

        this.mockMvc.perform(
                    get("/greeting")
                    .param("mood", "happy")
                    )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void greeting(){
        WebTestClient testClient = MockMvcWebTestClient.bindToController(new HomeController())
                                    .viewResolvers(new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp"))
                                    .build();

        EntityExchangeResult<Void> result = testClient.get().uri("/greeting?mood=sad")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();

        ModelAndView modelAndView = MockMvcWebTestClient.resultActionsFor(result).andReturn().getModelAndView();
        assertEquals("Things will be better", modelAndView.getModel().get("msg"));


    }


}
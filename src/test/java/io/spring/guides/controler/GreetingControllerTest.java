package io.spring.guides.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.guides.model.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Test
    public void defaultGreeting() throws Exception {
        //given
        MvcResult result = mockMvc.perform(
                get("/greeting")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        //when
        Greeting greeting = OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), Greeting.class);
        //then
        assertEquals(1, greeting.getId());
        assertEquals("Hello World", greeting.getContent());
    }

    @Test
    public void paramGreeting() throws Exception{
        ///given
        MvcResult result = mockMvc.perform(
                get("/greeting")
                    .param("name", "Kania")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        //when
        Greeting greeting = OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), Greeting.class);

        //then
        assertEquals(1, greeting.getId());
        assertEquals("Hello Kania", greeting.getContent());
    }
}

package com.java.engineering.springmvctdd2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Springmvctdd2ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givencfWithoutParamterwhenMockMVC_thenResponseAllOKResult() throws Exception {

        this.mockMvc.perform(get("/cf"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(content().string("[{\"description\":\"Cloud Foundry sponsored by Pivotal\",\"api_version\":\"2.126.0\"},{\"description\":\"IBM Bluemix\",\"api_version\":\"2.106.0\"}]"))
            .andReturn();

    }

    @Test
    public void givencfWithParamterPWCwhenMockMVC_thenPWCResponseOKResult() throws Exception {
        this.mockMvc.perform(get("/cf/PWC"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(content().string("{\"description\":\"Cloud Foundry sponsored by Pivotal\",\"api_version\":\"2.126.0\"}"))
            .andReturn();
    }

    @Test
    public void givencfWithParamterBLUwhenMockMVC_thenBLUResponseOKResult() throws Exception {
        this.mockMvc.perform(get("/cf/BLU"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(content().string("{\"description\":\"IBM Bluemix\",\"api_version\":\"2.106.0\"}"))
            .andReturn();
    }

    @Test
    public void givencfWithWrongParamterwhenMockMVC_thenBLUResponseBadRequestResult() throws Exception {
        this.mockMvc.perform(get("/cf/B"))
            .andDo(print()).andExpect(status().isBadRequest())
            .andReturn();
    }


}

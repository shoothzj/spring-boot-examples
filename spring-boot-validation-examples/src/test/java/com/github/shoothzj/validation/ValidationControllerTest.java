package com.github.shoothzj.validation;

import com.github.shoothzj.validation.api.ValidationApiController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ValidationApiController.class)
@AutoConfigureMockMvc
public class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidationFailureEmptyValidationMap() throws Exception {
        String requestBody = "{\"validationMap\":{}}";

        mockMvc.perform(MockMvcRequestBuilders.post("/validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testValidationFailureTooManyProperties() throws Exception {
        String requestBody = "{\"validationMap\":{" +
                "\"key1\":\"value1\"," +
                "\"key2\":\"value2\"," +
                "\"key3\":\"value3\"," +
                "\"key4\":\"value4\"," +
                "\"key5\":\"value5\"," +
                "\"key6\":\"value6\"" +
                "}}";

        mockMvc.perform(MockMvcRequestBuilders.post("/validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

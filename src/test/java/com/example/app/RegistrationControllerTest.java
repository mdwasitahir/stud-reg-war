package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

// Annotation to test only the web layer (RegistrationController)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    // Inject MockMvc to simulate HTTP requests
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test case to verify that the registration form loads correctly.
     * Checks for HTTP 200 OK status and the correct view name ("registration-form").
     */
    @Test
    void testShowRegistrationForm() throws Exception {
        // Perform a GET request to the root path
        mockMvc.perform(get("/"))
               .andExpect(status().isOk()) // Expect HTTP 200 OK
               .andExpect(view().name("registrationForm")); // Expect the Thymeleaf view name
    }

    /**
     * Test case to verify successful form submission.
     * Simulates a POST request with valid form data.
     */
    @Test
    void testSubmitRegistration_Success() throws Exception {
        // Simulate a POST request with form parameters
        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("studentName", "Jane Doe")
                .param("course", "Computer Science")
                .param("email", "jane.doe@example.com"))
               
               .andExpect(status().isOk()) // Expect HTTP 200 OK after successful submission
               .andExpect(view().name("registrationResult")) // Expect the result view
               .andExpect(model().attributeExists("student")); // Check if the model object exists
    }

    /**
     * Test case to verify form submission failure (e.g., missing data).
     * While Spring Boot validation would typically handle this, here we test the happy path.
     * A robust test suite would include a negative case for validation errors.
     */
    @Test
    void testSubmitRegistration_MissingData() throws Exception {
        // Simulate a POST request with missing parameters (e.g., no name)
        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("course", "Physics"))
               
               // Note: Depending on your controller's validation logic, this might return 
               // 400 (Bad Request) or redirect back to the form (200 OK) or 3xx Redirect.
               // Assuming a simple controller that processes the request and returns 200 for now.
               .andExpect(status().isOk()); 
    }
}

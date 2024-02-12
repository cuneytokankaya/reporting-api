package com.cuneytokankaya.homework.reportingapi.controller;

import com.cuneytokankaya.homework.reportingapi.model.request.RequestLogin;
import com.cuneytokankaya.homework.reportingapi.security.JwtUtil;
import com.cuneytokankaya.homework.reportingapi.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MerchantController.class)
class MerchantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MerchantService merchantService;

    @MockBean
    public AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void login() throws Exception
    {
        // /api/v3/merchant/user/login
        RequestLogin requestLogin = new RequestLogin("ali.kaya@email","ali.kaya");

         mvc.perform(post("/api/v3/merchant/user/login")
                        .content(objectMapper.writeValueAsString(requestLogin))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isForbidden());
    }

}
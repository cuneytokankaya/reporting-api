package com.cuneytokankaya.homework.reportingapi.controller;

import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestGetMerchantById;
import com.cuneytokankaya.homework.reportingapi.model.request.RequestLogin;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseError;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseGetMerchantById;
import com.cuneytokankaya.homework.reportingapi.model.response.ResponseLogin;
import com.cuneytokankaya.homework.reportingapi.security.JwtUtil;
import com.cuneytokankaya.homework.reportingapi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/merchant")
public class MerchantController {

    @Autowired
    public MerchantService merchantService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public JwtUtil jwtUtil;

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody RequestLogin requestLogin)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword()));
            Merchant user = new Merchant(requestLogin.getEmail(),requestLogin.getPassword());
            String token = jwtUtil.createToken(user);
            ResponseLogin responseLogin = new ResponseLogin("APPROVED",token);
            return ResponseEntity.ok(responseLogin);

        }catch (BadCredentialsException e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }catch (Exception e){
            ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        }
    }

    @PostMapping("/get")
    public ResponseGetMerchantById getMerchantById(@RequestBody RequestGetMerchantById requestGetMerchantById)
    {
        Merchant merchant = merchantService.getMerchantById(requestGetMerchantById.getId());
        ResponseGetMerchantById responseGetMerchantById = new ResponseGetMerchantById();
        responseGetMerchantById.setMerchant(merchant);

        return responseGetMerchantById;
    }

    @PostMapping("/save")
    public Merchant saveMerchant(@RequestBody Merchant merchant)
    {
        return merchantService.saveMerchant(merchant);
    }

}


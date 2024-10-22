package com.piggymetrics.auth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.piggymetrics.auth.dto.AuthRequest;
import com.piggymetrics.auth.entity.UserInfo;
import com.piggymetrics.auth.service.JwtService;
import com.piggymetrics.auth.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return productService.addUser(userInfo);
    }
    @GetMapping("/{username}")
    public Optional<UserInfo> getTheUser(@PathVariable String username) {
        return productService.getUser(username);
    }
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getname(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getname());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}
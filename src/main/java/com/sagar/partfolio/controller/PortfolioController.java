package com.sagar.partfolio.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PortfolioController {

	@GetMapping("/profile")
    public Map<String, Object> getProfile() {
        return AdminController.getAllStatic();
    }
}

package com.cinemador.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cinemador")
public class BaseController {
	
	@GetMapping("/base")
    public String base() {
        return "base";
    }

}

package com.concursante.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Concursante {

	@GetMapping("")
	public String home() {
		return "index.html";
	}
}

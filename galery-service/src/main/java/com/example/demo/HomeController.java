package com.example.demo;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@GetMapping("/gallery")
	public String home() {
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");

	}

	@GetMapping("/gallery/{id}")
	public Gallery getGallery(@PathVariable final int id) {
		Gallery gallery = new Gallery();
		gallery.setId(id);

		List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
		
		gallery.setImages(images);
		return gallery;
	}

	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}

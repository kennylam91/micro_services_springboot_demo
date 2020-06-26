package com.example.demo;

import java.util.List;

public class Gallery {

	private Integer id;
	private List<Object> images;
	public Gallery(Integer id, List<Object> images) {
		super();
		this.id = id;
		this.images = images;
	}
	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Object> getImages() {
		return images;
	}
	public void setImages(List<Object> images) {
		this.images = images;
	}
	
	
}

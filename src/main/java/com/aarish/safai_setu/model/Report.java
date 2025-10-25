package com.aarish.safai_setu.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String heading;
	private String description;
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;
	
	
	
	public Report() {
		super();
	}

	public Report(int id, String heading, String description, String imageName, String imageType, byte[] imageData) {
		super();
		this.id = id;
		this.heading = heading;
		this.description = description;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
	

	@Override
	public String toString() {
		return "Report [id=" + id + ", heading=" + heading + ", description=" + description + ", imageName=" + imageName
				+ ", imageType=" + imageType + ", imageData=" + Arrays.toString(imageData) + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}


}

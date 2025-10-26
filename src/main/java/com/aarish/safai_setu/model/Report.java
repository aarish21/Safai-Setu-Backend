package com.aarish.safai_setu.model;

import java.sql.Date;
import java.time.LocalDateTime;
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
	private String address;
	private String longitude;
	private String latitude;
	private String status = "Pending";
	private LocalDateTime date = LocalDateTime.now();

	public Report(int id, String heading, String description, String imageName, String imageType, byte[] imageData,
			String address, String longitude, String latitude) {
		super();
		this.id = id;
		this.heading = heading;
		this.description = description;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Report() {
		super();
	}

	

	@Override
	public String toString() {
		return "Report [id=" + id + ", heading=" + heading + ", description=" + description + ", imageName=" + imageName
				+ ", imageType=" + imageType + ", imageData=" + Arrays.toString(imageData) + ", address=" + address
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", date=" + date + ", status=" + status + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}

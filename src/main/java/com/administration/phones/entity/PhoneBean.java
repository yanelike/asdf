package com.administration.phones.entity;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Phones")
public class PhoneBean {
	@Id
	private ObjectId id;
	@NotNull(message = "brand is required")
	public String brand;
	@NotNull(message = "model is required")
	public String model;
	public String shortName;
	public String imei;
	public String cellNumber;
	public String emailSupport;
	public boolean hasIos;
	public String getBrand() {
		return brand;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getEmailSupport() {
		return emailSupport;
	}
	public void setEmailSupport(String emailSupport) {
		this.emailSupport = emailSupport;
	}
	public boolean isHasIos() {
		return hasIos;
	}
	public void setHasIos(boolean hasIos) {
		this.hasIos = hasIos;
	}
	
	
}

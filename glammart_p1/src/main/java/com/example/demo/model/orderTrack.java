package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tracking")
public class orderTrack {
@Id
private int orderId;
private String startat;
private String endat;
public int getorderId() {
	return orderId;
}
public void setTrainno(int orderId) {
	this.orderId = orderId;
}

public String getStartat() {
	return startat;
}
public void setStartat(String startat) {
	this.startat = startat;
}
public String getEndat() {
	return endat;
}
public void setEndat(String endat) {
	this.endat = endat;
}
public orderTrack(int orderId, String startat, String endat) {
	super();
	this.orderId = orderId;
	this.startat = startat;
	this.endat = endat;
}
public orderTrack() {
	super();
	// TODO Auto-generated constructor stub
}


}
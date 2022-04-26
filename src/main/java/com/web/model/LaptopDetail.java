package com.web.model;

public class LaptopDetail {

private int id;	
private String lapName;
private String lapSpecification;
private String lapModel;
private String price;
private String rating ;
private String count;
public LaptopDetail() {
	super();

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLapName() {
	return lapName;
}
public void setLapName(String lapName) {
	this.lapName = lapName;
}
public String getLapSpecification() {
	return lapSpecification;
}
public void setLapSpecification(String lapSpecification) {
	this.lapSpecification = lapSpecification;
}
public String getLapModel() {
	return lapModel;
}
public void setLapModel(String lapModel) {
	this.lapModel = lapModel;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
}

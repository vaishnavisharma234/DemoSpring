package com.demo.sre.DemoModel;

public class DemoModel {

private String name;
private int age;
private int id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public DemoModel(String name, int age, int id) {
	super();
	this.name = name;
	this.age = age;
	this.id = id;
}
public DemoModel() {
	
}
}

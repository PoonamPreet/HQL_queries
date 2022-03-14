package com.practice.com.practice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StdDetails")
public class Student {
	@Id
private int id;
private int marks;
private String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Student [id=" + id + ", marks=" + marks + ", name=" + name + "]";
}



}

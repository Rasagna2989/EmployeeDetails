package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	private String id;

	private String name;

	private int age;

	private String gender;

	@Override
	public String toString() {
		return "Employee --> id= " + this.id + ", name= " + this.name + "age= " + this.age + " gender= " + this.gender;
	}
}

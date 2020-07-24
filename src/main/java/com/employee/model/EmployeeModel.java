package com.employee.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

	@NotEmpty
	private String id;

	@NotEmpty
	private String name;

	@Min(1)
	private int age;

	@NotEmpty
	private String gender;

	@Override
	public String toString() {
		return "Employee --> id= " + this.id + ", name= " + this.name + "age= " + this.age + " gender= " + this.gender;
	}

}

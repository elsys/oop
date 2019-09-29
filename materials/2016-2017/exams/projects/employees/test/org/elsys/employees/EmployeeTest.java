package org.elsys.employees;

import static org.junit.Assert.*;

import org.elsys.employees.Employee;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		Employee employee = new Employee(1, "Petar", 10);
		assertEquals(1, employee.getId());
		assertEquals("Petar", employee.getName());
		assertEquals(10, employee.getSalary(), 0.01);
	}

}

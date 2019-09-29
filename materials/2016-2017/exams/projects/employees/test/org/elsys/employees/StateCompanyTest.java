package org.elsys.employees;

import static org.junit.Assert.*;

import org.elsys.employees.Company;
import org.elsys.employees.Employee;
import org.junit.Test;

public class StateCompanyTest {

	@Test
	public void testHireExceedingBudget() {
		Company company = new StateCompany(10);
		company.hire(new Employee(1, "Petar", 2));
		company.hire(new Employee(2, "Petar", 9));
		assertEquals(-1, company.getBudgetLeft(), 0.01);
	}

}

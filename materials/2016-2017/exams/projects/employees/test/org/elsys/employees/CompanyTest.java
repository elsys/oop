package org.elsys.employees;

import static org.junit.Assert.*;

import org.elsys.employees.Company;
import org.elsys.employees.Employee;
import org.elsys.employees.Manager;
import org.elsys.employees.NotEnoughBudgetException;
import org.junit.Test;

public class CompanyTest {

	@Test
	public void testBudget() {
		assertEquals(10, new Company(10).getBudget(), 0.01);
	}

	@Test
	public void testSuccessfullHire() {
		Company company = new Company(10);
		company.hire(new Employee(1, "Petar", 2));
		assertEquals(8, company.getBudgetLeft(), 0.01);
	}

	@Test
	public void testManagerHire() {
		Company company = new Company(10);
		company.hire(new Manager(1, "Petar", 2));
		assertEquals(8, company.getBudgetLeft(), 0.01);
	}

	@Test(expected = NotEnoughBudgetException.class)
	public void testUnsuccessfulHire() {
		Company company = new Company(10);
		company.hire(new Employee(1, "Petar", 2));
		company.hire(new Employee(2, "Petar", 9));
	}

	@Test(expected = NotEnoughBudgetException.class)
	public void testUnsuccessfulManagerHire() {
		Company company = new Company(10);
		company.hire(new Manager(1, "Petar", 2));
		company.hire(new Manager(2, "Petar", 9));
	}
	
	@Test
	public void testIsHired() {
		Company company = new Company(10);
		Employee e = new Employee(1, "Petar", 2);
		company.hire(e);
		assertTrue(company.isHired(e));
		assertTrue(company.isHired(new Employee(1, "Petar", 2)));
	}

	@Test
	public void testFire() {
		Company company = new Company(10);
		Employee e = new Employee(1, "Petar", 2);
		company.hire(e);
		company.fire(new Employee(1, "Petar", 2));
		assertFalse(company.isHired(e));
	}

	@Test
	public void testClose() {
		Company company = new Company(10);
		company.hire(new Employee(1, "Petar", 2));
		company.hire(new Employee(2, "Petar", 8));
		company.close();
		assertEquals(0, company.getBudget(), 0.01);
		assertEquals(0, company.getBudgetLeft(), 0.01);
	}

	@Test
	public void testGetManagersWithLevel() {
		Company company = new Company(10);
		company.hire(new Manager(1, "Petar", 2));
		Manager manager = new Manager(2, "Petar", 8, 2);
		company.hire(manager);
		assertTrue(company.getManagersWithLevel(2).contains(manager));
	}
}

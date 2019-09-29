package org.elsys.employees;

import java.util.List;

public class Company {

	/**
	 * Creates company with budget provided as parameter.
	 * 
	 * @param budget
	 */
	public Company(double budget) {

	}

	/**
	 * Returns the budget of the company.
	 * 
	 * @return
	 */
	public double getBudget() {
		return 0;
	}

	/**
	 * Returns the remaining budget of the company - the company budget minus
	 * the salaries of all employees (including the managers).
	 * 
	 * @return
	 */
	public double getBudgetLeft() {
		return 0;
	}

	/**
	 * Hires an employees in the company.
	 * 
	 * If the budget is going to be exceeded, {@link NotEnoughBudgetException}
	 * must be thrown.
	 * 
	 * @param e
	 *            the employee to be hired
	 */
	public void hire(Employee e) {

	}

	/**
	 * Fires an employee.
	 * 
	 * @param e
	 *            employee to be fired
	 */
	public void fire(Employee e) {

	}

	/**
	 * Checks whether the given employee is hried in the company
	 * 
	 * @param e
	 */
	public boolean isHired(Employee e) {
		return false;
	}

	/**
	 * Closes the company. Sets the budget to 0 and fires all employees
	 */
	public void close() {

	}

	/**
	 * Returns a list of all managers with the given level.
	 * 
	 * @param level
	 * @return
	 */
	public List<Manager> getManagersWithLevel(int level) {
		return null;
	}
}

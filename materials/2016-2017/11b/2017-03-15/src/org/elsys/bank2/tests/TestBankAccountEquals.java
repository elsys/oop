package org.elsys.bank2.tests;

import static org.junit.Assert.*;

import org.elsys.bank2.CheckingAccount;
import org.junit.Test;

public class TestBankAccountEquals {

	@Test
	public void testEquals() {
		CheckingAccount a1 = new CheckingAccount(100);
		CheckingAccount a2 = new CheckingAccount(100);

		CheckingAccount aref = a1;

		assertTrue(a1.equals(a1));
		assertTrue(a2.equals(a2));
		assertTrue(a1.equals(aref));

		assertTrue(a1.equals(a2));
	}
	
	@Test
	public void testNotEquals() {
		CheckingAccount a1 = new CheckingAccount(100);
		CheckingAccount a2 = new CheckingAccount(200);
		
		assertFalse(a1.equals(a2));
	}

}

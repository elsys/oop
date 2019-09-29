package org.elsys.bank2.tests;

import static org.junit.Assert.*;

import org.elsys.bank2.CheckingAccount;
import org.junit.Test;

public class TestBankAccount {
	
	static class Num {
		private int val;
		
		public Num(int val) {
			this.val = val;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Num) {
				Num n = (Num) o;
				if(val == n.val) {
					return true;
				}
			}
			return false;
		}
	}
	
	@Test
	public void testNumEquals() {
		Num n1 = new Num(1);
		Num n2 = new Num(1);
		
		assertTrue(n1.equals(n1));
		assertTrue(n2.equals(n2));
		
		assertTrue(n1.equals(n2));
	}

	@Test
	public void testEquals() {
		CheckingAccount a1 = new CheckingAccount(100);
		CheckingAccount a2 = new CheckingAccount(100);

		assertTrue(a1.equals(a1));
		assertTrue(a2.equals(a2));

		assertTrue(a1.equals(a2));
	}
	
	
	@Test
	public void testStringEquals() {
		String s1 = new String("hell");
		String s2 = new String("hell");
		
		assertTrue(s1.equals(s2));
		
		
	}

}

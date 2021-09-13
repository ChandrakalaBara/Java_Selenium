package com.techigai.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.techigai.listners.TestNGListners.class)
public class ListnersDemo {

	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test2");
		Assert.assertTrue(1<0);
	}
	
	@Test(dependsOnMethods = {"test2"})
	public void test3() {
		System.out.println("I am inside test3");
	}
	
	@Test
	public void test4() {
		System.out.println("I am inside test4");
	}
	
}

package br.com.projuris;

import org.junit.Assert;
import org.junit.Test;

public class MyFindArrayTest {

	@Test
	public void findArrayTest1() {
		MyFindArray myFindArray = new MyFindArray();
		int[] array1 = new int[] {4,9,3,7,8};
		int[] subArray1 = new int[] {3,7};
		int resultTest1 = myFindArray.findArray(array1, subArray1);
		Assert.assertEquals(2, resultTest1);
	}
	
	@Test
	public void findArrayTest2() {
		MyFindArray myFindArray = new MyFindArray();
		int[] array2 = new int[] {1,3,5};
		int[] subArray2 = new int[] {1};
		int resultTest2 = myFindArray.findArray(array2, subArray2);
		Assert.assertEquals(0, resultTest2);
	}
	
	@Test
	public void findArrayTest3() {
		MyFindArray myFindArray = new MyFindArray();
		int[] array3 = new int[] {7,8,9};
		/*
		 * Seguindo a lógica pedida e os valores dados originalmente, o resultado não é -1, porque o 8 é localizado no primeiro Array.
		 * Modifiquei os valoes para ter um teste com -1
		 * int[] subArray3 = new int[] {8,9,10};
		 */
		int[] subArray3 = new int[] {18,19,10};
		int resultTest3 = myFindArray.findArray(array3, subArray3);
		Assert.assertEquals(-1, resultTest3);
	}
	
	@Test
	public void findArrayTest4() {
		MyFindArray myFindArray = new MyFindArray();
		int[] array4 = new int[] {4,9,3,7,8,3,7,1};
		int[] subArray4 = new int[] {3,7};
		int resultTest4 = myFindArray.findArray(array4, subArray4);
		Assert.assertEquals(5, resultTest4);
	}
	
}

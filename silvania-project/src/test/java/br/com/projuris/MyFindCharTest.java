package br.com.projuris;

import org.junit.Assert;
import org.junit.Test;

public class MyFindCharTest {

	@Test
	public void findCharTest1() {
		MyFindChar myFindChar = new MyFindChar();
		String wordTest1 = "stress";
		char resultTest1 = myFindChar.findChar(wordTest1);
		Assert.assertEquals('t', resultTest1);
	}

	@Test
	public void findCharTest2() {
		MyFindChar myFindChar = new MyFindChar();
		String wordTest2 = "reembolsar";
		char resultTest2 = myFindChar.findChar(wordTest2);
		Assert.assertEquals('m', resultTest2);
	}
	
	@Test
	public void findCharTest3() {
		MyFindChar myFindChar = new MyFindChar();
		String wordTest3 = "ssttee";
		char resultTest3 = myFindChar.findChar(wordTest3);
		Assert.assertEquals(' ', resultTest3);
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordTesterTest {

	@BeforeEach
	public void cleanUp() {
		PasswordTester.passwordList.clear();
	}

	@Test
	void doesNotExistInList() {
		String word = "AE1words";
		boolean result = PasswordTester.addPassword(word);
		assertEquals(true, result);
	}

	@Test
	void existInList() {
		String word = "AE1words";
		PasswordTester.passwordList.add(word);
		boolean result = PasswordTester.addPassword(word);
		assertEquals(false, result);
	}

	@Test
	void passwordLength() {
		String word = "AE1words";
		boolean result = PasswordTester.addPassword(word);
		assertEquals(true, result);
	}

	@Test
	void passwordLengthTooShort() {
		String word = "AE1wo";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);	
	}
	
	@Test
	void passwordNumber() {
		String word = "AE1words";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(true, result);
	}
	
	@Test
	void passwordNum6() {
		String word = "AE6words";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);
	}
	
	@Test
	void passwordSpace() {
		String word = "AE1 words";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);
	}
	
	@Test
	void passwordSpace1() {
		String word = "A E1words";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);
	}
	
	@Test
	void passwordTwoVowel() {
		String word = "E1wOrds22";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(true, result);
	}
	
	@Test
	void passwordOneVowel() {
		String word = "Ae1words";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);
	}
	
	@Test
	void passwordAdmin() {
		String word = "admin";
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(true, result);
	}
	
	@Test
	void passwordMod() {
		String word = "mod";
		PasswordTester.passwordList.add(word);
		boolean result = PasswordTester.addPassword(word);	
		assertEquals(false, result);
	}
}

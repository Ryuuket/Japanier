package co.simplon.japanier.japanierbusiness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class UtilsTests {

    @Test
    void testHashPassword() {
	String pass1 = hashPassword("azerty");
	assertEquals("The same password should always give the same hashed password.", pass1, hashPassword("azerty"));
	String pass2 = hashPassword("aserty");
	assertNotSame("Two different password should always give different hashed password.", pass2, pass1);
	//Ajouter un test sur le pattern avec une regex.
    }

}

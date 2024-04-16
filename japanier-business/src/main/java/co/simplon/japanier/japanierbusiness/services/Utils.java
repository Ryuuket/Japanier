package co.simplon.japanier.japanierbusiness.services;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public abstract class Utils {
    public String hashPassword(String password) {
	BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
	Hash hash = Password.hash(password).with(bcrypt);
	return hash.getResult();
    }
}

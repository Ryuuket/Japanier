package co.simplon.japanier.japanierbusiness.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.japanier.japanierbusiness.config.SecurityHelper;
import co.simplon.japanier.japanierbusiness.dto.CreateUser;
import co.simplon.japanier.japanierbusiness.entities.User;
import co.simplon.japanier.japanierbusiness.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityHelper securityHelper;

    public void register(CreateUser inputs) {
	User user = new User();
	user.setEmail(inputs.getEmail());
	String hashPw = securityHelper.encode(inputs.getPassword());
	user.setPassword(hashPw);
	userRepository.save(user);
    }

    public String login(CreateUser inputs) {
	User existingUser = userRepository.findOneByEmail(inputs.getEmail());
	if (existingUser != null) {
	    if (securityHelper.matches(inputs.getPassword(), existingUser.getPassword())) {
		List<String> roles = new ArrayList<String>();
		roles.add("member");
		return securityHelper.createToken(existingUser.getEmail(), roles);
	    } else {
		return "Bad pw";
	    }
	} else {
	    return "Not found";
	}
    }
}

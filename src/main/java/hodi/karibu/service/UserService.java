package hodi.karibu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hodi.karibu.model.user.User;
import hodi.karibu.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}

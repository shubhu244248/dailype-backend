package com.dp.dailype.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.dailype.exception.CustomException;
import com.dp.dailype.model.Manager;
import com.dp.dailype.model.User;
import com.dp.dailype.respository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

//	private ManagerRepository managerRepository;

	@Override
	public void saveUser(User user, Manager manager) {
		// TODO Auto-generated method stub
//		System.out.println(manager.getIsActive());
//		int n = manager.getIsActive().compareTo(manager.getIsActive());

		if (user.getUserFullName() == null || user.getUserFullName().isEmpty()) {
			throw new CustomException("Full name must not be empty.");
		}

		String mobNum = user.getMobNum().replaceAll("[^0-9]", "");
		if (mobNum.length() == 12 && mobNum.startsWith("91")) {
			mobNum = mobNum.substring(2);
		} else if (mobNum.length() == 11 && mobNum.startsWith("0")) {
			mobNum = mobNum.substring(1);
		}

		if (!Pattern.matches("\\d{10}", mobNum)) {
			throw new CustomException("Mobile number must be a valid 10-digit number.");
		}
		user.setMobNum(mobNum);

		String panNum = user.getPanNum().toUpperCase();
		if (!Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", panNum)) {
			throw new CustomException("Invalid PAN number format.");
		}
		user.setPanNum(panNum);

		if (manager.getIsActive()) {
			userRepository.save(user);
		} else {
			throw new CustomException("Manger is Not active");
		}
	}

}

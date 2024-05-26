package com.dp.dailype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.dailype.model.Manager;
import com.dp.dailype.respository.ManagerRepository;

@Service
public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Long saveManager(Manager manager) {
		// TODO Auto-generated method stub
		Long Id = managerRepository.save(manager).getManagerId();
		return Id;
	}

}

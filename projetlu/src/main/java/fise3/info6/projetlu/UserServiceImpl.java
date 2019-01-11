package fise3.info6.projetlu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fise3.info6.projetlu.model.User;
import fise3.info6.projetlu.repository.EmployeeRepository;
import fise3.info6.projetlu.repository.UserRepository;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmployeeRepository myEmployeeService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(id);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		if(user.getUserId()==100)
			user.setRoles("CEO");
		else if(myEmployeeService.findByEmployeeId(user.getUserId()).getDepartment().getDepartmentId()==100||myEmployeeService.findByEmployeeId(user.getUserId()).getDepartment().getDepartmentId()==110)
			user.setRoles("AccountingFinance");
		else if(myEmployeeService.findByEmployeeId(user.getUserId()).getDepartment().getDepartmentId()==80)
			user.setRoles("salse");
		else
			user.setRoles("others");
		userRepository.save(user);

	}

}

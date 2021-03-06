package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.EmployeeDAO;
import be.vdab.entities.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void create(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findByIdIsNotNullOrderByIdAsc();
	}

	@Override
	public Employee find(Long id) {

		return employeeDAO.findOne(id);
	}
	@Transactional(readOnly = false)
	@Override
	public void remove(Employee employee) {
		employeeDAO.delete(employee);

	}
	
	@Transactional(readOnly = false)
	@Override
	public void edit(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public List<Employee> findByNaamContaining(String waarde) {
		return employeeDAO.findByFirstNameContaining(waarde);
	}

}

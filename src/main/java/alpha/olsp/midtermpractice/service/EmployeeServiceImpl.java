package alpha.olsp.midtermpractice.service;

import alpha.olsp.midtermpractice.model.Employee;
import alpha.olsp.midtermpractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<Employee> createEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public Optional<Employee> updateEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        try{
            employeeRepository.delete(employee);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<Employee> getEmployeeWithOrder() {
        return employeeRepository.findAllByOrderBySalaryAscLastNameDesc();
    }
}

package alpha.olsp.midtermpractice.service;

import alpha.olsp.midtermpractice.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeByFirstName(String firstName);
    public Optional<Employee> createEmployee(Employee employee);
    public Optional<Employee> updateEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public List<Employee> getEmployeeWithOrder();
}

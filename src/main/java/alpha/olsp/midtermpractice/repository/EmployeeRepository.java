package alpha.olsp.midtermpractice.repository;

import alpha.olsp.midtermpractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Optional<Employee> findByFirstName(String firstName);
    public List<Employee> findAllByOrderBySalaryAscLastNameDesc();
}

package alpha.olsp.midtermpractice;

import alpha.olsp.midtermpractice.model.Employee;
import alpha.olsp.midtermpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MidTermPracticeApplication {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(MidTermPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            employeeService.createEmployee(new Employee("John","Doe",50000.0));
            employeeService.createEmployee(new Employee("Jane","Dona",50000.0));
            employeeService.createEmployee(new Employee("Alice","Smith",60000.0));
            employeeService.createEmployee(new Employee("Bob","Brown",45000.0));

            System.out.println("Fetch all employees With Order By Salary Asc And Last Name Desc");
            employeeService.getEmployeeWithOrder().forEach(System.out::println);

            System.out.println("Update Employee id 1 Name to John Doe 2");
            Optional<Employee> emp = employeeService.getEmployeeByFirstName("John");
            emp.ifPresent(e->{
                e.setLastName("Doe 2"); employeeService.updateEmployee(emp.get());
            });

            System.out.println("Fetch all employees after update");
            employeeService.getAllEmployees().forEach(System.out::println);

            System.out.println("Delete Employee 1");
            Optional<Employee> emp1 = employeeService.getEmployeeByFirstName("John");
            emp1.ifPresent(e->{
               employeeService.deleteEmployee(e);
            });
            System.out.println("Fetch all employees after delete");
            employeeService.getAllEmployees().forEach(System.out::println);

            System.out.println("Fetch all employees after delete");
            employeeService.getAllEmployees().forEach(System.out::println);
        };
    }

}

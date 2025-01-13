package dz8.service;

import dz8.model.Employee;
import dz8.model.Project;
import dz8.model.Timesheet;
import dz8.repository.EmployeeRepository;
import dz8.repository.ProjectRepository;
import dz8.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final TimesheetRepository timesheetRepository;
    @Autowired
    private final ProjectRepository projectRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Timesheet> getTimesheets(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Employee " + id + " doesn't exist");
        }
        return timesheetRepository.findByEmployeeId(id);
    }

    public void addProject(Long id, Project project) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Employee " + id + " doesn't exist");
        }
        if (projectRepository.findById(project.getProjectId()).isEmpty()) {
            throw new NoSuchElementException("Project " + id + " doesn't exist");
        }
        Employee employee = employeeRepository.findById(id).get();
        Set<Project> projects = employee.getProjects();
        projects.add(projectRepository.findById(project.getProjectId()).get());
        employee.setProjects(projects);
        employeeRepository.save(employee);
    }

}
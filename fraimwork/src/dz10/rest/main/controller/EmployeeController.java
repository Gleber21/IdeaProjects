package dz10.rest.main.controller;

import dz10.rest.main.model.Employee;
import dz10.rest.main.model.Project;
import dz10.rest.main.model.Timesheet;
import dz10.rest.main.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("employeeId") Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{employeeId}/timesheets")
    public ResponseEntity<List<Timesheet>> getAllEmployeeTimesheets(@PathVariable("employeeId") Long id) {
        try {
            return ResponseEntity.ok(employeeService.getTimesheets(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{employeeId}/projects")
    public ResponseEntity<Void> setProject(@RequestBody Project project, @PathVariable("employeeId") Long id) {
        employeeService.addProject(id, project);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee (@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}

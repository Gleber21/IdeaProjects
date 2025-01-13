package dz10.page.main.client;

import lombok.Data;

import java.util.Set;

@Data
public class EmployeeResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Set<ProjectResponse> projects;

}

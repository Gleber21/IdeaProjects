package dz10.page.main.client;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimesheetResponse {

    private Long id;
    private Long projectId;
    private Long employeeId;
    private Integer minutes;
    private LocalDate createdAt;

}
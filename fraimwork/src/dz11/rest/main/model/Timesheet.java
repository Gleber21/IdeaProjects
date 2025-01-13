package dz11.rest.main.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Timesheet {
    private Long id;
    private String project;
    private int minutes;
    private LocalDate createdAt;
}

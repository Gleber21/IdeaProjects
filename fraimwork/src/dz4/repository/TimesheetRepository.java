package dz4.repository;

import dz4.model.Timesheet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository // @Component для классов, работающих с данными
public class TimesheetRepository {

    private static Long sequence = 1L;

    private final List<Timesheet> timesheets = new ArrayList<>(); // это наше хранилище

    // получить конкретную запись по идентификатору
    public Optional<Timesheet> getById(Long id) {
        return timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    // получить все
    public List<Timesheet> getAll() {
        return List.copyOf(timesheets);
    }

    // создание нового ресурса
    public Timesheet create(Timesheet timesheet) {
        timesheet.setId(sequence++);
        timesheets.add(timesheet);
        return timesheet;
    }

    public void delete(Long id) {
        timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(timesheets::remove); // если нет - иногда посылают 404 Not Found
    }
}
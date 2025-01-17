package dz8.service;

import dz8.model.Timesheet;

public class ProxyTimesheetService extends TimesheetService {

    private final TimesheetService original;

    public ProxyTimesheetService(TimesheetService original) {
        super(original);
        this.original = original;
    }

    @Override
    public Optional<Timesheet> original.getById(Long id) {
        //BEFORE
        Optional<Timesheet> result = null;
        try {
            result = super.getById(id);
            //AFTER RETURNING
        } catch (Throwable e) {
            //AFTER THROWING
            throw e;
        } finally {
            //AFTER
            return result;
        }
    }
}

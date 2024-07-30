package Presenter;


import Service.FamilyTreeService;
import Service.HumanFamilyTree;
import Model.Writer.FileHandler;
import Viewer.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final FamilyTreeService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanFamilyTree(new FileHandler());
    }

    public void addObject(String name, LocalDate dob, String viewGender) {
        service.addObject(name, dob, viewGender);
    }

    public String getTree() {
        return service.getTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public boolean saveTree() {
        return service.save();
    }

    public void readTree() {
        service.read();
    }

    public boolean addParentByID(int parentID, int childID) {
        return service.addParentByID(parentID, childID);
    }

}

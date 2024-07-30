package Service;

import java.time.LocalDate;

public interface FamilyTreeService {
    void addObject(String name, LocalDate dob, String viewGender);

    String getTreeInfo();

    void sortByAge();

    void sortByName();

    boolean save();

    void read();

    boolean addParentByID(int parentID, int childID);

}

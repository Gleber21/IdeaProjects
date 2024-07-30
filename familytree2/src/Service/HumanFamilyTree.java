package Service;

import Model.Human.Gender;
import Model.Human.Human;
import Model.FamilyTree.FamilyTree;
import Model.Writer.Writable;
import Viewer.ViewGender;

import java.time.LocalDate;

public class HumanFamilyTree implements FamilyTreeService {
    private int genId;
    private FamilyTree<Human> tree;
    private final Writable fH;

    //Пока работаю только с одним древом, в дальнейшем можно создать список деревьев

    public HumanFamilyTree(Writable writable) {
        tree = new FamilyTree<>();FamilyTree<>();
        fH = writable;
    }


    public void addHuman (String name, LocalDate dob, Gender gender){
        Human human = new Human(name, dob, gender);
        human.setId(genId++);
        this.tree.addHuman(human);
    }

    @Override
    public void addObject (String name, LocalDate dob, String strGender){
        Gender gender = null;
        if (strGender == ViewGender.MALE.toString()) {
            gender = Gender.Male;
        } else if (strGender == ViewGender.FEMALE.toString()) {
            gender = Gender.Female;
        }
        addHuman(name, dob, gender);
    }

    public String getTreeInfo (){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Object human : this.tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        this.tree.sortByName();
    }

    public void sortByAge() {
        this.tree.sortByAge();
    }

    public boolean save (){
        return fH.save(this.tree);
    }

    @Override
    public void read() {

    }


    public Human findByID(int iD) {
        for (Human human : this.tree){
            if(human.getId() == iD){
                return human;
            }
        }
        return null;
    }

    public boolean addParentByID(int parentID, int childID) {
        if ((findByID(parentID) != null) && findByID(childID) != null){
            findByID(parentID).addChild(findByID(childID));
            return true;
        }
        return false;
    }
}
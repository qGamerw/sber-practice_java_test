import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Team {
    private Human human;
    private int numberInTeam;
    private  int limitTeam;
    private ArrayList<Human> arrTeam;

    public Team () {
        numberInTeam = 0;
        limitTeam = 2;
    }

    public String createdTeam(String name) {
        if (numberInTeam > 0) {
            return "The team has already been created";
        } else {
            numberInTeam = 1;
            human = new Human(name);
            arrTeam = new ArrayList<Human>();
            arrTeam.add(human);
            return "Team is created";
        }
    }
    public String createdTeam(Human human) {
        if (numberInTeam > 0) {
            return "The team has already been created";
        } else {
            numberInTeam = 1;
            arrTeam = new ArrayList<Human>();
            arrTeam.add(human);
            return "Team is created";
        }
    }

    public boolean isAddTeam(String name) throws LimitedTeamException {
        if (numberInTeam == limitTeam)
            throw new LimitedTeamException("Limited number in the team");
        if (numberInTeam == 0)
            return false;
        human = new Human(name);
        numberInTeam++;
        arrTeam.add(human);
        return true;
    }

    public boolean isRemoveHumanTeam() {
        if (numberInTeam != 0) {
            arrTeam.remove(human);
            return true;
        }
        return false;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public String getHumanName() {
        return human.getNamePerson();
    }

    private int getLimitTeam() {
        return limitTeam;
    }

}

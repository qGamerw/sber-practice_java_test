package testsjunit;

import java.util.ArrayList;

public class Team {
    private Human human;
    private int numberInTeam;
    private int limitTeam;
    private ArrayList<String> arrNamesTeam;

    public Team() {
        numberInTeam = 0;
        limitTeam = 2;
    }
    
    public Team(int numberInTeam, int limitTeam) {
        this.numberInTeam = numberInTeam;
        this.limitTeam = limitTeam;
    }

    public String createdTeam(String name) {
        if (numberInTeam > 0) {
            return "The team has already been created";
        } else {
            numberInTeam++;
            human = new Human(name);
            arrNamesTeam = new ArrayList<>();
            arrNamesTeam.add(name);
            return "tests.Team is created";
        }
    }

    public boolean isAddTeam(String name) throws LimitedTeamException {
        if (numberInTeam == limitTeam)
            throw new LimitedTeamException("Limited number in the team");
        if (numberInTeam == 0)
            return false;
        numberInTeam++;
        arrNamesTeam.add(name);
        return true;
    }

    public boolean isRemoveHumanTeam(String name) {
        if (numberInTeam != 0 && arrNamesTeam.contains(name)) {
            arrNamesTeam.remove(name);
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
    
    public Human getHuman() {
        return human;
    }

    public int getNumberInTeam() {
        return numberInTeam;
    }

    public void setNumberInTeam(int numberInTeam) {
        this.numberInTeam = numberInTeam;
    }

    public void setLimitTeam(int limitTeam) {
        this.limitTeam = limitTeam;
    }

    private int getLimitTeam() {
        return limitTeam;
    }

}

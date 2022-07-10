public class Human {
    private String namePerson;
    private String genus;

    public Human (String namePerson) {
        this.namePerson = namePerson;
        this.genus = "man";
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public String toString() {
        return "Person [genus = " + genus + ", namePerson = " + namePerson + "]";
    }

}

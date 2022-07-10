public class Check {
    public static void main(String[] args) {
        Team team = new Team();
        team.createdTeam("Egor");
        team.createdTeam("Egor");
        try {
            team.isAddTeam("Egor");
            team.isAddTeam("Egor");
            team.isAddTeam("Egor");
        } catch (LimitedTeamException e) {
            System.out.println("Limited Team");;
        }
        System.out.println("The program continues");
    }
}

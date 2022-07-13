package testsjunit;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TeamTest {
    //some tests
    @Test
    public void createdTeamTest() {
        System.out.println("Created tests.Team Test - complete");

        Team team = new Team();
        assertEquals("tests.Team is created", team.createdTeam("Egor"));
        assertEquals("The team has already been created", team.createdTeam("Egor"));
    }

    @Test
    public void removeHumanTeamTest() {
        System.out.println("Remove tests.Human tests.Team Test - complete");

        Team team = new Team();
        assertFalse(team.isRemoveHumanTeam("Egor"));

        team.createdTeam("Egor");
        try {
            team.isAddTeam("Egor");
        } catch (LimitedTeamException e) {
            System.out.println("Limited number in the team");
        }
        assertFalse(team.isRemoveHumanTeam("Igor"));
        assertTrue(team.isRemoveHumanTeam("Egor"));
    }

    //1
    @Test
    public void getHumanNameTest() {
        System.out.println("Get tests.Human Name Test - complete");

        Human human = mock(Human.class);
        doReturn("Egor").when(human).getNamePerson();

        Team team = new Team();
        team.setHuman(human);
        assertEquals("Egor", team.getHumanName());
    }

    @Test
    public void getHumanNameTest2() {
        System.out.println("Get tests.Human Name Test 2 - complete");

        Human human = mock(Human.class);
        doReturn("Egor").when(human).getNamePerson();

        Team team = new Team();
        team.setHuman(human);
        assertEquals("Egor", human.getNamePerson());
    }

    //2
    @Test
    public void numberCallsAddCommandTest() {
        System.out.println("Number of calls to add a command - complete");

        Team team = spy(Team.class);
        team.createdTeam("Egor");

        verify(team, times(1)).createdTeam("Egor");
    }

    //3
    @Test(expected = LimitedTeamException.class)
    public void limitedTeamTest() throws LimitedTeamException {
        System.out.println("Limited tests.Team Test - complete");

        Team team = mock(Team.class);
        team.createdTeam("Egor");

        when(team.isAddTeam("Egor")).thenThrow(new LimitedTeamException("Limited number in the team"));
        team.isAddTeam("Egor");
    }

    //4
    @Test
    public void limitedNumberPrivateTeamTest() throws Exception {
        System.out.println("Limited Number tests.Team Private Test - complete");
        Team team = new Team();
        team.createdTeam("Egor");

        Method method = Team.class.getDeclaredMethod("getLimitTeam");
        method.setAccessible(true);
        assertEquals(2, (int) method.invoke(team));
    }
}


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import org.junit.Test;

public class TeamTest {
    //some tests
    @Test
    public void createdTeamTest(){
        System.out.println("Created Team Test - complete");

        Team team = new Team();
        assertEquals("Team is created", team.createdTeam("Egor"));
        assertEquals("The team has already been created", team.createdTeam("Egor"));
    }

    @Test
    public void removeHumanTeamTest() {
        System.out.println("Remove Human Team Test - complete");

        Team team = new Team();
        assertFalse(team.isRemoveHumanTeam());

        team.createdTeam("Egor");
        try {
            team.isAddTeam("Egor");
        } catch (LimitedTeamException e){
            System.out.println("Limited number in the team");
        }

        assertTrue(team.isRemoveHumanTeam());
    }

    //1
    @Test
    public void getHumanNameTest(){
        System.out.println("Get Human Name Test - complete");

        Human human = mock(Human.class);
        doReturn("Egor").when(human).getNamePerson();

        Team team = new Team();
        team.setHuman(human);
        assertEquals("Egor", team.getHumanName());
    }

    @Test
    public void getHumanNameTest2(){
        System.out.println("Get Human Name Test 2 - complete");

        Human human = mock(Human.class);
        doReturn("Egor").when(human).getNamePerson();

        Team team = new Team();
        team.setHuman(human);
        assertEquals("Egor", human.getNamePerson());
    }

    //2
    @Test
    public void numberCallsAddCommandTest(){
        System.out.println("Number of calls to add a command - complete");

        Team team = spy(Team.class);
        team.createdTeam("Egor");

        verify(team, times(1)).createdTeam("Egor");
    }

    //3
    @Test(expected = LimitedTeamException.class)
    public void LimitedTeamTest() throws LimitedTeamException {
        System.out.println("Limited Team Test - complete");

        Team team = mock(Team.class);
        team.createdTeam("Egor");

        when(team.isAddTeam("Egor")).thenThrow(new LimitedTeamException("Limited number in the team"));
        team.isAddTeam("Egor");
    }

    //4
    @Test
    public void LimitedNumberPrivateTeamTest() throws Exception{
        System.out.println("Limited Number Team Private Test - complete");
        Team team = new Team();
        team.createdTeam("Egor");

        Method method = Team.class.getDeclaredMethod("getLimitTeam");
        method.setAccessible(true);
        assertEquals(2, (int) method.invoke(team));
    }
}

package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Moiez B.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("moiez12", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-09", t.getName());
    }
    
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Jason Z."), "Team should contain Jason Z.");
        assertTrue(t.getMembers().contains("Fred Z."), "Team should contain Fred Z.");
        assertTrue(t.getMembers().contains("Andrew K."), "Team should contain Andrew K.");
        assertTrue(t.getMembers().contains("Ruben A."), "Team should contain Ruben A.");
        assertTrue(t.getMembers().contains("Moiez B."), "Team should contain Moiez B.");
        assertTrue(t.getMembers().contains("Joel S."), "Team should contain Joel S.");
    }

    @Test
        public void getTeam_returns_team_with_JasonZ() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Jason Z."), "Team should contain Jason Z.");
        }

        @Test
        public void getTeam_returns_team_with_FredZ() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Fred Z."), "Team should contain Fred Z.");
        }

        @Test
        public void getTeam_returns_team_with_AndrewK() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Andrew K."), "Team should contain Andrew K.");
        }

        @Test
        public void getTeam_returns_team_with_RubenA() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Ruben A."), "Team should contain Ruben A.");
        }

        @Test
        public void getTeam_returns_team_with_MoiezB() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Moiez B."), "Team should contain Moiez B.");
        }

        @Test
        public void getTeam_returns_team_with_JoelS() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Joel S."), "Team should contain Joel S.");
        }

            // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}

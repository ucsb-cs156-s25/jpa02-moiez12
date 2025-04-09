package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import  java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

        @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
        @Test
    public void testEqualsDifferentNameDifferentMembers() {
        Team t1 = new Team("1");
        t1.setMembers(new ArrayList<>(Arrays.asList("Alice", "Bob")));

        Team t2 = new Team("2");
        t2.setMembers(new ArrayList<>(Arrays.asList("Charlie", "Dana")));

        assertFalse(t1.equals(t2));
    }

        @Test
    public void testEqualsDifferentNameSameMembers() {
        Team t1 = new Team("1");
        t1.setMembers(new ArrayList<>(Arrays.asList("Mark", "Jason")));

        Team t2 = new Team("2");
        t2.setMembers(new ArrayList<>(Arrays.asList("Mark", "Jason")));

        assertFalse(t1.equals(t2));
    }

        @Test
    public void testEqualsSameNameDifferentMembers() {
        Team t1 = new Team("1");
        t1.setMembers(new ArrayList<>(Arrays.asList("Waluigi", "Mario")));

        Team t2 = new Team("1");
        t2.setMembers(new ArrayList<>(Arrays.asList("Waluigi", "Wario")));

        assertFalse(t1.equals(t2));
    }

        @Test
    public void testEqualsSameNameSameMembers() {
        Team t1 = new Team("1");
        t1.setMembers(new ArrayList<>(Arrays.asList("Mark", "Jason")));

        Team t2 = new Team("1");
        t2.setMembers(new ArrayList<>(Arrays.asList("Mark", "Jason")));

        assertTrue(t1.equals(t2));
    }

        @Test
    public void testEqualsDifferentClass() {
        Team t1 = new Team("1");
        assertFalse(t1.equals("Not a team"));
    }

        @Test
    public void testEqualsSameObject() {
        Team t1 = new Team("1");
        t1.addMember("Mark");
        assertTrue(t1.equals(t1));
    }

    @Test
    public void testHashCodeConsistencyForEqualObjects() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        assertEquals(t1, t2); // Sanity check: they are equal
        assertEquals(t1.hashCode(), t2.hashCode()); // Must also have same hashCode
    }

    @Test
    public void testHashCodeDeterministic() {
        Team t = new Team("1");
        t.addMember("Joel");
        t.addMember("Joyce");

        int hash1 = t.hashCode();
        int hash2 = t.hashCode();

        // The hashCode must be consistent across calls
        assertEquals(hash1, hash2);
}
    @Test
    public void testHashCodeNotZero() {
        Team t = new Team("1");
        t.addMember("Marko");

        // This ensures the hashCode isn't always zero
        assertNotEquals(0, t.hashCode());
    }

    @Test
    public void testHashCodeExpectedValue() {
        Team t = new Team("1");
        ArrayList<String> members = new ArrayList<>();
        members.add("Joyce");
        t.setMembers(members);

        int expected = "1".hashCode() | members.hashCode();
        assertEquals(expected, t.hashCode());
    }

}

package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");  
        team.addMember("Christopher L");
        team.addMember("Michael J");
        team.addMember("Xinghan");
        team.addMember("Skanda");
        team.addMember("Edward");
        team.addMember("Victor");  
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[Christopher L, Michael J, Xinghan, Skanda, Edward, Victor])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertEquals(team.equals(team), true);
    }

    @Test
    public void equals_returns_false_for_different_class() {
        String team1 = "fake-team";
        assertEquals(team.equals(team1), false);
    }

    @Test
    public void equals_returns_true_for_equal_team() {
        Team team2 = new Team("test-team");
        team2.addMember("Christopher L");
        team2.addMember("Michael J");
        team2.addMember("Xinghan");
        team2.addMember("Skanda");
        team2.addMember("Edward");
        team2.addMember("Victor");
        assertEquals(true, team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_equal_name_but_different_members() {
        Team team3 = new Team("test-team");
        team3.addMember("Not Christopher L");
        assertEquals(team.equals(team3), false);
    }

    @Test 
    public void equals_returns_false_for_different_name_but_same_members() {
        Team team4 = new Team("different-team");
        team4.addMember("Christopher L");
        team4.addMember("Michael J");
        team4.addMember("Xinghan");
        team4.addMember("Skanda");
        team4.addMember("Edward");
        team4.addMember("Victor");
        assertEquals(team.equals(team4), false);
    }

    @Test 
    public void equals_returns_false_for_different_name_and_different_members() {
        Team team5 = new Team("different-team");
        team5.addMember("Not Christopher L");
        assertEquals(team.equals(team5), false);
    }

    @Test
    public void hashCode_returns_same_hashCode_for_equal_teams() {
        Team team2 = new Team("test-team");
        team2.addMember("Christopher L");
        team2.addMember("Michael J");
        team2.addMember("Xinghan");
        team2.addMember("Skanda");
        team2.addMember("Edward");
        team2.addMember("Victor");
        assertEquals(team.hashCode(), team2.hashCode());
    }

    @Test
    public void hashCode_returns_different_hashCode_for_different_teams() {
        Team team3 = new Team("different-team");
        team3.addMember("Not Christopher L");
        assertEquals(team.hashCode() != team3.hashCode(), true);
    }
}

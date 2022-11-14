//Tested by Sara
package camp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScheduleTest {
    private Schedule schedule;
    private ArrayList<String> campActivities = new ArrayList<String>();

    @BeforeEach
    public void setUp() throws Exception{
        campActivities.add("wake up" );
        campActivities.add("breakfast at the mess hall");
		campActivities.add("lunch at the mess hall");
		campActivities.add("snack/rest time at cabin");
		campActivities.add("dinner at the mess hall");
        campActivities.add("campfire songs at firepit");
        campActivities.add("lights out");
        campActivities.add("ziplining at zipline track");
        campActivities.add("swimming in lake");
        campActivities.add("running on the field");
        campActivities.add("gaga ball at the gaga ball pit");
        campActivities.add("soccer on the field");
        campActivities.add("kayaking in the lake");
        campActivities.add("bracelet making in the mess hall");
        campActivities.add("arts and crafts at craft building");
        campActivities.add("painting at the craft building");
        campActivities.add("archery at the archery range");
        campActivities.add("tie dying at the craft building");
        campActivities.add("singing at the mess hall");
        
        schedule = new Schedule(campActivities, 1);
        schedule.setActivityList(campActivities);
    }

    @AfterEach
    public void tearDown(){
        campActivities.clear();
        schedule = null;
    }

    @Test
    void testEditScheduleValidInputSetsKeyCorrect(){
        schedule.editSchedule("10:00 - 11:45:", "kayaking in the lake");
        assertTrue("failure - should be true", schedule.getSchedule().containsKey("10:00 - 11:45:"));        
    }

    @Test
    void testEditScheduleValidInputSetsValueCorrect(){
        schedule.editSchedule("10:00 - 11:45:", "kayaking in the lake");
        assertEquals(schedule.getSchedule().get("10:00 - 11:45:"),"kayaking in the lake");
    }

    @Test
    void testEditScheduleInvalidKeyEntered(){
        schedule.editSchedule("", "kayaking in the lake");
        assertFalse(schedule.getSchedule().containsKey(""), "failure - should be false");
    }

    @Test
    void testEditScheduleInvalidValueEntered(){
        schedule.editSchedule("10:00 - 11:45:", "");
        assertFalse(schedule.getSchedule().containsKey("10:00 - 11:45:"), "failure - should be false");
    }

    @Test
    void testRemoveScheduleValidInput(){
        schedule.remove("10:00 - 11:45:");
        assertFalse(schedule.getSchedule().containsKey("10:00 - 11:45:"), "failure - should be false");
    }

    @Test
    void testRemoveScheduleInvalidTime(){
        assertFalse(schedule.remove(""));
    }

    @Test
    void testRemoveScheduleInvalidTimeNull(){
        assertFalse(schedule.remove(null));
    }

    @Test
    void testAddScheduleValidInput(){
        schedule.add("10:00 - 11:45:", "kayaking in the lake");
        assertEquals(schedule.getSchedule().get("10:00 - 11:45:"),"kayaking in the lake");
    }

    @Test
    void testAddScheduleInvalidTime(){
        assertFalse(schedule.add("","kayaking in the lake"));
    }

    @Test
    void testAddScheduleInvalidTimeNull(){
        assertFalse(schedule.add(null,"kayaking in the lake"));
    }

    @Test
    void testAddScheduleInvalidActivity(){
        assertFalse(schedule.add("10:00 - 11:45:",""));
    }

    @Test
    void testAddScheduleInvalidActivityNull(){
        assertFalse(schedule.add("10:00 - 11:45:",null));    
    }
}

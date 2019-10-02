package java;


import model.Events;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventsTest {
    private Events task = new Events("celebration", "12/12/2019 1200");

    @Test
    void TestToString() {
        assertEquals(task.toString(), "[E][" + "✘" + "] celebration (at: 12th of December 2019, 12pm)");
    }

    @Test
    void TestSaveFormat() {
        assertEquals(task.getFormat(), "E | false | celebration | 12th of December 2019, 12pm");
    }

}
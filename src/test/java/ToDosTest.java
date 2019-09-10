package java;

import model.ToDos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDosTest {
    private ToDos task = new ToDos("buy wallet");

    @Test
    void TestToString() {
        assertEquals(task.toString(), "[T][" + "✘" + "] buy wallet");
    }

    @Test
    void TestSaveFormat() {
        assertEquals(task.getFormat(), "T | false | buy wallet");
    }
}

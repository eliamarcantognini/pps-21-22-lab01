import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new SimpleCircularList();
    }

    @Test
    void testSize(){
        assertEquals(0, circularList.size());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        assertEquals(1, circularList.size());
    }





}

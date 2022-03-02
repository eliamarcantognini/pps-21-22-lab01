import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testIsEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testNext(){
        this.addAll(1, 2, 3);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
        assertEquals(1, circularList.next().get());
    }

    @Test
    void testPrevious(){
        addAll(1, 2, 3);
        assertEquals(1, circularList.previous().get());
        assertEquals(3, circularList.previous().get());
        assertEquals(2, circularList.previous().get());
        assertEquals(1, circularList.previous().get());
    }

    @Test
    void testReset(){
        this.addAll(1, 2, 3);
        circularList.next();
        assertEquals(2, circularList.next().get());
        circularList.reset();
        assertEquals(1, circularList.next().get());
    }

    private void addAll(Integer... elements){
        for (int e : elements) {
            circularList.add(e);
        }
    }
}

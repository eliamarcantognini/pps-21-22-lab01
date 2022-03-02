import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private final SelectStrategyFactory factory = new SimpleSelectStrategyFactory();

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
        assertEquals(Optional.empty(), circularList.next());
        this.addAll(1, 2, 3);
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testPrevious(){
        assertEquals(Optional.empty(), circularList.previous());
        addAll(1, 2, 3);
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(1), circularList.previous());
    }

    @Test
    void testPreviousNextBehaviour(){
        addAll(1, 2, 3, 4);
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(4), circularList.next());
    }

    @Test
    void testReset(){
        this.addAll(1, 2, 3);
        circularList.next();
        assertEquals(Optional.of(2), circularList.next());
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testNextWithStrategy(){
        this.addAll(1, 2, 3, 5, 6, 7, 8, 9, 10);
        assertEquals(Optional.of(2), circularList.next(factory.createEvenStrategy()));
        assertEquals(Optional.of(3), circularList.next(factory.createMultipleOfStrategy(3)));
        assertEquals(Optional.of(8), circularList.next(factory.createMultipleOfStrategy(4)));
        assertEquals(Optional.of(10), circularList.next(factory.createEqualsStrategy(10)));
    }

    private void addAll(Integer... elements){
        for (int e : elements) {
            circularList.add(e);
        }
    }

}

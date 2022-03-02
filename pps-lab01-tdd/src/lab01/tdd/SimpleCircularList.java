package lab01.tdd;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private static final int START_INDEX = 0;
    private final List<Integer> elements;
    private int index;

    public SimpleCircularList() {
        this.elements = new ArrayList<>();
        this.index = START_INDEX;
    }

    @Override
    public void add(final int element) {
        this.elements.add(element);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> element = Optional.empty();
        if (!this.isEmpty()) {
            element = Optional.of(elements.get(this.index));
            increaseIndex();
        }
        return element;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> element = Optional.empty();
        if (!this.isEmpty()) {
            element = Optional.of(elements.get(this.index));
            decreaseIndex();
        }
        return element;
    }

    @Override
    public void reset() {
        this.index = START_INDEX;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> element = Optional.empty();
        if (strategy.apply(this.elements.get(this.index))) {
            element = Optional.of(this.elements.get(this.index));
        }
        return element;
    }

    private void increaseIndex(){
        if (this.index == this.size() - 1) {
            this.index = START_INDEX;
        } else {
            this.index++;
        }
    }

    private void decreaseIndex(){
        if (this.index == START_INDEX) {
            this.index = this.size() - 1;
        } else {
            this.index--;
        }
    }
}

package lab01.tdd;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> elements;
    private int index;

    public SimpleCircularList() {
        this.elements = new ArrayList<>();
        this.index = 0;
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
            element = Optional.of(elements.get(index));
            increaseIndex();
        }
        return element;
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }

    private void increaseIndex(){
        if (this.index == this.size() - 1) {
            this.index = 0;
        } else {
            this.index++;
        }
    }

}

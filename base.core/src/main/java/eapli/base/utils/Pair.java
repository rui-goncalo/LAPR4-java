package eapli.base.utils;

public class Pair<E, T> {
    private final E element1;
    private final T element2;


    public Pair(E element1, T element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public E getElement1() {
        return element1;
    }

    public T getElement2() {
        return element2;
    }

    @Override
    public String toString() {
        return String.format("<%s , %s>", element1, element2);
    }
}

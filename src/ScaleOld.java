import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ScaleOld implements List<Note> {
    private List<Note> notes = new ArrayList<>();


    @Override
    public int size() {
        return notes.size();
    }

    @Override
    public boolean isEmpty() {
        return notes.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return notes.contains(o);
    }

    @Override
    public Iterator<Note> iterator() {
        return notes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Note> action) {

    }

    @Override
    public Object[] toArray() {
        return notes.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return notes.toArray(a);
    }

    @Override
    public boolean add(Note note) {
        return notes.add(note);
    }

    @Override
    public boolean remove(Object o) {
        return notes.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return notes.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Note> c) {
        return notes.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Note> c) {
        return notes.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return notes.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super Note> filter) {
        return notes.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return notes.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<Note> operator) {
        notes.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Note> c) {
        notes.sort(c);
    }

    @Override
    public void clear() {
        notes.clear();
    }

    @Override
    public Note get(int index) {
        return notes.get(index);
    }

    @Override
    public Note set(int index, Note element) {
        return notes.set(index, element);
    }

    @Override
    public void add(int index, Note element) {
        add(index, element);
    }

    @Override
    public Note remove(int index) {
        return notes.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return notes.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return notes.lastIndexOf(o);
    }

    @Override
    public ListIterator<Note> listIterator() {
        return notes.listIterator();
    }

    @Override
    public ListIterator<Note> listIterator(int index) {
        return notes.listIterator(index);
    }

    @Override
    public List<Note> subList(int fromIndex, int toIndex) {
        return notes.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<Note> spliterator() {
        return notes.spliterator();
    }

    @Override
    public Stream<Note> stream() {
        return notes.stream();
    }

    @Override
    public Stream<Note> parallelStream() {
        return notes.parallelStream();
    }
}

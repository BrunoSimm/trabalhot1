public interface ListOfIntegers<T> {
    void add(int element);
    void add(int index, int element);
    int get(int index);
    int set(int index, int element);
    boolean remove(int element);
    boolean removeAll(int element);
    int removeByIndex(int index);
    boolean isEmpty();
    int getSize();
    boolean contains(int element);
    int indexOf(int element);
    void clear();
    void sort();
    void reverse();
    T getSubset(int start, int end);
}

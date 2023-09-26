/**
 * Classe que implementa a estrutura de dados e os
 * procedimentos de uma lista de inteiros linear
 * usando arranjo.
 *
 * @author Bruno Simm
 * @author Joao Gabriel Bergamaschi
 */
public class ListArrayOfIntegers implements ListOfIntegers {

    // Quantidade de elementos na lista.
    private int count;
    // Arranjo como estrutura base de funcionamento da lista
    private int[] data;
    // Tamanho padrao de inicio da lista
    private static final int DEFAULT_SIZE = 10;

    /**
     * Construtor da lista
     *
     * @param size tamanho inicial atribuido para o
     *             arranjo data
     */
    public ListArrayOfIntegers(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        data = new int[size];
        count = 0;
    }

    /**
     * Construtor da lista com tamanho padrao
     */
    public ListArrayOfIntegers() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(int element) {
        if (data.length == count) {
            increaseSize(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    @Override
    public void add(int index, int element) {
        rangeCheck(index, count);
        if (data.length < count + 1) {
            increaseSize(data.length * 2);
        }
        int oldValue = data[index];
        data[index] = element;
        count++;
        for (int i = index + 1; i < count; i++) {
            int aux = data[i];
            data[i] = oldValue;
            oldValue = aux;
        }
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index, count);
        return data[index];
    }

    @Override
    public int set(int index, int element) {
        this.rangeCheck(index, count);
        int oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    @Override
    public boolean remove(int element) {
        for (int i = 0; i < count; i++) {
            if (element == data[i]) {
                reorderList(i);
                count--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(final int element) {
        final int initialCount = this.count;
        for (int index = 0; index < this.count; index++) {
            if (this.data[index] == element) {
                reorderList(index);
                this.count--;
            }
        }
        return this.count < initialCount;
    }

    @Override
    public int removeByIndex(final int index) {
        rangeCheck(index, this.count);
        final int oldValue = data[index];
        if (index == (this.count - 1)) {
            this.count--;
            return oldValue;
        }
        reorderList(index);
        this.count--;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < count; i++) {
            if (data[i] == element) return true;
        }
        return false;
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < count; i++) {
            if (data[i] == element) return i;
        }
        return -1;
    }

    @Override
    public void clear() {
        data = new int[DEFAULT_SIZE];
        count = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            int biggestElementIndex = i; // Posição do maior elemento da iteração atual
            for (int j = i + 1; j < count; j++) { // Busca pelo maior elemento da lista apartir de [i]
                if (data[j] > data[biggestElementIndex]) {
                    biggestElementIndex = j;
                }
            }
            // Troca o elemento atual [i] com o maior elemento da lista [biggestElementIndex].
            int biggestElementValue = data[biggestElementIndex];
            data[biggestElementIndex] = data[i];
            data[i] = biggestElementValue;
        }
    }

    @Override
    public void reverse() {
        if (count > 0) {
            for (int i = 0; i < count / 2; i++) {
                int auxEnd = data[(count - 1) - i];
                data[(count - 1) - i] = data[i];
                data[i] = auxEnd;
            }
        }
    }

    @Override
    public ListArrayOfIntegers getSubset(int start, int end) {
        rangeCheck(start, end, count);
        ListArrayOfIntegers newList = new ListArrayOfIntegers((end - start) + 1);
        for (int i = start; i < end; i++) {
            newList.add(data[i]);
        }
        return newList;
    }

    /**
     * Metodo com visibilidade interna (privado),
     * responsavel pelo aumento do tamanho do
     * arranjo.
     *
     * @param newSize novo tamanho que sera
     *                definido ao arranjo
     */
    private void increaseSize(int newSize) {
        int[] newData = new int[newSize];
        for (int index = 0; index < this.data.length; index++) {
            newData[index] = this.data[index];
        }
        this.data = newData;
    }

    /**
     * Metodo que reordena a lista apos uma
     * remocao
     *
     * @param index indice da lista em que
     *              o elemento sera removido
     */
    private void reorderList(int index) {
        for (int aux = index; aux < this.count; aux++) {
            this.data[aux] = this.data[aux + 1];
        }
    }

}

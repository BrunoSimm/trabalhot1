/**
 * The type List array of integers.
 */
public class ListArrayOfIntegers implements ListOfIntegers<ListArrayOfIntegers> {
    private int count;
    private int[] elements;
    static final int DEFAULT_SIZE = 10;

    /**
     * Instancia uma nova lista.
     *
     * @param size o tamanho inicial da nova lista.
     */
    public ListArrayOfIntegers(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        elements = new int[size];
        count = 0;
    }

    /**
     * Instancia uma nova lista com o tamanho padrão.
     */
    public ListArrayOfIntegers() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adiciona um elemento no final lista
     *
     * @param element elemento a ser adicionado
     *                Complexidade: O(n) (Quando for necessário modificar a capacidade da lista)
     */
    @Override
    public void add(int element) {
        if (elements.length == count) {
            setCapacity(elements.length * 2);
        }
        elements[count] = element;
        count++;
    }

    /**
     * Adiciona um elemento na lista na posição indicada por index
     *
     * @param index   posição
     * @param element elemento
     *                Complexidade: O(2n) (Quando for necessário modificar a capacidade da lista)
     */
    @Override
    public void add(int index, int element) {
        rangeCheck(index);
        if (elements.length < count + 1) {
            setCapacity(elements.length * 2);
        }
        int oldValue = elements[index];
        elements[index] = element;
        count++;
        for (int i = index + 1; i < count; i++) {
            int aux = elements[i];
            elements[i] = oldValue;
            oldValue = aux;
        }
    }

    /**
     * Retorna o elemento da posição indicada por index
     *
     * @param index index
     * @return valor do elemento da posição index
     * Complexidade: O(1)
     */
    @Override
    public int get(int index) {
        this.rangeCheck(index);
        return elements[index];
    }

    /**
     * Substitui o valor na posição index pelo elemento passado por parâmetro
     *
     * @param index   index
     * @param element element
     * @return retorna o valor antigo
     * Complexidade: O(1)
     */
    @Override
    public int set(int index, int element) {
        this.rangeCheck(index);
        int oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * Remove a primeira ocorrência do elemento passado por parâmetro
     *
     * @param element element
     * @return true se conseguiu remover e falso caso contrário
     * Complexidade: O(n)
     */
    @Override
    public boolean remove(int element) {
        for (int i = 0; i < count; i++) {
            if (element == elements[i]) {
                for (int j = i; j < count - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Remove todas as ocorrências do elemento passado por parâmetro
     *
     * @param element elemento a ser removido
     * @return true se conseguiu remover e falso caso contrário
     */
    @Override
    public boolean removeAll(int element) {
        boolean removed = false;
        for (int i = 0; i < count; i++) {
            if (element == elements[i]) {
                for (int j = i; j < count; j++) {
                    elements[j] = elements[j + 1];
                }
                count--;
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Remove o elemento indicado por index e retorna este valor
     *
     * @param index index
     * @return valor do elemento removido
     * Complexidade: O(n)
     */
    @Override
    public int removeByIndex(int index) {
        rangeCheck(index);
        int aux = elements[index];
        if (index == (count - 1)) {
            elements[index] = 0;
        } else {
            for (int i = index; i < (count - 1); i++) {
                elements[i] = elements[i + 1];
            }
        }
        count--;
        return aux;
    }

    /**
     * Verifica se a lista está vazia
     *
     * @return true se a lista está vazia e false caso contrário
     * Complexidade: O(1)
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Gets size.
     *
     * @return the size
     * Complexidade: O(1)
     */
    @Override
    public int getSize() {
        return count;
    }

    /**
     * Verifica se o elemento está contido na lista
     *
     * @param element o elemento a ser buscado
     * @return true se o elemento está na lista e false caso contrário
     * Complexidade: O(n)
     */
    @Override
    public boolean contains(int element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) return true;
        }
        return false;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento
     *
     * @param element o elemento a ser buscado
     * @return a posição da primeira ocorrência do elemento
     * Complexidade: O(n)
     */
    @Override
    public int indexOf(int element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) return i;
        }
        return -1;
    }

    /**
     * Limpa a lista.
     * Complexidade: O(1)
     */
    @Override
    public void clear() {
        elements = new int[DEFAULT_SIZE];
        count = 0;
    }

    /**
     * Ordena a lista do maior para o menor elemento.
     * Complexidade: O(n²)
     */
    @Override
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            int biggestElementIndex = i; // Posição do maior elemento da iteração atual
            for (int j = i + 1; j < count; j++) { // Busca pelo maior elemento da lista apartir de [i]
                if (elements[j] > elements[biggestElementIndex]) {
                    biggestElementIndex = j;
                }
            }
            // Troca o elemento atual [i] com o maior elemento da lista [biggestElementIndex].
            int biggestElementValue = elements[biggestElementIndex];
            elements[biggestElementIndex] = elements[i];
            elements[i] = biggestElementValue;
        }
    }

    /**
     * Inverte a ordem da lista.
     * Complexidade: O(n/2)
     */
    @Override
    public void reverse() {
        if (count > 0) {
            for (int i = 0; i < count / 2; i++) {
                int auxEnd = elements[(count - 1) - i];
                elements[(count - 1) - i] = elements[i];
                elements[i] = auxEnd;
            }
        }
    }

    /**
     * Retorna um ListArrayOfIntegers apenas com os itens entre start(inclusive) e end(exclusive)
     *
     * @param start inicio
     * @param end   fim
     * @return nova lista
     */
    @Override
    public ListArrayOfIntegers getSubset(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("End index must be greater than Start");
        }
        rangeCheck(start);
        rangeCheck(end);
        ListArrayOfIntegers newList = new ListArrayOfIntegers((end - start) + 1);
        for (int i = start; i < end; i++) {
            newList.add(elements[i]);
        }
        return newList;
    }

    /**
     * Altera o tamanho da lista.
     * Complexidade: O(n)
     */
    private void setCapacity(int newSize) {
        if (newSize != elements.length) {
            int min;
            int[] newElements = new int[newSize];
            if (elements.length < newSize) {
                min = elements.length;
            } else {
                min = newSize;
                count = newSize;
            }
            for (int i = 0; i < min; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }


    /**
     * Verifica se o index é valido para o estado atual da lista.
     *
     * @throws IndexOutOfBoundsException se o index for inválido.
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index = " + index);
        }
    }
}

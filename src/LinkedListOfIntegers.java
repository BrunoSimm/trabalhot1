public class LinkedListOfIntegers implements ListOfIntegers<LinkedListOfIntegers> {

    //Primeiro elemento da lista.
    private Node head;
    // último elemento da lista.
    private Node tail;
    // Quantidade de elementos da lista.
    private int count;

    public LinkedListOfIntegers() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void add(int element) {
        Node newElement = new Node(element);
        if (head == null) {
            head = newElement;
        } else {
            tail.next = newElement;
        }
        tail = newElement;
        count++;
    }

    @Override
    public void add(int index, int element) {
        this.rangeCheck(index);
        Node newNode = new Node(element);

        if (count > 0 && index == count) { //Adicionar no final da lista
            tail.next = newNode;
            tail = newNode;
        } else if (index == 0) { //Adicionar no inicio da lista
            if (count == 0) {
                tail = newNode;
            } else {
                newNode.next = head;
            }
            head = newNode;
        } else { // Adicionar no "meio" da lista
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        // Incrementa o count
        count++;
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int set(int index, int element) {
        this.rangeCheck(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        int aux = current.element;
        current.element = element;
        return aux;
    }

    @Override
    public boolean remove(int element) {
        if (count == 0) return false;
        // Se remocao do primeiro
        if (element == head.element) {
            if (count == 1) { // se tem apenas 1 elemento na lista
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }
        Node current = head.next;
        Node previous = head;
        for (int i = 1; i < count; i++) {
            if (current.element == element) {
                if (current == tail) { // se remocao do ultimo
                    tail = previous;
                    tail.next = null;
                } else { // se remocao do meio
                    previous.next = current.next;
                }
                count--;
                return true;
            }
            previous = previous.next;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean removeAll(int element) {
        boolean removed = false;

        if (count == 0) return removed;

        Node current = head.next;
        Node previous = head;
        for (int i = 0; i < count; i++) {
            if (current.element == element) {
                if (current == tail) { // se remocao do ultimo
                    tail = previous;
                } else { // se remocao do meio
                    previous.next = current.next;
                }
                count--;
                removed = true;
            }
            previous = previous.next;
            current = current.next;
        }
        return removed;
    }

    @Override
    public int removeByIndex(int index) {
        this.rangeCheck(index);
        if (index == 0) { //Remover primeiro elemento
            int element = head.element;
            head = head.next;
            if (count == 1) {
                tail = null;
            }
            count--;
            return element;
        }

        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        int elementRemoved = previous.next.element;
        if (index == count - 1) { //Remover ultimo elemento.
            tail = previous;
            tail.next = null;
        } else { //Remover no "meio".
            previous.next = previous.next.next;
        }
        count--;
        return elementRemoved;
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
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.element == element) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(int element) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.element == element) return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void reverse() {
        if (count > 1) {
            Node headAux = head;
            Node tailAux = tail;
            for (int i = 0; i < count / 2; i++) {
                int aux = headAux.element;
                headAux.element = tailAux.element;
                tailAux.element = aux;
                headAux = headAux.next;
                tailAux = tailAux.next;
            }
        }
    }

    @Override
    public LinkedListOfIntegers getSubset(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("End index must be greater than Start");
        }
        rangeCheck(start);
        rangeCheck(end);
        LinkedListOfIntegers newList = new LinkedListOfIntegers();
        Node current = head;
        for (int i = 0; i < end; i++) {
            if (i >= start) {
                newList.add(current.element);
            }
            current = current.next;
        }
        return newList;
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

    private class Node {
        public int element;
        public Node next;

        public Node(int element) {
            this(element, null);
        }

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}

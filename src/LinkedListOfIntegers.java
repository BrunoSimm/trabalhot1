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

        if (head.element == element) { // se remocao do primeiro
            if (count == 1) { // se tem apenas 1 elemento na lista
                tail = null;
            }
            head = head.next;
            count--;
        }

        Node current = head.next;
        Node previous = head;
        while (current != null) {
            if (current.element == element) {
                if (current == tail) { // Se remocao do ultimo
                    tail = previous; // Atualiza a tail para o elemento anterior.
                    tail.next = null;
                } else { // Se remocao do meio
                    previous.next = current.next; // Remove o ponteiro de current, removendo-o.
                }
                count--;
                removed = true;
            }
            previous = current;
            current = current.next;
        }
        return removed; // Retorna true se pelo menos um elemento foi removido.
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
        return -1; // Retorna -1 caso não encontre o elemento.
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void sort() {
        if (count <= 1) {// Lista vazia ou 1 elemento não é necessário ordenar.
            return;
        }

        Node current = head;
        while (current != null) {
            Node maxNode = current;
            Node nextNode = current.next;

            while (nextNode != null) { // Procura pelo maior elemento dentro da lista
                if (nextNode.element > maxNode.element) {
                    maxNode = nextNode;
                }
                nextNode = nextNode.next;
            }

            // Troca os valores do node atual (current) e do maior ('maxNode').
            int temp = current.element;
            current.element = maxNode.element;
            maxNode.element = temp;

            current = current.next;
        }
    }

    @Override
    public void reverse() {
        if (count <= 1) {// Lista vazia ou 1 elemento não é necessário inverter.
            return;
        }

        Node current = head;
        Node previous = null;
        Node nextNodeTemp;

        while (current != null) { //Até chegar ao final da lista
            nextNodeTemp = current.next; // Salva o próximo node.
            current.next = previous; // Inverte o ponteiro next do node atual para o node anterior.
            previous = current;     // Atualiza o node anterior para o node atual.
            current = nextNodeTemp;     // Move para o próximo node.
        }

        // Atualiza head para ser o antigo tail.
        tail = head;
        head = previous; // Head aponta para o último node da lista.
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

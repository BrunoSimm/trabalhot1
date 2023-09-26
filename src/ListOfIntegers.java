/**
 * Contrato comum entre as listas com
 * os metodos fundamentais de uma lista
 *
 * @author Bruno Simm
 * @author Joao Gabriel Bergamaschi
 */
public interface ListOfIntegers {

    /**
     * Metodo que adiciona um elemento no final da
     * lista
     *
     * @param element elemento que sera adicionado
     *                ao final da lista
     */
    void add(int element);

    /**
     * Metodo que adiciona um elemento na lista na
     * posição indicada pelo indice
     *
     * @param index   indice da lista
     * @param element elemento que sera adicionado
     */
    void add(int index, int element);

    /**
     * Metodo responsavel por retornar o elemento da
     * posição indicada pelo indice
     *
     * @param index indice da lista
     * @return o elemento da posição indicada por
     * indice
     */
    int get(int index);

    /**
     * Metodo que substitui o valor na posicao indice
     * pelo elemento passado por parametro e retorna
     * o valor antigo
     *
     * @param index   indice da lista
     * @param element elemento que sera adicionado
     * @return valor antigo
     */
    int set(int index, int element);

    /**
     * Metodo que remove a primeira ocorrencia do
     * elemento passado por parametro
     *
     * @param element elemento que sera removido
     * @return true se conseguiu remover e falso
     * caso contrário
     */
    boolean remove(int element);

    /**
     * Metodo que remove todas as ocorrencia do
     * elemento passado por parametro
     *
     * @param element elemento que sera removido
     * @return true se conseguiu remover e falso
     * caso contrario
     */
    boolean removeAll(int element);

    /**
     * Metodo que remove o elemento indicado por
     * index
     *
     * @param index indice da lista
     * @return o valor do elemento que sera
     * retirado
     */
    int removeByIndex(int index);

    /**
     * Metodo que verifica se a lista esta vazia
     *
     * @return true se a lista esta vazia e false
     * caso contrario
     */
    boolean isEmpty();

    /**
     * Metodo para obter o tamanho da lista
     *
     * @return quantidade de itens da lista
     */
    int getSize();

    /**
     * Metodo que verifica se o elemento esta
     * contido na lista
     *
     * @param element elemento a ser verificado
     * @return true se o elemento esta na lista e
     * false caso contrario
     */
    boolean contains(int element);

    /**
     * Metodo que busca o primeiro indice da lista
     * que contem o elemento
     *
     * @param element elemento que sera buscado
     * @return o indice da primeira ocorrencia do elemento
     * ou -1 caso o elemento não seja encontrado
     */
    int indexOf(int element);

    /**
     * Metodo que limpa a lista
     */
    void clear();

    /**
     * Metodo que ordena a lista do maior para o menor elemento
     */
    void sort();

    /**
     * Metodo que inverte a ordem da lista.
     * Por exemplo: 2,3,4,1 (antes) -> 1,4,3,2 (depois)
     */
    void reverse();

    /**
     * Metodo que cria um subconjunto com apenas com os itens
     * entre start e end
     *
     * @param start indice que comeca o subconjunto (inclusido)
     * @param end   indice que termina o subconjunto (exclusivo)
     * @return subconjunto da lista
     */
    ListOfIntegers getSubset(int start, int end);

    /**
     * Metodo com implementacao padrao da interface,
     * responsavel por verificar se o indice esta
     * dentro do intervalo entre 0 e o tamanho atual
     * do arranjo
     *
     * @param index indice da lista
     * @param count tamanho atual da lista
     * @throws ArrayIndexOutOfBoundsException quando
     *                                        o indice for menor que 0 ou maior do que o
     *                                        tamanho da lista
     */
    default void rangeCheck(int index, int count) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format(
                            "Index (%d) passed is out of the accepted range (Index >= 0 and Index < %d).",
                            index, count
                    )
            );
        }
    }

    /**
     * Metodo com implementacao padrao da interface,
     * responsavel por verificar se o start e end estao
     * dentro do intervalo entre 0 e o tamanho atual
     * do arranjo
     *
     * @param start indice do inicio da sublista
     * @param end indice do fim da sublista
     * @param count tamanho atual da lista
     * @throws IllegalArgumentException quando o valor de end é menor ou igual ao start
     * @throws ArrayIndexOutOfBoundsException quando o indice for menor que 0 ou maior
     *                                        do que o tamanho da lista
     */
    default void rangeCheck(int start, int end, int count) {
        if (start >= end) {
            throw new IllegalArgumentException(
                    String.format("End (%d) index must be greater than Start", end)
            );
        }

        if (start < 0 || end > count) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "Start (%d) must be greater than 0 or End (%d) must be minor than the list's Count (%d)",
                            start, end, count
                    )
            );
        }
    }

}

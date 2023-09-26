public class MainLinked {
    public static void main(String[] args) {
        ListOfIntegers<LinkedListOfIntegers> array = new LinkedListOfIntegers();
        array.add(12);
        array.add(15);
        array.add(11);
        array.add(13);
//        array.add(14);
//        array.add(11);
//        array.add(13);
//        array.add(18);
//        array.add(1, 30);
//        array.removeAll(0);
//        array.removeByIndex(0);
//        array.add(25);
//        LinkedListOfIntegers newArray = array.getSubset(0, 2);
        array.reverse();
//        array.sort();
        System.out.println(array);

    }
}
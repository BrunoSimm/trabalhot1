public class MainArray {
    public static void main(String[] args) {
        ListOfIntegers<ListArrayOfIntegers> array = new ListArrayOfIntegers(5);
        array.add(12);
        array.add(15);
        array.add(13);
//        array.add(14);
//        array.add(11);
//        array.add(13);
//        array.add(18);
//        array.add(1, 30);
//        array.removeAll(0);
//        array.removeByIndex(0);
//        array.add(25);
        ListArrayOfIntegers newArray = array.getSubset(0, 2);
//        array.reverse();
        array.sort();
        System.out.println(array);

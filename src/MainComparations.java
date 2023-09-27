import java.util.Random;

public class MainComparations {

    private static final Random random = new Random();

    public static ListOfIntegers<LinkedListOfIntegers> getLinkedMock() {
        ListOfIntegers<LinkedListOfIntegers> linkedArray = new LinkedListOfIntegers();
        for (int i = 0; i < 5000; i++) {
            linkedArray.add(random.nextInt(10000));
        }
        return linkedArray;
    }

    public static ListOfIntegers<ListArrayOfIntegers> getArrayMock() {
        ListOfIntegers<ListArrayOfIntegers> arrayStatic = new ListArrayOfIntegers();
        for (int i = 0; i < 5000; i++) {
            arrayStatic.add(random.nextInt(10000));
        }
        return arrayStatic;
    }

    public static void main(String[] args) {
        addTest();
        addIndexTest(getLinkedMock(), getArrayMock());
        getTest(getLinkedMock(), getArrayMock());
        setTest(getLinkedMock(), getArrayMock());
        removeTest(getLinkedMock(), getArrayMock());
        removeAllTest(getLinkedMock(), getArrayMock());
        removeByIndexTest(getLinkedMock(), getArrayMock());
        isEmptyTest(getLinkedMock(), getArrayMock());
        getSizeTest(getLinkedMock(), getArrayMock());
        containsTest(getLinkedMock(), getArrayMock());
        indexOfTest(getLinkedMock(), getArrayMock());
        clearTest(getLinkedMock(), getArrayMock());
        sortTest(getLinkedMock(), getArrayMock());
        reverseTest(getLinkedMock(), getArrayMock());
        getSubSetTest(getLinkedMock(), getArrayMock());
    }

    public static void getSubSetTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.getSubset(0, 4999);
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.getSubset(0, 4999);
        long endTimeB = System.nanoTime();

        System.out.println("GET SUBSET TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void reverseTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.reverse();
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.reverse();
        long endTimeB = System.nanoTime();

        System.out.println("REVERSE TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void sortTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.sort();
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.sort();
        long endTimeB = System.nanoTime();

        System.out.println("SORT TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void clearTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.clear();
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.clear();
        long endTimeB = System.nanoTime();

        System.out.println("CLEAR TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void indexOfTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        linkedArray.set(4500, 200);
        long startTimeA = System.nanoTime();
        linkedArray.indexOf(200);
        long endTimeA = System.nanoTime();

        arrayStatic.set(4500, 200);
        long startTimeB = System.nanoTime();
        arrayStatic.indexOf(200);
        long endTimeB = System.nanoTime();

        System.out.println("INDEX OF TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void containsTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        linkedArray.set(4500, 200);
        long startTimeA = System.nanoTime();
        linkedArray.contains(200);
        long endTimeA = System.nanoTime();

        arrayStatic.set(4500, 200);
        long startTimeB = System.nanoTime();
        arrayStatic.contains(200);
        long endTimeB = System.nanoTime();

        System.out.println("CONTAINS TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void getSizeTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.getSize();
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.getSize();
        long endTimeB = System.nanoTime();

        System.out.println("Get Size TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void isEmptyTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.isEmpty();
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.isEmpty();
        long endTimeB = System.nanoTime();

        System.out.println("IS EMPTY TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void removeByIndexTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.removeByIndex(4500);
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.removeByIndex(4500);
        long endTimeB = System.nanoTime();

        System.out.println("REMOVE BY INDEX TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void removeAllTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        linkedArray.set(4500, 200);
        linkedArray.set(2150, 200);
        long startTimeA = System.nanoTime();
        linkedArray.removeAll(200);
        long endTimeA = System.nanoTime();

        arrayStatic.set(4500, 200);
        arrayStatic.set(2150, 200);
        long startTimeB = System.nanoTime();
        arrayStatic.removeAll(200);
        long endTimeB = System.nanoTime();

        System.out.println("REMOVE ALL TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void removeTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        linkedArray.set(4500, 200);
        long startTimeA = System.nanoTime();
        linkedArray.remove(200);
        long endTimeA = System.nanoTime();

        arrayStatic.set(4500, 200);
        long startTimeB = System.nanoTime();
        arrayStatic.remove(200);
        long endTimeB = System.nanoTime();

        System.out.println("REMOVE TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void setTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.set(4500, 200);
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.set(4500, 200);
        long endTimeB = System.nanoTime();

        System.out.println("SET TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void getTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.get(4500);
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.get(4500);
        long endTimeB = System.nanoTime();

        System.out.println("GET TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void addIndexTest(ListOfIntegers<LinkedListOfIntegers> linkedArray, ListOfIntegers<ListArrayOfIntegers> arrayStatic) {
        long startTimeA = System.nanoTime();
        linkedArray.add(4500, 1);
        long endTimeA = System.nanoTime();

        long startTimeB = System.nanoTime();
        arrayStatic.add(4500, 1);
        long endTimeB = System.nanoTime();

        System.out.println("ADD INDEX TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }

    public static void addTest() {
        // LINKED LIST
        ListOfIntegers<LinkedListOfIntegers> linkedArray = new LinkedListOfIntegers();
        long startTimeA = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            linkedArray.add(random.nextInt(10000));
        }
        long endTimeA = System.nanoTime();

        // LIST ARRAY
        long startTimeB = System.nanoTime();
        ListOfIntegers<ListArrayOfIntegers> arrayStatic = new ListArrayOfIntegers();
        for (int i = 0; i < 5000; i++) {
            arrayStatic.add(random.nextInt(10000));
        }
        long endTimeB = System.nanoTime();

        System.out.println("ADD TEST:");
        System.out.println("\tLINKED LIST -> " + getElapsedTimeInMicroseconds(endTimeA, startTimeA));
        System.out.println("\tLIST ARRAY -> " + getElapsedTimeInMicroseconds(endTimeB, startTimeB));
        System.out.println("-------------------");
    }


    public static long getElapsedTimeInMicroseconds(long endTime, long startTime) {
        return (endTime - startTime) / 1000;
    }
}
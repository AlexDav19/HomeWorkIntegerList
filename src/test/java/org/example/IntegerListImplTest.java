package org.example;

import org.example.exceptions.ValidationIndexException;
import org.example.exceptions.ValidationItemNullException;
import org.example.exceptions.ValidationSizeException;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
class IntegerListImplTest {

    final int LENGTH = 100_000;
    final IntegerListImpl CORRECTED_LIST = new IntegerListImpl(LENGTH);
    final IntegerListImpl OTHER_LIST = new IntegerListImpl(LENGTH);
    final IntegerListImpl NULL_LIST = new IntegerListImpl(0);
    final Integer CORRECTED_STRING = 2;
    final Integer NULL_STRING = null;
    final int CORRECTED_INDEX = 2;


    @Test
    void addTest_success() {
        Integer actualString = CORRECTED_LIST.add(CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        Integer[] expectedList = new Integer[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void addTest_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.add(CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.add(NULL_STRING));
    }

    @Test
    void addTest_withIndex_success() {
        Integer actualString = CORRECTED_LIST.add(CORRECTED_INDEX, CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        Integer[] expectedList = new Integer[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void addTest_withIndex_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.add(CORRECTED_INDEX, CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.add(CORRECTED_INDEX, NULL_STRING));
    }

    @Test
    void set_success() {
        Integer actualString = CORRECTED_LIST.set(CORRECTED_INDEX, CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        Integer[] expectedList = new Integer[LENGTH];
        expectedList[0] = CORRECTED_STRING;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void set_Exception() {
        assertThrows(ValidationSizeException.class, () -> NULL_LIST.set(CORRECTED_INDEX, CORRECTED_STRING));
        assertThrows(ValidationItemNullException.class, () -> CORRECTED_LIST.set(CORRECTED_INDEX, NULL_STRING));

    }

    @Test
    void remove_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add(3);

        Integer actualString = CORRECTED_LIST.remove(CORRECTED_STRING);
        assertEquals(CORRECTED_STRING, actualString);

        Integer[] expectedList = new Integer[LENGTH];
        expectedList[0] = 1;
        expectedList[1] = 3;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);

    }

    @Test
    void remove_Exception() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertThrows(ValidationItemNullException.class, () -> NULL_LIST.remove(CORRECTED_STRING));
    }

    @Test
    void remove_withIndex_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add(3);

        Integer actualString = CORRECTED_LIST.remove(1);
        assertEquals(CORRECTED_STRING, actualString);

        Integer[] expectedList = new Integer[LENGTH];
        expectedList[0] = 1;
        expectedList[1] = 3;
        assertArrayEquals(expectedList, CORRECTED_LIST.arr);
    }

    @Test
    void remove_withIndex_Exception() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertThrows(ValidationIndexException.class, () -> NULL_LIST.remove(4));
    }

    @Test
    void contains_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertTrue(() -> CORRECTED_LIST.contains(3));
        assertFalse(() -> CORRECTED_LIST.contains(4));
    }

    @Test
    void containsSort_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertTrue(() -> CORRECTED_LIST.containsSort(CORRECTED_LIST.arr, 3));
        assertFalse(() -> CORRECTED_LIST.containsSort(CORRECTED_LIST.arr, 4));
    }

    @Test
    void indexOf_found() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        int expectedIndex = 2;
        int actualIndex = CORRECTED_LIST.indexOf(3);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void indexOf_notFound() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        int expectedIndex = -1;
        int actualIndex = CORRECTED_LIST.indexOf(4);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_found() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        int expectedIndex = 2;
        int actualIndex = CORRECTED_LIST.lastIndexOf(3);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void lastIndexOf_notFound() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        int expectedIndex = -1;
        int actualIndex = CORRECTED_LIST.lastIndexOf(4);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void get_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add(3);

        Integer actualString = CORRECTED_LIST.get(1);
        assertEquals(CORRECTED_STRING, actualString);
    }

    @Test
    void get_Exception() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(CORRECTED_STRING);
        CORRECTED_LIST.add(3);

        assertThrows(ValidationIndexException.class, () -> CORRECTED_LIST.get(4));
    }

    @Test
    void testEquals_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);
        OTHER_LIST.add(1);
        OTHER_LIST.add(2);
        OTHER_LIST.add(3);

        assertTrue(CORRECTED_LIST.equals(OTHER_LIST));

    }
    @Test
    void testEquals_false() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);
        OTHER_LIST.add(1);
        OTHER_LIST.add(2);
        OTHER_LIST.add(4);

        assertFalse(CORRECTED_LIST.equals(OTHER_LIST));

    }

    @Test
    void size_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertEquals(3,CORRECTED_LIST.size());
    }

    @Test
    void isEmpty_false() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        assertFalse(CORRECTED_LIST.isEmpty());
    }
    @Test
    void isEmpty_true() {
        assertTrue(CORRECTED_LIST.isEmpty());
    }


    @Test
    void clear_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        IntegerListImpl NULL_LIST = new IntegerListImpl(LENGTH);
        CORRECTED_LIST.clear();
        assertArrayEquals(NULL_LIST.arr, CORRECTED_LIST.arr);
    }

    @Test
    void toArray_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);

        final IntegerListImpl NEW_LIST = new IntegerListImpl(3);
        NEW_LIST.add(1);
        NEW_LIST.add(2);
        NEW_LIST.add(3);

        assertArrayEquals(NEW_LIST.arr, CORRECTED_LIST.toArray());
    }

    @Test
    void addNewPlace_success() {
        CORRECTED_LIST.add(1);
        CORRECTED_LIST.add(2);
        CORRECTED_LIST.add(3);
        final IntegerListImpl NEW_LIST;
        Integer[] expectedArr = {1, 2, 3, null, null, null, null, null, null, null};
        NEW_LIST = CORRECTED_LIST.addNewPlace(10);
        assertArrayEquals(expectedArr, NEW_LIST.arr);
    }

    @Test
    void sortBubbleTest() {
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            CORRECTED_LIST.add(random.nextInt(100));
        }
        System.out.println("Bubble sort: ");
        long start = System.currentTimeMillis();
        CORRECTED_LIST.sortBubble(CORRECTED_LIST.arr);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void sortSelectionTest() {

        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            CORRECTED_LIST.add(random.nextInt(100));
        }
        System.out.println("Selection sort: ");
        long start = System.currentTimeMillis();
        CORRECTED_LIST.sortSelectionTest(CORRECTED_LIST.arr);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void sortInsertion() {
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            CORRECTED_LIST.add(random.nextInt(100));
        }
        System.out.println("Insertion sort: ");
        long start = System.currentTimeMillis();
        CORRECTED_LIST.sortInsertion(CORRECTED_LIST.arr);
        System.out.println(System.currentTimeMillis() - start);
    }
}
package org.example;

import org.example.exceptions.ValidationIndexException;
import org.example.exceptions.ValidationItemNullException;

import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    Integer[] arr;
    private int size = 0;

    IntegerListImpl(int length) {
        arr = new Integer[length];
    }

    @Override
    public Integer add(Integer item) {
        if (validationSize()) {
            grow();
        }
        validationItemNull(item);
        arr[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (validationSize()) {
            grow();
        }
        validationItemNull(item);
        if (index >= size) {
            arr[size] = item;
        } else {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = item;
        }
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (validationSize()) {
            grow();
        }
        validationItemNull(item);
        if (index >= size) {
            arr[size] = item;
        } else {
            arr[index] = item;
        }
        size++;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                for (int j = i; j < size - i; j++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                arr[size] = null;
                return item;
            }
        }
        throw new ValidationItemNullException();
    }

    @Override
    public Integer remove(int index) {
        validationIndex(index);
        Integer unit = arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        arr[size] = null;
        return unit;

    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSort(Integer[] arr, Integer item) {
        sortSelection(arr);
        int min = 0;
        int max = size;
        while (min < max) {
            int mid = (min + max) / 2;

            if (Objects.equals(item, arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validationIndex(index);
        return arr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList.isEmpty()) {
            throw new RuntimeException();
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(arr[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newList = new Integer[size];
        System.arraycopy(arr, 0, newList, 0, size);
        return newList;
    }

    //Увеличить количество ячеек
    public IntegerListImpl grow() {
        IntegerListImpl newArr = new IntegerListImpl((int) (arr.length * 1.5));
        System.arraycopy(arr, 0, newArr.arr, 0, arr.length);

        return newArr;
    }

    public boolean validationSize() {
        return size >= arr.length;
        //throw new ValidationSizeException("В массиве больше нет места");
    }

    public void validationIndex(int index) {
        if (index >= size) {
            throw new ValidationIndexException("Элемента с таким индексом нет");
        }
    }

    public void validationItemNull(Integer item) {
        if (item == null) {
            throw new ValidationItemNullException("Не передано значение");
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public void sortBubble(Integer[] arr) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public void sortSelectionTest(Integer[] arr) {
        sortSelection(arr);
    }

    private void sortSelection(Integer[] arr) {

        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}

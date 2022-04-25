package java;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList implements List {

    private final int ELEMENT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public void myArrayList() {
        this.elementData = new Object[ELEMENT_CAPACITY];
        this.size = 0;
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
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public void clear() {
        this.elementData = new Integer[ELEMENT_CAPACITY];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public boolean add(Object o) {
        if(elementData.length == size){
            elementData = Arrays.copyOf(elementData,elementData.length * 2);
            elementData[elementData.length - 1] = o;
            size++;
            return true;
        } else if(elementData.length > size){
            elementData[size] = o;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
        if(index <= size) {
            Object[] newArr = new Object[elementData.length + 1];
            System.arraycopy(elementData, 0, newArr, 0, index);
            newArr[index] = element;
            System.arraycopy(elementData, index, newArr, index + 1, elementData.length - index);
            elementData = newArr;
        }
    }

    @Override
    public Object remove(int index) {
        if(index <= size ){
            Object[] newArr = new Object[elementData.length == 0 ? elementData.length : elementData.length - 1];
            System.arraycopy(elementData, 0,newArr,0,index);
            System.arraycopy(elementData, index + 1, newArr, index,elementData.length - index - 1);
            elementData = newArr;
            return true;
        } else {
            return false;
        }

    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return List.super.removeIf(filter);
    }


    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }


    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream stream() {
        return List.super.stream();
    }

    @Override
    public Stream parallelStream() {
        return List.super.parallelStream();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
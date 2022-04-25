package java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List {

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o, null);
        if (head == null) {
            head = tail = node;
        } else {
            Node tailNode = tail;
            node.setPrevious(tailNode);
            tailNode.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        Node newElementNode = new Node(element);
        Node headNode = head;
        if (index == 0) {
            head = newElementNode;
            newElementNode.setNext(headNode);
            headNode.setPrevious(newElementNode);
        } else {
            for (int i = 1; i <= index; i++) {
                if (i == index) {
                    assert headNode != null;
                    assert headNode.getNext() != null;
                    headNode.getNext().setNext(newElementNode);
                    newElementNode.setPrevious(headNode);
                    headNode.getNext().setPrevious(newElementNode);
                    headNode.setNext(newElementNode);
                    if(headNode.getNext() == null){
                        tail = newElementNode;
                    }
                } else {
                    assert headNode != null;
                    headNode = headNode.getNext();
                }
            }
        }
        size++;
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
    public Object[] toArray() {
        Object[] array = new Object[size];
        if (size != 0) {
            Node node = head;
            for (int i = 0; i < size; i++) {
                array[i] = node.getValue();
                node = node.getNext();
            }
        }
        return array;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        E getValue = null;

        if(size / 2 > index){
            Node node = head;
            for (int i = 0; i <= index; i++) {
                if (i != index) {
                    node = node.getNext();
                } else {
                    getValue = (E) node.getValue();
                }
            }
        } else {
            Node node = tail;
            for (int i = size - 1; i >= index; i--) {
                if (i != index) {
                    node = node.getPrevious();
                } else {
                    getValue = (E) node.getValue();
                }
            }
        }
        return getValue;
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        Node headNode = head;
        Node tailNode = tail;
        E oldElement = (E) this.get(index);
        if(size / 2 > index){
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    headNode.setValue(element);
                } else {
                    headNode = headNode.getNext();
                }
            }
        } else {
            for (int i = size - 1; i <= index; i++) {
                if (i == index) {
                    tailNode.setValue(element);
                } else {
                    tailNode = tailNode.getPrevious();
                }
            }
        }
        return oldElement;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);

        Node tailNode = tail;
        Node headNode = head;

        Object getValue = this.get(index);

        if (index == 0) {
            head = headNode.getNext();
            headNode.setPrevious(null);
        } else if(index == size - 1){
            tail = tailNode.getPrevious();
            tailNode.getPrevious().setNext(null);
        } else {
            if(size / 2 > index){
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        deleteNode(headNode);
                    }
                    headNode = headNode.getNext();
                }
            } else {
                for (int i = size - 1; i >= index; i--) {
                    if (i == index) {
                        deleteNode(tailNode);
                    }
                    tailNode = tailNode.getPrevious();
                }
            }
        }
        size--;
        return getValue;
    }

    @Override
    public boolean remove(Object o) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.getValue() == o) {
                this.remove(i);
                return true;
            } else {
                node = node.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.getValue() == o) {
                return true;
            } else {
                node = node.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
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

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index should be greater than -1 and less than %s", size));
        }
    }

    private void deleteNode(Node node){
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }

    private static class Node<E> {
        private E value;
        private Node next;
        private Node previous;

        public Node getPrevious() {
            return previous;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }
        public Node(E value) {
            this.value = value;
        }
        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

}

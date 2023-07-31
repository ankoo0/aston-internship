import java.util.Collection;
import java.util.Comparator;

public class CustomList<E> {

    private static final int INITIAL_SIZE = 10;
    private int pointer = 0;
    private Object[] elements;

    public CustomList() {
        this.elements = new Object[INITIAL_SIZE];
    }


    public CustomList(int capacity) {
        this.elements = new Object[capacity];
    }


    public void addAll(Collection<? extends E> c) {
        checkCapacity(c.size());
        Object[] arr = c.toArray();
        for (int i = 0; i <c.size() ; i++) {
            this.add((E) arr[i]);
        }
    }


    public void add(E element) {
        checkCapacity(1);
        elements[pointer] = element;
        pointer++;
    }


    public void add(int index, E element) {
        checkCapacity(1);
        Object[] newArr = new Object[elements.length];
        System.arraycopy(elements, 0, newArr, 0, index);
        newArr[index] = element;
        System.arraycopy(elements, index, newArr, index + 1, elements.length - (index + 1));
        this.elements = newArr;
        pointer++;
    }


    public void clear() {
        this.pointer = 0;
        this.elements = new Object[]{};
    }


    public boolean remove(int index){
        if (checkRange(index)) {
            return shift(index);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size());
        }
    }


    public boolean remove(E element){
        for (int i=0;i<elements.length; i++){
            if (elements[i].equals(element)){
                return shift(i);
            }
        }
        return false;
    }


    private boolean shift(int i) {
        Object[] arr = new Object[elements.length];
        System.arraycopy(elements,0,arr,0,i);
        System.arraycopy(elements,i+1,arr,i,elements.length-i-1);
        elements=arr;
        pointer--;
        return true;
    }


    public E get(int index) {
        if (checkRange(index)) {
            return (E) this.elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size());
        }
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public int size() {
        return pointer;
    }


    private boolean checkRange(int index) {
        return index <= size();
    }


    private void checkCapacity(int additionalLength) {
        if (size() + additionalLength >= elements.length) {
            grow();
        }
    }


    private void grow() {
        Object[] newArr = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArr, 0, pointer+1);
        elements = newArr;
    }


    public void sort(Comparator<? super E> c) {
        quickSort((E[]) this.elements, 0, pointer-1, c);
    }


    private void quickSort(E[] array, int first, int last, Comparator<? super E> comparator) {

        if (first < last) {
            int pivot = partition(array, first, last, comparator);
            quickSort(array, first, pivot - 1, comparator);
            quickSort(array, pivot + 1, last, comparator);
        }


    }


    private int partition(E[] array, int first, int last, Comparator<? super E> comparator) {
        int pivot = last;
        int i = first;
        int j = first;


        while (j < pivot) {
            if (comparator.compare(array[j], array[pivot]) < 0) {
                swap(array, i, j);
                i++;
            }
            j++;
        }

        swap(array, pivot, i);

        return i;
    }


    private void swap(E[] array, int first, int second) {
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (i <= pointer - 1) {
            if (i == pointer - 1) {
                sb.append(elements[i]);
            } else {
                sb.append(elements[i]).append(", ");
            }
            i++;
        }

        sb.append("]");
        return sb.toString();
    }

}




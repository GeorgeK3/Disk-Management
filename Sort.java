import java.util.*;
import java.io.*;

public class Sort<T>{

    private Comparator<T> comparator; 
    
    public Sort(Comparator<T> comparator) {

        this.comparator = comparator;

    }


    public void quickSort(T[] a, int begin, int end) {
        if (begin < end) {
            int pIndex = partition(a, begin, end);
    
            quickSort(a, begin, pIndex-1);
            quickSort(a, pIndex+1, end);
        }
    }

    private int partition(T a[], int begin, int end) {
        T pivot = a[end];
        int i = begin-1;
    
        for (int j = begin; j < end; j++) {
            if (comparator.compare(a[j],pivot)> 0 || comparator.compare(a[j],pivot)==0) {
                i++;
    
                T exch = a[i];
                a[i] = a[j];
                a[j] = exch;
            }
        }
    
        T exch = a[i+1];
        a[i+1] = a[end];
        a[end] = exch;
    
        return i+1;
    }
}
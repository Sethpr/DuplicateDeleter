package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications){
        T[] array = this.array;
        for (int i = 0; i < array.length; i++) {
            if(getOccurrences(array[i]) >= maxNumberOfDuplications){
                array = removeInstance(array[i], getOccurrences(array[i]), array);
                i--;
            }
        }
        return array;
    }
    public T[] removeDuplicatesExactly(int exactNumberOfDuplications){
        T[] array = this.array;
        for (int i = 0; i < array.length; i++) {
            if(getOccurrences(array[i]) == exactNumberOfDuplications){
                array = removeInstance(array[i], getOccurrences(array[i]), array);
                i--;
            }
        }
        return array;
    }
    public int getOccurrences(T item){
        int count = 0;
        for(T t:array){
            if(t.equals(item)){
                count++;
            }
        }
        return count;
    }

    public T[] removeInstance(T toRemove, int occurrences, T[] array){
        int counter = 0;
        T[] arr = (T[]) Array.newInstance(array[0].getClass(), array.length - occurrences);
        for(T t: array){
            if(!t.equals(toRemove)){
                arr[counter] = t;
                counter++;
            }
        }
        return arr;
    }
}

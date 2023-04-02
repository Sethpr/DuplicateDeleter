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
        for (int i = 0; i < array.length; i++) {
            if(getOccurrences(array[i]) >= maxNumberOfDuplications){
                removeInstance(array[i], getOccurrences(array[i]));
                i--;
            }
        }
        return array;
    }
    public T[] removeDuplicatesExactly(int exactNumberOfDuplications){
        for (int i = 0; i < array.length; i++) {
            if(getOccurrences(array[i]) == exactNumberOfDuplications){
                removeInstance(array[i], getOccurrences(array[i]));
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

    public void removeInstance(T toRemove, int occurrences){
        int counter = 0;
        T[] arr = (T[]) Array.newInstance(array[0].getClass(), array.length - occurrences);
        for(T t: array){
            if(!t.equals(toRemove)){
                arr[counter] = t;
                counter++;
            }
        }
        array = arr;
    }
}

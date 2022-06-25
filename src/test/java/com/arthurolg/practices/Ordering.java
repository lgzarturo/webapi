package com.arthurolg.practices;

import java.util.ArrayList;
import java.util.List;

public class Ordering {
    public static void bubble(int[] data) {
        int aux;
        boolean hasChange;
        do {
            hasChange = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i] < data[i - 1]) {
                    aux = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = aux;
                    hasChange = true;
                }
            }
        } while (hasChange);
    }

    public static void insertion(int[] data) {
        int aux;
        int firstIndex;
        int secondIndex;
        for (firstIndex = 1; firstIndex<data.length; firstIndex++) {
            aux = data[firstIndex];
            for (secondIndex = firstIndex-1; secondIndex >= 0 && data[secondIndex] > aux; secondIndex--) {
                data[secondIndex+1] = data[secondIndex];
                data[secondIndex] = aux;
            }
        }
    }

    public static void quick(int[] data) {
        quickNextIteration(data);
    }

    public static void quickNextIteration(int[] data) {
        quickLastIteration(data, 0, data.length - 1);
    }

    public static void quickLastIteration(int[] data, int left, int right) {
        if (left >= right) return;
        int indexLeft=left, indexRight=right;
        int pivote;
        int aux;
        pivote = left;
        while(left!=right) {
            while (data[right]>=data[pivote]&&left<right)
                right--;
                while (data[left]<data[pivote]&&left<right)
                    left++;
            if (right != left) {
               aux = data[right];
               data[right] = data[left];
               data[left] = aux;
            }
        }
        quickLastIteration(data, indexLeft, left-1);
        quickLastIteration(data, left+1, indexRight);
    }

    public static void print(int[] data) {
        for (int datum : data) {
            System.out.print(datum + ",");
        }
    }

    public static void main(String[] args) {
        int numberOfRandomNumbers = 1000;
        int[] data = new int[numberOfRandomNumbers];
        int[] bubbleData = new int[numberOfRandomNumbers];
        int[] quickData = new int[numberOfRandomNumbers];
        int[] insertionData = new int[numberOfRandomNumbers];
        for (var i = 0; i < numberOfRandomNumbers; i++) {
            var randomNumber = (int) Math.floor((Math.random() * 1000) + 1);
            bubbleData[i] = randomNumber;
            quickData[i] = randomNumber;
            insertionData[i] = randomNumber;
            data[i] = randomNumber;
        }
        print(data);
        long startTime = System.nanoTime();
        bubble(bubbleData);
        //print(bubbleData);
        System.out.println("\n [B] sort takes " + (System.nanoTime() - startTime) + "ns\n => (BubbleSort)");
        startTime = System.nanoTime();
        quick(quickData);
        //print(quickData);
        System.out.println("\n [Q] sort takes " + (System.nanoTime() - startTime) + "ns\n => (QuickSort)");
        startTime = System.nanoTime();
        insertion(insertionData);
        //print(insertionData);
        System.out.println("\n [I] sort takes " + (System.nanoTime() - startTime) + "ns\n => (InsertionSort)");
    }
}

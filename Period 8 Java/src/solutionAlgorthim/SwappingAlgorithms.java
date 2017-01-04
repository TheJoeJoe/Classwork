package solutionAlgorthim;

import java.util.Arrays;

public class SwappingAlgorithms {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToSort = { 133, 0, -5, 31, 12, 12, 2 };
		System.out.println("- - - SELECTION SORT - - -");
		System.out.println(Arrays.toString(arrayToSort));
		selectionSort(copy(arrayToSort));
	}

	public static int[] copy(int[] arr) {
		int[] copy = new int[arr.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int placeHolder = arr[j];
		arr[j] = arr[i];
		arr[i] = placeHolder;
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arrayToSort) {
		int minIndex = 0;
		int minimum = arrayToSort[0];
		for (int i = 0; i < arrayToSort.length; i++) {
			minIndex = i;
			minimum = arrayToSort[i];
			for (int j = i; j < arrayToSort.length; j++) {
				if (arrayToSort[j] < minimum) {
					minimum = arrayToSort[j];
					minIndex = j;
				}
			}
			swap(arrayToSort, i, minIndex);
		}
	}

	public static void bubbleSort(int[] arrayToSort) {
		for (int i = 0; i < arrayToSort.length; i++) {
			if (arrayToSort.length == 0) {
				break;
			}
			if (i < i + 1) {
				swap(arrayToSort, i, i + 1);
			}
		}
		bubbleSort(arrayToSort);
	}

}
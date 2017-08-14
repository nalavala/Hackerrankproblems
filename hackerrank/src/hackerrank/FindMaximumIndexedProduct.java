package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaximumIndexedProduct {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long array[] = new long[n];
		int lefts[] = new int[n];
		int rights[] = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = scan.nextInt();
		System.out.println(Arrays.toString(array));
		int left, right=0;
		long product = Integer.MIN_VALUE;
		long indexProduct;
		for (int i = 0; i < n; i++) {
			left = leftIndex(array, i, lefts);
			if(left!=0)
			right = rightIndex(array, i, rights);
			indexProduct = left * right;
			System.out.print(left + "....." + i + "...." + right + "...." + indexProduct);
			System.out.println();
			product = MAX(indexProduct, product);

		}
		System.out.println(product);
		System.out.println(Arrays.toString(lefts));
		System.out.println(Arrays.toString(rights));
		scan.close();
	}

	private static long MAX(long indexProduct, long product) {
		if (indexProduct > product)
			return indexProduct;
		else
			return product;
	}

	private static int leftIndex(long[] array, int i, int[] lefts) {
		int j = 0;
		long max = array[i];
		/*if (i != 0)
			for (int k = lefts[i - 1]; k >= 0; k--) {
				if (array[k] > max) {
					j = k + 1;
					break;
				}
			}
		else*/
			for (int k = i - 1; k >= 0; k--) {
				if (array[k] > max) {
					j = k + 1;
					break;
				}
			}
		lefts[i] = j;
		return j;
	}

	private static int rightIndex(long[] array, int i, int[] rights) {
		int j = 0;
		long max = array[i];
		/*if (i != 0 && array[i] > array[i - 1])
			for (int k = rights[i - 1]; k < array.length; k++) {
				if (array[k] > max) {
					j = k + 1;
					break;
				}
			}
		else*/
			for (int k = i + 1; k < array.length; k++) {
				if (array[k] > max) {
					j = k + 1;
					break;
				}
			}
		rights[i] = j;
		return j;

	}
}

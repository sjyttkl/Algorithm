package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * 归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，时间复杂度可以记为O(N)，故一共为O(N*
 * logN)。
 * 因为归并排序每次都是在相邻的数据中进行操作，所以归并排序在O(N*logN)的几种排序方法（快速排序，归并排序，希尔排序，堆排序）也是效率比较高的。
 * 
 * @author Administrator
 * 
 */
public class Merge_sort
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] x =
		{ 6, 2, 4, 1, 5, 9 };
		System.out.println("开始之前" + Arrays.toString(x));
		int[] sorted = new int[x.length];
		merge_sort(x, 0, x.length - 1, sorted);

		System.out.println("\n 结束之后" + Arrays.toString(x));

	}

	
	public static void merge_sort(int[] unsorted, int first, int last, int[] sorted)
	{
		if (first + 1 < last)
		{
			int mid = (first + last) / 2;
			System.out.println("{" + first + "}-{" + mid + "}-{" + last + "} ");
			System.out.println("-->>左大部分");
			merge_sort(unsorted, first, mid, sorted);
			System.out.println("-->>右大部分");
			merge_sort(unsorted, mid, last, sorted);
			System.out.println("开始了----->{" + first + "}-{" + mid + "}-{" + last + "} ");
			merge(unsorted, first, mid, last, sorted);
			System.out.println("每次比较的结果：----->" + Arrays.toString(unsorted));
		}
	}

	public static void merge(int[] unsorted, int first, int mid, int last, int[] sorted)
	{
		int i = first, j = mid;
		int k = 0;
		while (i < mid && j < last)
		{
			if (unsorted[i] < unsorted[j])
			{
				sorted[k++] = unsorted[i++];
			} else
			{
				sorted[k++] = unsorted[j++];
			}
		}

		while (i < mid)
		{
			sorted[k++] = unsorted[i++];
		}
		while (j < last)
		{
			sorted[k++] = unsorted[j++];
		}

		for (int v = 0; v < k; v++)
		{
			unsorted[first + v] = sorted[v];
		}
	}

}

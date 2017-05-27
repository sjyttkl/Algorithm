package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * 选择排序法 时间复杂度：O(N^2)
 * 
 * @author Administrator
 * 
 */
public class SelectionSort
{
	public static void main(String[] args)
	{
		int[] x =
		{ 6, 2, 4, 1, 5, 9 };
		System.out.println("开始之前" + Arrays.toString(x));
		selection_sort(x, x.length);
		System.out.println("开始之后" + Arrays.toString(x));
	}

	private static void selection_sort(int[] unsorted, int length)
	{
		for (int i = 0; i < unsorted.length; i++)
		{
			int min = unsorted[i], min_index = i;
			for (int j = i; j < unsorted.length; j++)
			{
				if (unsorted[j] < min)
				{
					min = unsorted[j];
					min_index = j;
				}
			}
			if (min_index != i)
			{
				int temp = unsorted[i];
				unsorted[i] = unsorted[min_index];
				unsorted[min_index] = temp;
			}
			System.out.println("--->" + Arrays.toString(unsorted));

		}
	}
}

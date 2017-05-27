package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序法，最坏的时间复杂度是O(N)，平均时间复杂度O(N^2)，最好时间复杂度O(N)，
 * 
 * @author xiaodong
 * 
 */
public class Bubble_sort
{

	public static void main(String[] args)
	{
		int[] x =
		{ 6, 2, 4, 1, 5, 9 };
		System.out.println("开始之前" + Arrays.toString(x));
		bubble_sort(x);
		System.out.println("开始之后" + Arrays.toString(x));
	}
	private static void bubble_sort(int[] unsorted)
	{
		for (int i = 0; i < unsorted.length; i++)
		{
			for (int j = i; j < unsorted.length; j++)
			{
				if (unsorted[i] > unsorted[j])
				{
					int temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				}
			}
			System.out.println("--->" + Arrays.toString(unsorted));
		}

	}

}

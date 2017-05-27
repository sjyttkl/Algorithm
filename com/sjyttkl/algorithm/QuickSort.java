package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * ���������Ƕ�ð������ĸĽ�
 * 
 * @author xiaodong
 * O(N*logN)��
 */
public class QuickSort
{
	public static void main(String[] args)
	{
		int[] x =
		{ 6, 9, 1, 2, 4, 7 };
		System.out.println("��ʼ֮ǰ" + Arrays.toString(x));
		quick_sort(x, 0, x.length - 1);
		System.out.println("��ʼ֮��" + Arrays.toString(x));

	}

	private static void quick_sort(int[] unsorted, int low, int high)
	{
		int loc = 0;
		if (low < high)
		{
			loc = partition(unsorted, low, high);
			quick_sort(unsorted, low, loc - 1);
			quick_sort(unsorted, loc + 1, high);
		}	
	}

	private static int partition(int[] unsorted, int low, int high)
	{
		int privot = unsorted[low];
		while (low < high)
		{
			while (low < high && unsorted[high] > privot)
			{
				high--;
			}
			unsorted[low] = unsorted[high];
			System.out.println("--->" + Arrays.toString(unsorted));
			while (low < high && unsorted[low] <= privot)
			{
				low++;
			}
			unsorted[high] = unsorted[low];
			System.out.println("--->" + Arrays.toString(unsorted));
		}
		unsorted[low] = privot;
		System.out.println("------>" + Arrays.toString(unsorted));

		return low;
	}
}

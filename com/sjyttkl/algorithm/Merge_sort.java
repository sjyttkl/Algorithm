package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * �鲢�����Ч���ǱȽϸߵģ������г�ΪN�������зֿ���С����һ��ҪlogN����ÿ������һ���ϲ��������еĹ��̣�ʱ�临�Ӷȿ��Լ�ΪO(N)����һ��ΪO(N*
 * logN)��
 * ��Ϊ�鲢����ÿ�ζ��������ڵ������н��в��������Թ鲢������O(N*logN)�ļ������򷽷����������򣬹鲢����ϣ�����򣬶�����Ҳ��Ч�ʱȽϸߵġ�
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
		System.out.println("��ʼ֮ǰ" + Arrays.toString(x));
		int[] sorted = new int[x.length];
		merge_sort(x, 0, x.length - 1, sorted);

		System.out.println("\n ����֮��" + Arrays.toString(x));

	}

	
	public static void merge_sort(int[] unsorted, int first, int last, int[] sorted)
	{
		if (first + 1 < last)
		{
			int mid = (first + last) / 2;
			System.out.println("{" + first + "}-{" + mid + "}-{" + last + "} ");
			System.out.println("-->>��󲿷�");
			merge_sort(unsorted, first, mid, sorted);
			System.out.println("-->>�Ҵ󲿷�");
			merge_sort(unsorted, mid, last, sorted);
			System.out.println("��ʼ��----->{" + first + "}-{" + mid + "}-{" + last + "} ");
			merge(unsorted, first, mid, last, sorted);
			System.out.println("ÿ�αȽϵĽ����----->" + Arrays.toString(unsorted));
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

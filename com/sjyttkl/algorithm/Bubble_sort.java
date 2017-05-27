package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * ð�����򷨣����ʱ�临�Ӷ���O(N)��ƽ��ʱ�临�Ӷ�O(N^2)�����ʱ�临�Ӷ�O(N)��
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
		System.out.println("��ʼ֮ǰ" + Arrays.toString(x));
		bubble_sort(x);
		System.out.println("��ʼ֮��" + Arrays.toString(x));
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

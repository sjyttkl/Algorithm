package com.sjyttkl.algorithm;

import java.util.Arrays;

import sun.nio.cs.US_ASCII;

/**
 * 
 * ϣ������
 * 
 * @author xiaodong ϣ�������ʱ�临�Ӷ�Ϊ��ƽ��Ϊ��O(N^3/2) ��� O(N^2)
 */
public class Shell_sort
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		int[] x = new int[]
//		{ 6, 2, 4, 1, 5, 9 };
		int[] x = new int[]
				{ 49,38,65,97,76,13,27,49,55,04 };
		System.out.println("��ʼ֮ǰ" + Arrays.toString(x));
		shell_sort(x, x.length);
		System.out.println("��ʼ֮��" + Arrays.toString(x));
	}


	private static void shell_sort(int[] unsorted, int len)
	{
		int group, i, j, temp;
		// ȡ����
		for (group = len / 2; group > 0; group /= 2)
		{
			// ��������
			for (i = group; i < len; i++)
			{
				// ��������
				for (j = i - group; j >= 0; j -= group)
				{
					if (unsorted[j] > unsorted[j + group])
					{
						temp = unsorted[j];
						unsorted[j] = unsorted[j + group];
						unsorted[j + group] = temp;
						System.out.println("--->" + Arrays.toString(unsorted));
					}
				}
			}
		}

	}

}

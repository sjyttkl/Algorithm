package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * ��������
 * 
 * @author xiaodong
 * 
 */
public class InsertAlgorithm
{
	public static void main(String args[])
	{
		int[] v = new int[]
		{ 8, 2, 4, 9, 3, 6 };
		System.out.println("��ʼ֮ǰ" + Arrays.toString(v));
		getInsert(v);
		System.out.println("��ʼ֮��" + Arrays.toString(v));
	}



	private static void getInsert(int[] v)
	{
		for (int i = 1; i < v.length; i++)
		{
			int key = v[i];
			int j = i - 1;
			while (j >= 0 && v[j] > key)
			{
				v[j + 1] = v[j];
				j--;
				System.out.println("->" + Arrays.toString(v));
			}
			v[j + 1] = key;
			System.out.println("--->" + Arrays.toString(v));
		}

	}
}

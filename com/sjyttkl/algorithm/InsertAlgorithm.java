package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * 插入排序法
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
		System.out.println("开始之前" + Arrays.toString(v));
		getInsert(v);
		System.out.println("开始之后" + Arrays.toString(v));
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

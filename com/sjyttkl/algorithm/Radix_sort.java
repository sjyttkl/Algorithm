package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * 基数排序 约定:待排数字中没有0,如果某桶内数字为0则表示该桶未被使用,输出时跳过即可
 * 
 * unsorted待排数组 
 * array_x桶数组第一维长度
 *  array_y桶数组第二维长度
 * 
 * @author xiaodong
 * 
 */
public class Radix_sort
{
	public static void main(String[] args)
	{

		int[] array =
		{ 999999999, 65, 24, 47, 13, 50, 92, 88, 66, 33, 22445, 10001, 624159, 624158, 624155501 };
		System.out.println("开始之前" + Arrays.toString(array));
		radix_sort(array, 10, 10);
		System.out.println("开始之后" + Arrays.toString(array));

	}

	private static void radix_sort(int[] unsorted, int array_x, int array_y)
	{
		
		for (int i = 0; i < array_x/* 最大数字不超过999999999...(array_x个9) */; i++)
		{
			int[][] bucket = new int[array_x][array_y];
			for (int j = 0; j < unsorted.length; j++)
			{
				int temp = (unsorted[j] / (int) Math.pow(10, i)) % 10;
				for (int l = 0; l < array_y; l++)
				{
					if (bucket[temp][l] == 0)
					{
						bucket[temp][l] = unsorted[j];
						break;
					}
				}
			}
			for (int o = 0, x = 0; x < array_x; x++)
			{
				for (int y = 0; y < array_y; y++)
				{
					if (bucket[x][y] == 0)
					{
						continue;
					}
					unsorted[o++] = bucket[x][y];
				}
			}
			System.out.println("-->" + Arrays.toString(unsorted));
		}

	}
}

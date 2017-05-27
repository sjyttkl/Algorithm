package com.sjyttkl.algorithm;

/**
 * 顺序查找算
 * @author xiaodong
 *
 */
public class SequelSearch
{
	
	public static void main(String[] args)
	{
		int[] array ={ 6, 2, 4, 1, 5, 9 };
		search(array,4);
	}

	private static int search(int[] array, int num)
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i] == num)
			{
				return i;//返回查找到的小标
			}
		}
		return -1;//查找失败返回-1；
	}

}

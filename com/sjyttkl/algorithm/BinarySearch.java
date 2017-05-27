package com.sjyttkl.algorithm;

/**
 * 二分查找又称为折半查找
 * 
 * @author xiaodong
 *         　二分查找又称为折半查找，仅适用于事先已经排好序的顺序表。其查找的基本思路：首先将给定值K，与表中中间位置元素的关键字比较
 *         ，若相等，返回该元素的存储位置；
 *         若不等，这所需查找的元素只能在中间数据以外的前半部分或后半部分中。然后在缩小的范围中继续进行同样的查找。如此反复直到找到为止
 */
public class BinarySearch
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] data =
		{ 1, 2, 4, 5, 9, 20 };
		int key = 4;
		int result = binarySearch(data, key);
		System.out.println(result);

	}

	private static int binarySearch(int data[], int key)
	{
		int low = 0;
		int high = data.length - 1;

		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if(data[mid] == key)
			{
				return mid;
			}
			else if(data[mid]>key)
			{
				high = mid-1;
			}
			else
			{
				low = mid+1;
			}
		}
		return -1;
	}
}

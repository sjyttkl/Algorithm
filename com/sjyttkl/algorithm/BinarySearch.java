package com.sjyttkl.algorithm;

/**
 * ���ֲ����ֳ�Ϊ�۰����
 * 
 * @author xiaodong
 *         �����ֲ����ֳ�Ϊ�۰���ң��������������Ѿ��ź����˳�������ҵĻ���˼·�����Ƚ�����ֵK��������м�λ��Ԫ�صĹؼ��ֱȽ�
 *         ������ȣ����ظ�Ԫ�صĴ洢λ�ã�
 *         �����ȣ���������ҵ�Ԫ��ֻ�����м����������ǰ�벿�ֻ��벿���С�Ȼ������С�ķ�Χ�м�������ͬ���Ĳ��ҡ���˷���ֱ���ҵ�Ϊֹ
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

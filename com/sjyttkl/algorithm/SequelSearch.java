package com.sjyttkl.algorithm;

/**
 * ˳�������
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
				return i;//���ز��ҵ���С��
			}
		}
		return -1;//����ʧ�ܷ���-1��
	}

}

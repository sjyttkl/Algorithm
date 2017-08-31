package com.sjyttkl.algorithm;

import java.util.Arrays;


/**
 * ���磺�������Ϊ4�������ӽڵ�ֱ�Ϊ10,13,15����С�����ĸ��ڵ�Ϊ12.
                 ���ǿ��Ѹ������ı�����ʽ�Ʋ������һ���������ֵΪ��1��2^k-1��
                ���ǿ����ö�����������������С�����ĸ��ڵ㡣
 * @author xiaodong
 *
 */

public class FindMid
{
	public static int FindMin(int [] arr ,int left,int right)
	{
		int mid = ((right-left)>>1) +left;
		if(arr[0]<=mid&&arr[2]>mid)
		{
			return mid;
		}
		else if(arr[0]>mid)
		{
			return FindMin(arr,mid+1,right);
		}
		else if(arr[2]<mid)
		{
			return FindMin(arr,left,mid-1);
		}
		return 0;
	}
	
	public static void main(String args[])
	{
		int k = 4;
		
		int arr[]= {10,13,15};
		
		Arrays.sort(arr);
		int right = (1<<k)-1; //��1����kλ��===��2^k
		int min = FindMin(arr,1,right);
		System.out.println(min);
		
	}
}

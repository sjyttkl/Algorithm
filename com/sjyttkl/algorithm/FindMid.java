package com.sjyttkl.algorithm;

import java.util.Arrays;


/**
 * 例如：输入深度为4，三个子节点分别为10,13,15，最小子树的根节点为12.
                 我们可已根据树的遍历方式推测出这是一个中序遍历值为从1到2^k-1。
                我们可以用二分搜索技术来找最小子树的根节点。
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
		int right = (1<<k)-1; //把1左移k位，===》2^k
		int min = FindMin(arr,1,right);
		System.out.println(min);
		
	}
}

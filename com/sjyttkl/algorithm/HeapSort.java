package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * ʱ�临�Ӷȣ��������ʱ�临�Ӷ�ΪO(nlog2n)�� �㷨�ȶ��ԣ�����ǰ����ͬԪ�ؼ�����λ�ÿ��ܻᷢ���ı䣬��������һ�ֲ��ȶ��������㷨��
 * 
 * @author Administrator
 * 
 */
public class HeapSort
{

	public static void main(String args[])
	{
		HeapSort hs = new HeapSort();
		int[] array =
		{ 87, 45, 78, 32, 17, 65, 53, 9, 122 };
		System.out.println("��ʼ֮ǰ" + Arrays.toString(array));
		System.out.print("��������ѣ�");
		hs.toString(hs.buildMaxHeap(array));
		System.out.print("\n" + "ɾ���Ѷ�Ԫ�أ�");
		hs.toString(hs.deleteMax(array));
		System.out.print("\n" + "����Ԫ��63:");
		hs.toString(hs.insertData(array, 63));
		System.out.print("\n" + "���������");
		hs.toString(hs.heapSort(array));
		System.out.println("����֮��" + Arrays.toString(array));
	}

	
	// �������:������array�в�������data----->��Ϊ�ǲ���һ��Ԫ�أ�֮ǰ�Ķ�������ã������Բ�����djustDownToUp������������Ҫ���ҵ�������������Ҫ���µ���
	public int[] insertData(int[] array, int data)
	{
		array[array.length - 1] = data; // ���½ڵ���ڶѵ�ĩ��
		int k = array.length - 1; // ��Ҫ�����Ľڵ�
		int parent = (k - 1) / 2; // ˫�׽ڵ�
		while (parent >= 0 && data > array[parent])
		{
			array[k] = array[parent]; // ˫�׽ڵ��µ�
			k = parent;
			if (parent != 0)
			{
				parent = (parent - 1) / 2; // �������ϱȽ�
			} else
			{ // ���ڵ��ѵ�����ϣ�����ѭ��
				break;
			}
		}
		array[k] = data; // ������Ľ��ŵ���ȷ��λ�� [9, 17, 32, 45, 53, 63, 65, 78, 87] [87, 45, 78, 63, 17, 65, 53, 9, 32]
		
		
		// 2, �ڶ��ַ�ʽֱ���� ������� ���ѣ������� 
		 //buildMaxHeap(array);
		 
		   
		return array;
	}

	
	// ɾ���Ѷ�Ԫ�ز���
	public int[] deleteMax(int[] array)
	{
		// ���ѵ����һ��Ԫ����Ѷ�Ԫ�ؽ������ѵ�Ԫ��ֵ��Ϊ-99999
		array[0] = array[array.length - 1];
		array[array.length - 1] = -99999;
		// �Դ�ʱ�ĸ��ڵ�������µ���
		adjustDownToUp(array, 0, array.length);
		return array;
	}

	// ������
	public int[] heapSort(int[] array)
	{
		array = buildMaxHeap(array); // ��ʼ���ѣ�array[0]Ϊ��һ��ֵ����Ԫ��
		for (int i = array.length - 1; i > 1; i--)
		{
			int temp = array[0]; // ���Ѷ�Ԫ�غͶѵ�Ԫ�ؽ��������õ���ǰ���Ԫ����ȷ������λ��
			array[0] = array[i];
			array[i] = temp;
			adjustDownToUp(array, 0, i); // ������ʣ���Ԫ������ɶ�
		}
		return array;
	}

	// ��������ѣ���array������ȫ��������˳��洢�ṹ
	private int[] buildMaxHeap(int[] array)
	{
		// �����һ���ڵ�array.length-1�ĸ��ڵ㣨array.length-1-1��/2��ʼ��ֱ�����ڵ�0������������//
		// ��Ϊ�Ǵ�0��ʼ�ģ�����Ҫ��ȥ2������ֻҪ��ȥ1������		
		for (int i = (array.length - 2) / 2; i >= 0; i--)// [9, 17, 32, 45, 53, 63, 65, 78, 87]
		{
			adjustDownToUp(array, i, array.length);
		}
		return array;
	}

	// ��Ԫ��array[k]���������𲽵������νṹ
	private void adjustDownToUp(int[] array, int k, int length)
	{
		int temp = array[k];
		for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1)
		{ // iΪ��ʼ��Ϊ�ڵ�k�����ӣ��ؽڵ�ϴ���ӽڵ����µ��� // ��Ϊ�Ǵ�0��ʼ�ģ�������������Ҫ+1.
			if (i <= length - 1 && array[i] < array[i + 1])
			{ // ȡ�ڵ�ϴ���ӽڵ���±�
				i++; // ����ڵ���Һ���>���ӣ���ȡ�Һ��ӽڵ���±�
			}
			if (temp >= array[i])
			{ // ���ڵ� >=������Ů�йؼ��ֽϴ��ߣ���������
				break;
			} else
			{ // ���ڵ� <������Ů�йؼ��ֽϴ���
				array[k] = array[i]; // �������ӽ���нϴ�ֵarray[i]������˫�׽ڵ���
				k = i; // ���ؼ����޸�kֵ���Ա�������µ���
			}
		}
		array[k] = temp; // �������Ľ���ֵ��������λ��
	}

	public void toString(int[] array)
	{

		System.out.println("-->" + Arrays.toString(array));
	}
}
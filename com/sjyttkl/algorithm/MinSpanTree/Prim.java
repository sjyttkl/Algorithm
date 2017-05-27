package com.sjyttkl.algorithm.MinSpanTree;

/**
 * ��С�����������ַ�ʽ������ķ�㷨�Ϳ�³˹�����㷨
 * ��С�����������������������ͼ
 * @author С��
 * 
 */
public class Prim
{
	int[][] matrix;// ����
	int MAX_WEIGHT = Integer.MAX_VALUE;
	int size;// �������

	/**
	 * ����ķ�㷨ʵ����С���������ȳ�ʼ���õ���һ�������������ȨֵԪ�طŵ������У����ҵ�����Ȩֵ��С�Ķ����±꣭���ٸ��ݸ��±꣬
	 * �����±궥���������Ȩֵ���뵽�����У���ѭ����������
	 */
	public void prim()
	{
		int[] tempWeight = new int[size];// ��ʱ��Ŷ���Ȩֵ�����飬ÿ��ѭ����Ҫ���л�ȡ����СȨֵ�Ͷ����±�
		int minWeight;// ��СȨֵ
		int minId;// ��СȨֵ����
		int sum = 0;// Ȩֵ�ܺ�
		// �ȳ�ʼ������һ�еĶ���Ȩֵ��ŵ���ʱȨֵ������
		for (int i = 0; i < size; i++)
		{
			tempWeight[i] = matrix[0][i];
		}

		System.out.println("�Ӷ���0��ʼ����");
		for (int i = 1; i < size; i++)
		{
			// ÿ��ѭ�����ҳ���ʱ����Ȩֵ����С��Ȩֵ
			minWeight = MAX_WEIGHT;
			minId = 0;
			for (int j = 1; j < size; j++)
			{
				if (tempWeight[j] > 0 && tempWeight[j] < minWeight)
				{
					minWeight = tempWeight[j];
					minId = j;
				}
			}
			sum += minWeight;
			// �ҵ�Ŀ�궥��minId,����ȨֵΪminweight��
			System.out.println("�ҵ�����:" + minId + " ȨֵΪ��" + minWeight+" �ܺ� "+sum);
			// �����ҵ��Ķ���minid������һ�е�����������Ķ���Ȩֵ��ӵ���ʱȨֵ������
			tempWeight[minId] = 0;//�Ѹö�����Ϊ0��ʾ�õ��������
			for (int j = 1; j < size; j++)
			{
				if (tempWeight[j] != 0 && matrix[minId][j] < tempWeight[j])
				{
					tempWeight[j] = matrix[minId][j];
				}
			}
		}
		System.out.println("��СȨֵ�ܺ�Ϊ��" + sum);
	}

	private void createGraph(int index)
	{
		size = index;
		matrix = new int[index][index];
		int[] a0 =
		{ 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
		int[] a1 =
		{ 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
		int[] a2 =
		{ MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
		int[] a3 =
		{ MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, 24, 16, 21 };
		int[] a4 =
		{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
		int[] a5 =
		{ 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
		int[] a6 =
		{ MAX_WEIGHT, 16, MAX_WEIGHT, 24, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
		int[] a7 =
		{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
		int[] a8 =
		{ MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };
		matrix[0] = a0;
		matrix[1] = a1;
		matrix[2] = a2;
		matrix[3] = a3;
		matrix[4] = a4;
		matrix[5] = a5;
		matrix[6] = a6;
		matrix[7] = a7;
		matrix[8] = a8;
	}

	public static void main(String[] args)
	{
		Prim prim = new Prim();
		prim.createGraph(9);
		prim.prim();
	}
}
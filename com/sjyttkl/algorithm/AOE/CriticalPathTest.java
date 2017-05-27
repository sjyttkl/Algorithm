package com.sjyttkl.algorithm.AOE;

/**
 * @title���ؼ�·��
 * @input: �����Ȩͼ��ͼ���ڽӱ���ʽ��ʾ��ͷ���ֻ�洢�ö���Ķȣ���̽��洢���㼰Ȩֵ
 * @output: ���п��ܹؼ�·���Ĳ���path��path[i][0]��path[i][1]����ߵĶ��㣬path[i][2]����Ȩֵ
 * @author xiaodong
 */

import java.util.*;

public class CriticalPathTest
{
	public static void main(String[] args)
	{
		int[][] graph =
		{
		{ 0, 1, 6, 2, 4, 3, 5, },
		{ 1, 4, 1, },
		{ 1, 4, 1 },
		{ 1, 5, 2, },
		{ 2, 6, 9, 7, 7, },
		{ 1, 7, 4, },
		{ 1, 8, 2, },
		{ 2, 8, 4, },
		{ 2, }, };
		int[][] path;

		CriticalPath criticalPath = new CriticalPath();
		criticalPath.input(graph);
		path = criticalPath.getPath();
		for (int i = 0; i < criticalPath.getLength(); i++)
		{
			System.out.println("�ߣ�" + path[i][0] + "-" + path[i][1] + " Ȩ��" + path[i][2]);
		}
	}
}

class CriticalPath
{
	private int[][] graph;
	private int[][] path;
	int len;

	void input(int[][] graph)
	{
		this.graph = graph;
		path = new int[graph.length - 1][];
		len = 0;
		calculate();
	}

	void calculate()
	{
		int[] ve = new int[graph.length]; // �¼������ʱ��

		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		int i, j, v;
		for (int t : ve)
			t = 0;
		stack1.push(0);
		while (stack1.empty() != true)
		{
			v = (Integer) stack1.pop();
			for (i = 1; i < graph[v].length; i = i + 2)
			{
				j = graph[v][i];
				if ((--graph[j][0]) == 0)
				{
					stack1.push(j);
				}
				if (ve[v] + graph[v][i + 1] > ve[j])
				{
					ve[j] = ve[v] + graph[v][i + 1];
				}
			}
			stack2.push(v);
		}

		int[] vl = new int[graph.length]; // �¼��������ʱ��

		for (i = 0; i < graph.length; i++)
			vl[i] = 1000;
		vl[graph.length - 1] = ve[graph.length - 1];
		while (stack2.empty() != true)
		{
			v = (Integer) stack2.pop();
			for (i = 1; i < graph[v].length; i = i + 2)
			{
				j = graph[v][i];
				if (vl[j] - graph[v][i + 1] < vl[v])
				{
					vl[v] = vl[j] - graph[v][i + 1];
				}
			}
		}

		for (v = 0; v < graph.length - 1; v++)
		{ // ��ؼ�·�������б�

			for (i = 1; i < graph[v].length; i = i + 2)
			{
				j = graph[v][i];
				if (ve[v] == (vl[j] - graph[v][i + 1]))
				{
					int[][] p =
					{
					{ v, j, graph[v][i + 1], }, };
					path[len++] = p[0];
				}
			}
		}
	}

	int[][] getPath()
	{
		return path;
	}

	int getLength()
	{
		return len;
	}
}
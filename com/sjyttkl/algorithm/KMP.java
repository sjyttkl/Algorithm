package com.sjyttkl.algorithm;

import java.util.Arrays;

/**
 * Javaʵ��KMP�㷨
 * 
 * ˼�룺ÿ��һ��ƥ������г����ַ��Ƚϲ��ȣ�����Ҫ����iָ�룬 ���������Ѿ��õ��ġ�����ƥ�䡱�Ľ����ģʽ���ҡ�������������Զ ��һ�ξ���󣬼������бȽϡ�
 * 
 * ʱ�临�Ӷ�O(n+m)
 * 
 * @author xiaodong
 * 
 */
public class KMP
{
	public static void main(String[] args)
	{
		String str = "ababcabcacbab";
		char[] str_chars = str.toCharArray();
		String pattern = "abcac";
		char[] pattern_chars = pattern.toCharArray();
		int[] next = new int[pattern_chars.length];
		getNext(pattern_chars, next);
		System.out.println("next --->" + Arrays.toString(next));// next --->[-1,
																// 0, 0, 1, 1,
																// 2, 0, 0]
		int result = Kmp(str_chars, pattern_chars, next);
		System.out.println(result);

	}

	private static int Kmp(char[] str_chars, char[] pattern_chars, int[] next)
	{
		int i = 0;
		int j = 0;
		while (i <= str_chars.length - 1 && j <= pattern_chars.length - 1)
		{
			if (j == -1 || str_chars[i] == pattern_chars[j])
			{
				i++;
				j++;
			} else
			{
				j = next[j];
			}
		}
		if (j < pattern_chars.length)
		{
			return -1;
		} else
		{
			return i - pattern_chars.length; // ����ģʽ���������е�ͷ�±�
		}
	}

	private static void getNext(char[] chars, int[] next)
	{
		int i = 0;
		int j = -1;
		next[0] = -1;
		// abcac
		while (i < next.length - 1) // ���ﲻ������Ҫ-1�������ִ���
		{
			if (j == -1 || chars[i] == chars[j])
			{
				++i;
				++j;
				//�������һ�� if--else �ǶԴ�ͳ��kmp���иĽ���, ����� 1 ��2,ȡһ��������
				//1,
				if (chars[i] != chars[j])
				{
					next[i] = j;
				} else
				{
					next[i] = next[j];
				}
				//2,
				//next[i] = j;

			} else
			{
				j = next[j];
			}
		}

	}

}

package com.sjyttkl.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaodong on 17/4/15. �����������Javaʵ��:����ʵ�ֶ����õݹ�ʵ�ֵ�.
 */
public class BST<Key extends Comparable<Key>, Value>
{

	private Node root;// ����������ĸ��ڵ�

	// �������Ľ��
	private class Node
	{
		private Key key;// ��
		private Value value;// ֵ
		private Node left, right;// ָ������������:��������������.
		private int N;// �Ըýڵ�Ϊ���������еĽ������

		public Node(Key key, Value value, int N)
		{
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	/**
	 * ��ȡ��������������Ĵ�С
	 * 
	 * @return
	 */
	public int size()
	{
		return size(root);
	}

	/**
	 * ��ȡĳһ�����Ϊ�����Ķ���������Ĵ�С
	 * Ҳ����һ���ж��ٸ��ڵ���
	 * @param x
	 * @return
	 */
	private int size(Node x)
	{
		if (x == null)
		{
			return 0;
		} else
		{
			return x.N;
		}
	}

	/**
	 * ͨ��key��ȡvalue
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key)
	{
		return get(root, key);
	}

	/**
	 * ���� x Ϊ���ڵ�������в��Ҳ�����Key����Ӧ��ֵ,����Ҳ����ͷ���null �ݹ�ʵ��
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key)
	{
		if (x == null)
		{
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
		{
			return get(x.left, key);
		} else if (cmp > 0)
		{
			return get(x.right, key);
		} else
		{
			return x.value;
		}
	}

	/**
	 * ���ü�ֵ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value)
	{
		root = put(root, key, value);
	}

	/**
	 * key��������� x Ϊ���ڵ��������,���������ֵ; ����key��value��ֵ�Բ��벢����һ���µĽ��.
	 * 
	 * @param x
	 * @param key
	 * @param value
	 * @return
	 */
	private Node put(Node x, Key key, Value value)
	{
		if (x == null)
		{
			x = new Node(key, value, 1);
			return x;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
		{
			x.left = put(x.left, key, value);
		} else if (cmp > 0)
		{
			x.right = put(x.right, key, value);
		} else
		{
			x.value = value;// ����value��ֵ
		}
		x.N = size(x.left) + size(x.right) + 1;

		return x;
	}

	/**
	 * ��С��
	 */
	public Key min()
	{
		return min(root).key;
	}

	/**
	 * ���ؽ��xΪroot�Ķ�������������Сkeyֵ��Node
	 * 
	 * @param x
	 * @return ����������Сkey�Ľ��
	 */
	private Node min(Node x)
	{
		if (x.left == null)
		{
			return x;
		} else
		{
			return min(x.left);
		}
	}

	/**
	 * ����
	 */
	public Key max()
	{
		return max(root).key;
	}

	/**
	 * ���ؽ��xΪroot�Ķ��������������keyֵ��Node
	 * 
	 * @param x
	 * @return
	 */
	private Node max(Node x)
	{
		if (x.right == null)
		{// ������Ϊ��,����ڵ�������
			return x;
		} else
		{
			return max(x.right);
		}
	}

	/**
	 * key����ȡ��
	 */
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if (x == null)
		{
			return null;
		}
		return x.key;
	}

	/**
	 * ��x Ϊ���ڵ�Ķ���������,�����Բ���key������ȡ����Node
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node floor(Node x, Key key)
	{
		if (x == null)
		{
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp == 0)
		{
			return x;
		}
		if (cmp < 0)
		{// ˵��key����С��x����key,��������ȡ�������������
			return floor(x.left, key);
		}
		// ����ȡ����������,
		Node t = floor(x.right, key);
		if (t != null)
		{
			return t;
		} else
		{
			return x;
		}
	}

	/**
	 * key����ȡ��
	 */
	public Key ceiling(Key key)
	{
		Node x = ceiling(root, key);
		if (x == null)
		{
			return null;
		}
		return x.key;
	}

	/**
	 * ��x Ϊ���ڵ�Ķ���������,�����Բ���key������ȡ����Node
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node ceiling(Node x, Key key)
	{
		if (x == null)
		{
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp == 0)
		{
			return x;
		}
		if (cmp > 0)
		{// ˵��key��������x����key,��������ȡ�������������
			return ceiling(x.right, key);
		}
		// ����ȡ����������,
		Node t = ceiling(x.left, key);
		if (t != null)
		{
			return t;
		} else
		{
			return x;
		}
	}

	/**
	 * ����Ϊk�Ľ���key--Ҳ���������ж��ٸ��ڵ�ĸ��ڵ�
	 */
	public Key select(int k)
	{
		Node x = select(root, k);
		if (x == null)
		{
			return null;
		}
		return x.key;
	}

	/**
	 * ��������Ϊk�Ľ��
	 * 
	 * @param x
	 *            ���ڵ�
	 * @param k
	 *            ����
	 * @return
	 */
	private Node select(Node x, int k)
	{
		if (x == null)
		{
			return null;
		}
		int t = size(x.left);// ��ȡ�������Ľڵ���

		if (t == k)
		{// �������ڵ�����k��ͬ
			return x.left;
		} else if (t + 1 == k)
		{// �������������kСһ.
			return x;
		} else if (t > k)
		{// ����k�Ľ����������
			return select(x.left, k);
		} else
		{
			// ����k����������
			return select(x.right, k - t - 1);
		}
	}

	/**
	 * ���ظ�����key������
	 */
	public int rank(Key key)
	{
		return rank(root, key);
	}

	/**
	 * �ڶ���������x�Ϸ���key������
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private int rank(Node x, Key key)
	{
		if (x == null)
		{
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
		{
			// key��С��root��key,����key����������
			return rank(x.left, key);
		} else if (cmp > 0)
		{
			// key����root��key,����key����������
			return 1 + size(x.left) + rank(x.right, key);
		} else
		{
			return size(x.left) + 1;
		}
	}

	/**
	 * ɾ����ֵ��С���
	 */
	public void deleteMin()
	{
		// ɾ��root����������е���Сkey�Ľ��,��ʵҲ��������ߵĽ��
		root = deleteMin(root);
	}

	/**
	 * ɾ����ֵ��С���
	 * 
	 * @param x
	 * @return �����µĶ���������ĸ��ڵ�
	 */
	private Node deleteMin(Node x)
	{
		if (x.left == null)
		{
			return x.right;// ɾ�����ڵ�,��ʱ���ص����µĶ���������ĸ��ڵ�
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * ɾ��:��ֵ�����
	 */
	public void deleteMax()
	{
		// ɾ��root����������е���Сkey�Ľ��,��ʵҲ�������ұߵĽ��
		root = deleteMax(root);
	}

	/**
	 * ɾ��
	 * 
	 * @param x
	 * @return �����µĶ���������ĸ��ڵ�
	 */
	private Node deleteMax(Node x)
	{
		if (x.right == null)
		{// ������Ϊ��
			return x.left;// ɾ�����ڵ�,��ʱ���ص����µĶ���������ĸ��ڵ�
		}
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * ɾ����key���.
	 * 
	 * @param key
	 */
	public void delete(Key key)
	{
		root = delete(root, key);
	}

	/**
	 * ɾ����xΪ�����Ķ����������key���Ľ��
	 * 
	 * @param x
	 * @param key
	 * @return �µĶ���������ĸ��ڵ�
	 */
	private Node delete(Node x, Key key)
	{
		if (x == null)
		{
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
		{
			x.left = delete(x.left, key);
		} else if (cmp > 0)
		{
			x.right = delete(x.right, key);
		} else
		{// ��ʱɾ�����ڵ�x
			if (x.left == null)
			{
				return x.right;
			}
			if (x.right == null)
			{
				return x.left;
			}
			/** ���ڵ���������������� */
			// 1. ��ָ�򼴽���ɾ���Ľ������ӱ���Ϊt;
			Node t = x;
			// 2. �����x������������С��ֵ�Ľ�㲢��xָ����.
			x = min(t.right);
			// 3. ��t��������ɾ����С�Ľ��֮��ĸ��ڵ㷵��
			x.right = deleteMin(t.right);
			// 3. ��t����������x��������
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * ��Χ����,���ص�ǰ���е����еļ�ֵ
	 */
	public Iterator<Key> keys()
	{
		return keys(min(), max());
	}

	/**
	 * ������С��ֵ������ֵ,��ȡ���еļ�ֵ
	 */
	public Iterator<Key> keys(Key lo, Key hi)
	{
		List<Key> list = new ArrayList<>();
		keys(root, list, lo, hi);
		return list.iterator();
	}

	/**
     *���ݶ����������ʣ���ʵ����Ǹ���������ķ�������������������������Ϳ�������ı�����������
     */
	private void keys(Node x, List<Key> list, Key lo, Key hi)
	{
		if (x == null)
		{
			return;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0)
		{
			keys(x.left, list, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0)
		{
			
			list.add(x.key);
		}
		if (cmphi > 0)
		{
			keys(x.right, list, lo, hi);
		}
	}

	/**
	 * main ����
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(5, "5");
		bst.put(1, "1");
		bst.put(4, "4");
		bst.put(7, "7");
		bst.put(3, "3");
		bst.put(8, "8");

		// bst.test(bst);
		bst.deleteMax();
//		System.out.println("/******************* ɾ����� *******************/");
//		// /bst.test(bst);
//
//		Iterator<Integer> iterator0 = bst.keys();
//		while (iterator0.hasNext())
//		{
//			System.out.println(iterator0.next());
//		}
//		bst.delete(1);
//		System.out.println("ɾ��1");
//
//		// bst.test(bst);
//
		Iterator<Integer> iterator = bst.keys();
		while (iterator.hasNext())
		{
			System.out.print (iterator.next() + "  ");
		}
	}

	public void test(BST<Integer, String> bst)
	{
		// ����get
		System.out.println("/** ���ҺͲ������ */");
		System.out.println(bst.get(5));
		System.out.println(bst.get(1));
		System.out.println(bst.get(5));
		System.out.println(bst.get(8));
       
		System.out.println("/** size */");
		System.out.println(bst.size());

		System.out.println("/** ��С��ֵ������ֵ */");
		System.out.println(bst.min());
		System.out.println(bst.max());

		System.out.println("/** ��������ȡ�� */");
		System.out.println(bst.floor(2));
		System.out.println(bst.ceiling(6));

		System.out.println("/** ����Ϊk�Ľ���ֵ */");
		System.out.println(bst.select(1));

		System.out.println("/** ��ȡ�������� */");
		System.out.println(bst.rank(3));
	}

}

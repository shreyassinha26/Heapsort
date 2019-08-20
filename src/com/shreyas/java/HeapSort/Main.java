package com.shreyas.java.HeapSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter numbers one by one,enter 0 to stop");
		int n = in.nextInt();
		while(n!=0) {
			arr.add(n);
			n = in.nextInt();
		}
		heapSort(0, arr.size()-1);;
		System.out.println(arr);
	}
	public static int getLeftchild(int i)
	{
		int j = (2*(i+1))-1;
		return j;
	}
	public static int getRightChild(int i)
	{
		int j = (2*(i+1));
		return j;
	}
	public static int getFather(int i) 
	{
		int j =( (int)(i+1)/2)+1;
		return j;
	}
	public static boolean ifHasBranches(int i , int length)
	{
		int j = getLeftchild(i);
		if(j>length)
		{
			return false;
		}
		return true;
	}
	public static boolean ifHasRightBranch(int i , int length)
	{
		int j = getRightChild(i);
		if(j>length)
		{
			return false;
		}
		return true;
	}
	public static void heapify(int lo , int hi)
	{
		for(int i = hi;i>=lo;i--)
		{
			check(i, hi);
		}
	}
	public static void check(int i , int hi)
	{
		if(ifHasBranches(i, hi))
		{
			if(ifHasRightBranch(i, hi))
			{
				if(arr.get(getLeftchild(i)) > arr.get(getRightChild(i)))
				{
					if(arr.get(getLeftchild(i))>arr.get(i))
					{
						int a = arr.get(i);
						arr.set(i, arr.get(getLeftchild(i)));
						arr.set(getLeftchild(i), a);
						check(getLeftchild(i), hi);
					}
				}
				else
				{
					if(arr.get(getRightChild(i))>arr.get(i))
					{
						int a = arr.get(i);
						arr.set(i, arr.get(getRightChild(i)));
						arr.set(getRightChild(i), a);
						check(getRightChild(i), hi);
					}
				}
				
			}
			else
			{
				if(arr.get(getLeftchild(i))>arr.get(i))
				{
					int a = arr.get(i);
					arr.set(i, arr.get(getLeftchild(i)));
					arr.set(getLeftchild(i), a);
					check(getLeftchild(i), hi);
				}
			}
		}
	}
	public static void heapSort(int lo , int hi)
	{
		heapify(lo, hi);
		for(int i = hi-1;i >=lo;i--)
		{
			int a = arr.get(0);
			arr.set(0, arr.get(i+1));
			arr.set(i+1, a);
			check(0, i);
		}
	}
}

package PartI;

import java.util.Arrays;

public class Q1 {
	
	public static void main(String[] args)
	{
		int n = 6;
		int a[] = new int[n];
		for(int i=0; i<n ; i++)
		{
			a[i] = (int)(Math.random()*30);
		}
		System.out.println(Arrays.toString(a));
		
		for(int i=0;i<n/2;i=i+2)
		{
			a[i] = a[i]+a[i+1]-(a[i+1]=a[i]);
			
		}
		System.out.println(Arrays.toString(a));
		
		for(int i=0;i<n/2;i=i+2)
		{
			a[i] = a[i]+a[i+1]-(a[i+1]=a[i]);
			
		}
		
		if(n%2==0)
		{
			for(int i=n/2;i<n-1;i=i+2)
			{
				a[i+1] = a[i]+a[i+1];
				
			}
		} else {
			for(int i=n/2+1;i<n-1;i=i+2)
			{
				a[i+1] = a[i]+a[i+1];
				
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}

}

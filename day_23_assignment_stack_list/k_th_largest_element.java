package day_23_assignment_stack_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class k_th_largest_element {
	public static int kthlargest(ArrayList<Integer> arr,int size,int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
				int i;
					for( i=0;i<size;i++)
					{
						pq.add(arr.get(i));
					}
				int l=k-1;
				while(l>0)
				{
					pq.poll();
					l=l-1;
				}
				return pq.peek();
	}
	
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> arr=new ArrayList<Integer>(Arrays.asList(3,2,1,5,6,4));
		int size=arr.size();
		int k=2;
		int result=kthlargest(arr,size,k);
		System.out.println(result);
	}

}

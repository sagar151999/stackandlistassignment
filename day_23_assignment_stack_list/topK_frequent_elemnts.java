package day_23_assignment_stack_list;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topK_frequent_elemnts {

	public static int[] topKFrequentPQ(int[] nums, int k) {
		Map<Integer, Integer> elemCountMap = new HashMap<>();

		for (int num : nums) {
			elemCountMap.put(num, elemCountMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
				(num1, num2) -> elemCountMap.get(num1) - elemCountMap.get(num2));

		for (int num : elemCountMap.keySet()) {
			pq.add(num);

			if (pq.size() > k)
				pq.poll();
		}

		int[] resultArr = new int[k];

		for (int i = k - 1; i >= 0; --i)
			resultArr[i] = pq.poll();

		return resultArr;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		int[] topKFrequent = topKFrequentPQ(nums, k);

		System.out.println("Top " + k + " frequent elements:");
		for (int num : topKFrequent) {
			System.out.print(num + " ");
		}
	}
}

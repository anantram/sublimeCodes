import java.util.*;

class MaxSub {
	public static void main(String[] args) {
		ArrayList<Integer> mainArray  = new ArrayList<Integer>();
		ArrayList<Integer> maxSubArray  = new ArrayList<Integer>();
		ArrayList<Integer> subArray  = new ArrayList<Integer>();

		Scanner inputScanner = new Scanner(System.in);
		int temp = 0;
		int sum = 0;
		int maxSum = 0;
		String input = inputScanner.nextLine();
		StringTokenizer token = new StringTokenizer(input, ",");
		while(token.hasMoreTokens()) {
			temp = Integer.parseInt(token.nextToken());
			mainArray.add(temp);
		}

		for(int start = 0; start < mainArray.size(); start++) {
			subArray.clear();
			sum = 0;
			sum = mainArray.get(start);
			subArray.add(mainArray.get(start));
			for(int check = start + 1; check < mainArray.size(); check ++) {
				subArray.add(mainArray.get(check));
				sum = sum + mainArray.get(check);
			}

			int growth = 0;
			int reverse = 0;
			int reverseValue = 0;
			boolean found = false;
			for(reverse = mainArray.size() - 1; reverse > start; reverse--) {
				growth = growth + mainArray.get(reverse);
				if(growth < 0) {
					found = true;
					//reverseValue++;
					while(mainArray.get(reverse) < 0) {
						reverse--;
						reverseValue++;
					}
				}
			}

			if(found) {
				for(int i = 0; i < reverseValue; i++) {
					subArray.remove(subArray.size() -1);
				}
				sum = sum - growth;
			}

			//System.out.println("size " + sum);
			if(sum >= maxSum) {
				maxSubArray.clear();
				for(int i = 0; i < subArray.size(); i++) {
					maxSubArray.add(subArray.get(i));
				}
				maxSum = sum;
			}
		}
		System.out.println(maxSum);
		for(int i = 0; i < maxSubArray.size(); i++)
			if(i != maxSubArray.size() - 1)
				System.out.print(maxSubArray.get(i) + ",");
			else
				System.out.print(maxSubArray.get(i));
	}

	// 	while(!minFind.isEmpty()) {
	// 		int currentmin = (int)minFind.poll();
	// 		subArray.clear();
	// 		subArray.add(currentmin);
	// 		int next = currentmin + 1;
	// 		sum = currentmin;
	// 		while(true) {
	// 			if(mainArray.containsKey(next)) {
	// 				sum = sum + next;
	// 				subArray.add(next);
	// 				next = next + 1;
	// 			}
	// 			else
	// 				break;
	// 		}
	// 		if(sum > maxSum) {
	// 			maxSubArray.clear();
	// 			for(int i = 0; i < subArray.size(); i++)
	// 				maxSubArray.add(subArray.get(i));
	// 			maxSum = sum;
	// 		}
	// 	}
	// 	System.out.println(maxSum);
	// 	for(int i = 0; i < maxSubArray.size(); i++)
	// 		if(i != maxSubArray.size() - 1)
	// 			System.out.print(maxSubArray.get(i) + ",");
	// 		else
	// 			System.out.print(maxSubArray.get(i));
	// }
}
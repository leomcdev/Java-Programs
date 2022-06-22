// Program which creates and computes different methods	
package lb223qk_assign1;

public class Main {

	public static void main(String[] args) {

		// method average
		int answer1[] = new int[] { 1, 2, 3, 4, 5 };
		Arrays.average(answer1);

		// method max
		int answer2[] = new int[] { 1, 2, 3, 4, 5 };
		Arrays.max(answer2);

		// method addN
		int n = 0;
		int arr[] = new int[] { 1, 2, 3, 4, 5 };
		Arrays.addN(arr, n);

		// method reverse
		int reversed[] = new int[] { 1, 2, 3, 4, 5 };
		Arrays.reverse(reversed);

		// method replaceAll
		int[] theArr = new int[] { 1, 2, 3 };
		Arrays.replaceAll(theArr, 1, 4);

		// method sort
		int[] numbers = new int[] { 7, 6, 3, 4, 5, 8 };

		System.out.println("Initial array: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		Arrays.sort(numbers);
		System.out.println("\n" + "Sorted array: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// method hasSubString
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[] { 1, 2, 3 };

		System.out.println(Arrays.hasSubString(arr1, arr2));

		// method absDif
		int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr4 = new int[] { 1, 1, 1, 1, 1 };
		Arrays.absDif(arr3, arr4);
	}
}

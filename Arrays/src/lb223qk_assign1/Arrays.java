package lb223qk_assign1;

public class Arrays {

	/**
	 * returns the average of the array
	 * @param arr
	 * @return
	 */
	static int average(int[] arr) {

		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double result = sum / arr.length;
		
		System.out.println("Average of array: " + result + "\n");
		return (int) (result);
	}

	/**
	 * returns the max value of the array
	 * @param arr
	 * @return
	 */
	static int max(int arr[]) {
		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < maxValue) {
				maxValue = arr[i];
			}
		}
		System.out.println("Max value is: " + arr[maxValue] + "\n");
		return arr[maxValue];
	}

	/**
	 * returns a changed array
	 * @param arr
	 * @param n
	 * @return
	 */
	static int[] addN(int[] arr, int n) {
		int value = 2;

		System.out.println("New array: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] += value;
			System.out.println(arr[i]);
		}
		System.out.println("\n");
		return arr;
	}

	/**
	 * reverse the array
	 * @param arr
	 * @return
	 */
	static int[] reverse(int[] arr) {

		System.out.println("Reversed Array: ");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		System.out.println("\n");
		return arr;
	}

	/**
	 * replaces values in the array
	 * @param arr
	 * @param old
	 * @param nw
	 */
	static void replaceAll(int[] arr, int old, int nw) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == old) {
				System.out.println("Old word: " + old);

				arr[i] = nw;
				System.out.println("Replace with nw: " + arr[i]);
				System.out.println("New array: ");
			}
			System.out.println(arr[i]);
		}
		System.out.println("\n");
	}

	/**
	 * sort the array with bubblesort method
	 * @param arr
	 * @return
	 */
	static int[] sort(int[] arr) {

		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap the elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * check if sub arrays numbers is part of the array
	 * @param arr
	 * @param sub
	 * @return
	 */
	static boolean hasSubString(int[] arr, int[] sub) {
		System.out.println("\n");
		String s1 = "";
		String s2 = "";

		for (int i = 0; i < arr.length; i++) {
			s1 = s1 + arr;
		}
		for (int j = 0; j < sub.length; j++) {
			s2 = s2 + arr;
		}

		if (s1.contains(s2))
			return true;
		else

			return false;
	}

	/**
	 * returns the absolute difference between array1 and array2
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	static int[] absDif(int[] a, int[] b) {
		System.out.println("\n" + "Absolute value of inputted array is: ");
		int num[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			num[i] = Math.abs(a[i] - b[i]);
			System.out.println(num[i]);
		}
		return num;
	}
}

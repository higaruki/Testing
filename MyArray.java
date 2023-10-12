import java.util.Arrays;

public class MyArray {
	public int[] mirror(int[] arr) {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[result.length - 1 - i] = arr[i];
		}
		return result;
	}

	public int[] mirror2(int[] arr) {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i < result.length; i++) {
			if (i < arr.length * 2 - arr.length) {
				result[i] = arr[i];
			} else {
				result[i] = arr[result.length - 1 - i];
			}
		}
		return result;
	}

	public int[] removeDuplicate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = 0;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						arr[i] = arr[j];
						arr[j] = 0;
						break;
					}
				}
			}
		}
		return arr;
	}

	public int[] removeDuplicate2(int[] arr) {
		int index = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = 0;
					count++;
				}
			}
		}
		int[] result = new int[count];
		for (int z = 0; z < arr.length; z++) {
			if (arr[z] != 0) {
				result[index++] = arr[z];
			}
		}
		return result;
	}

	public int[] getMissingValues(int[] arr) {
		int count = 0;
		int index = 0;
		for (int z = 1; z < arr.length; z++) {
			if (arr[z] - arr[z - 1] >= 1) {
				count += arr[z] - arr[z - 1] - 1;
			}
		}
		int[] result = new int[count];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] >= 1) {
				for (int j = 1; j < arr[i] - arr[i - 1]; j++) {
					result[index++] = arr[i - 1] + j;
				}
			}

		}
		return result;
	}

	public int[] fillMissingValues(int[] arr, int k) {
		int[] result = arr.clone();
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			int index1 = i - ((k + 1) / 2); // cốt lõi
			int index2 = i + ((k + 1) / 2); // cốt lõi
			if (arr[0] == -1 && i == 0) {
				for (int a = 1; a <= k; a++) {
					y += arr[a];
				}
				result[0] = y / k;
			}
			if (arr[i] == -1 && i == arr.length - 1) {
				for (int b = arr.length - 1; b >= arr.length - 1 - k; b--) {
					y += arr[b];
				}
				result[arr.length - 1] = y / k;
			}
			if (arr[i] == -1 && arr[0] != -1 && arr[arr.length - 1] != -1) {
				if (k % 2 == 0) {
					for (int j = index1; j <= index2; j++) {
						if (arr[j] != -1) {
							y += arr[j];
						}
					}
				} else {
					if (arr[index1] < arr[index2]) {
						for (int z = index1; z < index2; z++) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
					if (arr[index1] > arr[index2]) {
						for (int z = index2; z > index1; z--) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
				}
				result[i] = y / k;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 3, 5, 1, 3, 7, 8, 1, 9 };
		int[] arr3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] arr4 = { 13, 15, 19, 20 };
		MyArray m1 = new MyArray();
		System.out.println("mirror() {");
		System.out.println(Arrays.toString(m1.mirror(arr1)));
		System.out.println(Arrays.toString(m1.mirror2(arr1)));
		System.out.println("removeDuplicate() {");
//		System.out.println(Arrays.toString(m1.removeDuplicate(arr2))); SAI
		System.out.println(Arrays.toString(m1.removeDuplicate2(arr2))); //ĐÚNG
		System.out.println("getMissingValues() {");
		System.out.println(Arrays.toString(m1.getMissingValues(arr4)));	
		System.out.println(Arrays.toString(m1.getMissingValues(arr3)));

		System.out.println("fillMissingValues() {");
		// Input: 10 11 12 -1 14 10 17 19 20
		// Output(k=3): 10 11 12 12 14 16 17 19 20
		int[] input = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		int[] arr5 = { 10, 6, 12, -1, 14, 2, 17, 19, 20 };
		int[] arr6 = { -1, 10, 12, 9, 14, 15, 17, 19, 20 };
		int[] arr7 = { 10, 6, 12, 8, 14, 10, 17, 19, -1 };
		System.out.println(Arrays.toString(m1.fillMissingValues(input, 3)));
		System.out.println(Arrays.toString(m1.fillMissingValues(arr5, 2)));
		System.out.println(Arrays.toString(m1.fillMissingValues(arr5, 3)));
		System.out.println(Arrays.toString(m1.fillMissingValues(arr6, 5)));
		System.out.println(Arrays.toString(m1.fillMissingValues(arr7, 3)));
	}
}

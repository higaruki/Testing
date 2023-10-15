

	import java.util.Arrays;
	import java.util.Random;

	public class Task2_2_Sort {
	    public static void quickSort(int[] a) {
	        if (a.length <= 1) {
	            return;
	        }
	        quickSortRandom(a, 0, a.length - 1);
	    }

	    private static void quickSortRandom(int[] a, int l, int r) {
	        if (l < r) {
	            int pivotIndex = getPivotRandom(l, r);
	            int k = partition(a, l, r, pivotIndex);
	            quickSortRandom(a, l, k - 1);
	            quickSortRandom(a, k + 1, r);
	        }
	    }

	    public static int getPivotRandom(int l, int r) {
	        Random rand = new Random();
	        return rand.nextInt(r - l + 1) + l;
	    }

	    private static int partition(int[] a, int l, int r, int pivotIndex) {
	        int pivotValue = a[pivotIndex];
	        // Swap pivot element with the last element
	        int temp = a[r];
	        a[r] = a[pivotIndex];
	        a[pivotIndex] = temp;

	        int i = l - 1;
	        for (int j = l; j < r; j++) {
	            if (a[j] <= pivotValue) {
	                i++;
	                // Swap a[i] and a[j]
	                temp = a[i];
	                a[i] = a[j];
	                a[j] = temp;
	            }
	        }
	        // Swap a[i + 1] and pivot (put the pivot in its correct position)
	        temp = a[i + 1];
	        a[i + 1] = a[r];
	        a[r] = temp;
	        return i + 1;
	    }

	    public static void main(String[] args) {
	        int[] a = {6, 7, 8, 1, 5, 2, 3, 4};
	        quickSort(a);
	        System.out.println("Mảng đã sắp xếp bằng Quick Sort: " + Arrays.toString(a));
	    }
	}

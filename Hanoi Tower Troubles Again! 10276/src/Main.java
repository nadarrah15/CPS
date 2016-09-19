import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] array;
	static int size;
	static int total;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int count = reader.nextInt();
		for (int i = 0; i < count; i++) {
			size = reader.nextInt();
			array = new int[size];
			Arrays.fill(array, 0, array.length, 0);
			total = 0;

			System.out.println(backtrack(1, 0));
		}
	}

	static int backtrack(int value, int position) {
		if (position == size)
			return total;
		else if (array[position] == 0) {
			array[position] = value;
			total++;
			return backtrack(value + 1, position);
		} 
		else {
			for (int i = 0; i <= position; i++) {
				int root = (int) Math.sqrt(array[i] + value);
				if (root * root == array[i] + value) {
					array[i] = value;
					total++;
					return backtrack(value + 1, position);
				}
			}
		}

		return backtrack(value, position + 1);
	}
}

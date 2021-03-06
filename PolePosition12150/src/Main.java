import java.util.Scanner;

public class Main {

	public static class PolePosition {

		int number, position;

		public PolePosition(int number, int position) {
			this.number = number;
			this.position = position;
		}

		public int getPosition() {
			return position;
		}

		public int getNumber() {
			return number;
		}
	}

	public static void main(String[] args) {
		// create a scanner to read the input
		Scanner reader = new Scanner(System.in);

		// loop to read all inputs into an ArrayList
		// breaks when the EOF character is put in
		while (true) {
			int x = reader.nextInt();
			if (x == 0)
				break;
			else {
				String answer = "";
				PolePosition[] startingGrid = new PolePosition[x];
				for (int count = 0; count < x; count++) {
					PolePosition temp = new PolePosition(reader.nextInt(), reader.nextInt());
					try {
						if (startingGrid[count + temp.getPosition()] == null) {
							startingGrid[count + temp.getPosition()] = temp;
						} else
							throw new Exception("Throw me");
					} catch (Exception e) {
						answer = "-1";
					}
				}

				if (answer.equals("-1"))
					System.out.println(answer);
				else {
					
					answer += "" + startingGrid[0].getNumber();
					
					for (int i = 1; i < x; i++) {
						answer += " " + startingGrid[i].getNumber();
					}
					System.out.println(answer);
				}
			}
		}
	}
}

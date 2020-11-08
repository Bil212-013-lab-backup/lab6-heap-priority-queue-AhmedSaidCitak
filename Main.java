import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int size = keyboard.nextInt();
		PriorityQueue pq = new PriorityQueue(size);
		System.out.println();
		System.out.println(size);
		
		while(keyboard.hasNextLine()) {
			pq.insert(keyboard.nextInt(),keyboard.nextInt());
		}
		pq.calculate();
	}
}

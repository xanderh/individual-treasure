import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interact {

	public static void initialize() {
		System.out.println("Ready for input");
		System.out.println("Please format input as '<level> <amount>'");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String line = br.readLine();
				if (line.equals("quit") || line.equals("Quit") || line.equals("q")) {
					break;
				} else {
					String[] args = line.split(" ");
					if (args.length % 2 == 1) {
						System.out.println("Invalid input");
					} else {
						generate(args);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Something went wrong while reading the input from the file");
			}
		}
		System.out.println("program terminating");
	}

	public static void generate(String[] args) {
		int generated = 0;
		int results[] = new int[5];

		while (generated < args.length) {
			int result[] = Roller.Roll(Integer.parseInt(args[generated++]), Integer.parseInt(args[generated++]));
			for (int i = 0; i < results.length; i++) {
				results[i] = results[i] + result[i];
			}
		}
		System.out.println(results[0] + " copper, " + results[1] + " silver, " + results[2] + " electrum, " + results[3] + " gold, " + results[4] + " platinum.");
	}

}

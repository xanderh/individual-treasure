
public class Interact {

	public static void initialize() {
		// TODO Auto-generated method stub

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


public class Main {

	public static void main(String[] args) {
		if(args.length == 0) {
			InteractGUI.initialize();
		} else if (args[0].equals("-nogui")) {
			Interact.initialize();
		} else if (args.length % 2 == 0) {
			Interact.generate(args);
		} else if (args[0].equals("help")) {
			help();
		} else {
			System.out.println("badly formed argument, program closing");
		}

	}
	
	public static void help() {
		System.out.println("This program is designed for easily generating treasure found on random enemies in D&D 5e.");
		System.out.println("Run the program without arguments for a GUI");
		System.out.println("Run the program with the -nogui argument to get a command-line prompt");
		System.out.println("Run the program with an arbitrary amount of pairs of arguments to receive a single "
				+ "generated total amount. These pairs must be the level of the enemy, followed by the amount");
	}

}

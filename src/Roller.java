import java.util.Random;

public class Roller {
	public static int[] Roll(int level, int amount) {
		if (level <= 4) {
			return Tier1(amount);
		} else if (level <= 10) {
			return Tier2(amount);
		} else if (level <= 16) {
			return Tier3(amount);
		} else {
			return Tier4(amount);
		}
	}

	private static int[] Tier1(int amount) {
		int[] result = new int[5];
		Random random = new Random();
		for (int i = 0; i < amount; i++) {
			int number = random.nextInt(100) + 1;
			if (number <= 30) {
				result[0] = result[0] + d6(5);
			} else if (number <= 60) {
				result[1] = result[1] + d6(4);
			} else if (number <= 70) {
				result[2] = result[2] + d6(3);
			} else if (number <= 95) {
				result[3] = result[3] + d6(3);
			} else {
				result[4] = result[4] + d6(1);
			}
		}
		return result;
	}

	private static int[] Tier2(int amount) {
		int[] result = new int[5];
		Random random = new Random();
		for (int i = 0; i < amount; i++) {
			int number = random.nextInt(100) + 1;
			if (number <= 30) {
				result[0] = result[0] + (d6(4)*100);
				result[2] = result[2] + (d6(1)*10);
			} else if (number <= 60) {
				result[1] = result[1] + (d6(6)*10);
				result[3] = result[3] + (d6(2)*10);
			} else if (number <= 70) {
				result[2] = result[2] + (d6(3)*10);
				result[3] = result[3] + (d6(2)*10);
			} else if (number <= 95) {
				result[3] = result[3] + (d6(4)*10);
			} else {
				result[3] = result[3] + (d6(2)*10);
				result[4] = result[4] + d6(3);
			}
		}
		return result;
	}

	private static int[] Tier3(int amount) {
		int[] result = new int[5];
		Random random = new Random();
		for (int i = 0; i < amount; i++) {
			int number = random.nextInt(100) + 1;
			if (number <= 20) {
				result[1] = result[1] + (d6(4)*100);
				result[3] = result[3] + (d6(1)*100);
			} else if (number <= 35) {
				result[2] = result[2] + (d6(1)*100);
				result[3] = result[3] + (d6(1)*100);
			} else if (number <= 75) {
				result[3] = result[3] + (d6(2)*100);
				result[4] = result[4] + (d6(1)*10);
			} else {
				result[3] = result[3] + (d6(2)*100);
				result[4] = result[4] + (d6(2)*10);
			}
		}
		return result;
	}

	private static int[] Tier4(int amount) {
		int[] result = new int[5];
		Random random = new Random();
		for (int i = 0; i < amount; i++) {
			int number = random.nextInt(100) + 1;
			if (number <= 15) {
				result[2] = result[2] + (d6(2)*1000);
				result[3] = result[3] + (d6(8)*100);
			} else if (number <= 55) {
				result[3] = result[3] + (d6(1)*1000);
				result[4] = result[4] + (d6(1)*100);
			} else {
				result[3] = result[3] + (d6(1)*1000);
				result[4] = result[4] + (d6(2)*100);
			}
		}
		return result;
	}
	
	private static int d6(int times) {
		int result = 0;
		Random rn = new Random();
		while (times > 0) {
			result = result + rn.nextInt(6) + 1;
			times--;
		}
		return result;
		
		
	}
}

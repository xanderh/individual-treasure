import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InteractGUI {

	static JFrame frame = new JFrame("Individual Treasure");
	static JLabel[] optionLabels = new JLabel[4];
	static JTextField[] options = new JTextField[4];
	static JLabel[] outputLabels = new JLabel[5];
	static JTextField[] output = new JTextField[5];
	static JButton reset = new JButton("Reset");
	static JButton roll = new JButton("Roll!");

	// Fonts
	static Font smallFont = new Font("Calibri", Font.PLAIN, 12);

	static int height = 210;
	
	public static void initialize() {
		frame.setSize(400, height);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(0, 0, 400, height);
		panel.setLayout(null);
		frame.add(panel);

		// vertical 10-45
		reset.setBounds(10, 10, 375, 25);
		reset.setVisible(true);
		panel.add(reset);

		String[] labels = new String[4];
		labels[0] = "0-4";
		labels[1] = "5-10";
		labels[2] = "11-16";
		labels[3] = "17-20";

		for (int i = 0; i < optionLabels.length; i++) {
			optionLabels[i] = new JLabel(labels[i]);
			int x = i * 95 + 10;
			if (i == 0) {
				x = 10;
			}
			// vertical 45-60
			optionLabels[i].setBounds(x, 45, 90, 15);
			optionLabels[i].setHorizontalAlignment(JLabel.CENTER);
			optionLabels[i].setFont(smallFont);
			optionLabels[i].setVisible(true);
			panel.add(optionLabels[i]);
		}

		for (int i = 0; i < options.length; i++) {
			options[i] = new JTextField("0");
			int x = i * 95 + 10;
			if (i == 0) {
				x = 10;
			}
			// vertical 60-85
			options[i].setBounds(x, 60, 90, 25);
			options[i].setHorizontalAlignment(JTextField.LEFT);
			options[i].setEditable(true);
			options[i].setVisible(true);
			panel.add(options[i]);
		}

		// vertical 95-120
		roll.setBounds(10, 95, 375, 25);
		roll.setVisible(true);
		panel.add(roll);

		String[] oLabels = new String[5];
		oLabels[0] = "Copper";
		oLabels[1] = "Silver";
		oLabels[2] = "Electrum";
		oLabels[3] = "Gold";
		oLabels[4] = "Platinum";
		
		
		
		for (int i = 0; i < outputLabels.length; i++) {
			outputLabels[i] = new JLabel(oLabels[i]);
			int x = i * 75 + 10;
			if (i == 0) {
				x = 10;
			}
			// vertical 130-145
			outputLabels[i].setBounds(x, 130, 70, 15);
			outputLabels[i].setHorizontalAlignment(JLabel.CENTER);
			outputLabels[i].setFont(smallFont);
			outputLabels[i].setVisible(true);
			panel.add(outputLabels[i]);
		}

		for (int i = 0; i < output.length; i++) {
			output[i] = new JTextField();
			int x = i * 76 + 10;
			if (i == 0) {
				x = 10;
			}
			// vertical 145-170
			output[i].setBounds(x, 145, 70, 25);
			output[i].setHorizontalAlignment(JTextField.LEFT);
			output[i].setEditable(false);
			output[i].setVisible(true);
			panel.add(output[i]);
		}
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		}); 
		roll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				roll();
			}
		}); 
		
		
		
		frame.setVisible(true);

	}
	
	private static void reset() {
		for (int i = 0; i < options.length; i++) {
			options[i].setText("0");
		}
	}
	
	private static void roll() {
		int results[] = new int[5];
		int result[][] = new int[4][5];
		for (int i = 0; i < options.length; i++) {
			if (options[i].getText().equals("") || !isInt(options[i].getText())) {
				options[i].setText("0");
			}
		}
		result[0] = Roller.Roll(1, Integer.parseInt(options[0].getText()));
		result[1] = Roller.Roll(5, Integer.parseInt(options[1].getText()));
		result[2] = Roller.Roll(11, Integer.parseInt(options[2].getText()));
		result[3] = Roller.Roll(17, Integer.parseInt(options[3].getText()));
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < results.length; j++) {
				results[j] = results[j] + result[i][j];
			}
		}
		for (int i = 0; i < results.length; i++) {
			output[i].setText("" + results[i]);
		}
	}
	
	private static boolean isInt(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

}

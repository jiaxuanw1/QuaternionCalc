import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame;
	private JLabel label1;
	private JLabel r1, i1, j1, k1;
	private JTextField a1, b1, c1, d1;
	private JLabel label2;
	private JLabel r2, i2, j2, k2;
	private JTextField a2, b2, c2, d2;
	private JRadioButton add, subtract, multiply, divide;
	private ButtonGroup group;
	private JButton calc;
	private JTextArea calculations;
	private Quaternion q1, q2;
	private boolean twoInputs;
	private String output;

	public GUI() {
		initialize();
	}

	private void initialize() {
		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// First quaternion field
		label1 = new JLabel("Quaternion q1:");
		label1.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(label1);

		a1 = new JTextField();
		a1.setBounds(10, 33, 86, 20);
		frame.getContentPane().add(a1);
		a1.setColumns(10);

		r1 = new JLabel("    +");
		r1.setBounds(100, 36, 27, 14);
		frame.getContentPane().add(r1);

		b1 = new JTextField();
		b1.setColumns(10);
		b1.setBounds(137, 33, 86, 20);
		frame.getContentPane().add(b1);

		i1 = new JLabel("i     +");
		i1.setBounds(227, 36, 35, 14);
		frame.getContentPane().add(i1);

		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(272, 33, 86, 20);
		frame.getContentPane().add(c1);

		j1 = new JLabel("j     +");
		j1.setBounds(362, 36, 35, 14);
		frame.getContentPane().add(j1);

		d1 = new JTextField();
		d1.setColumns(10);
		d1.setBounds(407, 33, 86, 20);
		frame.getContentPane().add(d1);

		k1 = new JLabel("k");
		k1.setBounds(497, 36, 35, 14);
		frame.getContentPane().add(k1);

		// Second quaternion field
		label2 = new JLabel("Quaternion q2:");
		label2.setBounds(10, 64, 86, 14);
		frame.getContentPane().add(label2);

		a2 = new JTextField();
		a2.setColumns(10);
		a2.setBounds(10, 86, 86, 20);
		frame.getContentPane().add(a2);

		r2 = new JLabel("    +");
		r2.setBounds(100, 89, 27, 14);
		frame.getContentPane().add(r2);

		b2 = new JTextField();
		b2.setColumns(10);
		b2.setBounds(137, 86, 86, 20);
		frame.getContentPane().add(b2);

		i2 = new JLabel("i     +");
		i2.setBounds(227, 89, 35, 14);
		frame.getContentPane().add(i2);

		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(272, 86, 86, 20);
		frame.getContentPane().add(c2);

		j2 = new JLabel("j     +");
		j2.setBounds(362, 89, 35, 14);
		frame.getContentPane().add(j2);

		d2 = new JTextField();
		d2.setColumns(10);
		d2.setBounds(407, 86, 86, 20);
		frame.getContentPane().add(d2);

		k2 = new JLabel("k");
		k2.setBounds(497, 89, 35, 14);
		frame.getContentPane().add(k2);

		// Operation chooser
		add = new JRadioButton("Add");
		add.setBounds(10, 124, 77, 23);
		frame.getContentPane().add(add);

		subtract = new JRadioButton("Subtract");
		subtract.setBounds(10, 150, 77, 23);
		frame.getContentPane().add(subtract);

		multiply = new JRadioButton("Multiply");
		multiply.setBounds(10, 176, 77, 23);
		frame.getContentPane().add(multiply);

		divide = new JRadioButton("Divide");
		divide.setBounds(10, 202, 77, 23);
		frame.getContentPane().add(divide);

		group = new ButtonGroup();
		group.add(add);
		group.add(subtract);
		group.add(multiply);
		group.add(divide);

		// Calculate button
		calc = new JButton("Calculate");
		calc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// Detect whether the user has inputted two quaternions
				try {
					double z = Double.parseDouble(a2.getText()) + Double.parseDouble(b2.getText())
							+ Double.parseDouble(c2.getText()) + Double.parseDouble(d2.getText());
					twoInputs = true;
				} catch (Exception e) {
					twoInputs = false;
				}

				if (twoInputs) {
					if (add.isSelected()) {
						try {
							double aVal1 = Double.parseDouble(a1.getText());
							double bVal1 = Double.parseDouble(b1.getText());
							double cVal1 = Double.parseDouble(c1.getText());
							double dVal1 = Double.parseDouble(d1.getText());
							q1 = new Quaternion(aVal1, bVal1, cVal1, dVal1);

							double aVal2 = Double.parseDouble(a2.getText());
							double bVal2 = Double.parseDouble(b2.getText());
							double cVal2 = Double.parseDouble(c2.getText());
							double dVal2 = Double.parseDouble(d2.getText());
							q2 = new Quaternion(aVal2, bVal2, cVal2, dVal2);

							output = "q1 + q2 = \r\n\r\n" + q1.add(q2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter two valid quaternions.");
						}
					} else if (subtract.isSelected()) {
						try {
							double aVal1 = Double.parseDouble(a1.getText());
							double bVal1 = Double.parseDouble(b1.getText());
							double cVal1 = Double.parseDouble(c1.getText());
							double dVal1 = Double.parseDouble(d1.getText());
							q1 = new Quaternion(aVal1, bVal1, cVal1, dVal1);

							double aVal2 = Double.parseDouble(a2.getText());
							double bVal2 = Double.parseDouble(b2.getText());
							double cVal2 = Double.parseDouble(c2.getText());
							double dVal2 = Double.parseDouble(d2.getText());
							q2 = new Quaternion(aVal2, bVal2, cVal2, dVal2);

							output = "q1 - q2 = \r\n\r\n" + q1.subtract(q2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter two valid quaternions.");
						}
					} else if (multiply.isSelected()) {
						try {
							double aVal1 = Double.parseDouble(a1.getText());
							double bVal1 = Double.parseDouble(b1.getText());
							double cVal1 = Double.parseDouble(c1.getText());
							double dVal1 = Double.parseDouble(d1.getText());
							q1 = new Quaternion(aVal1, bVal1, cVal1, dVal1);

							double aVal2 = Double.parseDouble(a2.getText());
							double bVal2 = Double.parseDouble(b2.getText());
							double cVal2 = Double.parseDouble(c2.getText());
							double dVal2 = Double.parseDouble(d2.getText());
							q2 = new Quaternion(aVal2, bVal2, cVal2, dVal2);

							output = "q1 * q2 = \r\n\r\n" + q1.multiply(q2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter two valid quaternions.");
						}
					} else if (divide.isSelected()) {
						try {
							double aVal1 = Double.parseDouble(a1.getText());
							double bVal1 = Double.parseDouble(b1.getText());
							double cVal1 = Double.parseDouble(c1.getText());
							double dVal1 = Double.parseDouble(d1.getText());
							q1 = new Quaternion(aVal1, bVal1, cVal1, dVal1);

							double aVal2 = Double.parseDouble(a2.getText());
							double bVal2 = Double.parseDouble(b2.getText());
							double cVal2 = Double.parseDouble(c2.getText());
							double dVal2 = Double.parseDouble(d2.getText());
							q2 = new Quaternion(aVal2, bVal2, cVal2, dVal2);

							output = "q1 / q2 = \r\n\r\n" + q1.divide(q2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter two valid quaternions.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please select a mathematical operation.");
					}
				} else {
					try {
						double aVal = Double.parseDouble(a1.getText());
						double bVal = Double.parseDouble(b1.getText());
						double cVal = Double.parseDouble(c1.getText());
						double dVal = Double.parseDouble(d1.getText());
						q1 = new Quaternion(aVal, bVal, cVal, dVal);

						output = "Conjugate: " + q1.getConjugate() + "\r\n\r\nInverse: " + q1.getInverse()
								+ "\r\n\r\nNorm: " + q1.getNorm();
						JOptionPane.showMessageDialog(null, output);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Please enter a valid quaternion");
					}
				}
			}
		});
		calc.setBounds(10, 232, 89, 23);
		frame.getContentPane().add(calc);

		frame.setVisible(true);
	}

}

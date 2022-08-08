import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test11 extends JPanel {
	JTextField tf;
	JTextArea ta;
	JPanel p;
	JButton a, b;

	Test11() {
		setLayout(new BorderLayout());

		tf = new JTextField();
		tf.setPreferredSize(new Dimension(600, 30));
		ta = new JTextArea();
		ta.setPreferredSize(new Dimension(600, 300));
		ta.setEditable(false);
		p = new JPanel();
		a = new JButton("UpperCase");
		b = new JButton("LowerCase");

		p.add(a);
		p.add(b);
		add(BorderLayout.NORTH, tf);
		add(BorderLayout.CENTER, ta);
		add(BorderLayout.SOUTH, p);

		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText() );
				tf.setText("");
			}
		});

		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tf.getText();
				String s1 = s.toUpperCase();
				ta.append(tf.getText() + "\n" );
				ta.setText(s1);
			}
		});

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tf.getText();
				String s2 = s.toLowerCase();
				ta.append(tf.getText() );
				ta.setText("\n" + s2);
			}
		});
	}
}

public class Test1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Arslan Javkhlan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//x button
		frame.add(new Test11());
		frame.pack();
		frame.setVisible(true);
	}
}

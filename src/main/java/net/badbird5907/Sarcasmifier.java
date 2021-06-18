package net.badbird5907;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.UIManager.setLookAndFeel;
import static java.awt.BorderLayout.CENTER;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.System.out;

public class Sarcasmifier implements ActionListener {
	JTextField input;
	
//	why lol
	public static void main(String[] args) {
		new Sarcasmifier();
	}

	public Sarcasmifier() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		input = new JTextField(10);
		input.setText("Text");
		JButton button = new JButton("Submit");
		button.addActionListener(this);
		panel.add(input);
		panel.add(button);
		frame.add(panel, CENTER);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Sarcasmifier");
//		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			setLookAndFeel(getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		frame.pack();
		frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("submit")) {
			String text = sarcasmify(input.getText());
			System.out.println(text);
			Clipboard clipboard = getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(text), null);
			showMessageDialog(null, "Copied to clipboard:\n" + text);
		}
	}

	public static String sarcasmify(String input){
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (char c : input.toCharArray()) {
			i++;
			String s = Character.toString(c);
			out.println(s);
			if ((i & 1) == 0) sb.append(s.toUpperCase());
			else sb.append(s.toLowerCase());
		}
		return sb.toString();
	}
}

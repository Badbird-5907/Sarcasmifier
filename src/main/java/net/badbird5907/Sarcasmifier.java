package net.badbird5907;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;

public class Sarcasmifier implements ActionListener {
    //why lol
    public static void main(String[] args) {
        new Sarcasmifier();
    }
    JTextField input;
    public Sarcasmifier(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        input = new JTextField(10);
        input.setText("Text");
        JButton button = new JButton("Submit");
        button.addActionListener(this);
        panel.add(input);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sarcasmifier");
        //JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equalsIgnoreCase("submit")){
            String text = sarcasmify(input.getText());
            System.out.println(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(text), null);
            JOptionPane.showMessageDialog(null, "Copied to clipboard:\n" + text);
        }
    }
    public static String sarcasmify(String input){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            i++;
            String s = Character.toString(c);
            System.out.println(s);
            if ( (i & 1) == 0 ) {
                sb.append(s.toUpperCase());
            } else {
                sb.append(s.toLowerCase());
            }

        }
        return sb.toString();
    }
}

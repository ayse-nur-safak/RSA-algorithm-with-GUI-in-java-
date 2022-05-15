import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Text extends JFrame{
    private JLabel intro;
    private JTextArea text;
    private JButton encbutton;
    private JButton decbutton;
    private JButton clear;
    private JScrollPane scroller;
    private JPanel headerPnl;
    private JPanel PnlText;
    private JPanel act;

    public Text(String cmd) {
        setTitle("RSA Public-Key Cryptosystem");
        setSize(500,290);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        comps();
        if (cmd.equals("decrypt"))
            act.add(decbutton);
        else
            act.add(encbutton);
        act.add(clear);
        style();
        add(PnlText, BorderLayout.CENTER);
        add(headerPnl, BorderLayout.NORTH);
        add(act, BorderLayout.SOUTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void comps() {
        intro = new JLabel("<html><p style='margin: 10px 0px 20px text-align: center; font-size: 14px;'>"
                + "Enter your text which you <br>" + "want to encrypt/decrypt below</p></html>");

        text = new JTextArea(10, 35);
        clear = new JButton("Clear");
        encbutton = new JButton("Encryption");
        decbutton = new JButton("Decryption");
        clear.addActionListener(new ClearListener());
        encbutton.addActionListener(new EncButtonListener());
        decbutton.addActionListener(new DecButtonListener());
        scroller = new JScrollPane(text);
        headerPnl = new JPanel();
        PnlText = new JPanel();
        act = new JPanel();
        headerPnl.add(intro);
        PnlText.add(scroller);
    }
    private void style() {
        headerPnl.setBackground(Color.pink);
        intro.setFont(new Font("Monospaced", Font.BOLD, 17));
        PnlText.setBackground(Color.lightGray);
        text.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        act.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        act.setBackground(Color.lightGray);
        clear.setFont(new Font("Monospaced", Font.BOLD, 14));
        clear.setBackground(Color.white);
        encbutton.setFont(new Font("Monospaced", Font.BOLD, 14));
        encbutton.setBackground(Color.white);
        decbutton.setFont(new Font("Monospaced", Font.BOLD, 14));
        decbutton.setBackground(Color.white);
    }
    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("");
        }
    }
    private class EncButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Results("encrypt", RSA.encrypt(text.getText()));
        }
    }
    private class DecButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Results("decrypt", RSA.decrypt(text.getText()));
        }
    }

}
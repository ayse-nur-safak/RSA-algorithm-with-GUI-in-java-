import java.awt.*;
import javax.swing.*;


public class Results extends JFrame {
    private JPanel top;
    private JPanel center;
    private JScrollPane scroller;

    private JLabel header;
    private JTextArea result;

    /**
     *  cmd controls the text to be displayed.
     *  rslt  Encrypted / decrypted text.
     */
    public Results(String cmd, String rslt) {
        setTitle("RSA Public-Key Cryptosystem");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        if (cmd.equals("encrypt"))
            header = new JLabel("<html><p style='margin: 10px 0px 20px text-align: center;'>"
                    + "Encrypted text</p></html");
        else
            header = new JLabel("<html><p style='margin: 10px 0px 20px text-align: center;'>"
                    + "Decrypted text</p></html");
        result = new JTextArea(10, 35);
        top = new JPanel();
        center = new JPanel();
        scroller = new JScrollPane(result);
        top.setBackground(Color.pink);
        header.setFont(new Font("Monospaced", Font.BOLD, 17));
        center.setBackground(Color.lightGray);
        result.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        result.setText(rslt);
        top.add(header);
        center.add(scroller);
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        setSize(500,290);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

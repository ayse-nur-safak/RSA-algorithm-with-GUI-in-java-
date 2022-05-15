import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class Panel extends JFrame {
    private JPanel Intro;
    private JPanel NextButton;
    private JPanel EncDec;
    private JPanel Type;
    private JLabel intro;
    private JRadioButton encOpt;
    private JRadioButton decOpt;
    private JRadioButton textorparagraph;
    private JButton nextButton;
    public Panel() {
        setTitle("RSA Public-Key Cryptosystem");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panels();
        styleOfPanels();
        setLayout(new FlowLayout());
        add(Intro);
        add(EncDec);
        add(Type);
        add(NextButton);
        setSize(600,240);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        new KeyGenerator();
    }
    private void Panels() {
        String str = "<html><p style='margin: 10px 0px 20px 0px; text-align: center;'>"
                + "Do you want encrypt or decrypt a text?<br>"
                + "Please select one of them and then press the next</p></html>";
        intro = new JLabel(str);
        encOpt = new JRadioButton("Encryption", true);
        decOpt = new JRadioButton("Decryption");
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(encOpt);
        buttons.add(decOpt);
        textorparagraph = new JRadioButton("Text or Paragraph", true);
        ButtonGroup buttons2 = new ButtonGroup();
        buttons2.add(textorparagraph);
        nextButton = new JButton("Next");
        nextButton.addActionListener(NextListener);
        Intro = new JPanel();
        EncDec = new JPanel();
        Type = new JPanel();
        NextButton = new JPanel();
        Intro.add(intro);
        EncDec.add(encOpt);
        EncDec.add(decOpt);
        Type.add(textorparagraph);
        NextButton.add(nextButton);
    }
    private void styleOfPanels() {
        intro.setFont(new Font("Monospaced", Font.BOLD, 17));
        intro.setForeground(Color.white);
        Dimension dim = new Dimension(200,80);
        Intro.setBackground(Color.darkGray);
        Type.setPreferredSize(dim);
        Type.setLayout(new GridLayout(2,1));
        Type.setBorder(BorderFactory.createTitledBorder(null, "Type", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP,new Font("Monospaced", Font.BOLD, 17) ));
        textorparagraph.setFont(new Font("Monospaced", Font.ITALIC, 14));
        Type.setBackground(Color.PINK);
        textorparagraph.setBackground(Color.pink);
        EncDec.setPreferredSize(dim);
        EncDec.setLayout(new GridLayout(2,1));
        EncDec.setBorder(BorderFactory.createTitledBorder(null, "Action", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP,new Font("Monospaced", Font.BOLD, 17) ));
        encOpt.setFont(new Font("Monospaced", Font.ITALIC, 14));
        decOpt.setFont(new Font("Monospaced", Font.ITALIC, 14));
        EncDec.setBackground(Color.pink);
        encOpt.setBackground(Color.pink);
        decOpt.setBackground(Color.pink);
        nextButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        nextButton.setBackground(Color.white);
        NextButton.setBackground(Color.white);
    }
    ActionListener NextListener = event -> {
        if (encOpt.isSelected()) {
            if (textorparagraph.isSelected())   {
                new Text("encrypt");}
        }
        else {
            if (textorparagraph.isSelected()) {
                new Text("decrypt");}}
    };
    public static void main(String [] args) {
        new Panel();
    }
}
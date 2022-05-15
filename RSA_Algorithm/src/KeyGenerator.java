import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.math.BigInteger;

public class KeyGenerator extends JFrame {
    private JPanel panel1;
    private JPanel panel2;

    private JLabel str;
    private JButton newkey;
    private JButton extkey;
    /*
    *p and q are random prime numbers
    * N=p*q
    * encry -> encryption, It is used for public key
    * d = decryption. Used fot private key
    * lenOfBit -> length of bit, it is used in BigInteger prime generator
     */
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phiOfN;
    private BigInteger encryp;
    private BigInteger decryp;
    private int lenOfBit = 1024;
    private static Random r = new Random();
    public KeyGenerator() {
        setTitle("RSA Public-Key Cryptosystem");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        panelsOfGenerator();
        panelStyle();
        add(panel1);
        add(panel2);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void panelsOfGenerator() {
        str = new JLabel("<html><p style='margin: 5px 5px 15px 5px; font-size: 12px;'>"
                + " Do you want to use existing keys or create new keys?<br>" + "Note: If you did not create any keys before,<br>"+ " please choose new keys.</p></html>");
        newkey = new JButton("Generate New Keys");
        newkey.addActionListener(new KeyButtonListener());
        extkey = new JButton("Use Existing Keys");
        extkey.addActionListener(new KeyButtonListener());
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.add(str);
        panel2.add(newkey);
        panel2.add(extkey);
    }
    public void panelStyle(){
        panel1.setBackground(Color.white);
        str.setFont(new Font("Monospaced", Font.BOLD, 12));
        panel2.setBackground(Color.pink);
        newkey.setFont(new Font("Monospaced", Font.BOLD, 14));
        newkey.setBackground(Color.lightGray);
        extkey.setFont(new Font("Monospaced", Font.BOLD, 14));
        extkey.setBackground(Color.lightGray);
    }

    private void generateKeys() {
        r = new Random();
        p = BigInteger.probablePrime(lenOfBit, r);
        q = BigInteger.probablePrime(lenOfBit, r);
        N = p.multiply(q);
        phiOfN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        encryp = BigInteger.probablePrime(lenOfBit / 2, r);
        while (phiOfN.gcd(encryp).compareTo(BigInteger.ONE) > 0 && encryp.compareTo(phiOfN) < 0) {
            encryp.add(BigInteger.ONE);
        }
        decryp = encryp.modInverse(phiOfN);
    }
    private class KeyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                if (event.getSource() == newkey) {
                    generateKeys();
                    PrintWriter publicKeys = new PrintWriter("public_keys.txt");
                    PrintWriter privateKeys = new PrintWriter("private_keys.txt");
                    publicKeys.println(encryp);
                    publicKeys.println(N);
                    privateKeys.println(decryp);
                    privateKeys.println(N);
                    publicKeys.close();
                    privateKeys.close();
                    JOptionPane.showMessageDialog(null, "Public and private keys were created.");
                }

                setVisible(false);
            }
            catch(IOException ex) {
                JOptionPane.showMessageDialog(null, "Error!!");
            }
        }

    }

}
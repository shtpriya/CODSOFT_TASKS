import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM_Interface extends JFrame {

    private int pin;
    private float balance;
    private boolean pinVerified;
    private JLabel title, balancelabel, l1;
    private JTextField field;
    private JButton verify, check, withdraw, deposit;

    public ATM_Interface() {
        setTitle("Task 3");
        setSize(380, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);

        pin = 12345;
        balance = 50000.0f;
        pinVerified = false;

        title = new JLabel("ATM INTERFACE");
        title.setBounds(50, 50, 300, 50);
        title.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.WHITE);

        balancelabel = new JLabel("");
        balancelabel.setBounds(50, 150, 300, 50);
        balancelabel.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        balancelabel.setHorizontalAlignment(balancelabel.CENTER);
        balancelabel.setForeground(Color.blue);

        l1 = new JLabel("Enter PIN :");
        l1.setBounds(50, 100, 50, 30);
        l1.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        l1.setForeground(Color.white);

        field = new JTextField(5);
        field.setBounds(50, 150, 50, 20);
        field.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));

        verify = new JButton("Verify PIN ");
        verify.setBounds(30, 250, 50, 30);
        verify.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        verify.setBackground(Color.blue);
        verify.setForeground(Color.WHITE);

        check = new JButton("Check balance");
        check.setBounds(80, 250, 50, 30);
        check.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        check.setBackground(Color.black);
        check.setForeground(Color.white);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(150, 250, 100, 30);
        withdraw.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        withdraw.setBackground(Color.blue);
        withdraw.setForeground(Color.WHITE);

        deposit = new JButton("Deposit");
        deposit.setBounds(80, 350, 50, 30);
        deposit.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.WHITE);

        verify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int entry_pin = Integer.parseInt(field.getText());
                if (entry_pin == pin) {
                    pinVerified = true;
                    verify.setEnabled(true);
                    withdraw.setEnabled(true);
                    deposit.setEnabled(true);
                    check.setEnabled(true);
                    JOptionPane.showMessageDialog(ATM_Interface.this, "PIN verified!");
                } else {
                    JOptionPane.showMessageDialog(ATM_Interface.this, "Invalid PIN!");
                }
            }
        });

        check.setEnabled(false);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int entry_pin = Integer.parseInt(field.getText());
                if (entry_pin == pin) {
                    pinVerified = true;
                    verify.setEnabled(true);
                    withdraw.setEnabled(true);
                    deposit.setEnabled(true);
                    check.setEnabled(true);
                    JOptionPane.showMessageDialog(ATM_Interface.this, "Current Balance : Rs " + balance);
                } else {
                    JOptionPane.showMessageDialog(ATM_Interface.this, "Invalid PIN!");
                }
                field.setText("");
            }
        });

        withdraw.setEnabled(false);
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = JOptionPane.showInputDialog(ATM_Interface.this, "Enter amount to Withdraw");
                float amt = Float.parseFloat(amount);
                if (amt <= balance) {
                    balance -= amt;
                    balancelabel.setText("Remaining Balance: Rs " + balance);
                    JOptionPane.showMessageDialog(ATM_Interface.this, "Withdrawal Successful");
                } else {
                    JOptionPane.showMessageDialog(ATM_Interface.this, "Insufficient balance");
                }
                field.setText("");
            }
        });

        deposit.setEnabled(false);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = JOptionPane.showInputDialog(ATM_Interface.this, "Enter amount to deposit :");
                float amt = Float.parseFloat(amount);
                balance += amt;
                balancelabel.setText("New Balance: Rs " + balance);
                JOptionPane.showMessageDialog(ATM_Interface.this, "Deposit Successful ");
            }
        });

        getContentPane().setLayout(new GridLayout(0, 1));
        getContentPane().add(title);
        getContentPane().add(balancelabel);
        getContentPane().add(l1);
        getContentPane().add(field);
        getContentPane().add(verify);
        getContentPane().add(check);
        getContentPane().add(withdraw);
        getContentPane().add(deposit);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ATM_Interface atm = new ATM_Interface();
                atm.setVisible(true);
            }
        });
    }
}

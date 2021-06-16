package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmSupFindSup extends JFrame {

    private JPanel contentPane;
    private JTextField txtPeople;
    private JTextField txtTel;
    private JTextField txtAdress;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmSupFindSup frame = new FrmSupFindSup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmSupFindSup() {
        setVisible(true);
        setTitle("供货商查找");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("供货商名称：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setBounds(33, 30, 120, 21);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("联系人：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(33, 81, 120, 21);
        panel.add(label);

        JLabel label_1 = new JLabel("联系电话：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(33, 137, 120, 21);
        panel.add(label_1);

        JLabel label_2 = new JLabel("联系地址：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(33, 189, 120, 21);
        panel.add(label_2);

        txtPeople = new JTextField();
        txtPeople.setFont(new Font("宋体", Font.PLAIN, 20));
        txtPeople.setColumns(10);
        txtPeople.setBounds(168, 78, 202, 27);
        panel.add(txtPeople);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        txtTel.setBounds(168, 134, 202, 27);
        panel.add(txtTel);

        txtAdress = new JTextField();
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        txtAdress.setColumns(10);
        txtAdress.setBounds(168, 186, 202, 27);
        panel.add(txtAdress);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setBounds(48, 243, 123, 29);
        panel.add(btnSure);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setBounds(221, 243, 123, 29);
        panel.add(btnEsc);

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团"}));
        comboBox.setBounds(168, 27, 202, 27);
        panel.add(comboBox);
        setLocationRelativeTo(null);
    }

}

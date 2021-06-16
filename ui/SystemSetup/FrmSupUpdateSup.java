package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmSupUpdateSup extends JFrame {

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
                    FrmSupUpdateSup frame = new FrmSupUpdateSup();
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
    public FrmSupUpdateSup() {
        setVisible(true);
        setTitle("修改供货商");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 549, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("供货商名称：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setBounds(33, 28, 128, 21);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("联系人：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(33, 76, 128, 21);
        panel.add(label);

        JLabel label_1 = new JLabel("联系电话：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(33, 119, 128, 21);
        panel.add(label_1);

        JLabel label_3 = new JLabel("联系地址：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(33, 169, 128, 21);
        panel.add(label_3);

        txtPeople = new JTextField();
        txtPeople.setFont(new Font("宋体", Font.PLAIN, 20));
        txtPeople.setColumns(10);
        txtPeople.setBounds(160, 72, 321, 27);
        panel.add(txtPeople);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        txtTel.setBounds(160, 115, 321, 27);
        panel.add(txtTel);

        txtAdress = new JTextField();
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        txtAdress.setColumns(10);
        txtAdress.setBounds(160, 169, 321, 27);
        panel.add(txtAdress);

        JLabel label_4 = new JLabel("备注：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        label_4.setBounds(33, 226, 128, 21);
        panel.add(label_4);

        JTextArea txtBz = new JTextArea();
        txtBz.setFont(new Font("Monospaced", Font.PLAIN, 20));
        txtBz.setBounds(160, 237, 321, 111);
        panel.add(txtBz);

        JCheckBox chckbxNewCheckBox = new JCheckBox("默认供货商");
        chckbxNewCheckBox.setSelected(true);
        chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 20));
        chckbxNewCheckBox.setBounds(160, 380, 142, 29);
        panel.add(chckbxNewCheckBox);

        JButton btnSave = new JButton("保存(F5)");
        btnSave.setFocusPainted(false);
        btnSave.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSave.setBackground(new Color(135, 206, 250));
        btnSave.setBounds(82, 446, 123, 29);
        panel.add(btnSave);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setBounds(322, 446, 123, 29);
        panel.add(btnEsc);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团"}));
        comboBox.setBounds(160, 25, 321, 27);
        panel.add(comboBox);
    }

}

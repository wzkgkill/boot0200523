package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmEmpUpdateEmp extends JFrame {

    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtTel;
    private JTextField txtAdress;
    private JTextField txtBz;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmEmpUpdateEmp frame = new FrmEmpUpdateEmp();
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
    public FrmEmpUpdateEmp() {
        setVisible(true);
        setTitle("修改员工");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 438);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("员工姓名：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setBounds(15, 15, 101, 21);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("所任职务：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(15, 57, 101, 21);
        panel.add(label);

        JLabel label_1 = new JLabel("联系电话：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(15, 104, 101, 21);
        panel.add(label_1);

        JLabel label_2 = new JLabel("联系地址：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(15, 157, 101, 21);
        panel.add(label_2);

        JLabel label_3 = new JLabel("备注：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(15, 210, 101, 21);
        panel.add(label_3);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setBounds(124, 12, 176, 27);
        panel.add(txtName);
        txtName.setColumns(10);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        txtTel.setBounds(124, 104, 176, 27);
        panel.add(txtTel);

        txtAdress = new JTextField();
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        txtAdress.setColumns(10);
        txtAdress.setBounds(124, 154, 251, 27);
        panel.add(txtAdress);

        txtBz = new JTextField();
        txtBz.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBz.setColumns(10);
        txtBz.setBounds(124, 210, 251, 27);
        panel.add(txtBz);

        JCheckBox chckbxNewCheckBox = new JCheckBox("采购管理");
        chckbxNewCheckBox.setContentAreaFilled(false);
        chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 20));
        chckbxNewCheckBox.setBounds(15, 283, 125, 29);
        panel.add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("销售管理");
        chckbxNewCheckBox_1.setContentAreaFilled(false);
        chckbxNewCheckBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        chckbxNewCheckBox_1.setBounds(147, 283, 117, 29);
        panel.add(chckbxNewCheckBox_1);

        JCheckBox checkBox = new JCheckBox("库存管理");
        checkBox.setContentAreaFilled(false);
        checkBox.setFont(new Font("宋体", Font.PLAIN, 20));
        checkBox.setBounds(274, 283, 117, 29);
        panel.add(checkBox);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setBounds(51, 328, 123, 29);
        panel.add(btnSure);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setBounds(229, 328, 123, 29);
        panel.add(btnEsc);

        JLabel lblNewLabel_3 = new JLabel("业务权限：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(15, 251, 101, 21);
        panel.add(lblNewLabel_3);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setBackground(Color.WHITE);
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"收银员", "仓管", "采购员", "经理"}));
        comboBox.setBounds(124, 54, 176, 27);
        panel.add(comboBox);
    }

}

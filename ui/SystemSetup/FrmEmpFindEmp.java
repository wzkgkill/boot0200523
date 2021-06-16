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

public class FrmEmpFindEmp extends JFrame {

    private JPanel contentPane;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmEmpFindEmp frame = new FrmEmpFindEmp();
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
    public FrmEmpFindEmp() {
        setVisible(true);
        setTitle("员工查询");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 357);
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
        lblNewLabel.setBounds(45, 29, 111, 21);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("所任职务：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(45, 80, 111, 21);
        panel.add(label);

        JLabel label_1 = new JLabel("联系电话：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(45, 132, 111, 21);
        panel.add(label_1);

        JLabel label_2 = new JLabel("联系地址：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(45, 183, 111, 21);
        panel.add(label_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_2.setColumns(10);
        textField_2.setBounds(155, 129, 215, 27);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_3.setColumns(10);
        textField_3.setBounds(155, 180, 215, 27);
        panel.add(textField_3);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setBounds(60, 247, 123, 29);
        panel.add(btnSure);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setBounds(230, 247, 123, 29);
        panel.add(btnEsc);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"收银员", "仓管", "采购员", "经理"}));
        comboBox.setBounds(155, 77, 215, 27);
        panel.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_1.setBackground(Color.WHITE);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"小张", "小李", "小明", "小芳"}));
        comboBox_1.setBounds(155, 26, 215, 27);
        panel.add(comboBox_1);
    }

}

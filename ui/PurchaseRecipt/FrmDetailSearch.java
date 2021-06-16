package ui.PurchaseRecipt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmDetailSearch extends JFrame {

    private JPanel contentPane;
    private JTextField txtStartDate;
    private JTextField txtMoDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmDetailSearch frame = new FrmDetailSearch();
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
    public FrmDetailSearch() {
        setVisible(true);
        setTitle("查找");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 474, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("供货商：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(66, 30, 81, 21);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("开单日期：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(66, 85, 109, 21);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("至");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(66, 140, 81, 21);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("仓库名称：");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(66, 195, 100, 21);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("操作员：");
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(66, 253, 81, 21);
        panel.add(lblNewLabel_4);

        txtStartDate = new JTextField();
        txtStartDate.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        txtStartDate.setColumns(10);
        txtStartDate.setBounds(175, 81, 190, 27);
        panel.add(txtStartDate);

        txtMoDate = new JTextField();
        txtMoDate.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        txtMoDate.setColumns(10);
        txtMoDate.setBounds(175, 136, 190, 27);
        panel.add(txtMoDate);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnSure.setBounds(66, 328, 123, 29);
        panel.add(btnSure);

        JButton btnExist = new JButton("退出(F4)");
        btnExist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDetailSearch.this.dispose();

            }
        });
        btnExist.setFocusPainted(false);
        btnExist.setBackground(new Color(135, 206, 250));
        btnExist.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnExist.setBounds(242, 328, 123, 29);
        panel.add(btnExist);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团"}));
        comboBox.setBounds(175, 30, 190, 27);
        panel.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"所有仓库", "主仓库", "饮料库", "酒库"}));
        comboBox_1.setBounds(181, 193, 184, 27);
        panel.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"所有操作员", "admin", "jack", "tom"}));
        comboBox_2.setBounds(181, 251, 184, 27);
        panel.add(comboBox_2);
    }
}

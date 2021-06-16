package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmProTiaoJIa extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProTiaoJIa frame = new FrmProTiaoJIa();
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
    public FrmProTiaoJIa() {
        setVisible(true);
        setTitle("调价管理");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 756, 556);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        //panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        panel_1.setBorder(new TitledBorder(null, "商品信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_1.setBounds(15, 15, 694, 177);
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 2, 10, 15));

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("商品编号：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(textField);
        textField.setColumns(10);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel lblNewLabel_3 = new JLabel("商品名称：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(textField_3);
        textField_3.setColumns(10);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("预设进价：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_4 = new JLabel("预设售价：");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(textField_4);
        textField_4.setColumns(10);

        JPanel panel_9 = new JPanel();
        panel_1.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("商品折扣：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(lblNewLabel_2);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"0.95", "0.90", "0.85", "0.80", "0.75", "0.70", "0.60"}));
        comboBox_2.setBackground(Color.WHITE);
        comboBox_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(comboBox_2);

        JPanel panel_10 = new JPanel();
        panel_1.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JPanel panel_2 = new JPanel();
        //panel_2.setBackground(SystemColor.inactiveCaptionBorder);
        panel_2.setBorder(new TitledBorder(null, "该商品是特价商品", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_2.setBounds(15, 207, 694, 168);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel label = new JLabel("商品原价：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(1, 32, 107, 21);
        panel_2.add(label);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_5.setColumns(10);
        textField_5.setBounds(109, 29, 231, 39);
        panel_2.add(textField_5);

        JLabel label_1 = new JLabel("会员特价：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setBounds(350, 32, 100, 21);
        panel_2.add(label_1);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_6.setColumns(10);
        textField_6.setBounds(454, 29, 231, 39);
        panel_2.add(textField_6);

        JLabel label_2 = new JLabel("期限从：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        label_2.setBounds(1, 107, 107, 21);
        panel_2.add(label_2);

        JLabel label_3 = new JLabel("至：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        label_3.setBounds(350, 107, 100, 21);
        panel_2.add(label_3);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"2020-07-04"}));
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setBounds(109, 104, 231, 27);
        panel_2.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"2020-08-04"}));
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_1.setBackground(Color.WHITE);
        comboBox_1.setBounds(454, 104, 231, 27);
        panel_2.add(comboBox_1);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(15, 403, 694, 168);
        panel.add(panel_4);

        JButton btnBaoCun = new JButton("保存(F5)");
        btnBaoCun.setFocusPainted(false);
        btnBaoCun.setBackground(new Color(135, 206, 250));
        btnBaoCun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(btnBaoCun);

        Component horizontalStrut = Box.createHorizontalStrut(150);
        panel_4.add(horizontalStrut);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(btnEsc);
    }
}

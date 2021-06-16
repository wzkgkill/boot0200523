package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.DatePicker;

import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmVIPAddVIP extends JFrame {

    private JPanel contentPane;
    private JTextField textField_3;
    private JTextField textField_8;
    private JTextField txtName;
    private JTextField txtTel;
    private JTextField txtStartDate;
    private JTextField txtDownDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmVIPAddVIP frame = new FrmVIPAddVIP();
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
    public FrmVIPAddVIP() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 621, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 0, 0, 0));
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(135, 206, 250));
        btnNewButton.setFocusPainted(false);
        panel.add(btnNewButton);

        Component horizontalStrut = Box.createHorizontalStrut(80);
        panel.add(horizontalStrut);

        JButton btnNewButton_1 = new JButton("退出");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVIPAddVIP.this.dispose();
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(135, 206, 250));
        btnNewButton_1.setFocusPainted(false);
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "会员信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(10, 120));
        panel_2.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_13 = new JPanel();
        panel_3.add(panel_13, BorderLayout.NORTH);
        panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

        JLabel lblNewLabel_5 = new JLabel("备注：");
        lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_13.add(lblNewLabel_5);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new EmptyBorder(5, 5, 0, 5));
        panel_3.add(panel_14, BorderLayout.CENTER);
        panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));

        textField_8 = new JTextField();
        panel_14.add(textField_8);
        textField_8.setColumns(10);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(60, 5, 60, 5));
        panel_2.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new GridLayout(0, 2, 10, 20));

        JPanel panel_5 = new JPanel();
        panel_4.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("会员名称：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(label_2);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_5.add(txtName);

        JPanel panel_6 = new JPanel();
        panel_4.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("会员级别：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"普通会员", "中级会员", "高级会员", ""}));
        panel_6.add(comboBox);

        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("联系电话：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(label_3);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        panel_7.add(txtTel);

        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_3 = new JLabel("会员密码：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_3.setColumns(10);
        panel_8.add(textField_3);

        JPanel panel_9 = new JPanel();
        panel_4.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("加入日期：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(label_4);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtStartDate = new JTextField(df.format(System.currentTimeMillis()));
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser1.register(txtStartDate);
        //设置文本框不可编辑
        txtStartDate.setEditable(false);
        txtStartDate.setFont(new Font("宋体", Font.PLAIN, 20));
        txtStartDate.setEditable(false);
        txtStartDate.setColumns(10);
        panel_9.add(txtStartDate);

        JPanel panel_10 = new JPanel();
        panel_4.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label = new JLabel("截止日期：");

        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(label);


        Calendar calendar = Calendar.getInstance();
        //获取下个月的今天
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        txtDownDate = new JTextField(year + "-" + month + "-" + day);
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser2 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser2.register(txtDownDate);
        //设置文本框不可编辑
        txtDownDate.setEditable(false);
        txtDownDate.setFont(new Font("宋体", Font.PLAIN, 20));
        txtDownDate.setEditable(false);
        txtDownDate.setColumns(10);
        panel_10.add(txtDownDate);


    }

}

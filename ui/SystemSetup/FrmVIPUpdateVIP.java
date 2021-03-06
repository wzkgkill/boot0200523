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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmVIPUpdateVIP extends JFrame {

    private JPanel contentPane;
    private JTextField txtTel;
    private JTextField textField_3;
    private JTextField txtName;
    private JTextField txtStartDate;
    private JTextField txtDownDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmVIPUpdateVIP frame = new FrmVIPUpdateVIP();
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
    public FrmVIPUpdateVIP() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 610, 536);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("??????");
        btnNewButton.setFont(new Font("??????", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(135, 206, 250));
        btnNewButton.setFocusPainted(false);
        panel.add(btnNewButton);

        Component horizontalStrut = Box.createHorizontalStrut(80);
        panel.add(horizontalStrut);

        JButton btnNewButton_1 = new JButton("??????");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVIPUpdateVIP.this.dispose();
            }
        });
        btnNewButton_1.setFont(new Font("??????", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(135, 206, 250));
        btnNewButton_1.setFocusPainted(false);
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "????????????", TitledBorder.LEADING, TitledBorder.TOP, new Font("??????", Font.PLAIN, 20), new Color(0, 0, 0)));
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel_3.setPreferredSize(new Dimension(10, 120));
        panel_2.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_13 = new JPanel();
        panel_3.add(panel_13, BorderLayout.NORTH);
        panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

        JLabel lblNewLabel_5 = new JLabel("?????????");
        lblNewLabel_5.setFont(new Font("??????", Font.PLAIN, 20));
        panel_13.add(lblNewLabel_5);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new EmptyBorder(5, 5, 5, 0));
        panel_3.add(panel_14, BorderLayout.CENTER);
        panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        panel_14.add(textArea);

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new GridLayout(4, 2, 10, 10));

        JPanel panel_5 = new JPanel();
        panel_4.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("???????????????");
        label_2.setFont(new Font("??????", Font.PLAIN, 20));
        panel_5.add(label_2);

        txtName = new JTextField();
        txtName.setFont(new Font("??????", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_5.add(txtName);

        JPanel panel_6 = new JPanel();
        panel_4.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("???????????????");
        lblNewLabel_1.setFont(new Font("??????", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_1);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"????????????", "????????????", "????????????"}));
        comboBox_2.setFont(new Font("??????", Font.PLAIN, 20));
        comboBox_2.setBackground(Color.WHITE);
        panel_6.add(comboBox_2);

        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("???????????????");
        lblNewLabel_2.setFont(new Font("??????", Font.PLAIN, 20));
        panel_7.add(lblNewLabel_2);

        txtTel = new JTextField();
        txtTel.setFont(new Font("??????", Font.PLAIN, 20));
        txtTel.setColumns(10);
        panel_7.add(txtTel);

        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_3 = new JLabel("???????????????");
        lblNewLabel_3.setFont(new Font("??????", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("??????", Font.PLAIN, 20));
        textField_3.setColumns(10);
        panel_8.add(textField_3);

        JPanel panel_9 = new JPanel();
        panel_4.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("???????????????");
        label_3.setFont(new Font("??????", Font.PLAIN, 20));
        panel_9.add(label_3);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtStartDate = new JTextField(df.format(System.currentTimeMillis()));
        txtStartDate.setFont(new Font("??????", Font.PLAIN, 20));
        //???????????????????????????????????????????????????yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        //?????????????????????????????????textField??????textField????????????????????????????????????
        dateChooser1.register(txtStartDate);
        //???????????????????????????
        txtStartDate.setEditable(false);
        panel_9.add(txtStartDate);
        txtStartDate.setColumns(10);

        JPanel panel_10 = new JPanel();
        panel_4.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label = new JLabel("???????????????");
        label.setFont(new Font("??????", Font.PLAIN, 20));
        panel_10.add(label);

        Calendar calendar = Calendar.getInstance();
        //????????????????????????
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        txtDownDate = new JTextField(year + "-" + month + "-" + day);
        //???????????????????????????????????????????????????yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser2 = DatePicker.getInstance("yyyy-MM-dd");
        //?????????????????????????????????textField??????textField????????????????????????????????????
        dateChooser2.register(txtDownDate);
        //???????????????????????????
        txtDownDate.setEditable(false);
        txtDownDate.setFont(new Font("??????", Font.PLAIN, 20));
        panel_10.add(txtDownDate);
        txtDownDate.setColumns(10);
    }

}

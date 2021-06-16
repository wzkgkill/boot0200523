package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class FrmChaEr extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmChaEr frame = new FrmChaEr();
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
    public FrmChaEr() {
        setTitle("付款");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 568, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u5168\u989D\u4ED8\u6B3E", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_1.setBounds(27, 15, 505, 137);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("请选择付款方式");
        lblNewLabel.setBounds(56, 30, 140, 24);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(224, 29, 138, 27);
        panel_1.add(comboBox);
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"现金", "银行账号", "微信", "支付宝"}));

        JButton btnZhiFu = new JButton("支付");
        btnZhiFu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "支付完成！");
                FrmChaEr.this.dispose();
            }
        });
        btnZhiFu.setBackground(new Color(102, 153, 255));
        btnZhiFu.setFocusPainted(false);
        btnZhiFu.setFont(new Font("宋体", Font.PLAIN, 20));
        btnZhiFu.setBounds(239, 93, 123, 29);
        panel_1.add(btnZhiFu);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "\u5DEE\u989D\u4ED8\u6B3E", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_2.setBounds(37, 168, 497, 162);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JRadioButton radioQianKuan = new JRadioButton("该单据我方欠款");
        radioQianKuan.setFocusPainted(false);
        radioQianKuan.setFont(new Font("宋体", Font.PLAIN, 20));
        radioQianKuan.setBounds(68, 32, 177, 29);
        panel_2.add(radioQianKuan);

        JRadioButton radioYouHui = new JRadioButton("该单据对我方优惠");
        radioYouHui.setFocusPainted(false);
        radioYouHui.setFont(new Font("宋体", Font.PLAIN, 20));
        radioYouHui.setBounds(68, 79, 219, 29);
        panel_2.add(radioYouHui);

        radioQianKuan.setSelected(true);
        ButtonGroup gp1 = new ButtonGroup();
        gp1.add(radioQianKuan);
        gp1.add(radioYouHui);

        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmChaEr.this.dispose();

            }
        });
        btnSure.setBackground(new Color(102, 153, 255));
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSure.setBounds(233, 118, 123, 29);
        panel_2.add(btnSure);
    }
}

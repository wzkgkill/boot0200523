package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import entity.Repertory;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JRadioButton;

public class FrmShenHe extends JFrame {

    private JPanel contentPane;
    private FrmProcure2 frmList;
    private JRadioButton radioOK;
    private JRadioButton radioNO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmShenHe frame = new FrmShenHe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmShenHe(FrmProcure2 frmList) {
        this();
//		String zt=null;
//		if(radioOK.isSelected()) {
//			zt="已审核";
//			frmList.zt(zt);
//		}
//		if(radioNO.isSelected()) {
//			zt="未审核";
//			frmList.zt(zt);
//		}
    }

    /**
     * Create the frame.
     */
    public FrmShenHe() {
        setTitle("保存提示");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 648, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u5BA1\u6838\u72B6\u6001", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_1.setBounds(15, 31, 586, 92);
        panel.add(panel_1);
        panel_1.setLayout(null);

        radioOK = new JRadioButton("已审核状态");
        radioOK.setFocusPainted(false);
        radioOK.setFont(new Font("宋体", Font.PLAIN, 20));
        radioOK.setBounds(77, 38, 177, 29);
        panel_1.add(radioOK);

        radioNO = new JRadioButton("未审核状态");
        radioNO.setFocusPainted(false);
        radioNO.setFont(new Font("宋体", Font.PLAIN, 20));
        radioNO.setBounds(334, 38, 177, 29);
        panel_1.add(radioNO);

        //默认选中一个单选按钮
        radioOK.setSelected(true);
        ButtonGroup gp1 = new ButtonGroup();
        gp1.add(radioOK);
        gp1.add(radioNO);

        JPanel panel_2 = new JPanel();
        panel_2.setForeground(new Color(51, 51, 204));
        panel_2.setBounds(15, 157, 586, 104);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("说明：");
        lblNewLabel.setForeground(new Color(51, 51, 255));
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setBounds(0, 0, 90, 21);
        panel_2.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("1、已审核状态单据保存后，不允许再修改；");
        lblNewLabel_1.setForeground(new Color(51, 51, 255));
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(83, 32, 443, 21);
        panel_2.add(lblNewLabel_1);

        JLabel label = new JLabel("2、未审核状态的单据不影响库存量和账务，允许修改");
        label.setForeground(new Color(51, 51, 255));
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        label.setBounds(83, 68, 503, 21);
        panel_2.add(label);

        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repertory repertory = new Repertory();
                //FrmShenHe.this.dispose();
                //	new FrmChaEr();


            }
        });
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnSure.setBounds(81, 276, 123, 29);
        panel.add(btnSure);

        JButton btnEsc = new JButton("取消");
        btnEsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmShenHe.this.dispose();

            }
        });
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFocusPainted(false);
        btnEsc.setBounds(368, 276, 123, 29);
        panel.add(btnEsc);
    }
}

package ui.AddOldPro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.RepertoryDAO;
import entity.Repertory;
import ui.FrmProcure2;
import util.MyUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.LineBorder;

/**
 * 老商品添加详情
 */
public class FrmAddOldDetail extends JFrame {

    private JPanel contentPane;
    private JTextField txtBianHao;
    private JTextField txtName;
    private JTextField txtGuiGe;
    private JTextField txtUnit;
    private JTextField txtAdress;
    private JTextField txtColor;
    private JTextField txtKuCun;
    private JTextField txtJYprice;

    //给父级窗体设置全局变量
    private FrmProcure2 paranA;
    private Repertory repertory;
    private JTextField txtUnit1;
    private JTextField txtShangXian;
    private JTextField txtXiaXian;
    private JTextField txtPrice;
    private JTextField txtCount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmAddOldDetail frame = new FrmAddOldDetail();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmAddOldDetail(FrmProcure2 paranA, Repertory repertory) {
        this();
        this.paranA = paranA;
        this.repertory = repertory;
        txtBianHao.setText(repertory.getRsid());
        txtName.setText(repertory.getRname());
        txtKuCun.setText(repertory.getRinventory() + "");
        //采购数量
        txtCount.setText("1");
        //采购价格
        txtPrice.setText(repertory.getRprice() + "");
        txtAdress.setText(repertory.getRadress());
        txtColor.setText(repertory.getRcolor());
        txtGuiGe.setText(repertory.getRspec());
        txtColor.setText(repertory.getRcolor());
        txtJYprice.setText(repertory.getRprice() + "");
        txtUnit1.setText(repertory.getRunit());
        txtShangXian.setText(repertory.getRcap() + "");
        txtXiaXian.setText(repertory.getRfloor() + "");
    }

    /**
     * Create the frame.
     */
    public FrmAddOldDetail() {
        setVisible(true);
        setTitle("增加商品(采购进货)");
        setIconImage(new ImageIcon("src/images/超市图标.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 651, 437);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocation(532, 370);//绝对定位

        JPanel panel = new JPanel();
        panel.setFont(new Font("宋体", Font.BOLD, 20));
        panel.setForeground(new Color(0, 206, 209));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "商品信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(0, 10, 0, 10));
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EmptyBorder(10, 15, 10, 15));
        panel_1.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(6, 2, 10, 20));

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("商品编号：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_1);

        txtBianHao = new JTextField();
        txtBianHao.setBorder(null);
        txtBianHao.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBianHao.setEditable(false);//不可编辑
        panel_8.add(txtBianHao);
        txtBianHao.setColumns(10);

        JPanel panel_9 = new JPanel();
        panel_2.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("商品名称：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(label_1);

        txtName = new JTextField();
        txtName.setBorder(null);
        txtName.setEditable(false);
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_9.add(txtName);

        JPanel panel_10 = new JPanel();
        panel_2.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("规格型号：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(label_2);

        txtGuiGe = new JTextField();
        txtGuiGe.setBorder(null);
        txtGuiGe.setEditable(false);
        txtGuiGe.setFont(new Font("宋体", Font.PLAIN, 20));
        txtGuiGe.setColumns(10);
        panel_10.add(txtGuiGe);

        JPanel panel_11 = new JPanel();
        panel_2.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("基本单位：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(label_3);

        txtUnit1 = new JTextField();
        txtUnit1.setFont(new Font("宋体", Font.PLAIN, 20));
        txtUnit1.setEditable(false);
        txtUnit1.setColumns(10);
        txtUnit1.setBorder(null);
        panel_11.add(txtUnit1);

        JPanel panel_12 = new JPanel();
        panel_2.add(panel_12);
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("生产厂商：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(label_4);

        txtAdress = new JTextField();
        txtAdress.setBorder(null);
        txtAdress.setEditable(false);
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        txtAdress.setColumns(10);
        panel_12.add(txtAdress);

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13);
        panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

        JLabel label_5 = new JLabel("颜    色：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_13.add(label_5);

        txtColor = new JTextField();
        txtColor.setBorder(null);
        txtColor.setEditable(false);
        txtColor.setFont(new Font("宋体", Font.PLAIN, 20));
        txtColor.setColumns(10);
        panel_13.add(txtColor);

        JPanel panel_14 = new JPanel();
        panel_2.add(panel_14);
        panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));

        JLabel label_6 = new JLabel("当前库存：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_14.add(label_6);

        txtKuCun = new JTextField();
        txtKuCun.setBorder(null);
        txtKuCun.setFont(new Font("宋体", Font.PLAIN, 20));
        txtKuCun.setColumns(10);
        panel_14.add(txtKuCun);
        txtKuCun.setEditable(false);

        JPanel panel_15 = new JPanel();
        panel_2.add(panel_15);
        panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));

        JLabel label_7 = new JLabel("建议进价：");
        label_7.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_15.add(label_7);

        txtJYprice = new JTextField();
        txtJYprice.setBorder(null);
        txtJYprice.setEditable(false);
        txtJYprice.setFont(new Font("宋体", Font.PLAIN, 20));
        txtJYprice.setColumns(10);
        panel_15.add(txtJYprice);

        JPanel panel_6 = new JPanel();
        panel_2.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label = new JLabel("库存上限：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(label);

        txtShangXian = new JTextField();
        txtShangXian.setFont(new Font("宋体", Font.PLAIN, 20));
        txtShangXian.setEditable(false);
        txtShangXian.setColumns(10);
        txtShangXian.setBorder(null);
        panel_6.add(txtShangXian);

        JPanel panel_7 = new JPanel();
        panel_2.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_8 = new JLabel("库存下限：");
        label_8.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(label_8);

        txtXiaXian = new JTextField();
        txtXiaXian.setFont(new Font("宋体", Font.PLAIN, 20));
        txtXiaXian.setEditable(false);
        txtXiaXian.setColumns(10);
        txtXiaXian.setBorder(null);
        panel_7.add(txtXiaXian);

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel label_9 = new JLabel("采购价格：");
        label_9.setFont(new Font("宋体", Font.PLAIN, 20));
        label_9.setBounds(0, 0, 100, 24);
        panel_3.add(label_9);

        txtPrice = new JTextField();
        txtPrice.setFont(new Font("宋体", Font.PLAIN, 20));
        txtPrice.setColumns(10);
        txtPrice.setBorder(null);
        txtPrice.setBounds(100, -1, 117, 24);
        panel_3.add(txtPrice);

        //采购价格的文本框只能输入数字和.
        txtPrice.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81 || keycode == 46) {
                    System.out.println("是数字和退格键或.");
                } else {
                    e.consume();//消灭
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                System.out.println(keycode + "键值");
            }
        });

        JPanel panel_16 = new JPanel();
        panel_2.add(panel_16);
        panel_16.setLayout(null);

        JLabel label_10 = new JLabel("采购数量：");
        label_10.setFont(new Font("宋体", Font.PLAIN, 20));
        label_10.setBounds(0, 0, 100, 24);
        panel_16.add(label_10);

        txtCount = new JTextField();
        txtCount.setFont(new Font("宋体", Font.PLAIN, 20));
        txtCount.setColumns(10);
        txtCount.setBorder(null);
        txtCount.setBounds(100, -1, 117, 24);
        panel_16.add(txtCount);

        //采购数量的文本框只能输入数字
        txtCount.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81) {
                    System.out.println("是数字和退格键");
                } else {
                    e.consume();//消灭
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                System.out.println(keycode + "键值");
            }
        });

        java.util.Date wo = new java.util.Date();
        long ac = wo.getTime();
        System.out.println(ac + "----");

        JPanel panel_4 = new JPanel();
        contentPane.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_4.add(panel_5, BorderLayout.SOUTH);


        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取采购价格和采购数量
                String p = txtPrice.getText().trim();
                String c = txtCount.getText().trim();
                if (c.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入采购数量！");
                    return;
                }

                //比较库存上限,库存下限与采购数量的关系
                String sx = txtShangXian.getText().trim();//库存上限
                int sx1 = Integer.valueOf(sx);
                String xx = txtXiaXian.getText().trim();//库存下限
                int xx1 = Integer.valueOf(xx);
                String kc = txtKuCun.getText().trim();
                int kc1 = Integer.valueOf(kc);//当前库存
                int c1 = Integer.valueOf(c);//采购数量
                int zzKC = c1 + kc1;//最终库存
                if (zzKC > sx1) {
                    JOptionPane.showMessageDialog(null, "当前采购数量的最终库存超过库存上限，建议修改采购数量！");
                    return;
                }
                if (zzKC < xx1) {
                    JOptionPane.showMessageDialog(null, "当前采购数量的最终库存低于库存下限，建议修改采购数量！");
                    return;
                }
                //2、数据验证
                if (p.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入采购价格！");
                    return;
                }
                if (c.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入采购数量！");
                    return;
                }
                if (!MyUtil.isInteger(c)) {
                    JOptionPane.showMessageDialog(null, "请输入正确采购数量！");
                    return;
                }
                if (!MyUtil.isNumber(p)) {
                    JOptionPane.showMessageDialog(null, "请输入正确采购价格！");
                    return;
                }
                //调用采购进货页面的addRow
                if (paranA != null) {
                    paranA.addRow2(repertory, c, p);
                    FrmAddOldDetail.this.dispose();
                }
            }
        });
        btnNewButton.setFocusTraversalPolicyProvider(true);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(135, 206, 250));
        panel_5.add(btnNewButton);

        Component horizontalStrut = Box.createHorizontalStrut(100);
        panel_5.add(horizontalStrut);

        JButton btnNewButton_1 = new JButton("退出");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAddOldDetail.this.dispose();

            }
        });
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setFocusTraversalPolicyProvider(true);
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(135, 206, 250));
        panel_5.add(btnNewButton_1);

    }
}

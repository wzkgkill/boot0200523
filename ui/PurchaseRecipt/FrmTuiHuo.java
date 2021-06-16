package ui.PurchaseRecipt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

/**
 * 采购退货
 *
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmTuiHuo extends JFrame {

    private JPanel contentPane;
    private JTextField txtBz;
    private JTextField txtYMoney;
    private JTextField txtSMoney;
    private JTable table;
    private JTextField txtSuplier;
    private JTextField txtReciveWareHouse;
    private JTextField txtStockDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmTuiHuo frame = new FrmTuiHuo();
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
    public FrmTuiHuo() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("采购退货");
        setBounds(100, 100, 1216, 621);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JToolBar toolBar = new JToolBar();
        panel.add(toolBar, BorderLayout.NORTH);

        JButton btnCaiGou = new JButton("采购退货");
        btnCaiGou.setFocusPainted(false);
        btnCaiGou.setFont(new Font("宋体", Font.PLAIN, 20));
        btnCaiGou.setBackground(Color.WHITE);
        toolBar.add(btnCaiGou);

        JButton btnShenHe = new JButton("退货审核");
        btnShenHe.setFocusPainted(false);
        btnShenHe.setFont(new Font("宋体", Font.PLAIN, 20));
        btnShenHe.setBackground(SystemColor.controlHighlight);
        toolBar.add(btnShenHe);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setVgap(10);
        panel.add(panel_1, BorderLayout.CENTER);

        Component horizontalStrut_9 = Box.createHorizontalStrut(200);
        panel_1.add(horizontalStrut_9);

        JLabel lblNewLabel = new JLabel("采购退货");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 33));
        panel_1.add(lblNewLabel);

        Component horizontalStrut_10 = Box.createHorizontalStrut(70);
        panel_1.add(horizontalStrut_10);

        JLabel lblNewLabel_1 = new JLabel("单号:");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.RED);
        panel_1.add(lblNewLabel_1);

        JLabel lblDanHao = new JLabel("New label");
        lblDanHao.setForeground(Color.RED);
        lblDanHao.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel_1.add(lblDanHao);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 10));

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        panel_3.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("供货商：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_2);

        txtSuplier = new JTextField();
        txtSuplier.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtSuplier.setOpaque(false);
        txtSuplier.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtSuplier);
        txtSuplier.setColumns(10);

        Component horizontalStrut_11 = Box.createHorizontalStrut(10);
        panel_4.add(horizontalStrut_11);

        JButton btnSearch = new JButton("");
        btnSearch.setFocusPainted(false);
        btnSearch.setBorder(null);
        btnSearch.setPreferredSize(new Dimension(34, 27));
        btnSearch.setBackground(Color.WHITE);
        panel_4.add(btnSearch);

        Component horizontalStrut_7 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_7);

        JLabel lblNewLabel_6 = new JLabel("收货仓库：");
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_6);

        txtReciveWareHouse = new JTextField();
        txtReciveWareHouse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtReciveWareHouse.setOpaque(false);
        txtReciveWareHouse.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtReciveWareHouse);
        txtReciveWareHouse.setColumns(10);

        Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_8);

        JLabel lblNewLabel_8 = new JLabel("退货日期：");
        lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_8);

        txtStockDate = new JTextField();
        txtStockDate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtStockDate.setOpaque(false);
        txtStockDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtStockDate);
        txtStockDate.setColumns(10);

        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(SystemColor.inactiveCaptionBorder);
        panel_6.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel_5.add(panel_6, BorderLayout.NORTH);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JButton btnDaYin = new JButton("打印单据(F8)");
        btnDaYin.setFocusPainted(false);
        btnDaYin.setBounds(new Rectangle(0, 2, 0, 0));
        btnDaYin.setBackground(new Color(135, 206, 250));
        btnDaYin.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(btnDaYin);

        JPanel panel_7 = new JPanel();
        panel_5.add(panel_7, BorderLayout.SOUTH);
        panel_7.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_7.add(panel_8, BorderLayout.SOUTH);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_10 = new JLabel("备注：");
        lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_10);

        txtBz = new JTextField();
        txtBz.setOpaque(false);
        txtBz.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtBz.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(txtBz);
        txtBz.setColumns(10);

        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_8.add(horizontalStrut_6);

        JButton btnSure = new JButton("确定（F5）");
        btnSure.setFocusPainted(false);//是否绘制焦点
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(btnSure);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        panel_8.add(horizontalStrut_5);

        JButton btnQuit = new JButton("退出（F6）");
        btnQuit.setFocusPainted(false);
        btnQuit.setBackground(new Color(135, 206, 250));
        btnQuit.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(btnQuit);

        JPanel panel_9 = new JPanel();
        panel_7.add(panel_9, BorderLayout.NORTH);
        panel_9.setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel_9.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel lblNewLabel_4 = new JLabel("应付金额：");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(lblNewLabel_4);

        txtYMoney = new JTextField();
        txtYMoney.setOpaque(false);
        txtYMoney.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtYMoney.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(txtYMoney);
        txtYMoney.setColumns(10);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut_2);

        JLabel lblNewLabel_11 = new JLabel("实付金额：");
        lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(lblNewLabel_11);

        txtSMoney = new JTextField();
        txtSMoney.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtSMoney.setOpaque(false);
        txtSMoney.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(txtSMoney);
        txtSMoney.setColumns(10);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut_3);

        JLabel lblNewLabel_12 = new JLabel("经办人：");
        lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(lblNewLabel_12);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"小白", "小张", "小陈", "小李"}));
        panel_10.add(comboBox);

        Component horizontalStrut = Box.createHorizontalStrut(300);
        panel_10.add(horizontalStrut);

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "商品编号", "商品名称", "单位", "规格型号", "颜色", "单价", "数量", "总金额"
                }
        ));
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            //hh.setBackground(new Color(240, 255, 255));// 前景颜色
            //hh.setPreferredSize(new Dimension(hh.getWidth(),(40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table);
    }
}

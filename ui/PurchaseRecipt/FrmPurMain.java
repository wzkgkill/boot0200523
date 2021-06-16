package ui.PurchaseRecipt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import util.DatePicker;

import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

/**
 * 采购单据查询
 *
 * @author lenovo
 */
public class FrmPurMain extends JFrame {
    private JPanel contentPane;
    private JTextField txtSearch;
    private JTable table;
    private JTable table_1;
    private JTextField txtStartDate;
    private JTextField txtDownDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmPurMain frame = new FrmPurMain();
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
    public FrmPurMain() {
        setVisible(true);
        setTitle("采购单据查询");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 1261, 842);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_3.setBackground(SystemColor.inactiveCaptionBorder);
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_1.add(panel_4, BorderLayout.SOUTH);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_3);

        JLabel lblNewLabel = new JLabel("查询日期：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtStartDate = new JTextField(df.format(System.currentTimeMillis()));
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser1.register(txtStartDate);
        //设置文本框不可编辑
        txtStartDate.setEditable(false);
        txtStartDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtStartDate);
        txtStartDate.setColumns(8);

        Component horizontalStrut_5 = Box.createHorizontalStrut(10);
        panel_4.add(horizontalStrut_5);

        JLabel lblNewLabel_1 = new JLabel("至");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_1);


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

        Component horizontalStrut_4 = Box.createHorizontalStrut(10);
        panel_4.add(horizontalStrut_4);
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser2.register(txtDownDate);
        //设置文本框不可编辑
        txtDownDate.setEditable(false);
        txtDownDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtDownDate);
        txtDownDate.setColumns(8);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut);

        JLabel lblNewLabel_2 = new JLabel("按供货商/单据号/经办人查询：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_2);

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(txtSearch);
        txtSearch.setColumns(10);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_1);

        JButton btnChaXun = new JButton("查询(F2)");
        btnChaXun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnChaXun.setFocusPainted(false);
        btnChaXun.setBackground(new Color(135, 206, 250));
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(btnChaXun);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_2);

        JButton button = new JButton("详细查找");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmDetailSearch();
            }
        });
        button.setBackground(new Color(255, 255, 204));
        button.setHorizontalAlignment(SwingConstants.RIGHT);
        button.setIcon(new ImageIcon(FrmPurMain.class.getResource("/images/查找22.png")));
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.LEADING);
        button.setFont(new Font("宋体", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_4.add(button);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.LIGHT_GRAY);
        panel_2.add(scrollPane, BorderLayout.NORTH);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "单据号", "开单日期", "供货商名称", "仓库名称", "应付金额", "实付金额", "欠款金额", "优惠金额", "单据类型", "原始单号", "经办人", "操作人"
                }
        ));
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            hh.setBackground(new Color(240, 255, 255));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table);

        Component horizontalStrut_6 = Box.createHorizontalStrut(50);
        scrollPane.setColumnHeaderView(horizontalStrut_6);

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_5.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "商品编号", "商品名称", "单位", "单价", "数量", "总金额", "生产日期", "保质期(天)", "规格型号", "颜色"
                }
        ));
        {
            //设置行高
            table_1.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table_1.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            hh.setBackground(new Color(240, 255, 255));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table_1.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table_1.setDefaultRenderer(Object.class, render);
            table_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane_1.setViewportView(table_1);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EmptyBorder(4, 0, 4, 0));
        panel_5.add(panel_6, BorderLayout.NORTH);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel lblNewLabel_3 = new JLabel("单据的详细信息：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_3);
    }

}

package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class FrmProUpdatePro extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_3;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTable table;
    private JTextField textField_8;
    private JTextField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProUpdatePro frame = new FrmProUpdatePro();
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
    public FrmProUpdatePro() {
        setVisible(true);
        setTitle("修改商品");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 559, 694);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "商品基本信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(0, 2, 10, 10));

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JLabel label = new JLabel("所属类别：");
        label.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_3.add(label);

        textField = new JTextField();
        textField.setColumns(10);
        panel_3.add(textField);

        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(FrmProUpdatePro.class.getResource("/images/搜索.png")));
        btnSearch.setPreferredSize(new Dimension(29, 9));
        btnSearch.setBorder(null);
        btnSearch.setBackground(Color.WHITE);
        panel_3.add(btnSearch);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("商品编号：");
        label_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_4.add(label_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        panel_4.add(textField_1);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("商品名称：");
        label_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_5.add(label_2);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        panel_5.add(textField_2);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("商品条码：");
        label_4.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_6.add(label_4);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        panel_6.add(textField_4);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("规格类型：");
        label_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_7.add(label_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        panel_7.add(textField_3);

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label_5 = new JLabel("单    位：");
        label_5.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(label_5);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(comboBox);

        JPanel panel_9 = new JPanel();
        panel_1.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_6 = new JLabel("库存下限：");
        label_6.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_9.add(label_6);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        panel_9.add(textField_5);

        JPanel panel_10 = new JPanel();
        panel_1.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_7 = new JLabel("颜    色：");
        label_7.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_10.add(label_7);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_10.add(comboBox_1);

        JPanel panel_11 = new JPanel();
        panel_1.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_8 = new JLabel("预设进价：");
        label_8.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_11.add(label_8);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        panel_11.add(textField_6);

        JPanel panel_12 = new JPanel();
        panel_1.add(panel_12);
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));

        JLabel label_9 = new JLabel("预设售价：");
        label_9.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_12.add(label_9);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        panel_12.add(textField_7);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13, BorderLayout.NORTH);
        panel_13.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new EmptyBorder(8, 0, 5, 0));
        panel_13.add(panel_15);
        panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));

        JLabel label_10 = new JLabel("备    注：");
        label_10.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_15.add(label_10);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        panel_15.add(textField_8);

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new EmptyBorder(8, 0, 5, 0));
        panel_13.add(panel_16);
        panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));

        JLabel label_11 = new JLabel("生产厂家：");
        label_11.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(label_11);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        panel_16.add(textField_9);

        JPanel panel_14 = new JPanel();
        panel_2.add(panel_14, BorderLayout.SOUTH);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_14.add(btnSure);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_14.add(horizontalStrut);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_14.add(btnEsc);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_2.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[]{
                        "单位类型", "单位名称", "单位关系", "条码", "零售价", "特价商品"
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
            //hh.setBackground(SystemColor.inactiveCaptionBorder);// 前景颜色
            hh.setBackground(new Color(255, 255, 240));
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table);
        setLocationRelativeTo(null);
    }

}

package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.AddNewPro.FrmAddNewMain;

import java.awt.FlowLayout;

/**
 * 商品管理--增加商品
 *
 * @author lenovo
 */
public class FrmProAddPro extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtBz;
    private JTextField txtAdress;
    private JTextField txtName;
    private JTextField txtXiaXian;
    private JTextField txtJmONEY;
    private JTextField txtSmoney;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProAddPro frame = new FrmProAddPro();
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
    public FrmProAddPro() {
        setVisible(true);
        setTitle("增加商品");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1021, 681);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "商品基本信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new GridLayout(0, 2, 10, 10));

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("所属类别：");
        label_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_4.add(label_2);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"酒类", "饮料类", "食品类"}));
        panel_4.add(comboBox_1);

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("商品条码：");
        label_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_5.add(label_3);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        textField.setColumns(10);
        panel_5.add(textField);

        JPanel panel_6 = new JPanel();
        panel_2.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("商品名称：");
        label_4.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_6.add(label_4);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_6.add(txtName);

        JPanel panel_7 = new JPanel();
        panel_2.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_5 = new JLabel("单    位：");
        label_5.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_7.add(label_5);

        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(new String[]{"瓶", "袋", "罐", "箱", "盒"}));
        comboBox_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_7.add(comboBox_3);

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label_6 = new JLabel("规格类型：");
        label_6.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(label_6);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"斤", "升", "箱"}));
        panel_8.add(comboBox_2);

        JPanel panel_9 = new JPanel();
        panel_2.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_7 = new JLabel("颜    色：");
        label_7.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_9.add(label_7);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"白", "透明", "绿", "蓝", "红"}));
        comboBox.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_9.add(comboBox);

        JPanel panel_10 = new JPanel();
        panel_2.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_8 = new JLabel("库存下限：");
        label_8.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_10.add(label_8);

        txtXiaXian = new JTextField();
        txtXiaXian.setFont(new Font("宋体", Font.PLAIN, 20));
        txtXiaXian.setColumns(10);
        panel_10.add(txtXiaXian);

        JPanel panel_11 = new JPanel();
        panel_2.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_9 = new JLabel("库存上限：");
        label_9.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_11.add(label_9);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_12 = new JPanel();
        panel_2.add(panel_12);
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));

        JLabel label_10 = new JLabel("预设进价：");
        label_10.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_12.add(label_10);

        txtJmONEY = new JTextField();
        txtJmONEY.setFont(new Font("宋体", Font.PLAIN, 20));
        txtJmONEY.setColumns(10);
        panel_12.add(txtJmONEY);

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13);
        panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

        JLabel label_11 = new JLabel("预设售价：");
        label_11.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_13.add(label_11);

        txtSmoney = new JTextField();
        txtSmoney.setFont(new Font("宋体", Font.PLAIN, 20));
        txtSmoney.setColumns(10);
        panel_13.add(txtSmoney);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel_3.add(panel_14, BorderLayout.NORTH);
        panel_14.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new EmptyBorder(8, 0, 5, 0));
        panel_14.add(panel_16);
        panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));

        JLabel label = new JLabel("备    注：");
        label.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(label);

        txtBz = new JTextField();
        txtBz.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBz.setColumns(10);
        panel_16.add(txtBz);

        JPanel panel_17 = new JPanel();
        panel_17.setBorder(new EmptyBorder(8, 0, 5, 0));
        panel_14.add(panel_17);
        panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("生产厂家：");
        label_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_17.add(label_1);

        txtAdress = new JTextField();
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        txtAdress.setColumns(10);
        panel_17.add(txtAdress);

        JPanel panel_15 = new JPanel();
        panel_3.add(panel_15, BorderLayout.SOUTH);

        JButton btnSure = new JButton("确定(F5)");
        btnSure.setFocusPainted(false);
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_15.add(btnSure);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_15.add(horizontalStrut);

        JButton btnEsc = new JButton("退出(F4)");
        btnEsc.setFocusPainted(false);
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_15.add(btnEsc);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "已存商品", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[]{
                        "商品编号", "商品名称"
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
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
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

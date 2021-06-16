package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmVIPGradeVIP extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmVIPGradeVIP frame = new FrmVIPGradeVIP();
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
    public FrmVIPGradeVIP() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("会员级别设置");
        setBounds(100, 100, 963, 583);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(50);
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.add(panel_1);

        JButton btnAdd = new JButton("增 加");
        btnAdd.setFont(new Font("宋体", Font.PLAIN, 20));
        btnAdd.setBorder(null);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setIcon(new ImageIcon(FrmVIPGradeVIP.class.getResource("/images/增加.png")));
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        panel_1.add(btnAdd);

        JButton btnUpdate = new JButton("修 改");
        btnUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setIcon(new ImageIcon(FrmVIPGradeVIP.class.getResource("/images/修改.png")));
        btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_1.add(btnUpdate);

        JButton btnDelete = new JButton("删 除");
        btnDelete.setFont(new Font("宋体", Font.PLAIN, 20));
        btnDelete.setBorder(null);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setIcon(new ImageIcon(FrmVIPGradeVIP.class.getResource("/images/删 除.png")));
        btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_1.add(btnDelete);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.inactiveCaptionBorder);
        panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
        FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
        flowLayout_1.setHgap(20);
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel.add(panel_2);

        JLabel lblNewLabel = new JLabel("级别信息：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"普通会员", "中级会员", "高级会员", ""}));
        panel_2.add(comboBox);

        JButton btnChaXun = new JButton("查询F2");
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        btnChaXun.setFocusPainted(false);
        btnChaXun.setBackground(new Color(135, 206, 250));
        panel_2.add(btnChaXun);


        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "\u7EA7\u522B\u7F16\u53F7", "\u7EA7\u522B\u540D\u79F0", "\u7EA7\u522B\u6298\u6263", "\u79EF\u5206\u4E0B\u9650", "\u79EF\u5206\u4E0A\u9650"
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
    }

}
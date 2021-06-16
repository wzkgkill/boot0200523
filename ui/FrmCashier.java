package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class FrmCashier extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmCashier frame = new FrmCashier();
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
    public FrmCashier() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 902, 531);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(0, 129, 205));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        Component glue = Box.createGlue();
        panel.add(glue);

        JLabel lblNewLabel = new JLabel("店铺名称：");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
        panel.add(lblNewLabel_1);

        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        panel.add(rigidArea);

        JLabel lblNewLabel_2 = new JLabel("管理员：");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
        panel.add(lblNewLabel_3);

        JPanel panel_1 = new JPanel();

        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        //panel_4.setBackground(Color.RED);
        panel_4.setForeground(new Color(255, 255, 255));

        panel_1.add(panel_4, BorderLayout.NORTH);

        JLabel lblNewLabel_4 = new JLabel("New label");
        panel_4.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("New label");
        panel_4.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("New label");
        panel_4.add(lblNewLabel_6);

        JButton btnNewButton_2 = new JButton("New button");
        panel_4.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("New button");
        panel_4.add(btnNewButton_3);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.WHITE);
        panel_1.add(panel_5, BorderLayout.SOUTH);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8, BorderLayout.WEST);

        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setForeground(Color.BLACK);
        panel_8.add(lblNewLabel_7);

        textField = new JTextField();
        panel_8.add(textField);
        textField.setColumns(10);

        JPanel panel_9 = new JPanel();
        panel_5.add(panel_9, BorderLayout.EAST);

        JButton btnNewButton_4 = new JButton("New button");
        panel_9.add(btnNewButton_4);

        JPanel panel_10 = new JPanel();
        panel_5.add(panel_10, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setForeground(new Color(255, 255, 255));
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setForeground(new Color(30, 144, 255));
        panel_2.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "商品条码", "商品名称", "原价￥", "优惠", "现价￥", "数量", "小计￥"
                }
        ));
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(0, 191, 255)));// 边框
            //hh.setBackground(new Color(190, 191, 255));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.BOLD, 15));// 字体
            hh.setForeground(new Color(0, 171, 205));//字体颜色
            hh.setBackground(new Color(255, 255, 255));// 前景颜色
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 20));
        }
        scrollPane.setViewportView(table);

        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(new Color(0, 129, 205));
        panel_2.add(toolBar, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("后台管理");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(0, 129, 205));
        btnNewButton.setBorder(null);
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton.setIcon(new ImageIcon(FrmCashier.class.getResource("/images/后台管理_看图王.png")));
        toolBar.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("新增会员");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
        btnNewButton_1.setBackground(new Color(0, 129, 205));
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setIcon(new ImageIcon(FrmCashier.class.getResource("/images/新增会员_看图王.png")));
        toolBar.add(btnNewButton_1);

        JButton btnNewButton_5 = new JButton("销售单据");
        btnNewButton_5.setFont(new Font("宋体", Font.BOLD, 20));
        btnNewButton_5.setForeground(new Color(255, 255, 255));
        btnNewButton_5.setBackground(new Color(0, 129, 205));
        btnNewButton_5.setBorder(null);
        btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_5.setIcon(new ImageIcon(FrmCashier.class.getResource("/images/销售单据.png")));
        toolBar.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("帮助说明");
        btnNewButton_6.setFont(new Font("宋体", Font.BOLD, 20));
        btnNewButton_6.setForeground(new Color(255, 255, 255));
        btnNewButton_6.setBackground(new Color(0, 129, 205));
        btnNewButton_6.setBorder(null);
        btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_6.setIcon(new ImageIcon(FrmCashier.class.getResource("/images/帮助说明_看图王.png")));
        btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("设置");
        btnNewButton_7.setFont(new Font("宋体", Font.BOLD, 20));
        btnNewButton_7.setForeground(new Color(255, 255, 255));
        btnNewButton_7.setBackground(new Color(0, 129, 205));
        btnNewButton_7.setBorder(null);
        btnNewButton_7.setIcon(new ImageIcon(FrmCashier.class.getResource("/images/设置_看图王.png")));
        btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
        toolBar.add(btnNewButton_7);
    }

}

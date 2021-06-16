package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FrmProManage extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProManage frame = new FrmProManage();
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
    public FrmProManage() {
        setVisible(true);
        setTitle("商品信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1158, 697);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.inactiveCaptionBorder);
        panel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.setBorder(new TitledBorder(null, "商品列表", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        Component horizontalStrut_9 = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut_9);

        JButton btnAdd = new JButton("增加");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmProAddPro();
            }
        });
        btnAdd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnAdd.setContentAreaFilled(false);
        btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/增加.png")));
        btnAdd.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnAdd);

        Component horizontalStrut_2 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_2);

        JButton btnUpdate = new JButton("修改");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmProUpdatePro();
            }
        });
        btnUpdate.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/修改.png")));
        btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnUpdate);

        Component horizontalStrut_3 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_3);

        JButton btnDelete = new JButton("删除");
        btnDelete.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnDelete.setContentAreaFilled(false);
        btnDelete.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/删 除.png")));
        btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDelete.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnDelete);

        Component horizontalStrut_4 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_4);

        JButton btnPrice = new JButton("调价");
        btnPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmProTiaoJIa();
            }
        });
        btnPrice.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnPrice.setContentAreaFilled(false);
        btnPrice.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/自动调价.png")));
        btnPrice.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPrice.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPrice.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnPrice);

        Component horizontalStrut_5 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_5);

        JButton btnZheKou = new JButton("折扣");
        btnZheKou.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnZheKou.setContentAreaFilled(false);
        btnZheKou.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/折扣.png")));
        btnZheKou.setHorizontalTextPosition(SwingConstants.CENTER);
        btnZheKou.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnZheKou.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnZheKou);

        Component horizontalStrut_6 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_6);

        JButton btnDaoRu = new JButton("导入导出");
        btnDaoRu.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnDaoRu.setContentAreaFilled(false);
        btnDaoRu.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/导入导出.png")));
        btnDaoRu.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDaoRu.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDaoRu.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnDaoRu);

        Component horizontalStrut_7 = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut_7);

        JButton btnEsc = new JButton("退出");
        btnEsc.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnEsc.setContentAreaFilled(false);
        btnEsc.setIcon(new ImageIcon(FrmProManage.class.getResource("/images/退出 2.png")));
        btnEsc.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEsc.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnEsc);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_1.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_8);

        JLabel lblNewLabel = new JLabel("商品编号(F6)：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(lblNewLabel);

        txtID = new JTextField();
        txtID.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(txtID);
        txtID.setColumns(10);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_1);

        JButton btnChaXun = new JButton("查询(F2)");
        btnChaXun.setFocusPainted(false);
        btnChaXun.setFocusTraversalPolicyProvider(true);
        btnChaXun.setBackground(new Color(176, 224, 230));
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(btnChaXun);

        Component horizontalStrut = Box.createHorizontalStrut(600);
        panel_3.add(horizontalStrut);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "商品编号", "商品名称", "类别", "单位", "规格型号", "颜色", "状态", "特价商品"
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

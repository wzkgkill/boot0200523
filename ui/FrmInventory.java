package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.InventorylistDAO;
import dao.InventorylistsDAO;
import dao.commodityDAO;
import entity.Inventorylist;
import entity.Inventorylists;
import entity.commodity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmInventory extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private DefaultTableModel model;
    InventorylistDAO dao = new InventorylistDAO();
    private DefaultTableModel model2;
    private String danhao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmInventory frame = new FrmInventory();
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
    public FrmInventory() {
        setVisible(true);
        setIconImage(new ImageIcon("src/img/超市图标.png").getImage());
        setTitle("库存盘点");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel.add(panel_5, BorderLayout.NORTH);
        panel_5.setBackground(SystemColor.inactiveCaptionBorder);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        Component horizontalStrut = Box.createHorizontalStrut(5);
        panel_5.add(horizontalStrut);

        JButton btnNewButton = new JButton("新增盘点单");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmInventoryAdd aa = new FrmInventoryAdd(FrmInventory.this);
                aa.setVisible(true);
            }
        });
        btnNewButton.setBackground(new Color(135, 206, 250));
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnNewButton);

        Component horizontalStrut_1 = Box.createHorizontalStrut(10);
        panel_5.add(horizontalStrut_1);

        JButton btnNewButton_2 = new JButton("刪除盘点单");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 根据选中的行，删除
                int index = table.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showConfirmDialog(null, "请选择你要删除的行");
                    return;
                }
                // 2.获取选中行的主键
                String id = table.getValueAt(index, 0).toString();
                // 3.调用DAO方法进行删除
                InventorylistDAO dao = new InventorylistDAO();
                boolean flag = dao.doDelete(Integer.valueOf(id));
                List<Inventorylist> list = dao.select();
                bindData(list);
            }
        });
        btnNewButton_2.setBackground(new Color(135, 206, 250));
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnNewButton_2);

        Component horizontalStrut_3 = Box.createHorizontalStrut(10);
        panel_5.add(horizontalStrut_3);

        Component verticalStrut = Box.createVerticalStrut(50);
        panel_5.add(verticalStrut);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(SystemColor.inactiveCaptionBorder);
        panel.add(panel_6, BorderLayout.CENTER);
        panel_6.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_6.add(scrollPane, BorderLayout.CENTER);

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        table.setModel(
                new DefaultTableModel(new Object[][]{}, new String[]{"盘点单号", "仓库名称", "操作员", "商品条数", "商品数量"}));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    InventorylistsDAO aa = new InventorylistsDAO();
                    int x = table.getSelectedRow();
                    String ss = table.getValueAt(x, 0).toString();
                    List<Inventorylists> dd = aa.selectID(ss);
                    bindData2(dd);
                }
            }
        });
        model = (DefaultTableModel) table.getModel();
        scrollPane.setViewportView(table);
        List<Inventorylist> list = dao.select();
        bindData(list);
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        }

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.inactiveCaptionBorder);
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        Component horizontalStrut_5 = Box.createHorizontalStrut(5);
        panel_2.add(horizontalStrut_5);

        JLabel lblNewLabel_1 = new JLabel("盘点商品明细");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(lblNewLabel_1);

        Component verticalStrut_2 = Box.createVerticalStrut(30);
        panel_2.add(verticalStrut_2);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.setPreferredSize(new Dimension(110, 300));
        panel_1.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_4.add(scrollPane_1, BorderLayout.CENTER);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"商品编号", "商品名称", "单位", "库存量", "所在仓库", "进价", "售价"}));
        model2 = (DefaultTableModel) table_1.getModel();
        scrollPane_1.setViewportView(table_1);
        {
            //设置行高
            table_1.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table_1.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table_1.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table_1.setDefaultRenderer(Object.class, render);
            table_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        }
    }

    public void bindData(List<Inventorylist> list) {
        // 清空原来的数据
        model.setRowCount(0);
        // 1、实例化DAO类

        // 2、调用查询所有的方法

        // 3、循环遍历每个实体类，实体类转成一维数组
        for (Inventorylist aa : list) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getWpurchasing(), aa.getNum(), aa.getNumber()};
            model.addRow(row);
        }

    }

    public void bindData2(List<Inventorylists> li) {
        // 清空原来的数据
        model2.setRowCount(0);
        // 1、实例化DAO类

        // 2、调用查询所有的方法


        // 3、循环遍历每个实体类，实体类转成一维数组
        for (Inventorylists aa : li) {
            Object[] row = {aa.getEsid(), aa.getEname(), aa.getEcompany(), aa.getEstock(), aa.getEwhere(), aa.getEprice(), aa.getEmprice()};
            model2.addRow(row);
        }

    }
}

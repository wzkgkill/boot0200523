package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TabExpander;

import dao.InventoryDAO;
import dao.InventorylistDAO;
import dao.InventorylistsDAO;
import dao.RepertoryDAO;
import dao.commodityDAO;
import dao.warehousesDAO;
import entity.Inventory;
import entity.Inventorylist;
import entity.Inventorylists;
import entity.Repertory;
import entity.commodity;
import entity.purchase;
import entity.warehouses;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmInventoryAdd extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTextField textField;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private FrmInventory quanju;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmInventoryAdd frame = new FrmInventoryAdd();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmInventoryAdd(FrmInventory xx) {
        this();
        quanju = xx;
    }

    /**
     * Create the frame.
     */
    public FrmInventoryAdd() {
        setVisible(true);
        setIconImage(new ImageIcon("src/img/超市图标.png").getImage());
        setTitle("新增盘点单");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("盘点单号：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_3);

        java.util.Date aDate = new java.util.Date();// 获得当前系统时间
        long time = aDate.getTime();// 转成long类型
        String time2 = time + "";
        time2 = time2.substring(7, 11);// 截取时间戳的4位数
        Date bDate = new Date(time);// 转成sql的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 转换sql时间显示格式
        String cc = sdf.format(bDate);
        cc = cc.substring(2);// 截取年月日
        String dingDanID = cc + time2;// 最终生成订单单
        Integer pandian = Integer.valueOf(dingDanID) / 2;
        JLabel lblNewLabel_4 = new JLabel(pandian + "");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_4);

        Component horizontalStrut_1 = Box.createHorizontalStrut(40);
        panel_5.add(horizontalStrut_1);

        JLabel lblNewLabel_2 = new JLabel("选择盘点仓库");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"主仓库", "酒库", "饮料库", "日常用品库"}));

        comboBox.setMinimumSize(new Dimension(40, 21));
        panel_5.add(comboBox);

        Component horizontalGlue_2 = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue_2);

        Component horizontalGlue_1 = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue_1);

        Component horizontalGlue = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue);

        JLabel lblNewLabel_5 = new JLabel("操作员：");
        lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
        panel_2.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
        panel_2.add(lblNewLabel_6);

        Component horizontalStrut = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut);

        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("提示:盘点前请选择仓库，盘点中不能更换仓库。在没有修正库存之前请勿有采购进货、销售等能改变库存数里的操作，不然会造成库存数量不准。");
        lblNewLabel.setForeground(Color.RED);
        panel_3.add(lblNewLabel);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(SystemColor.inactiveCaptionBorder);
        panel_6.setPreferredSize(new Dimension(550, 10));
        contentPane.add(panel_6, BorderLayout.WEST);
        panel_6.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        panel_6.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(SystemColor.inactiveCaptionBorder);
        panel_1.add(panel_8, BorderLayout.NORTH);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("库存商品");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
        panel_8.add(lblNewLabel_1);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(SystemColor.inactiveCaptionBorder);
        panel_9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_1.add(panel_9, BorderLayout.SOUTH);
        panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_7 = new JLabel("商品编号：");
        lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(lblNewLabel_7);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String text = textField.getText().trim();
                bindData(text);
            }
        });
        btnNewButton.setBackground(new Color(135, 206, 250));
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        panel_6.add(scrollPane, BorderLayout.CENTER);

        String[] header = {"商品编号", "商品名称", "单位", "库存量", "所在仓库", "进价", "售价"};
        model = new DefaultTableModel(null, header);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 单元格不可编辑
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    int x = table.getSelectedRow();
                    String a = table.getValueAt(x, 0) + "";
                    String s = table.getValueAt(x, 1) + "";
                    String d = table.getValueAt(x, 2) + "";
                    Integer f = Integer.valueOf(table.getValueAt(x, 3) + "");
                    String g = table.getValueAt(x, 4) + "";
                    BigDecimal h = new BigDecimal(table.getValueAt(x, 5) + "");
                    BigDecimal j = new BigDecimal(table.getValueAt(x, 6) + "");
                    Object[] cc = {a, s, d, f, g, h, j};
                    String rname = comboBox.getSelectedItem().toString();
                    model1.addRow(cc);
                    InventorylistsDAO aa = new InventorylistsDAO();
                    Inventorylists ss = new Inventorylists(lblNewLabel_4.getText(), rname, "小王", "4", "5", a, s, d, f,
                            g, h, j);
                    aa.update(ss);
                }

            }
        });

        scrollPane.setViewportView(table);
        // 绑定数据
        // RepertoryDAO dao = new RepertoryDAO();
        // List<Repertory> list = dao.select();
        // bindData(list);
        bindData();
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

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(SystemColor.inactiveCaptionBorder);
        panel_7.setPreferredSize(new Dimension(550, 10));
        contentPane.add(panel_7, BorderLayout.EAST);
        panel_7.setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        panel_10.setBackground(SystemColor.inactiveCaptionBorder);
        panel_7.add(panel_10, BorderLayout.NORTH);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(SystemColor.inactiveCaptionBorder);
        panel_10.add(panel_11, BorderLayout.NORTH);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel lblNewLabel_8 = new JLabel("已盘商品");
        lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 16));
        panel_11.add(lblNewLabel_8);

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(SystemColor.inactiveCaptionBorder);
        panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_10.add(panel_12, BorderLayout.SOUTH);

        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int aa = 0;
                for (int i = 0; i < model1.getRowCount(); i++) {
                    aa = Integer.valueOf(table.getValueAt(i, 3) + "") + aa;
                }
                InventorylistDAO a = new InventorylistDAO();
                String rname = comboBox.getSelectedItem().toString();
                String aaa = aa + "";
                String hh = model1.getRowCount() + "";
                Inventorylist s = new Inventorylist(lblNewLabel_4.getText(), rname, "小王", hh, aaa);
                a.update(s);

                quanju.bindData(a.select());
            }
        });
        button.setBackground(new Color(135, 206, 250));
        button.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(button);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_12.add(horizontalStrut_2);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_12.add(horizontalStrut_3);

        JButton btnNewButton_3 = new JButton("退出");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmInventoryAdd.this.dispose();
            }
        });
        btnNewButton_3.setBackground(new Color(135, 206, 250));
        btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(btnNewButton_3);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_7.add(scrollPane_1, BorderLayout.CENTER);

        String[] header2 = {"商品编号", "商品名称", "单位", "库存量", "所在仓库", "进价", "售价"};
        model1 = new DefaultTableModel(null, header2);
        table_1 = new JTable(model1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 单元格不可编辑
                return false;

            }
        };
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
        scrollPane_1.setViewportView(table_1);
    }

    public void bindData(String key) {
        // 清空原来的数据
        model.setRowCount(0);
        // 1、实例化DAO类
        RepertoryDAO dao = new RepertoryDAO();
        // 2、调用查询所有的方法
        List<Repertory> list = null;
        if ("".equals(key)) {
            list = dao.selectAll();
        } else {
            list = dao.selectByAll(key);
        }
        // 3、循环遍历每个实体类，实体类转成一维数组
        for (Repertory aa : list) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            model.addRow(row);
        }

    }

    public void bindData() {
        // ①清空原来的数据
        model.setRowCount(0);
        // 实例化dao类
        RepertoryDAO dao = new RepertoryDAO();
        List<Repertory> list2 = dao.selectAll();
        // ②遍历list集合,将数据绑定到表格中
        for (Repertory aa : list2) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            // ④将一维数组（行）添加到表格的model对象中
            model.addRow(row);
        }

        // ⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = table.getTableHeader();
        int rowCount = table.getRowCount();
        Enumeration columns = table.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer()
                    .getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) table.getCellRenderer(row, col)
                        .getTableCellRendererComponent(table, table.getValueAt(row, col), false, false, row, col)
                        .getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + table.getIntercellSpacing().width);
        }
    }

}

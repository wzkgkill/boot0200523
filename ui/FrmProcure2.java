package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.omg.CORBA.PUBLIC_MEMBER;

import dao.JinHuoDAO;
import dao.RepertoryDAO;
import dao.StockDAO;
import dao.SupplierDAO;
import dao.WareHouseDAO;
import entity.Employee;
import entity.Repertory;
import entity.Stock;
import entity.Supplier;
import entity.WareHouse;
import ui.AddNewPro.FrmAddNewMain;
import ui.AddOldPro.FrmAddOldMain;
import util.DatePicker;
import util.MyUtil;

import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class FrmProcure2 extends JFrame {

    private JPanel panelmain;
    private JPanel panel1;
    private JTextField txtBz;
    private JTextField txtYMoney;
    private JTextField txtSMoney;
    private JTextField txtDanHao;
    private JTable table;
    private JTable xuanFuTable;
    private JTextField textField_1;
    private JTextField txtDate;

    private Employee employee;
    private JComboBox comCaoZuoYuan;
    WareHouseDAO caigoudao = new WareHouseDAO();// 采购单
    StockDAO xqDao = new StockDAO();// 采购详情
    private String zhua;
    private Repertory shiti;
    private List<Repertory> ccList = new ArrayList<>();
    // 悬浮
    private Popup pop = null;// 1.创建空白的popup的悬浮
    private JPanel xuanFuMain;
    private JButton btnChaZhao;
    private JTextField txtGHS;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProcure2 frame = new FrmProcure2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmProcure2(Employee employee) {
        this();
        this.employee = employee;
        // 给经办人赋值
        comCaoZuoYuan.setSelectedItem(employee.getPname());
        // 给采购单号赋值
        txtDanHao.setText(MyUtil.genrateNo("On"));
        System.out.println("单号");
    }

    /**
     * Create the frame.
     */
    public FrmProcure2() {
        setVisible(true);
        setTitle("采购进货");
        setIconImage(new ImageIcon("src/images/超市图标.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1156, 720);
        panelmain = new JPanel();
        panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelmain.setLayout(new BorderLayout(0, 0));
        setContentPane(panelmain);
        // setLocationRelativeTo(null);
        setLocation(254, 249);// 绝对定位

        JPanel panel = new JPanel();
        panelmain.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(255, 255, 153));
        tabbedPane.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(tabbedPane, BorderLayout.CENTER);

        JPanel panel1 = new JPanel();

        tabbedPane.addTab("采购进货", null, panel1, null);
        panel1.setLayout(new BorderLayout(0, 0));

        JPanel panel2 = new JPanel();
        panel1.add(panel2, BorderLayout.NORTH);
        panel2.setLayout(new BorderLayout(0, 0));

        JPanel panel3 = new JPanel();
        FlowLayout fl_panel3 = (FlowLayout) panel3.getLayout();
        fl_panel3.setVgap(10);
        panel2.add(panel3, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("采购进货");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 33));
        panel3.add(lblNewLabel);

        JPanel panel4 = new JPanel();
        panel2.add(panel4, BorderLayout.SOUTH);
        panel4.setLayout(new BorderLayout(0, 0));

        JPanel panel5 = new JPanel();
        panel1.add(panel5, BorderLayout.CENTER);
        panel5.setLayout(new BorderLayout(0, 10));

        JPanel panel6 = new JPanel();
        panel6.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel6.setBackground(SystemColor.inactiveCaptionBorder);
        panel5.add(panel6, BorderLayout.NORTH);
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));

        Component horizontalStrut_10 = Box.createHorizontalStrut(10);
        panel6.add(horizontalStrut_10);

        JLabel lblNewLabel_2 = new JLabel("供货商：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6.add(lblNewLabel_2);

        txtGHS = new JTextField();
        txtGHS.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtGHS.setEditable(false);
        txtGHS.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6.add(txtGHS);
        txtGHS.setColumns(10);

        Component horizontalStrut_9 = Box.createHorizontalStrut(10);
        panel6.add(horizontalStrut_9);

        btnChaZhao = new JButton("");
        btnChaZhao.setBorder(null);
        btnChaZhao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(btnChaZhao);// 显示悬浮窗口，显示在我要求显示的组件的下面，也就是你要的父级窗口
            }
        });
        btnChaZhao.setFocusPainted(false);
        btnChaZhao.setPreferredSize(new Dimension(28, 29));
        btnChaZhao.setIcon(new ImageIcon(FrmProcure2.class.getResource("/images/搜索.png")));
        panel6.add(btnChaZhao);
        cc();

        Component horizontalStrut_7 = Box.createHorizontalStrut(20);
        panel6.add(horizontalStrut_7);

        JLabel lblNewLabel_6 = new JLabel("收货仓库：");
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6.add(lblNewLabel_6);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBackground(Color.WHITE);
        comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"主仓库", "酒库", "饮料库"}));
        panel6.add(comboBox_1);

        Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        panel6.add(horizontalStrut_8);

        JLabel lblNewLabel_8 = new JLabel("进货日期：");
        lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6.add(lblNewLabel_8);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtDate = new JTextField(df.format(System.currentTimeMillis()));
        txtDate.setBorder(null);
        // 创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        // 将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser1.register(txtDate);
        // 设置文本框不可编辑
        txtDate.setEditable(false);
        txtDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel6.add(txtDate);
        txtDate.setColumns(10);

        Component horizontalStrut_1 = Box.createHorizontalStrut(250);
        panel6.add(horizontalStrut_1);

        JPanel panel7 = new JPanel();
        panel5.add(panel7, BorderLayout.CENTER);
        panel7.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel7.add(panel_6, BorderLayout.NORTH);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JButton btnAddOldPro = new JButton("老商品添加（F2）");
        btnAddOldPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmAddOldMain(FrmProcure2.this);

            }
        });
        btnAddOldPro.setFocusPainted(false);
        btnAddOldPro.setBounds(new Rectangle(0, 2, 0, 0));
        btnAddOldPro.setBackground(new Color(135, 206, 250));
        btnAddOldPro.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(btnAddOldPro);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_6.add(horizontalStrut);

        JButton btnAddNewPro = new JButton("新商品添加（F9）");
        btnAddNewPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmAddNewMain(FrmProcure2.this);

            }
        });
        btnAddNewPro.setFocusPainted(false);
        btnAddNewPro.setBackground(new Color(135, 206, 250));
        btnAddNewPro.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(btnAddNewPro);

        JPanel panel_7 = new JPanel();
        panel7.add(panel_7, BorderLayout.SOUTH);
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

        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断采购是否选择供货商
                if ("".equals(txtGHS.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择供货商");
                    return;
                }
                // 判断采购单是否存在数据
                if (table.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "请添加你的采购数据");
                    return;
                }
                // 进货单号
                String nu = txtDanHao.getText().trim();
                // 进货日期
                String date = txtDate.getText().trim();
                // 供货商名称
                String ghname = txtGHS.getText().trim();
                // 应付总金额
                String totalmoney = txtYMoney.getText().trim();
                BigDecimal totalmoney2 = new BigDecimal(totalmoney);
                // 实付金额
                String smoney = txtSMoney.getText().trim();
                BigDecimal smoney2 = new BigDecimal(smoney);
                // 操作人
                String people = comCaoZuoYuan.getSelectedItem().toString();

                // 组装采购表的实体类
                // "单据号", "开单日期", "供货商名称", "应付金额", "实付金额","操作员"
                WareHouse wareHouse = new WareHouse(nu, java.sql.Date.valueOf(date), ghname, totalmoney2, smoney2,
                        people);
                // 新增采购详情
                caigoudao.doInsert(wareHouse);
                // 同时新增多条采购详情
                int num = table.getRowCount();
                System.out.println("num" + num);
                for (int i = 0; i < table.getRowCount(); i++) {
                    // 采购进货表字段--"商品编号", "商品名称", "规格","建议进价", "当前进价", "数量", "总金额"
                    // 当前行的商品编号
                    // System.out.println("EEEEEEEEEEEEEEEE");
                    String id = table.getValueAt(i, 0).toString();
                    System.out.println(id);
                    // 当前行的采购数量
                    String c = table.getValueAt(i, 5).toString();
                    Integer c2 = Integer.valueOf(c);
                    // 当前行的采购价格
                    String p = table.getValueAt(i, 4).toString();
                    BigDecimal p2 = new BigDecimal(p);
                    // 组装采购详情表的实体类
                    Stock stock = new Stock(null, nu, id, p2, c2);
                    // 新增采购详情
                    xqDao.doInsert(stock);
                    System.out.println(stock);

                    // 修改老商品和新商品的库存（都适用） 商品编号 和采购数量
                    Repertory re = new Repertory(id, null, null, null, null, null, null, null, c2, null, null, null);
                    RepertoryDAO dao = new RepertoryDAO();
                    dao.doUpdateKuCun(re);
                    System.out.println("执行成功：" + i);

                    // 新商品新增的另一种思路
                    // RepertoryDAO dao2=new RepertoryDAO();
                    // System.out.println(ccList.size()+"aaaa");
                    // if(ccList.size()>0) {
                    // for (Repertory ac : ccList) {
                    // dao2.doCreate(ac);
                    // }
                    // }else {
                    // System.out.println("新商品新增错误");
                    // }

                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                txtGHS.setText("");
                txtYMoney.setText("");
                txtSMoney.setText("0.00");
                // 清空表格
                model.setRowCount(0);
            }
        });
        btnSure.setFocusPainted(false);// 是否绘制焦点
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(btnSure);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        panel_8.add(horizontalStrut_5);

        JButton btnQuit = new JButton("退出");
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmProcure2.this.dispose();

            }
        });
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
        txtYMoney.setForeground(Color.RED);
        txtYMoney.setEditable(false);
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
        txtSMoney.setText("0.00");
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

        comCaoZuoYuan = new JComboBox();
        comCaoZuoYuan.setBackground(Color.WHITE);
        comCaoZuoYuan.setFont(new Font("宋体", Font.PLAIN, 20));
        comCaoZuoYuan.setModel(new DefaultComboBoxModel(new String[]{"admin", "jack", "tom", "amy"}));
        panel_10.add(comCaoZuoYuan);

        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut_4);

        JLabel lblNewLabel_13 = new JLabel("原始单号：");
        lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(lblNewLabel_13);

        txtDanHao = new JTextField();
        txtDanHao.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtDanHao.setOpaque(false);
        txtDanHao.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(txtDanHao);
        txtDanHao.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        panel7.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{

        }, new String[]{"商品编号", "商品名称", "规格", "建议进价", "当前进价", "数量", "总金额"}));
        {
            // 设置行高
            table.setRowHeight(30);
            // 设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            // hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            // hh.setBackground(new Color(240, 255, 255));// 前景颜色
            // hh.setPreferredSize(new Dimension(hh.getWidth(),(40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            // 设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table);

        // JPanel panel_1 = new JPanel();
        // tabbedPane.addTab("单据审核", null, panel_1, null);
    }

    /**
     * 新商品行添加
     *
     * @param ssid
     * @param sname
     * @param sunit
     * @param ysmoney
     * @param caigouprice
     * @param count
     * @param price
     */
    public void addRow(String ssid, String sname, String sunit, String ysmoney, String caigouprice, String count,
                       String price) {
        // "商品编号", "商品名称", "单位","预设进价", "当前进价", "数量", "总金额"
        Object[] row = {ssid, sname, sunit, ysmoney, caigouprice, count, price};
        System.out.println("98");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(row);
        computeSum();// 计算累计金额
    }

    /**
     * 老商品行添加
     *
     * @param repertory
     * @param count
     * @param price
     */
    public void addRow2(Repertory repertory, String count, String price) {
        // 判断商品编号是否存在
        DefaultTableModel model2 = (DefaultTableModel) table.getModel();
        // 1、遍历当前的表格数据模型（获取每一行）
        for (int i = 0; i < model2.getRowCount(); i++) {
            // 获取行
            String id = model2.getValueAt(i, 0).toString();
            if (id.equals(repertory.getRsid().toString())) {
                // 当前商品存在于i行
                String c = model2.getValueAt(i, 5).toString();
                BigDecimal ccc = new BigDecimal(c);
                ccc = ccc.add(new BigDecimal(count));
                model2.setValueAt(ccc, i, 5);
                model2.setValueAt(price, i, 4);
                BigDecimal total = ccc.multiply(new BigDecimal(price));
                model2.setValueAt(total, i, 6);
                computeSum();// 调用总计方法
                return;
            }
        }
        Object[] row2 = {repertory.getRsid(), repertory.getRname(), repertory.getRunit(), repertory.getRprice(), price,
                count, new BigDecimal(count).multiply(new BigDecimal(price))};
        // 加 add 减subtract 乘multiply 除 divide
        model2.addRow(row2);
        computeSum();
    }

    // 计算累计金额
    public void computeSum() {
        // 获取每一行的最后一列的值，将其转换成数字之后累加。填充到应付金额框
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < table.getRowCount(); i++) {
            String a = table.getValueAt(i, table.getColumnCount() - 1).toString();
            sum = sum.add(new BigDecimal(a));
        }

        txtYMoney.setText(sum.toString());
    }

    /**
     * @param aa
     * @return
     */
    /**
     * 新商品入库
     *
     * @param aa
     * @return
     */
    public Repertory ruk(Repertory aa) {
        shiti = aa;
        System.out.println(shiti);
        ccList.add(shiti);
        return shiti;
    }

    // 4.写一个不显示组件的窗口方法。下面所有组件都是你要显示在悬浮窗口上的组件
    public void cc() {
        xuanFuMain = new JPanel();
        xuanFuMain.setPreferredSize(new Dimension(734, 374));
        JPanel panel3 = new JPanel();
        panel3.add(xuanFuMain, BorderLayout.CENTER);
        xuanFuMain.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        xuanFuMain.add(scrollPane, BorderLayout.CENTER);

        xuanFuTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;// 不可编辑
            }
        };
        xuanFuTable.setModel(new DefaultTableModel(new Object[][]{
                {null, null, null, null, null},
        },
                new String[]{"编号", "供货商名称", "联系人", "联系电话", "联系地址"}));
        {
            // 设置行高
            xuanFuTable.setRowHeight(30);
            // 设置表头对象
            JTableHeader hh = xuanFuTable.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.BOLD, 19));// 字体
            // hh.setBackground(SystemColor.inactiveCaptionBorder);// 前景颜色
            hh.setBackground(new Color(255, 255, 240));
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));// 40 指的是表头的高度
            xuanFuTable.setTableHeader(hh);
            // 设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            xuanFuTable.setDefaultRenderer(Object.class, render);
            xuanFuTable.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        }
        scrollPane.setViewportView(xuanFuTable);
        loadDataXuanFu();
        JPanel btnPanel = new JPanel();
        xuanFuMain.add(btnPanel, BorderLayout.SOUTH);

        JButton btnGhsSure = new JButton("确定");
        btnGhsSure.setFocusPainted(false);
        btnGhsSure.setBackground(new Color(135, 206, 250));
        btnGhsSure.setFont(new Font("宋体", Font.PLAIN, 20));
        btnGhsSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取表格选中的行
                int rowIndex = xuanFuTable.getSelectedRow();
                //2、判断是否选中
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中要使用的供货商数据行");
                    return;
                }
                //3、获取选中行的数据
                //创建一维数组,长度就是列的数量
                String[] row = new String[xuanFuTable.getColumnCount()];
                for (int i = 0; i < xuanFuTable.getColumnCount(); i++) {
                    //数组第一个值----表格中的第一列
                    //数组第二个值----表格中的第二列
                    //……………………
                    row[i] = xuanFuTable.getValueAt(rowIndex, i).toString();
                }
                //给供货商名称文本框赋值
                txtGHS.setText(row[1]);
                gu();
            }
        });
        btnPanel.add(btnGhsSure);
        btnPanel.setBackground(SystemColor.inactiveCaptionBorder);
        Component horizontalStrut = Box.createHorizontalStrut(100);
        btnPanel.add(horizontalStrut);

        JButton btnGhsEsc = new JButton("退出");
        btnGhsEsc.setFocusPainted(false);
        btnGhsEsc.setBackground(new Color(135, 206, 250));
        btnGhsEsc.setFont(new Font("宋体", Font.PLAIN, 20));
        btnGhsEsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gu();
            }
        });
        btnPanel.add(btnGhsEsc);
    }

    // 2.写一个触发的方法
    public void showPanel(Component owner) {// 触发的方法。参数是你要让那个组件作为你的父级窗口 触发悬浮
        if (pop != null)
            pop.hide();
        // 下面的组件，就是你要触发显示的那个组件
        Point show = new Point(0, txtGHS.getHeight() + 5);// 接受二个int参数让他显示在父级窗口哪个位置，
        // 第一个参数是x轴，0是在父级窗口对应的0，第二个是y轴，默认获取的是你要设置哪个组件的高度，并显示在他下方。
        SwingUtilities.convertPointToScreen(show, txtGHS);// 显示在哪个组件的下方。

        pop = PopupFactory.getSharedInstance().getPopup(owner, xuanFuMain, show.x, show.y);// x和y都是int类型，以你定好的窗口位置，xy轴移动
        // 这个上面的panel 就是你要显示的悬浮窗口
        pop.show();// 悬浮开始的方法
    }

    // 3.写一个关闭的方法
    public void gu() {
        pop.hide();// 悬浮关闭的方法
    }

    /**
     * 绑定供货商数据到供货商表格中
     */
    public void loadDataXuanFu() {
        DefaultTableModel model = (DefaultTableModel) xuanFuTable.getModel();
        // 清空表格
        model.setRowCount(0);
        /// 实例化DAO类
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> list = dao.selectAll();
        for (Supplier s : list) {
            if (s.getSupstatu() == true) {
                Object[] row = {
                        s.getSupid(),
                        s.getSupname(),
                        s.getSuppeople(),
                        s.getSuptel(),
                        s.getSupadress()
                };
                model.addRow(row);
            }
        }
        fitColumn();
    }

    private void fitColumn() {// ⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
        xuanFuTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = xuanFuTable.getTableHeader();
        int rowCount = xuanFuTable.getRowCount();
        Enumeration columns = xuanFuTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer()
                    .getTableCellRendererComponent(xuanFuTable, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) xuanFuTable.getCellRenderer(row, col)
                        .getTableCellRendererComponent(xuanFuTable, xuanFuTable.getValueAt(row, col), false, false, row, col)
                        .getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + xuanFuTable.getIntercellSpacing().width);
        }
    }
    // public void zt(String a) {
    //
    // zhua=a;
    //
    // }
    // /**
    // * 采购订单页面商品入库
    // */
    // public void baoCun() {
    // List<Object>list1=new ArrayList<>();
    // List<Object>list2=new ArrayList<>();
    // for(int i=0;i<table.getRowCount();i++) {
    // //采购进货表字段--"商品编号", "商品名称", "规格","预设进价", "当前进价", "数量", "总金额", "审核状态"
    // for(int y=0;y<table.getColumnCount();y++) {
    //
    // Object abc= table.getValueAt(i, y);
    //
    //
    // }
    // JinHuoDAO dao=new JinHuoDAO();
    // dao.insert(jh);
    //
    // }
    //
    // }

}

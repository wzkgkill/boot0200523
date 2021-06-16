package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.RepertoryDAO;
import dao.StockDAO;
import dao.WareHouseDAO;
import entity.Repertory;
import entity.Stock;
import entity.WareHouse;
import util.DatePicker;
import util.MyUtil;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

public class FrmRecipt extends JFrame {

    ///实例化DAO类
    WareHouseDAO dao = new WareHouseDAO();
    List<WareHouse> list = null;
    private JPanel contentPane;
    private JTextField txtDanJuHao;
    private JTextField txtStartDate;
    private JTextField txtDownDate;
    private JTable tableMain;
    private JTable tableDetails;
    private JComboBox comboBoxGHS;
    private JTable table;
    private JLabel lblWZFMoney;
    private JLabel lblTotalMoney;
    private JLabel lblShiFuMoney;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmRecipt frame = new FrmRecipt();
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
    public FrmRecipt() {
        setTitle("单据查询");
        setIconImage(new ImageIcon("src/images/超市图标.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1156, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);
        setLocation(254, 249);//绝对定位

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("供货商名称：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(lblNewLabel);

        comboBoxGHS = new JComboBox();
        comboBoxGHS.setBackground(Color.WHITE);
        comboBoxGHS.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团", "正龙集团", ""}));
        comboBoxGHS.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(comboBoxGHS);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut);

        JLabel label = new JLabel("单据号：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(label);

        txtDanJuHao = new JTextField();
        txtDanJuHao.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(txtDanJuHao);
        txtDanJuHao.setColumns(17);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut_1);

        JLabel label_1 = new JLabel("日期：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(label_1);

        //txtStartDate = new JTextField();
        Calendar calendar = Calendar.getInstance();
        //获取下个月的今天
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) - 1;
        String month2 = "";
        if (month < 10) {
            month2 = "0" + month;
            System.out.println("月份" + month2);
        } else {
            month2 = month + "";
        }
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        txtStartDate = new JTextField(year + "-" + month + "-" + day);
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser2 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser2.register(txtStartDate);
        //设置文本框不可编辑
        txtStartDate.setEditable(false);
        txtStartDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(txtStartDate);
        txtStartDate.setColumns(13);

        JLabel lblNewLabel_1 = new JLabel("-");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(lblNewLabel_1);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtDownDate = new JTextField(df.format(System.currentTimeMillis()));
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser1.register(txtDownDate);
        //设置文本框不可编辑
        txtDownDate.setEditable(false);
        txtDownDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(txtDownDate);
        txtDownDate.setColumns(13);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut_2);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //多条件组合查询
                loadData1();

            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBackground(new Color(135, 206, 250));
        panel_1.add(btnNewButton);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.NORTH);

        tableMain = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        tableMain.setPreferredScrollableViewportSize(new Dimension(450, 300));
        tableMain.setMaximumSize(new Dimension(0, 300));
        tableMain.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "单据号", "开单日期", "供货商名称", "应付金额", "实付金额", "操作员"
                }
        ));
        {
            //设置行高
            tableMain.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = tableMain.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            tableMain.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            tableMain.setDefaultRenderer(Object.class, render);
            tableMain.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(tableMain);

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_3.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        Component horizontalGlue = Box.createHorizontalGlue();
        panel_4.add(horizontalGlue);

        JLabel label_3 = new JLabel("总采购金额：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(label_3);

        lblTotalMoney = new JLabel();
        lblTotalMoney.setText("0");
        lblTotalMoney.setForeground(Color.RED);
        lblTotalMoney.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblTotalMoney);

        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_4);

        JLabel label_2 = new JLabel("实付金额：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(label_2);

        lblShiFuMoney = new JLabel();
        lblShiFuMoney.setText("0");
        lblShiFuMoney.setForeground(Color.RED);
        lblShiFuMoney.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblShiFuMoney);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_5);

        JLabel lblNewLabel_2 = new JLabel("共计待付金额：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblNewLabel_2);

        lblWZFMoney = new JLabel();
        lblWZFMoney.setForeground(Color.RED);
        lblWZFMoney.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_4.add(lblWZFMoney);

        Component horizontalStrut_3 = Box.createHorizontalStrut(10);
        panel_4.add(horizontalStrut_3);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_3.add(scrollPane_1, BorderLayout.CENTER);

//		table = new JTable();
//		scrollPane_1.setViewportView(table);

        tableDetails = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        tableDetails.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "商品编号", "商品名称", "单位", "单价", "数量", "总金额"
                }
        ));
        {
            //设置行高
            tableDetails.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = tableDetails.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            tableDetails.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            tableDetails.setDefaultRenderer(Object.class, render);
            tableDetails.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane_1.setViewportView(tableDetails);
        loadData();
        //给table_1添加双击事件
        tableMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    //获取选中的行
                    int index = tableMain.getSelectedRow();
                    //获取第一列的订单编号
                    String inno = tableMain.getValueAt(index, 0).toString();
                    StockDAO listdao = new StockDAO();
                    List<Stock> list = listdao.selectByWorder(inno);
                    DefaultTableModel model = (DefaultTableModel) tableDetails.getModel();
                    //清空表格
                    model.setRowCount(0);
                    System.out.println(list + "yyy");
                    for (Stock l : list) {
                        Object[] row = {
                                //"商品编号", "商品名称","单位", "单价", "数量", "总金额"
                                l.getSsid(),
                                l.getName(),
                                l.getUnit(),
                                l.getSprice(),//单价
                                l.getSordersize(),//数量
                                new BigDecimal(l.getSordersize()).multiply(l.getSprice())

                        };
                        model.addRow(row);
                    }
                }
                fitColumn();
            }
        });
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) tableMain.getModel();
        model.setRowCount(0);
//		"单据号", "开单日期", "供货商名称", "应付金额", "实付金额","操作员"
        WareHouseDAO caigoudao = new WareHouseDAO();
        List<WareHouse> list = caigoudao.selectAll();
        for (WareHouse wa : list) {
            Object[] row = {
                    wa.getWorder(),
                    wa.getWorderdata(),
                    wa.getWsource(),
                    wa.getWypay(),
                    wa.getWspaid(),
                    wa.getWauditor()
            };
            model.addRow(row);
        }
        totalMoney();//总应付金额
        shiFuMoney();//总实付金额
        computeSum();//计算待支付金额
    }


    /**
     * 模糊查询   //String worder单据号,Date start,Date down,String wsource供货商
     */
    public void loadData1() {
        String worder = txtDanJuHao.getText().trim();//单据号
        String wsource = comboBoxGHS.getSelectedItem().toString();//供货商

        String START = txtStartDate.getText().trim();
        Date START1 = java.sql.Date.valueOf(START);

        String DOWN = txtDownDate.getText().trim();
        Date DOWN1 = java.sql.Date.valueOf(DOWN);

        List<WareHouse> list = dao.selectByWord(worder, START1, DOWN1, wsource);
        DefaultTableModel model = (DefaultTableModel) tableMain.getModel();
        model.setRowCount(0);
        if (list == null || list.isEmpty()) {
            return;
        }
        //一行一行的添加数据
        for (WareHouse r : list) {
            Object[] row = {
                    r.getWorder(),
                    r.getWorderdata(),
                    r.getWsource(),
                    r.getWypay(),
                    r.getWspaid(),
                    r.getWauditor()
            };
            model.addRow(row);
        }
        totalMoney();//总应付金额
        shiFuMoney();//总实付金额
        computeSum();//计算待支付金额
        fitColumn();//单元格宽度自适应
    }

    /**
     * 总采购金额
     */
    public void totalMoney() {
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < tableMain.getRowCount(); i++) {
            String yinfu = tableMain.getValueAt(i, tableMain.getColumnCount() - 3).toString();
            total = total.add(new BigDecimal(yinfu));
        }
        lblTotalMoney.setText(total.toString());
    }

    /**
     * 实付金额
     */
    public void shiFuMoney() {
        BigDecimal totalshiFu = new BigDecimal("0");
        for (int i = 0; i < tableMain.getRowCount(); i++) {
            String yinfu = tableMain.getValueAt(i, tableMain.getColumnCount() - 2).toString();
            totalshiFu = totalshiFu.add(new BigDecimal(yinfu));
        }
        lblShiFuMoney.setText(totalshiFu.toString());
    }

    /**
     * 计算待支付金额
     */
    public void computeSum() {
        //获取每一行的最后一列的值，将其转换成数字之后累加。填充到应付金额框
        BigDecimal sum = new BigDecimal("0"); //实付
        BigDecimal ysum = new BigDecimal("0"); //应付
        for (int i = 0; i < tableMain.getRowCount(); i++) {
            String a = tableMain.getValueAt(i, tableMain.getColumnCount() - 2).toString();//实付
            String b = tableMain.getValueAt(i, tableMain.getColumnCount() - 3).toString();//应付
            sum = sum.add(new BigDecimal(a));//实付
            ysum = ysum.add(new BigDecimal(b));//应付
        }
        BigDecimal dmoney = ysum.subtract(sum);//待支付金额
        lblWZFMoney.setText(dmoney.toString());

    }

    //⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
    private void fitColumn() {
        tableMain.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = tableMain.getTableHeader();
        int rowCount = tableMain.getRowCount();
        Enumeration columns = tableMain.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer().getTableCellRendererComponent
                    (tableMain, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) tableMain.getCellRenderer(row, col).getTableCellRendererComponent
                        (tableMain, tableMain.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + tableMain.getIntercellSpacing().width);
        }
    }

}

package ui.SystemSetup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import util.DatePicker;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmVIP extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table11;
    private JTable table12;
    private JTable table_2;
    private JTextField txtIDName;
    private JTable table_4;
    private JTextField txtName;
    private JTable table_3;
    private JTextField txtStartDate;
    private JTextField txtDownDate;
    private JTextField txtStartDate2;
    private JTextField txtDownDate2;
    private JTextField txtStartDate3;
    private JTextField txtDownDate3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmVIP frame = new FrmVIP();
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
    public FrmVIP() {
        setVisible(true);
        setTitle("会员管理");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1201, 828);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(152, 251, 152));
        tabbedPane.setForeground(Color.DARK_GRAY);
        tabbedPane.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(tabbedPane, BorderLayout.CENTER);

        JPanel panel8 = new JPanel();
        tabbedPane.addTab("会员信息管理", null, panel8, null);
        panel8.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel8.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_5.setBackground(SystemColor.inactiveCaptionBorder);
        panel_3.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JButton button = new JButton("增加会员");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmVIPAddVIP();

            }
        });
        button.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/增加会员.png")));
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setFont(new Font("宋体", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_5.add(button);

        Component horizontalStrut = Box.createHorizontalStrut(50);
        panel_5.add(horizontalStrut);

        JButton button_1 = new JButton("修改会员");
        button_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmVIPUpdateVIP();

            }
        });
        button_1.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/修改会员.png")));
        button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_1.setHorizontalTextPosition(SwingConstants.CENTER);
        button_1.setFont(new Font("宋体", Font.PLAIN, 20));
        button_1.setFocusPainted(false);
        button_1.setContentAreaFilled(false);
        button_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_5.add(button_1);

        Component horizontalStrut_1 = Box.createHorizontalStrut(50);
        panel_5.add(horizontalStrut_1);

        JButton button_2 = new JButton("删除会员");
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取选中行的索引
                int rowIndex = table11.getSelectedRow();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中您要删除的行.");
                    return;
                }
//				//2、获取选中行的主键编号
//				String ID = table.getValueAt(rowIndex, 0).toString();
//				//3、调用DAO方法进行删除	
//				ProductDAO dao = new ProductDAO();
//				boolean flag = dao.doDelete(Integer.valueOf(ID));
//				//4、更新表格数据
//				//4.1  第一种方式：重新绑定数据到表格
//				//	①调用对应的方法（selectAll）
//				List<Product> list = dao.selectAll();
//				//	②调用表格数据绑定的方法
//				bindData(list);
//				//4.2  第二种方式：直接删除当前选中行				
//				bindData2();//再次调用分页的方法，更新下面分页的属性的值
            }

        });
        button_2.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/删除会员.png")));
        button_2.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_2.setHorizontalTextPosition(SwingConstants.CENTER);
        button_2.setFont(new Font("宋体", Font.PLAIN, 20));
        button_2.setFocusPainted(false);
        button_2.setContentAreaFilled(false);
        button_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_5.add(button_2);

        Component horizontalStrut_2 = Box.createHorizontalStrut(50);
        panel_5.add(horizontalStrut_2);

        JButton button_3 = new JButton("会员级别");
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmVIPGradeVIP();
            }
        });
        button_3.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/会员级别.png")));
        button_3.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_3.setHorizontalTextPosition(SwingConstants.CENTER);
        button_3.setFont(new Font("宋体", Font.PLAIN, 20));
        button_3.setFocusPainted(false);
        button_3.setContentAreaFilled(false);
        button_3.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_5.add(button_3);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_3.add(panel_6, BorderLayout.SOUTH);

        JLabel lblNewLabel = new JLabel("会员信息：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(textField);
        textField.setColumns(10);

        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_6.add(horizontalStrut_6);

        JButton btnChaXun = new JButton("查询(F2)");
        btnChaXun.setBackground(new Color(135, 206, 250));
        btnChaXun.setFocusPainted(false);
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(btnChaXun);

        JPanel panel_4 = new JPanel();
        panel8.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_4.add(scrollPane, BorderLayout.NORTH);

        table11 = new JTable();
        table11.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "会员姓名", "会员级别", "账户金额", "总消费额", "联系电话"
                }
        ));
        {
            //设置行高
            table11.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table11.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            //hh.setBackground(SystemColor.inactiveCaptionBorder);// 前景颜色
            hh.setBackground(new Color(255, 255, 240));
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table11.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table11.setDefaultRenderer(Object.class, render);
            table11.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table11);

        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7, BorderLayout.CENTER);
        panel_7.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_7.add(scrollPane_1, BorderLayout.CENTER);

        table12 = new JTable();
        table12.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[]{
                        "\u9500\u552E\u5355\u53F7", "\u9500\u552E\u65E5\u671F", "\u6D88\u8D39\u91D1\u989D", "\u652F\u4ED8\u65B9\u5F0F", "\u64CD\u4F5C\u5458", "\u5907\u6CE8"
                }
        ));
        {
            //设置行高
            table12.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table12.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table12.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table12.setDefaultRenderer(Object.class, render);
            table12.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane_1.setViewportView(table12);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new EmptyBorder(10, 0, 5, 0));
        panel_7.add(panel_8, BorderLayout.NORTH);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("会员消费明细：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_1);

        Component horizontalStrut_7 = Box.createHorizontalStrut(400);
        panel_8.add(horizontalStrut_7);

        JLabel label = new JLabel("查询日期：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(label);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtStartDate = new JTextField(df.format(System.currentTimeMillis()));
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser1 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser1.register(txtStartDate);
        //设置文本框不可编辑
        txtStartDate.setEditable(false);
        txtStartDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(txtStartDate);
        txtStartDate.setColumns(10);

        Component horizontalStrut_3 = Box.createHorizontalStrut(10);
        panel_8.add(horizontalStrut_3);

        JLabel label_1 = new JLabel("至");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(label_1);

        Component horizontalStrut_4 = Box.createHorizontalStrut(10);
        panel_8.add(horizontalStrut_4);

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
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser2.register(txtDownDate);
        //设置文本框不可编辑
        txtDownDate.setEditable(false);
        txtDownDate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(txtDownDate);
        txtDownDate.setColumns(10);

        Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        panel_8.add(horizontalStrut_8);

        JButton btnChaXunF3 = new JButton("查询(F3)");
        btnChaXunF3.setBackground(new Color(135, 206, 250));
        btnChaXunF3.setFocusPainted(false);
        btnChaXunF3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(btnChaXunF3);

        Component horizontalStrut_9 = Box.createHorizontalStrut(20);
        panel_8.add(horizontalStrut_9);

//		JPanel panel_2 = new JPanel();
//		tabbedPane.addTab("会员续费查询", null, panel_2, null);
//		panel_2.setLayout(new BorderLayout(0, 0));
//		
//		JPanel panel_10 = new JPanel();
//		panel_2.add(panel_10, BorderLayout.NORTH);
//		panel_10.setLayout(new BorderLayout(0, 0));
//		
//		JPanel panel_11 = new JPanel();
//		panel_11.setBackground(SystemColor.inactiveCaptionBorder);
//		panel_11.setBorder(new EmptyBorder(10, 10, 10, 0));
//		panel_10.add(panel_11, BorderLayout.CENTER);
//		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
//		
//		JButton btnDaoChu = new JButton("导出");
//		btnDaoChu.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/导出X.png")));
//		btnDaoChu.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnDaoChu.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnDaoChu.setFont(new Font("宋体", Font.PLAIN, 20));
//		btnDaoChu.setFocusPainted(false);
//		btnDaoChu.setContentAreaFilled(false);
//		btnDaoChu.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
//		panel_11.add(btnDaoChu);
//		
//		Component horizontalStrut_5 = Box.createHorizontalStrut(50);
//		panel_11.add(horizontalStrut_5);
//		
//		JButton btnDaYin = new JButton("打印");
//		btnDaYin.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/打印X.png")));
//		btnDaYin.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnDaYin.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnDaYin.setFont(new Font("宋体", Font.PLAIN, 20));
//		btnDaYin.setFocusPainted(false);
//		btnDaYin.setContentAreaFilled(false);
//		btnDaYin.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
//		panel_11.add(btnDaYin);
//		
//		Component horizontalStrut_11 = Box.createHorizontalStrut(50);
//		panel_11.add(horizontalStrut_11);
//		
//		JButton btnEsc = new JButton("退出");
//		btnEsc.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/退出 2.png")));
//		btnEsc.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnEsc.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnEsc.setFont(new Font("宋体", Font.PLAIN, 20));
//		btnEsc.setFocusPainted(false);
//		btnEsc.setContentAreaFilled(false);
//		btnEsc.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
//		panel_11.add(btnEsc);
//		
//		JPanel panel_12 = new JPanel();
//		panel_12.setBorder(new EmptyBorder(10, 0, 10, 0));
//		panel_10.add(panel_12, BorderLayout.SOUTH);
//		
//		JLabel label_3 = new JLabel("查询日期：");
//		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(label_3);
//		
//		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
//		txtStartDate2 = new JTextField(df2.format(System.currentTimeMillis()));			
//		//创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
//		DatePicker dateChooser3 = DatePicker.getInstance("yyyy-MM-dd");
//		//将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
//		dateChooser3.register(txtStartDate2);
//		//设置文本框不可编辑
//		txtStartDate2.setEditable(false);
//		txtStartDate2.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(txtStartDate2);
//		txtStartDate2.setColumns(15);
//		
//		JLabel label_2 = new JLabel("至");
//		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(label_2);
//		
//		Calendar calendar2=calendar.getInstance();
//		//获取下个月的今天
//		calendar2.setTime(new Date());
//		calendar2.add(calendar2.MONTH,+1);
//		int year2=calendar2.get(calendar2.YEAR);
//		int month2=calendar2.get(calendar2.MONTH)+1;
//		int day2=calendar2.get(calendar2.DAY_OF_MONTH);
//		txtDownDate2 = new JTextField(year2+"-"+month2+"-"+day2);			
//		//创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
//		DatePicker dateChooser4 = DatePicker.getInstance("yyyy-MM-dd");		
//		//将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
//		dateChooser4.register(txtDownDate2);
//		//设置文本框不可编辑
//		txtDownDate2.setEditable(false);
//		txtDownDate2.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(txtDownDate2);
//		txtDownDate2.setColumns(15);
//		
//		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
//		panel_12.add(horizontalStrut_12);
//		
//		JLabel lblNewLabel_2 = new JLabel("充值方式：");
//		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(lblNewLabel_2);
//		
//		JComboBox comboBox_4 = new JComboBox();
//		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"全部", "现金", "银行卡", "支付宝"}));
//		comboBox_4.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(comboBox_4);
//		
//		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
//		panel_12.add(horizontalStrut_13);
//		
//		JLabel lblNewLabel_3 = new JLabel("会员卡或姓名：");
//		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(lblNewLabel_3);
//		
//		txtIDName = new JTextField();
//		txtIDName.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(txtIDName);
//		txtIDName.setColumns(10);
//		
//		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
//		panel_12.add(horizontalStrut_14);
//		
//		JButton btnChaXun2 = new JButton("查询");
//		btnChaXun2.setBackground(new Color(135, 206, 250));  
//		btnChaXun2.setFocusPainted(false);
//		btnChaXun2.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_12.add(btnChaXun2);
//		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		panel_2.add(scrollPane_2, BorderLayout.CENTER);
//		
//		table_2 = new JTable();
//		table_2.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"交费日期", "会员卡号", "会员姓名", "续费金额", "实际支付", "优惠金额", "操作员", "充值方式", "备注"
//			}
//		));
//		{
//			//设置行高
//			table_2.setRowHeight(30);
//			//设置表头对象
//			JTableHeader hh = table_2.getTableHeader();
//			hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
//			//hh.setBackground(new Color(120, 192, 110));// 背景颜色
//			hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
//			hh.setBackground(new Color(255, 255, 240));// 前景颜色
//			hh.setPreferredSize(new Dimension(hh.getWidth(),(40)));//40 指的是表头的高度
//			table_2.setTableHeader(hh);
//			//设置表格内容居中
//			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
//			render.setHorizontalAlignment(SwingConstants.CENTER);
//			table_2.setDefaultRenderer(Object.class, render);
//			table_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
//}
//		scrollPane_2.setViewportView(table_2);

        JPanel panel_9 = new JPanel();
        tabbedPane.addTab("会员消费统计", null, panel_9, null);
        panel_9.setLayout(new BorderLayout(0, 0));

        JPanel panel_13 = new JPanel();
        panel_9.add(panel_13, BorderLayout.NORTH);
        panel_13.setLayout(new BorderLayout(0, 0));

        JPanel panel_15 = new JPanel();
        panel_15.setBackground(SystemColor.inactiveCaptionBorder);
        panel_15.setBorder(new EmptyBorder(10, 10, 10, 0));
        panel_13.add(panel_15, BorderLayout.CENTER);
        panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));

        JButton button_8 = new JButton("查看单据");
        button_8.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/会员查看单据.png")));
        button_8.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_8.setHorizontalTextPosition(SwingConstants.CENTER);
        button_8.setFont(new Font("宋体", Font.PLAIN, 20));
        button_8.setFocusPainted(false);
        button_8.setContentAreaFilled(false);
        button_8.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_15.add(button_8);

        Component horizontalStrut_17 = Box.createHorizontalStrut(50);
        panel_15.add(horizontalStrut_17);

        JButton button_10 = new JButton("退出");
        button_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVIP.this.dispose();
            }
        });
        button_10.setIcon(new ImageIcon(FrmVIP.class.getResource("/images/退出 2.png")));
        button_10.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_10.setHorizontalTextPosition(SwingConstants.CENTER);
        button_10.setFont(new Font("宋体", Font.PLAIN, 20));
        button_10.setFocusPainted(false);
        button_10.setContentAreaFilled(false);
        button_10.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        panel_15.add(button_10);

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_13.add(panel_16, BorderLayout.SOUTH);

        JLabel label_4 = new JLabel("查询日期：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_16.add(label_4);

        SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
        txtStartDate3 = new JTextField(df3.format(System.currentTimeMillis()));
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser5 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser5.register(txtStartDate3);
        //设置文本框不可编辑
        txtStartDate3.setEditable(false);
        txtStartDate3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_16.add(txtStartDate3);
        txtStartDate3.setColumns(15);

        JLabel label_5 = new JLabel("至");
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_16.add(label_5);

        Calendar calendar3 = Calendar.getInstance();
        //获取下个月的今天
        calendar3.setTime(new Date());
        calendar3.add(calendar3.MONTH, +1);
        int year3 = calendar3.get(calendar3.YEAR);
        int month3 = calendar3.get(calendar3.MONTH) + 1;
        int day3 = calendar3.get(calendar3.DAY_OF_MONTH);
        txtDownDate3 = new JTextField(year3 + "-" + month3 + "-" + day3);
        //创建日期控件面板，指定的日期格式是yyyy-MM-dd hh:mm:ss
        DatePicker dateChooser6 = DatePicker.getInstance("yyyy-MM-dd");
        //将日期控件指定到文本框textField中（textField就是你现有的文本框控件）
        dateChooser6.register(txtDownDate3);
        //设置文本框不可编辑
        txtDownDate3.setEditable(false);
        txtDownDate3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_16.add(txtDownDate3);
        txtDownDate3.setColumns(15);

        Component horizontalStrut_18 = Box.createHorizontalStrut(20);
        panel_16.add(horizontalStrut_18);

        JLabel label_6 = new JLabel("会员卡或姓名/单据号查询：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_16.add(label_6);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_16.add(txtName);

        Component horizontalStrut_19 = Box.createHorizontalStrut(20);
        panel_16.add(horizontalStrut_19);

        JButton button_11 = new JButton("查询");
        button_11.setFont(new Font("宋体", Font.PLAIN, 20));
        button_11.setFocusPainted(false);
        button_11.setBackground(new Color(135, 206, 250));
        panel_16.add(button_11);

        JPanel panel_14 = new JPanel();
        panel_9.add(panel_14, BorderLayout.CENTER);
        panel_14.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_4 = new JScrollPane();
        panel_14.add(scrollPane_4, BorderLayout.CENTER);

        table_4 = new JTable();
        table_4.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "商品编号", "商品名称", "单价", "数量", "单位", "总金额", "规格型号", "生产厂商"
                }
        ));
        {
            //设置行高
            table_4.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table_4.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table_4.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table_4.setDefaultRenderer(Object.class, render);
            table_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane_4.setViewportView(table_4);

        JPanel panel_17 = new JPanel();
        panel_14.add(panel_17, BorderLayout.NORTH);
        panel_17.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_3 = new JScrollPane();
        panel_17.add(scrollPane_3, BorderLayout.CENTER);

        table_3 = new JTable();
        table_3.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "卡号", "姓名", "销售单号", "销售日期", "消费金额", "储值卡", "现金", "银行卡", "代金券", "支付宝", "微信"
                }
        ));
        {
            //设置行高
            table_3.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table_3.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            //hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("微软雅黑", Font.PLAIN, 20));// 字体
            hh.setBackground(new Color(255, 255, 240));// 前景颜色
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table_3.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table_3.setDefaultRenderer(Object.class, render);
            table_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane_3.setViewportView(table_3);

        JPanel panel_18 = new JPanel();
        panel_18.setBorder(new EmptyBorder(0, 0, 5, 0));
        panel_17.add(panel_18, BorderLayout.SOUTH);
        panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));

        JLabel lblNewLabel_4 = new JLabel("消费明细：");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_18.add(lblNewLabel_4);
    }

}

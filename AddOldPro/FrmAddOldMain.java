package ui.AddOldPro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.RepertoryDAO;
import entity.Repertory;
import ui.FrmProcure2;
import ui.AddNewPro.FrmAddNewMain;
import util.MyUtil;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
/**
 * com.jtattoo.plaf.noire.NoireLookAndFeel  柔和黑
 * com.jtattoo.plaf.smart.SmartLookAndFeel 木质感+xp风格
 * com.jtattoo.plaf.mint.MintLookAndFeel  椭圆按钮+黄色按钮背景
 * com.jtattoo.plaf.mcwin.McWinLookAndFeel 椭圆按钮+绿色按钮背景
 * com.jtattoo.plaf.luna.LunaLookAndFeel  纯XP风格
 * com.jtattoo.plaf.hifi.HiFiLookAndFeel  黑色风格
 * com.jtattoo.plaf.fast.FastLookAndFeel  普通swing风格+蓝色边框
 * com.jtattoo.plaf.bernstein.BernsteinLookAndFeel  黄色风格
 * com.jtattoo.plaf.aluminium.AluminiumLookAndFeel 椭圆按钮+翠绿色按钮背景+金属质感
 * com.jtattoo.plaf.aero.AeroLookAndFeel xp清新风格
 * com.jtattoo.plafacryl.AcrylLookAndFeel 布质感+swing纯风格
 *
 * @author pika
 * 主题与布局
 */

/**
 * 老商品添加主页面
 */
public class FrmAddOldMain extends JFrame {

    private JPanel contentPane;
    private JTable table_1;
    private DefaultTableModel model;

    ///实例化DAO类
    RepertoryDAO dao = new RepertoryDAO();
    List<Repertory> list = null;
    private FrmProcure2 parentA;
    private JTextField txtBianHao;
    private JTextField txtName;
    private JTextField txtMin;
    private JTextField txtMax;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmAddOldMain frame = new FrmAddOldMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmAddOldMain(FrmProcure2 param) {
        this();
        this.parentA = param;
    }

    /**
     * Create the frame.
     */
    public FrmAddOldMain() {
        setVisible(true);
        setTitle("增加商品(采购进货)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 914, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocation(426, 249);//绝对定位

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_1.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u4EA7\u54C1\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        panel_4.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_7.setBackground(new Color(224, 255, 255));
        panel_7.setBackground(SystemColor.inactiveCaptionBorder);
        panel_5.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("步骤一：请输入产品编号、名称或价格查询产品，查询到产品后双击产品行添加到采购进货清单");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(lblNewLabel);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new EmptyBorder(5, 0, 5, 0));
        //panel_8.setBackground(new Color(224, 255, 255));
        panel_8.setBackground(SystemColor.inactiveCaptionBorder);
        panel_5.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("步骤二：直接选择产品清单的产品双击行添加到采购进货清单");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_1);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_9.setBackground(SystemColor.inactiveCaptionBorder);
        //panel_9.setBackground(new Color(224, 255, 255));
        panel_5.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("输入产品编号、名称或价格查询相应商品信息：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(lblNewLabel_2);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_4.add(panel_6, BorderLayout.SOUTH);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("编号：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_3);

        txtBianHao = new JTextField();
        txtBianHao.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(txtBianHao);
        txtBianHao.setColumns(10);

        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_6.add(horizontalStrut_4);

        JLabel label = new JLabel("名称：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(label);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_6.add(txtName);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        panel_6.add(horizontalStrut_5);

        JLabel label_1 = new JLabel("价格：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(label_1);

        txtMin = new JTextField();
        txtMin.setFont(new Font("宋体", Font.PLAIN, 20));
        txtMin.setColumns(8);
        panel_6.add(txtMin);

        JLabel label_2 = new JLabel("-");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(label_2);

        txtMax = new JTextField();
        txtMax.setFont(new Font("宋体", Font.PLAIN, 20));
        txtMax.setColumns(8);
        panel_6.add(txtMax);

        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_6.add(horizontalStrut_6);

        JButton btnChaXun = new JButton("查询");
        btnChaXun.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //多条件组合查询
                loadData1();
            }
        });
        btnChaXun.setBackground(new Color(135, 206, 250));
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(btnChaXun);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(new Color(0, 191, 255));
        panel_1.add(scrollPane_1, BorderLayout.CENTER);

        table_1 = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//不可编辑
            }
        };
        table_1.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "产品编号", "产品名称", "建议进价", "类别", "当前库存", "建议售价"
                }
        ));
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
//		model = new DefaultTableModel();
//		table_1= new JTable(model) {
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			};
//		};
        scrollPane_1.setViewportView(table_1);

        JPanel panel_10 = new JPanel();
        panel_1.add(panel_10, BorderLayout.SOUTH);

        JButton button_2 = new JButton("确定(F5)");
        button_2.setFont(new Font("宋体", Font.PLAIN, 20));
        button_2.setFocusPainted(false);
        button_2.setBackground(new Color(135, 206, 250));
        panel_10.add(button_2);

        JButton button_4 = new JButton("退出(Esc)");
        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAddOldMain.this.dispose();

            }
        });

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut_3);
        button_4.setFont(new Font("宋体", Font.PLAIN, 20));
        button_4.setFocusPainted(false);
        button_4.setBackground(new Color(135, 206, 250));
        panel_10.add(button_4);

        //调用加载数据的方法
        loadData(null);
        //给表格添加双击事件
        table_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标双击事件
                if (e.getClickCount() == 2) {
                    //1、获取当前选中的行号
                    int index = table_1.getSelectedRow();
                    //2、获取商品编号，第1列
                    String ID = table_1.getValueAt(index, 0).toString();
                    //3、通过循环获取list集合中对应的商品信息
                    for (Repertory r : list) {
                        if ((r.getRsid() + "").equals(ID)) {
                            //当前r对象表示选中的商品对象
                            FrmAddOldDetail oldDetail = new FrmAddOldDetail(parentA, r);
                        }
                    }
                }
            }
        });
    }

    //加载数据到表格中
    public void loadData(String word) {
        if (null == word || "".equals(word)) {
            list = dao.selectAll();
        } else {
            list = dao.selectByWord(word);
        }
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        //清空表格
        model.setRowCount(0);
        //"编号", "名称", "建议进价", "类别", "当前库存", "建议售价"
        for (Repertory r : list) {
            Object[] row = {
                    r.getRsid(),
                    r.getRname(),
                    r.getRprice(),
                    r.getRtype(),
                    r.getRinventory(),
                    r.getRmprice()
            };
            model.addRow(row);
        }
        fitColumn();
    }

    /**
     * 模糊查询
     */
    public void loadData1() {
        String rsid = txtBianHao.getText().trim();
        Integer min = null, max = null;
        String rname = txtName.getText().trim();
        //String rname=name;
        String MIN = txtMin.getText().trim();
        if (MyUtil.isInteger(MIN)) {
            min = Integer.parseInt(MIN);
        }
        String MAX = txtMax.getText().trim();
        if (MyUtil.isInteger(MAX)) {
            max = Integer.parseInt(MAX);
        }
        List<Repertory> list = dao.selectByWord(rsid, rname, min, max);
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0);
        if (list == null || list.isEmpty()) {
            return;
        }
        //一行一行的添加数据
        for (Repertory r : list) {
            Object[] row = {
                    r.getRsid(),
                    r.getRname(),
                    r.getRprice(),
                    r.getRtype(),
                    r.getRinventory()
            };
            model.addRow(row);
        }
    }

    //	//加载数据到表格中
//	public void loadData() {
//		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
//		//清空表格
//		model.setRowCount(0);
//		//"编号", "名称", "价格", "类别", "当前库存", 
//		for (Repertory r : list) {
//			Object[] row= {
//					r.getRsid(),
//					r.getRname(),
//					r.getRprice(),
//					r.getRtype(),
//					r.getRinventory()					
//			};
//			model.addRow(row);
//		}
//		fitColumn();
//	}
    private void fitColumn() {//⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
        table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = table_1.getTableHeader();
        int rowCount = table_1.getRowCount();
        Enumeration columns = table_1.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer().getTableCellRendererComponent
                    (table_1, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) table_1.getCellRenderer(row, col).getTableCellRendererComponent
                        (table_1, table_1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + table_1.getIntercellSpacing().width);
        }
    }
}

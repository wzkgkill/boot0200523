package ui.AddNewPro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.RepertoryDAO;
import entity.Repertory;
import ui.FrmProcure2;
import ui.AddOldPro.FrmAddOldDetail;
import ui.AddOldPro.FrmAddOldMain;
import util.MyUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class FrmAddNewMain extends JFrame {

    private JPanel contentPane;
    private JTextField txtShangXian;
    private JTextField txtJYmoney;
    private JTextField txtJSowmoney;
    private JTextField txtBZ;
    private JTextField txtAdress;
    private JTextField txtBianHao;
    private JTextField txtName;
    private JTextField txtXiaXian;
    private JTextField txtCaiGouPrice;
    private JTextField txtCaiGouCount;
    //给父级窗体设置全局变量
    private FrmProcure2 paranA;
    private FrmProcure2 ac;
    private JComboBox<String> comboBoxUnit;
    private JTextField txtKuCun;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmAddNewMain frame = new FrmAddNewMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmAddNewMain(FrmProcure2 paranA) {
        this();
        this.paranA = paranA;
    }

    /**
     * Create the frame.
     */
    public FrmAddNewMain() {
        setVisible(true);
        setTitle("增加商品");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 603, 689);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocation(513, 250);//绝对定位

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "商品基本信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new GridLayout(6, 2, 10, 15));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("商品名称：");
        lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_2.add(lblNewLabel_1);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_2.add(txtName);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("商品编号：");
        label_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_3.add(label_2);

        txtBianHao = new JTextField();
        java.util.Date aDate = new java.util.Date();//获得当前系统时间
        long time = aDate.getTime();//转成long类型
        String time2 = time + "";
        time2 = time2.substring(7, 11);//截取时间戳的4位数
        Date bDate = new Date(time);//转成sql的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//转换sql时间显示格式
        String cc = sdf.format(bDate);
        cc = cc.substring(2);//截取年月日
        String bianHao = cc + time2;//最终生成订单单号
        txtBianHao.setText(bianHao);
        //txtBianHao.setFocusable(false);//不可编辑

        txtBianHao.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBianHao.setColumns(10);
        panel_3.add(txtBianHao);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("所属类别：");
        label_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_4.add(label_1);

        JComboBox comboBoxType = new JComboBox();
        comboBoxType.setModel(new DefaultComboBoxModel(new String[]{"酒类", "饮料类", "食品类", "生活用品", "婴儿用品", "服装", "水果"}));
        comboBoxType.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBoxType.setBackground(Color.WHITE);
        panel_4.add(comboBoxType);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JLabel label = new JLabel("颜    色：");
        label.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_5.add(label);

        JComboBox comboBoxColor = new JComboBox();
        comboBoxColor.setModel(new DefaultComboBoxModel(new String[]{"白", "透明", "绿", "黄", "红", "黑", "橙", "青", "蓝", "紫", "粉"}));
        comboBoxColor.setFont(new Font("楷体", Font.PLAIN, 20));
        comboBoxColor.setBackground(Color.WHITE);
        panel_5.add(comboBoxColor);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("规格类型：");
        label_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_6.add(label_3);

        String[] guige = {"350ml", "6盒", "10个", "10条", "10斤", "12片", "12包", "12瓶", "20袋", "20件"};
        String[][] unit = {
                {"瓶", "罐"},
                {"箱"},
                {"盒", "包", "打"},
                {"包", "打", "箱"},
                {"箱", "袋"},
                {"箱", "盒", "包"},
                {"袋", "盒", "箱"},
                {"箱"},
                {"箱", "盒"},
                {"箱", "包"}
        };
        JComboBox<String> comboBoxGuiGe = new JComboBox<String>(guige);
        comboBoxGuiGe.insertItemAt("请选择规格", 0);
        comboBoxGuiGe.setSelectedIndex(0);
        comboBoxGuiGe.setBackground(Color.WHITE);
        comboBoxGuiGe.setFont(new Font("宋体", Font.PLAIN, 20));
        //comboBoxGuiGe.setModel(new DefaultComboBoxModel(new String[] {"350ml", "6盒", "10个", "10条", "10斤", "12包", "12片", "12瓶", "20袋", "20件"}));
        panel_6.add(comboBoxGuiGe);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("单    位：");
        label_4.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_7.add(label_4);

        comboBoxUnit = new JComboBox<String>();
        comboBoxUnit.setBackground(Color.WHITE);
        comboBoxUnit.setFont(new Font("楷体", Font.PLAIN, 20));
        //comboBoxUnit.setModel(new DefaultComboBoxModel(new String[] {"瓶", "罐", "箱", "盒", "包", "打", "袋"}));
        panel_7.add(comboBoxUnit);

//		//规格这个下拉列表，在选择发生改变的时候，要去填充“单位”下拉列表的值
        comboBoxGuiGe.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("我选中了一个规格");
                    //获取选中的值
                    int index = comboBoxGuiGe.getSelectedIndex();
                    //清除掉单位下拉列表里面的值
                    comboBoxUnit.removeAllItems();
                    if (index == 0) {
                        String[] myunit1 = unit[0];
                        for (String c : myunit1) {
                            comboBoxUnit.addItem(c.toString());
                        }
                    }
                    //根据索引获取二维数组对应的单位信息
                    String[] muUnit = unit[index - 1];
                    //清除掉单位下拉列表里面的值
                    comboBoxUnit.removeAllItems();
                    for (String c : muUnit) {
                        comboBoxUnit.addItem(c.toString());
                    }

                } else {
                    System.out.println("成功替换了一个规格");
                }
            }
        });


        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label_5 = new JLabel("库存上限：");
        label_5.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(label_5);

        txtShangXian = new JTextField();
        txtShangXian.setText("500");
        txtShangXian.setFont(new Font("宋体", Font.PLAIN, 20));
        txtShangXian.setColumns(10);
        panel_8.add(txtShangXian);

        JPanel panel_9 = new JPanel();
        panel_1.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_6 = new JLabel("库存下限：");
        label_6.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_9.add(label_6);

        txtXiaXian = new JTextField();
        txtXiaXian.setText("0");
        txtXiaXian.setFont(new Font("宋体", Font.PLAIN, 20));
        txtXiaXian.setColumns(10);
        panel_9.add(txtXiaXian);

        JPanel panel_10 = new JPanel();
        panel_1.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_7 = new JLabel("建议进价：");
        label_7.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_10.add(label_7);

        txtJYmoney = new JTextField();
        txtJYmoney.setFont(new Font("宋体", Font.PLAIN, 20));
        txtJYmoney.setColumns(10);
        panel_10.add(txtJYmoney);

        JPanel panel_11 = new JPanel();
        panel_1.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_8 = new JLabel("建议售价：");
        label_8.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_11.add(label_8);

        txtJSowmoney = new JTextField();
        txtJSowmoney.setFont(new Font("宋体", Font.PLAIN, 20));
        txtJSowmoney.setColumns(10);
        panel_11.add(txtJSowmoney);

        JPanel panel_21 = new JPanel();
        panel_1.add(panel_21);
        panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.X_AXIS));


        JPanel panel_12 = new JPanel();
        contentPane.add(panel_12, BorderLayout.CENTER);
        panel_12.setLayout(new BorderLayout(0, 0));

        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new TitledBorder(null, "\u5546\u54C1\u5176\u4ED6\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_12.add(panel_13, BorderLayout.NORTH);
        panel_13.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_13.add(panel_14);
        panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("备    注：");
        lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_14.add(lblNewLabel_2);

        txtBZ = new JTextField();
        txtBZ.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBZ.setText("无");
        panel_14.add(txtBZ);
        txtBZ.setColumns(10);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel_13.add(panel_15);
        panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));

        JLabel lblNewLabel_3 = new JLabel("生产厂家：");
        lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_15.add(lblNewLabel_3);

        txtAdress = new JTextField();
        txtAdress.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_15.add(txtAdress);
        txtAdress.setColumns(10);

        JPanel panel_16 = new JPanel();
        panel_12.add(panel_16, BorderLayout.SOUTH);

        Component horizontalStrut_1 = Box.createHorizontalStrut(10);
        panel_16.add(horizontalStrut_1);


        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取采购价格和采购数量
                String p = txtCaiGouPrice.getText().trim();//采购价格
                String c = txtCaiGouCount.getText().trim();//采购数量

                String n = txtName.getText().trim();//商品名称
                String sx1 = txtShangXian.getText().toString();//库存上限
                int sx3 = Integer.valueOf(sx1);//库存上限

                //①获取商品名称，判断是否老商品中已经存在
                RepertoryDAO dao = new RepertoryDAO();
                List<Repertory> lists = dao.selectAll();
                for (Repertory repertory : lists) {
                    if (repertory.getRname().equals(n)) {
                        JOptionPane.showMessageDialog(null, "该商品仓库已经存在，请确认是否从新添加该商品！");
                        return;
                    }
                }
                //2、数据验证
                if (p.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入采购价格！");
                    return;
                }
                if (c.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入采购数量！");
                    return;
                }
                if (!MyUtil.isNumber(p)) {
                    JOptionPane.showMessageDialog(null, "请输入正确采购价格！");
                    return;
                }
                if (!MyUtil.isInteger(c)) {
                    JOptionPane.showMessageDialog(null, "请输入正确采购数量！");
                    return;
                }

                String smoney1 = txtJSowmoney.getText().trim();
                int smoney = Integer.valueOf(smoney1);//建议售价
                System.out.println("建议售价：" + smoney);
                String jymoney1 = txtJYmoney.getText().trim();
                int jymoney = Integer.valueOf(jymoney1);//建议进价
                System.out.println("建议进价：" + jymoney);
                int cgprice = Integer.valueOf(p);//采购进价
                int count = Integer.valueOf(c);//采购数量
                if (smoney <= cgprice) {//判断售价和采购进价大小
                    JOptionPane.showMessageDialog(null, "售价低于进价,建议修改售价！");
                    return;
                }
                if (cgprice >= jymoney) {
                    JOptionPane.showMessageDialog(null, "采购进价高于建议进价,是否采用该进价！");
                    return;
                }
                if (count > sx3) {
                    JOptionPane.showMessageDialog(null, "采购数量大于库存上限,建议修改采购数量");
                    return;
                }
                //调用采购进货页面的addRow
                //"商品编号", "商品名称", "规格","预设进价", "当前进价", "数量", "总金额"
                String b = txtBianHao.getText().trim();
                String g = comboBoxGuiGe.getSelectedItem().toString();
                String y = txtJYmoney.getText().trim();
                String z = (new BigDecimal(txtCaiGouCount.getText()).multiply(new BigDecimal(txtCaiGouPrice.getText()))).toString();

                String t = comboBoxType.getSelectedItem().toString();//商品类别
                String j = txtJYmoney.getText().toString();//建议进价
                String js1 = txtJSowmoney.getText().toString();//建议售价
                String xx1 = txtXiaXian.getText().toString();//库存下限
                String dw = comboBoxUnit.getSelectedItem().toString();//单位
                String dz = txtAdress.getText().toString();//地址
                String ys = comboBoxColor.getSelectedItem().toString();//颜色
                //改变数据类型
                BigDecimal jy = new BigDecimal(j);//建议进价
                BigDecimal js2 = new BigDecimal(js1);//建议售价
                Integer sx2 = Integer.valueOf(sx1);//库存上限
                Integer xx2 = Integer.valueOf(xx1);//库存下限
                Integer c2 = Integer.valueOf(c);//当前库存


                //新商品增加到数据库，不改库存(当前库存给0)
                Repertory repertory = new Repertory(b, n, t, g, jy, js2, sx2, xx2, 0, dw, dz, ys);
                RepertoryDAO dao2 = new RepertoryDAO();
                dao2.doCreate(repertory);

                //调用采购进货页面的addRow,把新商品填入的数据添加到采购进货页面
                if (paranA != null) {
                    paranA.addRow2(repertory, c, p);
                    FrmAddNewMain.this.dispose();
                }

                //另一种思路（采购进货主页面新写一个addRow方法）
//				System.out.println(paranA+"----");
//				paranA.addRow(b,n,g,y,c,p,z);
//				paranA.ruk(re);

            }
        });
        btnSure.setFocusPainted(false);
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(btnSure);

        Component horizontalStrut = Box.createHorizontalStrut(100);
        panel_16.add(horizontalStrut);

        JButton btnEsc = new JButton("退出");
        btnEsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAddNewMain.this.dispose();
            }
        });
        btnEsc.setFocusPainted(false);
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(btnEsc);

        JPanel panel_17 = new JPanel();
        panel_17.setBorder(new TitledBorder(null, "\u5546\u54C1\u91C7\u8D2D\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel_12.add(panel_17, BorderLayout.CENTER);
        panel_17.setLayout(new BorderLayout(0, 0));

        JPanel panel_18 = new JPanel();
        panel_17.add(panel_18, BorderLayout.NORTH);
        panel_18.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_18.add(panel_19);
        panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("采购价格：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_19.add(lblNewLabel);

        txtCaiGouPrice = new JTextField();

        txtCaiGouPrice.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_19.add(txtCaiGouPrice);
        txtCaiGouPrice.setColumns(10);

        //采购价格的文本框只能输入数字和.
        txtCaiGouPrice.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81 || keycode == 46) {
                    System.out.println("是数字和退格键或.");
                } else {
                    e.consume();//消灭
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                System.out.println(keycode + "键值");
            }
        });

        Component horizontalStrut_2 = Box.createHorizontalStrut(280);
        panel_19.add(horizontalStrut_2);

        JPanel panel_20 = new JPanel();
        panel_20.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_18.add(panel_20);
        panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.X_AXIS));

        JLabel label_9 = new JLabel("采购数量：");
        label_9.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_20.add(label_9);

        txtCaiGouCount = new JTextField();
        txtCaiGouCount.setFont(new Font("宋体", Font.PLAIN, 20));
        txtCaiGouCount.setColumns(10);
        panel_20.add(txtCaiGouCount);

        //采购数量的文本框只能输入数字
        txtCaiGouCount.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81) {
                    System.out.println("是数字和退格键");
                } else {
                    e.consume();//消灭
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                System.out.println(keycode + "键值");
            }
        });

        Component horizontalStrut_3 = Box.createHorizontalStrut(280);
        panel_20.add(horizontalStrut_3);
    }
    //加载数据到表格中
}

package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;

import javax.imageio.ImageTypeSpecifier;
import javax.net.ssl.SSLContext;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.GoodsDao;
import dao.RepertoryDAO;

import dao.VipDao;
import dao.marketDao;
import entity.Goods;
import entity.Market;
import entity.Repertory;
import entity.Vip;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.security.interfaces.RSAKey;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;


public class Cashier2 extends JFrame {

    private JPanel contentPane;
    private JTextField viptex;
    private JTextField shanpoSo;
    private JTable table;
    private JTextField shiShou1;
    private JButton queding;
    private VipDao dao;
    private JLabel vipname;
    private JLabel vipgrade;
    private DefaultTableModel model;
    private JLabel tabShu;
    private JLabel lblNewLabel_12;
    private JLabel tabMoney;
    private JLabel zongEn;
    private JLabel yinShou;
    private JLabel zhaoLin;
    private JLabel youHui;
    private JLabel zhekou1;
    private String qz;
    private String zheKou;
    private JLabel xiTime;
    private JLabel dinDan;
    private JLabel shouYinName;
    private JLabel shiShou;
    private String vIPid;
    private Popup pop = null;//1.创建空白的popup的悬浮
    private JPanel xu;
    private JTable xutable;

    private DefaultTableModel xuModel;
    private String dingDanID;
    private JButton gudan2;
    private JButton gudan1;
    private JPanel gudan_panel2;
    private List<Object> list2;
    private int xtabe;
    private Object[][] aos = null;
    private String[] linGuan1s;

    private String[] gudan2s;
    private Object[][] aos2s;

    DecimalFormat yu = new DecimalFormat("0.00");
    DecimalFormat yu1 = new DecimalFormat("0");
    private JLabel xiaJixiaFe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cashier2 frame = new Cashier2();
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
    public Cashier2() {
        setVisible(true);
        Cashier2.this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                queding.requestFocusInWindow();
                queding.requestFocus();
                //	focusEvt(e);
                //	super.windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1283, 696);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_3);

        JButton btnNewButton = new JButton("返回");
        btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 23));
        btnNewButton.setIcon(new ImageIcon(Cashier2.class.getResource("/img/返回上一级1.png")));
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_3.add(btnNewButton);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_2);

        JButton delete = new JButton("删除商品");
        delete.setFont(new Font("宋体", Font.PLAIN, 23));
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (table.getRowCount() > 0) {
                    int x = table.getSelectedRow();
                    System.out.println("选中行为" + x);
                    model.removeRow(x);
                    chozhi();

                } else {
                    JOptionPane.showMessageDialog(null, "没有选中该商品，无法删除");
                }
            }
        });
        delete.setIcon(new ImageIcon(Cashier2.class.getResource("/img/删除商品.png")));
        delete.setHorizontalTextPosition(SwingConstants.CENTER);
        delete.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_3.add(delete);

        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_4);

        JButton btnNewButton_2 = new JButton("修改数量");
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 23));
        btnNewButton_2.setActionCommand("修改数量");
        btnNewButton_2.setIcon(new ImageIcon(Cashier2.class.getResource("/img/修改商品.png")));
        btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_3.add(btnNewButton_2);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_5);

        JPanel panel_25 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_25.getLayout();
        flowLayout.setHgap(50);
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_25);

        xiTime = new JLabel("时间");
        xiTime.setFont(new Font("宋体", Font.PLAIN, 35));

        panel_25.add(xiTime);

        Timer timer = new Timer(1000, new ActionListener() {//显示时间的方法

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                showTime();
            }
        });
        timer.start();

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setPreferredSize(new Dimension(50, 10));
        panel_4.add(lblNewLabel);

        viptex = new JTextField();
        viptex.setForeground(Color.LIGHT_GRAY);
        viptex.setText("会员卡号/手机号");
        dao = new VipDao();
        viptex.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                viptex.setText("");
                viptex.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);

            }
        });
        viptex.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == 10) {
                    String hui = viptex.getText();
                    Vip sVip = dao.selectID(hui);
                    System.out.println(sVip + "/*/");
                    if (sVip == null) {
                        JOptionPane.showMessageDialog(null, "查无此人");
                    } else {
                        vipname.setText(sVip.getVipname());
                        vipgrade.setText(sVip.getVipgrade());


                        zheKou = sVip.getVdiscount().toString();
                        vIPid = sVip.getVipid();

                        Vip vips = dao.chaoXiaJi(vIPid);
                        if (vips.getConsume().compareTo(vips.getViptomoney()) == 1) {
                            BigDecimal kk = vips.getConsume().subtract(vips.getViptomoney());

                            xiaJixiaFe.setText(yu1.format(kk));
                        } else if (vips.getConsume().compareTo(vips.getViptomoney()) == -1) {

                        }


                        qz = zheKou;
                    }

                    if (table.getRowCount() > 0) {
                        BigDecimal wBigDecimal = new BigDecimal("0");
                        for (int c = 0; c < table.getRowCount(); c++) {//价格的累加
                            wBigDecimal = wBigDecimal.add(new BigDecimal(model.getValueAt(c, 6).toString()));
                        }


                        BigDecimal yo = new BigDecimal(qz).multiply(wBigDecimal);
                        String ccString = yu.format(yo);
                        BigDecimal y2 = wBigDecimal.subtract(yo);

                        BigDecimal y3 = new BigDecimal(qz).multiply(wBigDecimal);


                        yinShou.setText(yu.format(y3));
                        youHui.setText(yu.format(y2));

                        if (shiShou1.getText().length() > 0) {
                            String CC = shiShou1.getText();
                            String A1 = yinShou.getText();


                            BigDecimal shu1 = new BigDecimal(CC).subtract(new BigDecimal(A1));
                            zhaoLin.setText(yu.format(shu1));
                        }


                    }


                }
            }
        });

        JLabel lblNewLabel_3 = new JLabel("查找会员");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_4.add(lblNewLabel_3);
        viptex.setMaximumSize(new Dimension(150, 2147483647));
        panel_4.add(viptex);

        viptex.setColumns(10);

        Component horizontalStrut = Box.createHorizontalStrut(150);
        panel_4.add(horizontalStrut);

        shanpoSo = new JTextField();
        shanpoSo.setForeground(Color.LIGHT_GRAY);
        shanpoSo.setText("商品编码号");
        shanpoSo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                shanpoSo.setText("");
                shanpoSo.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub


                super.mouseExited(e);

            }
        });

        popup();


        RepertoryDAO sDao = new RepertoryDAO();

        shanpoSo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (shanpoSo.getText().length() == 0) {
                    if (pop != null) {
                        pop.hide();
                        pop = null;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (shanpoSo.getText().length() > 0) {
                    String tx = shanpoSo.getText();
                    List<Repertory> wList = sDao.selectByWord(tx);
                    xuModel.setRowCount(0);
                    for (Repertory cc : wList) {
                        Object[] objects = {
                                cc.getRsid(),
                                cc.getRname()

                        };
                        xuModel.addRow(objects);
                        xu.repaint();
                    }

                    showPanel(btnNewButton);

                } else {

                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {//搜索商品的键盘事件，为表格赋值

                    String cc = shanpoSo.getText().trim();
                    RepertoryDAO redao = new RepertoryDAO();
                    Repertory sp = redao.selectID(cc);

                    if (sp == null) {
                        JOptionPane.showMessageDialog(null, "没找到该商品");
                    } else {

                        for (int i = 0; i < table.getRowCount(); i++) {
                            String bj = table.getValueAt(i, 1) + "";
                            if (sp.getRsid().equals(bj)) {
                                String c1 = table.getValueAt(i, 2) + "";

                                int a1 = Integer.valueOf(c1) + 1;

                                BigDecimal c2 = new BigDecimal(table.getValueAt(i, 4).toString());
                                BigDecimal a2 = c2.multiply(new BigDecimal(a1));
                                String a3 = yu.format(a2);
                                table.setValueAt(a1, i, 2);
                                table.setValueAt(a3, i, 6);


                                int c23 = 0;
                                BigDecimal wBigDecimal = new BigDecimal("0");
                                for (int c = 0; c < table.getRowCount(); c++) {//价格的累加
                                    wBigDecimal = wBigDecimal.add(new BigDecimal(model.getValueAt(c, 6).toString()));
                                    String shu = table.getValueAt(c, 2) + "";
                                    c23 = Integer.valueOf(shu) + c23;

                                }
                                tabShu.setText(c23 + "");
                                tabMoney.setText(yu.format(wBigDecimal));
                                zongEn.setText(yu.format(wBigDecimal));

                                if (vipname.getText().equals("姓名")) {

                                    yinShou.setText(zongEn.getText());

                                } else {
                                    BigDecimal yo = new BigDecimal(qz).multiply(wBigDecimal);
                                    BigDecimal y2 = wBigDecimal.subtract(yo);

                                    yinShou.setText(yu.format(yo));
                                    youHui.setText(yu.format(y2));
                                }

                                return;
                            }
                        }
                        Object[] obj = {
                                sp.getRname(),
                                sp.getRsid(),
                                1,
                                sp.getRspec(),
                                sp.getRmprice(),
                                sp.getRadress(),
                                sp.getRmprice().multiply(new BigDecimal(1)).setScale(1)
                        };
                        model.addRow(obj);

                    }


//				


//				
//					
//					


                    chozhi();


//				
//					 int c1=0;
//					BigDecimal wBigDecimal=new BigDecimal("0");
//					for(int c=0;c<table.getRowCount();c++) {//价格的累加 
//						wBigDecimal=wBigDecimal.add(new BigDecimal(model.getValueAt(c, 6).toString()));	
//						String shu=table.getValueAt(c, 2)+"";
//						c1=Integer.valueOf(shu)+c1;
//						
//					}
//					tabShu.setText(c1+"");
//					tabMoney.setText(yu.format(wBigDecimal));
//					zongEn.setText(yu.format(wBigDecimal));
//					
//					if(vipname.getText().equals("姓名")) {
//						
//						yinShou.setText(zongEn.getText());
//						
//					}else {
//						BigDecimal yo=new BigDecimal(qz).multiply(wBigDecimal);
//						BigDecimal y2=wBigDecimal.subtract(yo);
//						
//						
//						yinShou.setText(yu.format(yo));
//						youHui.setText(yu.format(y2));
//					}


                }
            }
        });

        JLabel lblNewLabel_6 = new JLabel("商品添加");
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_4.add(lblNewLabel_6);
        shanpoSo.setMaximumSize(new Dimension(150, 2147483647));
        panel_4.add(shanpoSo);
        shanpoSo.setColumns(10);

        Component horizontalStrut_1 = Box.createHorizontalStrut(80);
        panel_4.add(horizontalStrut_1);

        JLabel lblNewLabel_10 = new JLabel("收银员：");
        lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_4.add(lblNewLabel_10);

        shouYinName = new JLabel("陈三");
        shouYinName.setForeground(Color.BLACK);
        shouYinName.setFont(new Font("宋体", Font.BOLD, 27));
        panel_4.add(shouYinName);

        Component horizontalStrut_6 = Box.createHorizontalStrut(40);
        panel_4.add(horizontalStrut_6);

        JLabel dinDaHao = new JLabel("收银单号");
        dinDaHao.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_4.add(dinDaHao);


        dingDanID = shenchengdindan();

        dinDan = new JLabel(dingDanID);
        dinDan.setForeground(Color.RED);
        dinDan.setFont(new Font("宋体", Font.BOLD, 27));
        panel_4.add(dinDan);

        Component horizontalStrut_11 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_11);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                if (column == 2) {

                    return true;
                } else {
                    return false;
                }
            }


        };
        table.setToolTipText("");
        table.setFont(new Font("宋体", Font.PLAIN, 17));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u6570\u91CF", "\u89C4\u683C", "\u5546\u54C1\u4EF7\u683C", "\u751F\u4EA7\u5382\u5546", "\u91D1\u989D"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(77);
        table.getColumnModel().getColumn(0).setMinWidth(30);
        model = (DefaultTableModel) table.getModel();

        table.addKeyListener(new KeyListener() {

            private double a;

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == 10) {//修改表格双击事件
                    BigDecimal wBigDecimal = new BigDecimal("0");
                    int c1 = 0;

                    for (int i = 0; i < table.getRowCount(); i++) {
                        String cc = table.getValueAt(i, 2) + "";
                        try {
                            a = Double.valueOf(cc);
                        } catch (Exception e2) {
                            // TODO: handle exception
                            JOptionPane.showMessageDialog(null, "只能输入数字");
                            table.setValueAt(1, i, 2);
                            a = Double.valueOf(table.getValueAt(i, 2).toString());
                            //table.setValueAt(2, i, 6);

                            System.out.println("==");

                        }
                        String c2 = table.getValueAt(i, 4) + "";
                        double b = Double.valueOf(c2);

                        System.out.println(a + "数量");//数量
                        System.out.println(b + "单价");//单价

                        BigDecimal yy = new BigDecimal(a).multiply(new BigDecimal(b));
                        table.setValueAt(yu.format(yy), i, 6);
                        wBigDecimal = wBigDecimal.add(new BigDecimal(model.getValueAt(i, 6).toString()));

                        String shu = model.getValueAt(i, 2) + "";
                        c1 = Integer.valueOf(shu) + c1;

                    }

                    tabMoney.setText(yu.format(wBigDecimal));
                    tabShu.setText(c1 + "");
                    zongEn.setText(yu.format(wBigDecimal));

                    if (vipname.getText().equals("姓名")) {//判断是否有会员，来设定优惠金额 和应收金额
                        yinShou.setText(zongEn.getText());
                    } else {
                        BigDecimal yo = new BigDecimal(qz).multiply(wBigDecimal);
                        BigDecimal y2 = wBigDecimal.subtract(yo);
                        yinShou.setText(yu.format(yo));
                        youHui.setText(yu.format(y2));
                    }


                }
            }
        });


        scrollPane.setViewportView(table);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8, BorderLayout.NORTH);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JPanel panel_9 = new JPanel();
        panel_8.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JPanel panel_16 = new JPanel();
        panel_9.add(panel_16);
        panel_16.setLayout(new GridLayout(0, 4, 0, 0));

        JButton btnNewButton_6 = new JButton("挂单");

        btnNewButton_6.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent arg0) {
                if (gudan2.getText().equals("临时挂单2")) {
                    qingkong();
                    dinDan.setText(shenchengdindan());


                } else if (gudan1.getText().equals("临时挂单1")) {
                    gudan2.setVisible(true);
                    gudan2.setText("临时挂单2");
                    gudan2s = guadan();
                    aos2s = new Object[table.getRowCount()][table.getColumnCount()];
                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int y = 0; y < table.getColumnCount(); y++) {
                            Object aObject = table.getValueAt(i, y);
                            aos2s[i][y] = aObject;
                        }
                    }
                    gudan2.setActionCommand(dinDan.getText());
                    qingkong();
                    dinDan.setText(shenchengdindan());
                } else if (gudan1.getText().equals("临时挂单")) {
                    aos = new Object[table.getRowCount()][table.getColumnCount()];
                    linGuan1s = guadan();
                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int y = 0; y < table.getColumnCount(); y++) {
                            Object aObject = table.getValueAt(i, y);
                            aos[i][y] = aObject;
                        }
                    }
                    gudan1.setActionCommand(dinDan.getText());
                    gudan1.setVisible(true);
                    gudan1.setText("临时挂单1");
                    qingkong();
                    dinDan.setText(shenchengdindan());

                }

            }
        });

        panel_16.add(btnNewButton_6);

        JButton qingKong = new JButton("清空");
        qingKong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                qingkong();
            }
        });
        panel_16.add(qingKong);

        JButton button = new JButton("会员查询");
        panel_16.add(button);

        JButton button_1 = new JButton("打印小票");
        panel_16.add(button_1);

        JButton button_2 = new JButton("删除单件商品");
        panel_16.add(button_2);

        JButton button_3 = new JButton("修改单件商品数量");
        panel_16.add(button_3);

        JButton button_4 = new JButton("交接班");
        panel_16.add(button_4);

        JButton button_5 = new JButton("New button");
        panel_16.add(button_5);

        JPanel panel_17 = new JPanel();
        panel_17.setMinimumSize(new Dimension(248, 10));
        panel_17.setMaximumSize(new Dimension(250, 32767));

        panel_9.add(panel_17);
        panel_17.setLayout(new BorderLayout(0, 0));

        queding = new JButton("收银" + "\n" + "F2");
        //btnNewButton_5.dispatchEvent(new FocusEvent(btnNewButton_5, FocusEvent.FOCUS_GAINED,true));
        //btnNewButton_5.requestFocusInWindow();
        queding.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub
                //Object ac=arg0.getSource();
//				if(ac instanceof JButton) {
//				 	String CC= arg0.getKeyChar()+"";
//				 	System.out.println(CC);
//				 	if ("F".equalsIgnoreCase(CC)) {
//						System.out.println("ok");
//					}
//				}
                String cc = arg0.getKeyChar() + "";
                System.out.println(cc);
                if ("f".equalsIgnoreCase(cc)) {
                    System.out.println("ok");
                }
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }
        });


        queding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GoodsDao dao = new GoodsDao();
                String cc5 = dinDan.getText();
                Integer gorder = Integer.valueOf(cc5);


                java.util.Date aDate = new java.util.Date();//获得当前系统时间
                long time = aDate.getTime();//转成long类型
                System.out.println(time + "*/*");


                java.sql.Date tt = new java.sql.Date(time);
                System.out.println(shiShou.getText());
                if (table.getRowCount() < 1) {
                    JOptionPane.showMessageDialog(null, "没有添加商品，不能完成收银");
                } else {

                    if (shiShou1.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "没有收钱，不能完成收银");
                    } else {
                        double a = Double.valueOf(yinShou.getText());
                        double b = Double.valueOf(shiShou1.getText());

                        System.out.println(a + "1*a");
                        System.out.println(b + "2*b");

                        if (a > b) {
                            JOptionPane.showMessageDialog(null, "收款金额不对，请重新审核");
                        } else {

                            for (int i = 0; i < table.getRowCount(); i++) {//判断完成后入库
                                String gsid = table.getValueAt(i, 1) + "";
                                String gname = table.getValueAt(i, 0) + "";
                                BigDecimal gmprice = new BigDecimal(table.getValueAt(i, 4).toString());
                                Integer gamount = Integer.valueOf(table.getValueAt(i, 2).toString());
                                java.sql.Date gtime = tt;
                                String gcashier = shouYinName.getText();
                                BigDecimal gchange = new BigDecimal(zhaoLin.getText());
                                BigDecimal gcollect = new BigDecimal(shiShou1.getText());
                                String gpayment = table.getValueAt(i, 5).toString();
                                String gvip = vIPid;
                                Goods aa = new Goods(gorder, gsid, gname, gmprice, gamount, gtime, gcashier, gchange, gcollect, gpayment, gvip);
                                dao.insert(aa);
                                ;
                                System.out.println("储存成功");
                            }
                            if (cc5.equals(gudan1.getActionCommand())) {
                                gudan1.setVisible(false);
                                gudan1.setText("临时挂单");
                            }
                            ;
                            if (cc5.equals(gudan2.getActionCommand())) {
                                gudan2.setVisible(false);
                                gudan2.setText("临时挂单");
                            }
                            ;
                            java.sql.Timestamp tt1 = new java.sql.Timestamp(time);
                            marketDao dao2 = new marketDao();
                            Integer cc2 = Integer.valueOf(tabShu.getText());
                            String cc1 = zongEn.getText();
                            BigDecimal cc3 = new BigDecimal(cc1);
                            BigDecimal cc4 = new BigDecimal(shiShou1.getText());
                            BigDecimal cc6 = new BigDecimal(zhaoLin.getText());
                            String name = shouYinName.getText();

                            Market kMarket = new Market(gorder, tt1, cc2, cc3, cc4, cc6, vIPid, name);
                            dao2.insert(kMarket);


                            if (!vipname.getText().equals("姓名")) {
                                VipDao dVipDao = new VipDao();
                                BigDecimal aBigDecimal = new BigDecimal(yinShou.getText());
                                String c = vIPid;
                                dVipDao.xiuGaiHuiYu(aBigDecimal, c);

                            }

                            qingkong();

                            dinDan.setText(shenchengdindan());
                            System.out.println("重置完成");
                        }
                    }
                }


            }
        });
        queding.setVerticalTextPosition(SwingConstants.BOTTOM);
        queding.setHorizontalTextPosition(SwingConstants.CENTER);
        queding.setPreferredSize(new Dimension(150, 50));
        queding.setBackground(Color.GREEN);
        panel_17.add(queding);

        JPanel panel_10 = new JPanel();
        panel_8.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_10.add(panel_19);
        panel_19.setLayout(new GridLayout(5, 0, 0, 0));

        JPanel panel_20 = new JPanel();
        panel_19.add(panel_20);

        JLabel lblNewLabel_7 = new JLabel("会员信息");
        lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 22));
        panel_20.add(lblNewLabel_7);

        JPanel panel_21 = new JPanel();
        panel_19.add(panel_21);

        JLabel lblNewLabel_8 = new JLabel("会员名");
        lblNewLabel_8.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_21.add(lblNewLabel_8);

        vipname = new JLabel("姓名");
        vipname.setForeground(Color.RED);
        vipname.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_21.add(vipname);

        JPanel panel_22 = new JPanel();
        panel_19.add(panel_22);

        JLabel label_2 = new JLabel("会员等级");
        label_2.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_22.add(label_2);

        vipgrade = new JLabel("1-10");
        vipgrade.setForeground(Color.RED);
        vipgrade.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_22.add(vipgrade);

        zhekou1 = new JLabel("");
        zhekou1.setVisible(false);
        panel_22.add(zhekou1);

        JPanel panel_23 = new JPanel();
        panel_19.add(panel_23);

        JLabel label_4 = new JLabel("离下级消费金额");
        label_4.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_23.add(label_4);


        xiaJixiaFe = new JLabel("1000");
        xiaJixiaFe.setForeground(Color.RED);
        xiaJixiaFe.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_23.add(xiaJixiaFe);

        JPanel panel_24 = new JPanel();
        panel_19.add(panel_24);

        JLabel label_6 = new JLabel("本次优惠");
        label_6.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_24.add(label_6);

        youHui = new JLabel("多少元");
        youHui.setForeground(Color.RED);
        youHui.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_24.add(youHui);

        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_10.add(panel_11);
        panel_11.setLayout(new GridLayout(5, 0, 0, 0));

        JPanel panel_18 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_18.getLayout();
        flowLayout_1.setHgap(10);
        panel_11.add(panel_18);

        JLabel lblNewLabel_5 = new JLabel("收银信息");
        lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 22));
        panel_18.add(lblNewLabel_5);

        JPanel panel_12 = new JPanel();
        panel_11.add(panel_12);

        JLabel lblNewLabel_1 = new JLabel("商品总额");
        panel_12.add(lblNewLabel_1);

        zongEn = new JLabel("多少钱");
        zongEn.setForeground(Color.RED);
        zongEn.setFont(new Font("宋体", Font.PLAIN, 22));
        panel_12.add(zongEn);

        JPanel panel_13 = new JPanel();
        panel_11.add(panel_13);

        JLabel lblNewLabel_2 = new JLabel("应收金额");
        panel_13.add(lblNewLabel_2);

        yinShou = new JLabel("多少钱");
        yinShou.setForeground(Color.RED);
        yinShou.setFont(new Font("宋体", Font.PLAIN, 22));
        panel_13.add(yinShou);

        JPanel panel_14 = new JPanel();
        panel_11.add(panel_14);

        shiShou = new JLabel("实收金额");
        panel_14.add(shiShou);

        shiShou1 = new JTextField();
        shiShou1.addKeyListener(new KeyListener() {


            private double ys;
            private double ss;

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                if (ys > ss) {
                    zhaoLin.setText("0");
                }
                System.out.println(ys + "/");
                System.out.println(ss + "*");
            }

            @Override
            public void keyReleased(KeyEvent e) {

                // TODO Auto-generated method stub
                try {
                    ys = Double.valueOf(yinShou.getText());
                    ss = Double.valueOf(shiShou1.getText());

                } catch (Exception e2) {
                    // TODO: handle exception
                    System.out.println("不是整数");

                }
                if (ss > ys) {
                    BigDecimal he = new BigDecimal(ss).subtract(new BigDecimal(ys));

                    zhaoLin.setText(yu.format(he));
                    System.out.println("修改");
                } else if (ss == ys) {
                    BigDecimal he = new BigDecimal(ss).subtract(new BigDecimal(ys));

                    zhaoLin.setText(yu.format(he));
                    System.out.println("刚好");
                } else {
                    zhaoLin.setText("0");
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
//				if(e.getKeyCode()==10) {
//					String CC=shiShou1.getText();
//					String A1= yinShou.getText();
//					double shu=Double.valueOf(CC)-Double.valueOf(A1);
//					BigDecimal shu1=new BigDecimal(CC).subtract(new BigDecimal(A1));
//					String KK=yu.format(shu1);
//					zhaoLin.setText(KK);
//				}
            }
        });


        panel_14.add(shiShou1);
        shiShou1.setColumns(10);

        JPanel panel_15 = new JPanel();
        panel_11.add(panel_15);

        JLabel lblNewLabel_4 = new JLabel("找零");
        panel_15.add(lblNewLabel_4);

        zhaoLin = new JLabel("多少钱");
        zhaoLin.setForeground(Color.RED);
        zhaoLin.setFont(new Font("宋体", Font.PLAIN, 22));
        panel_15.add(zhaoLin);

        JPanel gudan_pane = new JPanel();
        panel_1.add(gudan_pane, BorderLayout.NORTH);
        gudan_pane.setLayout(new BoxLayout(gudan_pane, BoxLayout.X_AXIS));

        gudan_panel2 = new JPanel();
        gudan_pane.add(gudan_panel2);
        gudan_panel2.setLayout(null);

        gudan1 = new JButton("临时挂单");

        gudan1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                model.setRowCount(0);
                for (Object[] ac : aos) {
                    model.addRow(ac);
                }
                dingzhi(linGuan1s);


                //model.addRow(rowData);
            }
        });
        gudan1.setVisible(false);
        gudan1.setBounds(53, 10, 119, 37);
        gudan_panel2.add(gudan1);

        gudan2 = new JButton("临时挂单");
        gudan2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                model.setRowCount(0);
                for (Object[] ad : aos2s) {
                    model.addRow(ad);
                }
                dingzhi(gudan2s);
            }
        });
        gudan2.setVisible(false);
        gudan2.setBounds(241, 10, 119, 37);
        gudan_panel2.add(gudan2);

        Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        gudan_pane.add(horizontalStrut_8);

        JLabel lblNewLabel_11 = new JLabel("共计商品数量:");
        lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 32));
        gudan_pane.add(lblNewLabel_11);

        Component horizontalStrut_10 = Box.createHorizontalStrut(20);
        gudan_pane.add(horizontalStrut_10);

        tabShu = new JLabel("多少");
        tabShu.setBorder(new EmptyBorder(10, 0, 10, 0));
        tabShu.setForeground(Color.RED);
        tabShu.setFont(new Font("宋体", Font.PLAIN, 32));
        gudan_pane.add(tabShu);

        Component horizontalStrut_7 = Box.createHorizontalStrut(20);
        gudan_pane.add(horizontalStrut_7);

        lblNewLabel_12 = new JLabel("金额：");
        lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 32));
        gudan_pane.add(lblNewLabel_12);

        tabMoney = new JLabel("钱");
        tabMoney.setForeground(Color.RED);
        tabMoney.setFont(new Font("宋体", Font.PLAIN, 32));
        gudan_pane.add(tabMoney);

        Component horizontalStrut_9 = Box.createHorizontalStrut(20);
        gudan_pane.add(horizontalStrut_9);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7, BorderLayout.SOUTH);
    }

    public void showTime() {//
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
        String time1 = sdf.format(new Date());
        xiTime.setText(time1);
    }

    public void popup() {//悬浮的方法
        xu = new JPanel();
        xutable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        xu.setLayout(new BorderLayout());
        //xu.setPreferredSize(new Dimension(100,100));
        xutable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[]{
                        "New column", "2222"
                }
        ));
        xutable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

                if (e.getClickCount() == 2) {

                    int y = xutable.getSelectedRow();

                    String cc = xutable.getValueAt(y, 0).toString();
                    System.out.println(cc);
                    RepertoryDAO redao = new RepertoryDAO();
                    Repertory sp = redao.selectID(cc);
                    for (int i = 0; i < table.getRowCount(); i++) {
                        String bj = table.getValueAt(i, 1) + "";
                        if (sp.getRsid().equals(bj)) {
                            String c1 = table.getValueAt(i, 2) + "";

                            int a1 = Integer.valueOf(c1) + 1;

                            BigDecimal c2 = new BigDecimal(table.getValueAt(i, 4).toString());
                            BigDecimal a2 = c2.multiply(new BigDecimal(a1));
                            String a3 = yu.format(a2);
                            table.setValueAt(a1, i, 2);
                            table.setValueAt(a3, i, 6);


                            int c23 = 0;
                            BigDecimal wBigDecimal = new BigDecimal("0");
                            for (int c = 0; c < table.getRowCount(); c++) {//价格的累加
                                wBigDecimal = wBigDecimal.add(new BigDecimal(model.getValueAt(c, 6).toString()));
                                String shu = table.getValueAt(c, 2) + "";
                                c23 = Integer.valueOf(shu) + c23;

                            }
                            tabShu.setText(c23 + "");
                            tabMoney.setText(yu.format(wBigDecimal));
                            zongEn.setText(yu.format(wBigDecimal));

                            if (vipname.getText().equals("姓名")) {

                                yinShou.setText(zongEn.getText());

                            } else {
                                BigDecimal yo = new BigDecimal(qz).multiply(wBigDecimal);
                                BigDecimal y2 = wBigDecimal.subtract(yo);

                                yinShou.setText(yu.format(yo));
                                youHui.setText(yu.format(y2));
                            }

                            return;
                        }
                    }


                    Object[] obj = {
                            sp.getRname(),
                            sp.getRsid(),
                            1,
                            sp.getRspec(),
                            sp.getRmprice(),
                            sp.getRadress(),
                            sp.getRmprice().multiply(new BigDecimal(1)).setScale(1)
                    };


                    model.addRow(obj);
                    if (pop != null) {
                        pop.hide();
                        pop = null;
                    }

                    chozhi();

                }
                super.mouseClicked(e);
            }
        });
        xuModel = (DefaultTableModel) xutable.getModel();
        xutable.getColumnModel().getColumn(0).setPreferredWidth(200);
        xu.add(xutable);


    }

    public void showPanel(Component owner) {//触发的方法。参数是你要让那个组件作为你的父级窗口 触发悬浮
        if (pop != null)
            pop.hide();
        //下面的组件，就是你要触发显示的那个组件
        Point show = new Point(0, shanpoSo.getHeight());//接受二个int参数让他显示在父级窗口哪个位置，
//第一个参数是x轴，0是在父级窗口对应的0，第二个是y轴，默认获取的是你要设置哪个组件的高度，并显示在他下方。
        SwingUtilities.convertPointToScreen(show, shanpoSo);//显示在哪个组件的下方。

        pop = PopupFactory.getSharedInstance().getPopup(owner, xu, show.x, show.y);//x和y都是int类型，以你定好的窗口位置，xy轴移动
        //这个上面的panel 就是你要显示的悬浮窗口
        pop.show();//悬浮开始的方法
    }

    public void chozhi() {

        BigDecimal wBigDecimal = new BigDecimal("0");
        int c1 = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            int sshu = Integer.valueOf(table.getValueAt(i, 2).toString());
            double sjg = Double.valueOf(table.getValueAt(i, 4).toString());
            double jine = sshu * sjg;
            table.setValueAt(jine, i, 6);
            BigDecimal qBigDecimal = new BigDecimal(jine);
            wBigDecimal = wBigDecimal.add(qBigDecimal);
            c1 = c1 + sshu;
        }

        tabShu.setText(c1 + "");//设置数量
        tabMoney.setText(yu.format(wBigDecimal));//设置金额
        zongEn.setText(yu.format(wBigDecimal));//设置金额

        if (vipname.getText().equals("姓名")) {
            yinShou.setText(yu.format(wBigDecimal));


        } else {
            BigDecimal qian = wBigDecimal.multiply(new BigDecimal(qz));
            yinShou.setText(yu.format(qian));
            BigDecimal you = wBigDecimal.subtract(qian);
            youHui.setText(yu.format(you));

        }

    }

    public void qingkong() {
        model.setRowCount(0);
        youHui.setText("多少钱");
        vipgrade.setText("1-10");
        vipname.setText("姓名");
        viptex.setText("会员卡号/手机号");
        shanpoSo.setText("商品编码号");
        shiShou1.setText("");
        zhaoLin.setText("多少钱");
        chozhi();
    }

    public String shenchengdindan() {

        java.util.Date aDate = new java.util.Date();//获得当前系统时间
        long time = aDate.getTime();//转成long类型
        String time2 = time + "";
        time2 = time2.substring(7, 11);//截取时间戳的4位数
        Date bDate = new Date(time);//转成sql的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//转换sql时间显示格式
        String cc = sdf.format(bDate);
        cc = cc.substring(2);//截取年月日

        return cc = cc + time2;

    }

    public String[] guadan() {
        String a1 = shouYinName.getText();
        String a2 = dinDan.getText();
        String a3 = tabShu.getText();
        String a4 = tabMoney.getText();
        //会员
        String a5 = vipname.getText();
        String a6 = vipgrade.getText();
        String a7 = youHui.getText();
        //收银
        String a8 = zongEn.getText();
        String a9 = yinShou.getText();
        String a10 = shiShou1.getText();
        String a11 = zhaoLin.getText();

        String[] ac = {
                a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11
        };
        return ac;
    }

    public void dingzhi(String[] aa) {

        shouYinName.setText(aa[0]);
        dinDan.setText(aa[1]);
        tabShu.setText(aa[2]);
        tabMoney.setText(aa[3]);
        //会员
        vipname.setText(aa[4]);
        vipgrade.setText(aa[5]);
        youHui.setText(aa[6]);
        //收银
        zongEn.setText(aa[7]);
        yinShou.setText(aa[8]);
        shiShou1.setText(aa[9]);
        zhaoLin.setText(aa[10]);
    }
}

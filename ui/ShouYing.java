package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dao.GoodsDao;
import dao.marketDao;
import entity.Goods;
import entity.Market;
import util.Mypager;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class ShouYing extends JFrame {

    private JPanel contentPane;
    private JTextField danjuTex;
    private JTable table;
    private JTable table_1;
    private DefaultTableModel model;
    private DefaultTableModel mod2;
    private JTextField yetxt;
    marketDao dao = new marketDao();
    private JLabel zoJIlu;
    private JLabel yeShu;
    private JLabel zoYe;
    private List<Market> list1;
    private Mypager fenye;
    private JTextField qitext;
    private JTextField zotext;
    private JTextField qian_1;
    private JTextField qian_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShouYing frame = new ShouYing();
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
    public ShouYing() {
        setVisible(true);
        setTitle("收银查询");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(25);
        panel_1.add(panel_2);

        JButton btnNewButton_1 = new JButton("查看单据");
        panel_2.add(btnNewButton_1);

        JButton btnNewButton = new JButton("删除");
        panel_2.add(btnNewButton);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_4);

        JLabel lblNewLabel = new JLabel("查找单据号：");
        panel_3.add(lblNewLabel);

        Date cc = new Date();
        long w = cc.getTime();
        java.sql.Timestamp cc1 = new Timestamp(w);


        fenye = new Mypager();
        int qiye = 1;
        int yelian = 5;
        int yezon = dao.getToal();

        fenye.setPageNo(qiye);
        fenye.setPageSize(yelian);
        fenye.setTotal(yezon);


        System.out.println(cc1);

        danjuTex = new JTextField();
        danjuTex.setMaximumSize(new Dimension(79, 2147483647));
        danjuTex.addKeyListener(new KeyListener() {

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
                    String C = danjuTex.getText();
                    marketDao dao = new marketDao();

                    Market ac = dao.selectId(C);
                    if (ac == null) {
                        JOptionPane.showMessageDialog(null, "没找到");
                    } else {
                        Object[] obj = {
                                ac.getMorder(),
                                ac.getMamountg(),
                                ac.getmDate(),
                                ac.getMmoney()
                        };
                        model.setRowCount(0);
                        model.addRow(obj);

                    }

                }

            }
        });
        panel_3.add(danjuTex);
        danjuTex.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("  查找时间  ");
        panel_3.add(lblNewLabel_3);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        util.DatePicker dateChooser1 = util.DatePicker.getInstance("yyyy-MM-dd");

        //259200000  long 转3天
        //604800000 long转7天
        Date aDate = new Date();
        long ylong = aDate.getTime() - 604800000;

        qitext = new JTextField(df.format(ylong));
        qitext.setEditable(false);
        dateChooser1.register(qitext);

        qitext.setMaximumSize(new Dimension(79, 2147483647));
        qitext.setColumns(10);
        panel_3.add(qitext);

        JLabel lblNewLabel_6 = new JLabel("—");
        panel_3.add(lblNewLabel_6);

        util.DatePicker dateChooser2 = util.DatePicker.getInstance("yyyy-MM-dd");
        //82800000 long 转23小时
        long xlong = aDate.getTime() + 82800000;
        zotext = new JTextField(df.format(xlong));
        zotext.setEditable(false);
        dateChooser2.register(zotext);

        zotext.setMaximumSize(new Dimension(79, 2147483647));
        zotext.setColumns(10);
        panel_3.add(zotext);

        JLabel lblNewLabel_8 = new JLabel("  消费金额  ");
        panel_3.add(lblNewLabel_8);

        qian_1 = new JTextField();
        qian_1.setMaximumSize(new Dimension(79, 2147483647));
        qian_1.setColumns(10);
        panel_3.add(qian_1);

        JLabel lblNewLabel_10 = new JLabel("一");
        panel_3.add(lblNewLabel_10);

        qian_2 = new JTextField();
        qian_2.setMaximumSize(new Dimension(79, 2147483647));
        qian_2.setColumns(10);
        panel_3.add(qian_2);

        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_6);

        JButton btnNewButton_2 = new JButton("查找");
        btnNewButton_2.addActionListener(new ActionListener() {
            private BigDecimal qian1;
            private BigDecimal qian2;

            public void actionPerformed(ActionEvent arg0) {

                String CC = danjuTex.getText();


                java.sql.Date chu = java.sql.Date.valueOf(qitext.getText());
                java.sql.Date zho = java.sql.Date.valueOf(zotext.getText());
                if (qian_1.getText().length() == 0) {
                    qian1 = null;
                } else {
                    qian1 = new BigDecimal(qian_1.getText());
                }

                if (qian_2.getText().length() == 0) {
                    qian2 = null;
                } else {
                    qian2 = new BigDecimal(qian_2.getText());
                }
                fenye.setPageNo(1);
                List<Market> zuhe = dao.zuheChao2(fenye, CC, chu, zho, qian1, qian2);
                bdcs(zuhe);
                zoJIlu.setText(fenye.getTotal().toString());
                yeShu.setText(fenye.getPageSize().toString());
                zoYe.setText(fenye.getPageCount().toString());
                yetxt.setText("1");

            }
        });
        panel_3.add(btnNewButton_2);

        Component horizontalGlue_1 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_1);

        JPanel panel_4 = new JPanel();
        panel.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

        JPanel panel_5 = new JPanel();
        panel_4.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane);

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;

            }
        };

        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u6536\u94F6\u8BA2\u5355\u53F7", "\u9500\u552E\u6570\u91CF", "\u6536\u94F6\u65F6\u95F4", "\u5E94\u6536\u91D1\u989D", "\u5B9E\u6536\u91D1\u989D", "\u627E\u96F6", "\u4F1A\u5458\u7F16\u53F7", "\u6536\u94F6\u4EBA"
                }
        ));
        model = (DefaultTableModel) table.getModel();

        list1 = dao.ass(fenye.getPageNo(), fenye.getPageSize());
        //dao.zuheChao(fenye);


        bdcs(list1);


        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    int x = table.getSelectedRow();
                    System.out.println(x);
                    GoodsDao dao = new GoodsDao();
                    String id = table.getValueAt(x, 0) + "";
                    System.out.println(id + "///");
                    List<Goods> ac = dao.selteid(id);
                    mod2.setRowCount(0);
                    for (Goods aa : ac) {
                        Object[] obje = {
                                aa.getGsid(),
                                aa.getGname(),
                                aa.getGmprice(),
                                aa.getGamount(),
                                aa.getGpayment()

                        };
                        mod2.addRow(obje);
                    }


                }
            }
        });

        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JPanel panel_9 = new JPanel();
        panel_8.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_9.add(horizontalStrut_2);

        JLabel lblNewLabel_2 = new JLabel("共");
        panel_9.add(lblNewLabel_2);

        zoJIlu = new JLabel("多少条");
        zoJIlu.setForeground(Color.RED);
        panel_9.add(zoJIlu);

        JLabel lblNewLabel_4 = new JLabel("记录");
        panel_9.add(lblNewLabel_4);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_9.add(horizontalStrut_3);

        JLabel lblNewLabel_5 = new JLabel("当页共");
        panel_9.add(lblNewLabel_5);

        yeShu = new JLabel("多少");
        yeShu.setForeground(Color.RED);
        panel_9.add(yeShu);

        JLabel lblNewLabel_7 = new JLabel("条记录  共");
        panel_9.add(lblNewLabel_7);

        zoYe = new JLabel("多少");
        zoYe.setForeground(Color.RED);
        panel_9.add(zoYe);

        JLabel lblNewLabel_9 = new JLabel("页");
        panel_9.add(lblNewLabel_9);


        zoJIlu.setText(fenye.getTotal().toString());
        yeShu.setText(fenye.getPageSize().toString());
        zoYe.setText(fenye.getPageCount().toString());

        Component horizontalGlue = Box.createHorizontalGlue();
        panel_9.add(horizontalGlue);

        JPanel panel_10 = new JPanel();
        panel_8.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JButton btnNewButton_3 = new JButton("上一页");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                boolean a = fenye.isFirst();
                if (a) {
                    JOptionPane.showMessageDialog(null, "已经是第一页了");
                    return;
                }
                Integer t = fenye.prevPageNo();
                fenye.setPageNo(t);

                //List<Market> list=dao.ass(fenye.getPageNo(), fenye.getPageSize());
                String CC = danjuTex.getText();


                BigDecimal qian11;
                BigDecimal qian22;
                java.sql.Date chu = java.sql.Date.valueOf(qitext.getText());
                java.sql.Date zho = java.sql.Date.valueOf(zotext.getText());
                if (qian_1.getText().length() == 0) {
                    qian11 = null;
                } else {
                    qian11 = new BigDecimal(qian_1.getText());
                }

                if (qian_2.getText().length() == 0) {
                    qian22 = null;
                } else {
                    qian22 = new BigDecimal(qian_2.getText());
                }
                List<Market> list = dao.zuheChao2(fenye, CC, chu, zho, qian11, qian22);

                bdcs(list);
                yetxt.setText(t.toString());//设置文本框 页数量
                yeShu.setText(list.size() + "");//设置当前页多少条记录

            }
        });
        panel_10.add(btnNewButton_3);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut_1);

        yetxt = new JTextField();
        yetxt.setHorizontalAlignment(SwingConstants.CENTER);
        yetxt.setText("1");
        yetxt.setMaximumSize(new Dimension(50, 2147483647));
        panel_10.add(yetxt);
        yetxt.setColumns(10);

        yetxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);

            }
        });

        yetxt.addKeyListener(new KeyListener() {

            private Integer tt;

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub


            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
                if (arg0.getKeyCode() == 10) {

                    try {
                        tt = Integer.valueOf(yetxt.getText());
                    } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "只能输入数字");
                    }
                    if (tt <= fenye.getPageCount() && tt >= 1) {
                        fenye.setPageNo(tt);
                        List<Market> list = dao.ass(fenye.getPageNo(), fenye.getPageSize());
                        bdcs(list);
                        yeShu.setText(list.size() + "");
                    } else {
                        JOptionPane.showMessageDialog(null, "只能输入1到" + fenye.getPageCount() + "之间的数值");
                    }

                }
            }
        });

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_10.add(horizontalStrut);

        JButton btnNewButton_4 = new JButton("下一页");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                boolean a = fenye.isLast();
                if (a) {
                    JOptionPane.showMessageDialog(null, "已经是最后一页");
                    return;
                }
                Integer da = fenye.nextPageNo();
                fenye.setPageNo(da);
                //List<Market> list=dao.ass(fenye.getPageNo(), fenye.getPageSize());
                String CC = danjuTex.getText();


                BigDecimal qian11;
                BigDecimal qian22;
                java.sql.Date chu = java.sql.Date.valueOf(qitext.getText());
                java.sql.Date zho = java.sql.Date.valueOf(zotext.getText());
                if (qian_1.getText().length() == 0) {
                    qian11 = null;
                } else {
                    qian11 = new BigDecimal(qian_1.getText());
                }

                if (qian_2.getText().length() == 0) {
                    qian22 = null;
                } else {
                    qian22 = new BigDecimal(qian_2.getText());
                }

                List<Market> list = dao.zuheChao2(fenye, CC, chu, zho, qian11, qian22);

                bdcs(list);

                yetxt.setText(da.toString());//设置文本框 页数量
                yeShu.setText(list.size() + "");//设置当前页多少条记录

            }
        });
        panel_10.add(btnNewButton_4);
        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);

        JLabel lblNewLabel_1 = new JLabel("单据详情");
        panel_7.add(lblNewLabel_1);

        JPanel panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(300, 400));
        panel_4.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_6.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u552E\u4EF7", "\u5546\u54C1\u6570\u91CF", "\u51FA\u5382\u5546"
                }
        ));

        mod2 = (DefaultTableModel) table_1.getModel();
        scrollPane_1.setViewportView(table_1);
    }

    public void bdcs(List<Market> list) {
        model.setRowCount(0);

        for (Market aa : list) {
            Object[] cc = {
                    aa.getMorder(),
                    aa.getMamountg(),
                    aa.getmDate(),
                    aa.getMmoney(),
                    aa.getGathering(),
                    aa.getChange1(),
                    aa.getVipid(),
                    aa.getName()

            };
            model.addRow(cc);
        }
    }


}

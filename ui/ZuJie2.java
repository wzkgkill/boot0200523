package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;

import entity.Employee;
import ui.AddOldPro.FrmAddOldMain;
import ui.PurchaseRecipt.FrmPurMain;
import ui.SystemSetup.FrmEmployeeInfor;
import ui.SystemSetup.FrmProManage;
import ui.SystemSetup.FrmSupplier;
import ui.SystemSetup.FrmVIP;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ZuJie2 extends JFrame {

    private JPanel contentPane;
    private JPanel zhoJian;
    private JPanel guGan;
    private JPanel shiJian;
    private JLabel xiTime;
    private JLabel lblNewLabel_1;
    private ImageIcon aIcon;
    private JLabel lblNewLabel_7;
    private JLabel label;
    private JLabel lblNewLabel_14;
    private JLabel lblNewLabel_17;
    private JPanel panel_9;
    private JPanel panel_4;
    private JPanel panel_16;
    private JPanel panel_22;
    private JPanel jinHuo;
    private JButton btnNewButton_3;
    private Employee employee;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ZuJie2 frame = new ZuJie2();
                    frame.setLocationRelativeTo(null);
                    frame.setUndecorated(true);//
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //添加带参构造方法，处理登录页面传递过来的用户数据
    public ZuJie2(Employee employee) {
        this();//调用无参构造方法
        if (employee != null) {
            this.employee = employee;
            lblNewLabel_2.setText(employee.getPname() + "欢迎您登录");
        }
    }

    /**
     * Create the frame.
     */
    public ZuJie2() {

        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1191, 645);
        contentPane = new JPanel();
        contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel touBu = new JPanel();
        contentPane.add(touBu, BorderLayout.NORTH);
        touBu.setLayout(new BoxLayout(touBu, BoxLayout.Y_AXIS));

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_2.setBackground(SystemColor.inactiveCaptionBorder);
        touBu.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        JLabel lblNewLabel_18 = new JLabel("");
        ImageIcon logo = new ImageIcon(ZuJie2.class.getResource("/images/超市图标.png"));
        logo.setImage(logo.getImage().getScaledInstance(55, 50, Image.SCALE_DEFAULT));
        lblNewLabel_18.setIcon(logo);

        //lblNewLabel_18.setPreferredSize(new Dimension(50,10));
        panel_2.add(lblNewLabel_18);

        JLabel lblNewLabel = new JLabel("加百利超市系统内测版 ");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
        panel_2.add(lblNewLabel);

        Component horizontalGlue = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue);

        JButton button = new JButton("");
        button.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon(ZuJie2.class.getResource("/images/关 闭 (2).png")));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZuJie2.this.dispose();
            }
        });

        JButton btnNewButton_18 = new JButton("");
        btnNewButton_18.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        btnNewButton_18.setContentAreaFilled(false);
        btnNewButton_18.setFocusPainted(false);
        btnNewButton_18.setIcon(new ImageIcon(ZuJie2.class.getResource("/images/最小化_默认.png")));
        btnNewButton_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZuJie2.this.setExtendedState(JFrame.ICONIFIED);

                //aIcon.setImage(aIcon.getImage().getScaledInstance(1920, 94, Image.SCALE_DEFAULT));
                //lblNewLabel_1.setIcon(aIcon);
                //	ZuJie2.this.addWindowListener();

                ZuJie2.this.addWindowStateListener(new WindowStateListener() {

                    @Override
                    public void windowStateChanged(WindowEvent e) {
                        if (e.getOldState() == JFrame.ICONIFIED && !ZuJie2.this.isActive()) {
                            ZuJie2.this.setExtendedState(Frame.MAXIMIZED_BOTH);//最大化
                            //ZuJie2.this.toFront();
                            //aIcon.setImage(aIcon.getImage().getScaledInstance(1161, 64, Image.SCALE_DEFAULT));
                            //lblNewLabel_1.setIcon(aIcon);
                        }
                    }
                });

            }
        });
        panel_2.add(btnNewButton_18);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut_2);
        panel_2.add(button);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut_3);

        JPanel panel_3 = new JPanel();
        panel_3.setMaximumSize(new Dimension(1921, 130));
        panel_3.setBackground(new Color(59, 59, 60));
        panel_3.setPreferredSize(new Dimension(1920, 128));

        touBu.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalGlue_3 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_3);

        JPanel panel_28 = new JPanel();
        panel_28.setOpaque(false);
        panel_28.setMaximumSize(new Dimension(129, 120));
        panel_28.setPreferredSize(new Dimension(128, 120));

        panel_3.add(panel_28);
        panel_28.setLayout(null);

        btnNewButton_3 = new JButton("设 置");
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setContentAreaFilled(false);
        btnNewButton_3.setForeground(Color.BLACK);
        btnNewButton_3.setFont(new Font("幼圆", Font.BOLD, 17));
        btnNewButton_3.setOpaque(false);
        btnNewButton_3.setBorder(null);
        btnNewButton_3.setBounds(10, 20, 108, 100);
        panel_28.add(btnNewButton_3);
        btnNewButton_3.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/设置.png")));
        btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_3.setActionCommand("设置");
        btnNewButton_3.addActionListener(new dianJi());
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                btnNewButton_3.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/设置金.png")));
                btnNewButton_3.setFont(new Font("华文新魏", Font.PLAIN, 21));
                btnNewButton_3.setForeground(Color.YELLOW);
                btnNewButton_3.setBounds(10, 5, 108, 100);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                btnNewButton_3.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/设置.png")));
                btnNewButton_3.setFont(new Font("幼圆", Font.BOLD, 17));
                btnNewButton_3.setForeground(Color.black);
                btnNewButton_3.setBounds(10, 20, 108, 100);
            }
        });


        Component horizontalGlue_2 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_2);

        JPanel panel_29 = new JPanel();
        panel_29.setOpaque(false);
        panel_29.setMaximumSize(new Dimension(129, 120));
        panel_29.setPreferredSize(new Dimension(128, 120));
        panel_3.add(panel_29);
        panel_29.setLayout(null);

        JButton btnNewButton = new JButton("商 品");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("幼圆", Font.BOLD, 17));

        btnNewButton.setBorder(null);
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBounds(10, 20, 108, 100);
        panel_29.add(btnNewButton);
        btnNewButton.setFocusPainted(false);
        //btnNewButton.setPreferredSize(new Dimension(123,110));
        btnNewButton.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/商品9.png")));
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
                super.mouseEntered(arg0);
                btnNewButton.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/商品金.png")));
                btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 21));
                btnNewButton.setForeground(Color.YELLOW);
                btnNewButton.setBounds(10, 5, 108, 100);

                //(new Font("华文新魏", Font.PLAIN, 21));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                btnNewButton.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/商品9.png")));
                btnNewButton.setFont(new Font("幼圆", Font.BOLD, 17));
                btnNewButton.setForeground(Color.black);
                btnNewButton.setBounds(10, 20, 108, 100);
            }

        });

        btnNewButton.setActionCommand("商品");

        btnNewButton.addActionListener(new dianJi());

        Component horizontalGlue_5 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_5);

        JPanel panel_30 = new JPanel();
        panel_30.setOpaque(false);
        panel_30.setMaximumSize(new Dimension(129, 120));
        panel_30.setPreferredSize(new Dimension(128, 120));
        panel_3.add(panel_30);
        panel_30.setLayout(null);

        JButton btnNewButton_1 = new JButton("主页面");
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBounds(10, 20, 108, 100);
        panel_30.add(btnNewButton_1);
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 17));
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBackground(new Color(135, 206, 250));
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_1.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/主页25.png")));
        btnNewButton_1.setActionCommand("主界面");
        btnNewButton_1.addActionListener(new dianJi());
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                btnNewButton_1.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/主页金.png")));
                btnNewButton_1.setFont(new Font("华文新魏", Font.PLAIN, 21));
                btnNewButton_1.setForeground(Color.YELLOW);
                btnNewButton_1.setBounds(10, 5, 108, 100);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                btnNewButton_1.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/主页25.png")));
                btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 17));
                btnNewButton_1.setForeground(Color.black);
                btnNewButton_1.setBounds(10, 20, 108, 100);
            }
        });

        Component horizontalGlue_4 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_4);

        JPanel panel_31 = new JPanel();
        panel_31.setOpaque(false);
        panel_31.setMaximumSize(new Dimension(129, 120));
        panel_31.setPreferredSize(new Dimension(128, 120));
        panel_3.add(panel_31);
        panel_31.setLayout(null);

        JButton btnNewButton_2 = new JButton("仓 库");
        btnNewButton_2.setForeground(Color.BLACK);
        btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 17));
        btnNewButton_2.setOpaque(false);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setBorder(null);
        btnNewButton_2.setBounds(10, 20, 108, 100);
        panel_31.add(btnNewButton_2);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/进货区.png")));
        btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_2.setActionCommand("仓库");
        btnNewButton_2.addActionListener(new dianJi());
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                btnNewButton_2.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/进货区金.png")));
                btnNewButton_2.setFont(new Font("华文新魏", Font.PLAIN, 21));
                btnNewButton_2.setForeground(Color.YELLOW);
                btnNewButton_2.setBounds(10, 5, 108, 100);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                btnNewButton_2.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/进货区.png")));
                btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 17));
                btnNewButton_2.setForeground(Color.black);
                btnNewButton_2.setBounds(10, 20, 108, 100);
            }
        });

        Component horizontalGlue_6 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_6);

        JPanel panel_32 = new JPanel();
        panel_32.setOpaque(false);
        panel_32.setMinimumSize(new Dimension(129, 120));
        panel_32.setMaximumSize(new Dimension(129, 120));
        panel_32.setPreferredSize(new Dimension(128, 120));
        panel_3.add(panel_32);
        panel_32.setLayout(null);

        JButton btnNewButton_4 = new JButton("收 银");
        btnNewButton_4.setForeground(Color.BLACK);
        btnNewButton_4.setFont(new Font("幼圆", Font.BOLD, 17));
        btnNewButton_4.setBorder(null);
        btnNewButton_4.setContentAreaFilled(false);
        btnNewButton_4.setOpaque(false);
        btnNewButton_4.setBounds(10, 20, 108, 100);
        panel_32.add(btnNewButton_4);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/收银台.png")));
        btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_4.setActionCommand("收银");

        Component horizontalGlue_7 = Box.createHorizontalGlue();
        panel_3.add(horizontalGlue_7);
        btnNewButton_4.addActionListener(new dianJi());
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                btnNewButton_4.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/收银台金.png")));
                btnNewButton_4.setFont(new Font("华文新魏", Font.PLAIN, 21));
                btnNewButton_4.setForeground(Color.YELLOW);
                btnNewButton_4.setBounds(10, 5, 108, 100);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                btnNewButton_4.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/收银台.png")));
                btnNewButton_4.setFont(new Font("幼圆", Font.BOLD, 17));
                btnNewButton_4.setForeground(Color.black);
                btnNewButton_4.setBounds(10, 20, 108, 100);
            }
        });


        guGan = new JPanel();
        touBu.add(guGan);
        guGan.setLayout(new BoxLayout(guGan, BoxLayout.X_AXIS));

        int x1 = guGan.getWidth();
        int y1 = guGan.getHeight();


        lblNewLabel_1 = new JLabel("");
        aIcon = new ImageIcon(ZuJie2.class.getResource("/img/95.png"));
        aIcon.setImage(aIcon.getImage().getScaledInstance(1920, 94, Image.SCALE_DEFAULT));

        lblNewLabel_1.setIcon(aIcon);
        lblNewLabel_1.setPreferredSize(new Dimension(10, 65));
        guGan.add(lblNewLabel_1);

        shiJian = new JPanel();
        touBu.add(shiJian);
        shiJian.setLayout(new BoxLayout(shiJian, BoxLayout.X_AXIS));

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        shiJian.add(horizontalStrut_1);

        xiTime = new JLabel("显示时间 和欢迎客户");
        xiTime.setFont(new Font("宋体", Font.PLAIN, 24));
        shiJian.add(xiTime);

        Component horizontalStrut = Box.createHorizontalStrut(120);
        shiJian.add(horizontalStrut);

        lblNewLabel_2 = new JLabel("欢迎用户登录");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        shiJian.add(lblNewLabel_2);

        Component horizontalGlue_1 = Box.createHorizontalGlue();
        shiJian.add(horizontalGlue_1);

        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                showTime();
            }
        });
        timer.start();

        zhoJian = new JPanel();
        contentPane.add(zhoJian, BorderLayout.CENTER);
        zhoJian.setLayout(new CardLayout(0, 0));

        JPanel zhuJIM = new JPanel();
        zhuJIM.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        zhoJian.add(zhuJIM, "主界面");
        zhuJIM.setLayout(new BoxLayout(zhuJIM, BoxLayout.X_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        zhuJIM.add(panel_1);

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8);

        JLabel lblNewLabel_4 = new JLabel("管理员日志");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(lblNewLabel_4);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        zhuJIM.add(panel_6);

        JLabel lblNewLabel_5 = new JLabel("营业详情");
        lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel_5);

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        zhuJIM.add(panel_7);

        JLabel lblNewLabel_6 = new JLabel("仓库库存");
        lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(lblNewLabel_6);

        jinHuo = new JPanel();
        jinHuo.setBackground(new Color(255, 204, 204));
        jinHuo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        zhoJian.add(jinHuo, "商品");
        jinHuo.setLayout(null);
        int x = jinHuo.getWidth();
        int y = jinHuo.getHeight();

        panel_9 = new JPanel();
        panel_9.setOpaque(false);
        //思考 问题  自定义最大化按钮 为按钮触发设置最大化  获得面板的宽高 为绝对定位 设置宽高
        panel_9.setBounds(148, 66, 1617, 708);
        jinHuo.add(panel_9);
        panel_9.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_9.add(panel, BorderLayout.WEST);

        JLabel lblNewLabel_8 = new JLabel("zuo");
        lblNewLabel_8.setPreferredSize(new Dimension(100, 10));
        panel.add(lblNewLabel_8);

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_9.add(panel_10, BorderLayout.EAST);

        JLabel lblNewLabel_9 = new JLabel("you");
        lblNewLabel_9.setPreferredSize(new Dimension(100, 10));
        panel_10.add(lblNewLabel_9);

        JPanel panel_11 = new JPanel();
        panel_11.setOpaque(false);
        panel_9.add(panel_11, BorderLayout.CENTER);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JPanel panel_12zuo = new JPanel();
        panel_12zuo.setOpaque(false);
        panel_11.add(panel_12zuo);

        JPanel panel_13you = new JPanel();
        panel_13you.setRequestFocusEnabled(false);
        panel_13you.setBackground(new Color(115, 115, 115, 150));

        panel_13you.setMaximumSize(new Dimension(300, 32767));
        panel_13you.setPreferredSize(new Dimension(250, 10));
        panel_11.add(panel_13you);
        panel_13you.setLayout(new GridLayout(5, 0, 0, 20));

        JButton btnNewButton_5 = new JButton("新增新商品");
        btnNewButton_5.setBorder(null);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                //panel_13you.repaint();
            }

        });

//			btnNewButton_5.setContentAreaFilled(false);
        btnNewButton_5.setBackground(new Color(248, 248, 255));
        btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);

        ImageIcon xzIcon = new ImageIcon(ZuJie2.class.getResource("/img/新增新商品.png"));
        xzIcon.setImage(xzIcon.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        btnNewButton_5.setIcon(xzIcon);

        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //FrmAddMainXing sp= new FrmAddMainXing();
                //sp.setLocationRelativeTo(null);
                lblNewLabel_7.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/树.jpg")));
                jinHuo.repaint();

            }
        });
        panel_13you.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("单据查询");
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmRecipt();

            }
        });
        btnNewButton_6.setBorder(null);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageIcon xzl = new ImageIcon(ZuJie2.class.getResource("/img/新增老商品.png"));
        xzl.setImage(xzl.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));


        btnNewButton_6.setIcon(xzl);


        panel_13you.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("采货进货");
        btnNewButton_7.setBorder(null);
        btnNewButton_7.setBackground(new Color(248, 248, 255));
        btnNewButton_7.setFocusPainted(false);
        ImageIcon cgjh = new ImageIcon(ZuJie2.class.getResource("/img/采购进货(1).png"));
        cgjh.setImage(cgjh.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));

        btnNewButton_7.setIcon(cgjh);


        btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmProcure2(employee);
            }
        });
        panel_13you.add(btnNewButton_7);

        JButton btnNewButton_17 = new JButton("采购单据查询");
        btnNewButton_17.setBorder(null);
        btnNewButton_17.setBackground(new Color(248, 248, 255));
        btnNewButton_17.setFocusPainted(false);
        btnNewButton_17.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_17.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageIcon cgdj = new ImageIcon(ZuJie2.class.getResource("/img/采购单据.png"));
        cgdj.setImage(cgdj.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        btnNewButton_17.setIcon(cgdj);
        btnNewButton_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new FrmPurMain();
            }
        });
        panel_13you.add(btnNewButton_17);

        JButton btnNewButton_19 = new JButton("商品列表");
        btnNewButton_19.setBorder(null);
        btnNewButton_19.setBackground(new Color(248, 248, 255));
        btnNewButton_19.setFocusPainted(false);
        ImageIcon solb = new ImageIcon(ZuJie2.class.getResource("/img/商品列表.png"));
        solb.setImage(solb.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        btnNewButton_19.setIcon(solb);
        btnNewButton_19.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_19.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new FrmProManage();
            }
        });
        panel_13you.add(btnNewButton_19);


        lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setOpaque(true);
        lblNewLabel_7.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/timg.jpg")));
        lblNewLabel_7.setBounds(148, 67, 1617, 708);
        jinHuo.add(lblNewLabel_7);

        JPanel caKu = new JPanel();
        caKu.setBackground(new Color(102, 204, 102));
        zhoJian.add(caKu, "仓库");
        caKu.setLayout(null);

        panel_4 = new JPanel();
        panel_4.setOpaque(false);
        panel_4.setBounds(148, 67, 1617, 708);
        caKu.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_4.add(panel_5, BorderLayout.WEST);

        JLabel lblNewLabel_10 = new JLabel("zuo");
        lblNewLabel_10.setPreferredSize(new Dimension(100, 10));
        panel_5.add(lblNewLabel_10);

        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_4.add(panel_12, BorderLayout.EAST);

        JLabel lblNewLabel_11 = new JLabel("右");
        lblNewLabel_11.setPreferredSize(new Dimension(100, 10));
        panel_12.add(lblNewLabel_11);

        JPanel panel_13 = new JPanel();
        panel_13.setOpaque(false);
        panel_4.add(panel_13, BorderLayout.CENTER);
        panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

        JPanel panel_14 = new JPanel();
        panel_14.setOpaque(false);
        panel_13.add(panel_14);

        JPanel panel_15 = new JPanel();

        panel_15.setBackground(new Color(115, 115, 115, 150));
        panel_15.setMaximumSize(new Dimension(300, 32767));
        panel_15.setPreferredSize(new Dimension(250, 10));
        panel_13.add(panel_15);
        panel_15.setLayout(new GridLayout(4, 0, 20, 20));

        JButton btnNewButton_8 = new JButton("仓库查询");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //new FrmWarehouse();
            }
        });
        panel_15.add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("商品信息");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new FrmCommodityinformation();
            }
        });
        panel_15.add(btnNewButton_9);

        JButton btnNewButton_10 = new JButton("仓库盘点");
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new FrmInventory();
            }
        });
        panel_15.add(btnNewButton_10);

        label = new JLabel("New label");
        label.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/timg (3).jpg")));
        label.setBounds(148, 67, 1283, 688);
        caKu.add(label);

        JPanel SheZhi = new JPanel();
        SheZhi.setBackground(new Color(255, 153, 102));
        zhoJian.add(SheZhi, "设置");
        SheZhi.setLayout(null);

        panel_16 = new JPanel();
        panel_16.setOpaque(false);
        panel_16.setBounds(148, 67, 1617, 708);
        SheZhi.add(panel_16);
        panel_16.setLayout(new BorderLayout(0, 0));

        JPanel panel_17 = new JPanel();
        panel_17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_16.add(panel_17, BorderLayout.EAST);

        JLabel lblNewLabel_13 = new JLabel("左");
        lblNewLabel_13.setPreferredSize(new Dimension(100, 10));
        panel_17.add(lblNewLabel_13);

        JPanel panel_18 = new JPanel();
        panel_18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_16.add(panel_18, BorderLayout.WEST);

        JLabel lblNewLabel_12 = new JLabel("右");
        lblNewLabel_12.setPreferredSize(new Dimension(100, 10));
        panel_18.add(lblNewLabel_12);

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_19.setOpaque(false);
        panel_16.add(panel_19, BorderLayout.CENTER);
        panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));

        JPanel panel_20 = new JPanel();
        panel_20.setOpaque(false);
        panel_19.add(panel_20);

        JPanel panel_21 = new JPanel();
        panel_21.setBackground(new Color(115, 115, 115, 115));
        panel_21.setMaximumSize(new Dimension(300, 32767));
        panel_21.setPreferredSize(new Dimension(250, 10));
        panel_19.add(panel_21);
        panel_21.setLayout(new GridLayout(4, 0, 20, 20));

        JButton btnNewButton_11 = new JButton("会员设置");
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmVIP();
            }
        });
        btnNewButton_11.setActionCommand("会员设置");
        panel_21.add(btnNewButton_11);

        JButton btnNewButton_12 = new JButton("员工设置");
        btnNewButton_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmEmployeeInfor();
            }
        });
        panel_21.add(btnNewButton_12);

        JButton btnNewButton_13 = new JButton("供货商设置");
        btnNewButton_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmSupplier();
            }
        });
        panel_21.add(btnNewButton_13);

        JButton btnNewButton_20 = new JButton("商品管理");
        btnNewButton_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmProManage();
            }
        });
        panel_21.add(btnNewButton_20);

        lblNewLabel_14 = new JLabel("New label");
        lblNewLabel_14.setOpaque(true);
        lblNewLabel_14.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/天空3.jpg")));
        lblNewLabel_14.setBounds(148, 67, 1617, 708);
        SheZhi.add(lblNewLabel_14);

        JPanel shouYin = new JPanel();
        shouYin.setBackground(new Color(51, 153, 204));
        zhoJian.add(shouYin, "收银");
        shouYin.setLayout(null);

        panel_22 = new JPanel();
        panel_22.setOpaque(false);
        panel_22.setBounds(148, 67, 1617, 708);
        shouYin.add(panel_22);
        panel_22.setLayout(new BorderLayout(0, 0));

        JPanel panel_23 = new JPanel();
        panel_22.add(panel_23, BorderLayout.EAST);

        JLabel lblNewLabel_15 = new JLabel("New label");
        panel_23.add(lblNewLabel_15);

        JPanel panel_24 = new JPanel();
        panel_22.add(panel_24, BorderLayout.WEST);

        JLabel lblNewLabel_16 = new JLabel("New label");
        panel_24.add(lblNewLabel_16);

        JPanel panel_25 = new JPanel();
        panel_25.setOpaque(false);
        panel_22.add(panel_25, BorderLayout.CENTER);
        panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.X_AXIS));

        JPanel panel_26 = new JPanel();
        panel_26.setOpaque(false);
        panel_25.add(panel_26);

        JPanel panel_27 = new JPanel();
        panel_27.setBackground(new Color(115, 115, 115, 115));
        panel_27.setMaximumSize(new Dimension(300, 32767));
        panel_27.setPreferredSize(new Dimension(250, 10));
        panel_25.add(panel_27);
        panel_27.setLayout(new GridLayout(3, 1, 0, 20));

        JButton btnNewButton_14 = new JButton("收银管理");
        btnNewButton_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new FrmCashier();
            }
        });
        panel_27.add(btnNewButton_14);

        JButton btnNewButton_15 = new JButton("收银管理2");
        btnNewButton_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Cashier2();
            }
        });
        panel_27.add(btnNewButton_15);

        JButton btnNewButton_16 = new JButton("New button");
        panel_27.add(btnNewButton_16);

        lblNewLabel_17 = new JLabel("");
        lblNewLabel_17.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/星空.jpg")));
        lblNewLabel_17.setBounds(148, 67, 1617, 708);
        shouYin.add(lblNewLabel_17);

        JPanel Butto = new JPanel();
        contentPane.add(Butto, BorderLayout.SOUTH);

        JLabel lblNewLabel_3 = new JLabel("一些系统快捷设置 提醒");
        Butto.add(lblNewLabel_3);
    }

    //方法区
    class dianJi implements ActionListener {//为按钮添加事件


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            CardLayout ka = (CardLayout) zhoJian.getLayout();
            Object obj = e.getSource();
            if (obj instanceof JButton) {
                JButton bb = (JButton) obj;
                String bj = bb.getActionCommand();
                if ("主界面".equals(bj)) {
                    ka.show(zhoJian, "主界面");
                    shiJian.setVisible(true);
                    guGan.setVisible(true);
                    lblNewLabel_7.setIcon(new ImageIcon(ZuJie2.class.getResource("/img/timg.jpg")));
                    //System.out.println("9999");
                    //contentPane.updateUI();
                }
                if ("仓库".equals(bj)) {
                    ka.show(zhoJian, "仓库");
                    shiJian.setVisible(false);
                    guGan.setVisible(false);
                }
                if ("设置".equals(bj)) {
                    ka.show(zhoJian, "设置");

                    shiJian.setVisible(false);
                    guGan.setVisible(false);
                }
                if ("商品".equals(bj)) {
                    ka.show(zhoJian, "商品");
                    shiJian.setVisible(false);
                    guGan.setVisible(false);
                }
                if ("收银".equals(bj)) {
                    ka.show(zhoJian, "收银");
                    shiJian.setVisible(false);
                    guGan.setVisible(false);
                }


            }
        }

    }

    public void showTime() {//
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
        String time1 = sdf.format(new Date());
        xiTime.setText(time1);
    }
}

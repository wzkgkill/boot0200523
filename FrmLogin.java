package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import dao.EmployeeDAO;
import entity.Employee;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class FrmLogin extends JFrame {

    private JPanel contentPane;
    private JTextField txtID;
    private JPasswordField txtPwd;
    static char defaultChar;// 默认的字符, 如果你喜欢星号, 那么设置为星号也可以

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmLogin frame = new FrmLogin();
                    frame.setVisible(true);
                    //frame.setFocusable(true);//焦点默认在第一个文本框上
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //实例化DAO类
    EmployeeDAO emodao = new EmployeeDAO();
    static Point origin = new Point();
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_1;

    // 窗体移动函数
    public void WindowMove() {
        //设置没有标题的窗口可以拖动
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
                origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
                origin.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();  //当鼠标拖动时获取窗口当前位置
                //设置窗口的位置
                //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 779, 498);
        contentPane = new JPanel() {
            ImageIcon icon = new ImageIcon("src/images/背景云.jpg");
            //icon.setImage(icon.getImage().getScaledInstance(779,498,Image.SCALE))
            Image img = icon.getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, 779, 498, this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setLocationRelativeTo(null);//自己的窗体放中间
        setContentPane(contentPane);

        //设置窗体没有标题
        setUndecorated(true);
        //设置没有标题栏的窗体可拖动
        //全局的位置变量，用于表示鼠标在窗口上的位置
        WindowMove();

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(new Rectangle(0, 10, 0, 0));
        panel.setBackground(new Color(255, 255, 153));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/超市图标.png")));
        lblNewLabel.setBounds(308, 0, 138, 114);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("家百利超市管理系统");
        label.setForeground(new Color(51, 51, 102));
        label.setFont(new Font("隶书", Font.BOLD, 50));
        label.setBounds(169, 129, 482, 52);
        panel.add(label);

        JLabel label_1 = new JLabel("账号：");
        label_1.setFont(new Font("宋体", Font.BOLD, 25));
        label_1.setBounds(203, 203, 78, 30);
        panel.add(label_1);

        txtID = new JTextField();
        txtID.setText("请输入账号：");
        txtID.setFont(new Font("宋体", Font.BOLD, 20));
        txtID.setForeground(Color.LIGHT_GRAY);
        txtID.setBorder(null);
        txtID.setColumns(50);
        txtID.setBounds(286, 201, 276, 39);
        txtID.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //鼠标进入。判断文本框的值
                Object obj = e.getSource();
                if (obj instanceof JTextField) {
                    JTextField text = (JTextField) obj;
                    //获取当前文本框的值
                    String str = text.getText().trim();
                    if ("请输入账号：".equals(str)) {
                        //将文本框的值清空
                        text.setText("");
                        text.setForeground(Color.black);
                        lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/账号.png")));
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //鼠标移开
                Object obj = e.getSource();
                if (obj instanceof JTextField) {
                    JTextField text = (JTextField) obj;
                    //获取当前文本框的值
                    String str = text.getText().trim();
                    if ("".equals(str)) {
                        //将文本框的值清空
                        text.setText("请输入账号：");
                        text.setForeground(Color.lightGray);
                        lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/账号灰.png")));
                    }
                }
            }
        });
        panel.add(txtID);

        JLabel label_2 = new JLabel("密码：");
        label_2.setFont(new Font("宋体", Font.BOLD, 25));
        label_2.setBounds(203, 264, 78, 30);
        panel.add(label_2);

        JButton btnLogin = new JButton("登录");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //登录按钮
                login();
            }
        });
        btnLogin.setBorder(new LineBorder(null, 0, true));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("宋体", Font.BOLD, 25));
        btnLogin.setBackground(new Color(60, 179, 113));
        btnLogin.setBounds(224, 340, 338, 39);
        btnLogin.setFocusPainted(false);
        panel.add(btnLogin);

        txtPwd = new JPasswordField();
        defaultChar = txtPwd.getEchoChar();
        txtPwd.setEchoChar('\0');// \0 比较特殊, 密码框的文字会明文显示
        txtPwd.setText("请输入密码：");// 设置密码框的内容
        txtPwd.setFont(new Font("宋体", Font.BOLD, 20));
        txtPwd.setForeground(Color.LIGHT_GRAY);// 设置密码框的文字颜色
        txtPwd.setBorder(null);
        txtPwd.setBounds(286, 262, 276, 39);

        txtPwd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {// 失去焦点的时候
                //鼠标进入。判断文本框的值
                Object obj = e.getSource();
                if (obj instanceof JPasswordField) {
                    JPasswordField text = (JPasswordField) obj;
                    //获取当前文本框的值
                    String str = text.getText().trim();
                    //String pswd = new String(txtPwd.getPassword()).trim();//一句话解决
                    if ("请输入密码：".equals(str)) {// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
                        txtPwd.setText("");
                        txtPwd.setEchoChar(defaultChar);// 默认的字符, 如果你喜欢星号, 那么设置为星号也可以
                        txtPwd.setForeground(Color.BLACK);
                        lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/密码.png")));
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {// 获得焦点的时候
                //鼠标进入。判断文本框的值
                Object obj = e.getSource();
                if (obj instanceof JPasswordField) {
                    JPasswordField text = (JPasswordField) obj;
                    //获取当前文本框的值
                    String str = text.getText().trim();
                    //String pswd = new String(txtPwd.getPassword()).trim();//一句话解决，替代判断是否是密码框
                    if ("".equals(str)) {// 如果没有输入密码. 就用明文 提示用户输入密码
                        txtPwd.setEchoChar('\0');// \0 比较特殊, 密码框的文字会明文显示
                        txtPwd.setText("请输入密码：");
                        txtPwd.setForeground(Color.LIGHT_GRAY);
                        lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/密码灰.png")));
                    }
                }
            }
        });
        txtPwd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                int keycode = e.getKeyCode();
                if (keycode == 10) {
                    //按下回车键的时候，调用登录的逻辑
                    login();
                }
            }

        });
        panel.add(txtPwd);


        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBorder(null);
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/密码灰.png")));
        lblNewLabel_1.setBounds(560, 262, 28, 39);
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBorder(null);
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/账号灰.png")));
        lblNewLabel_2.setBounds(561, 201, 25, 39);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        contentPane.add(panel_1, BorderLayout.NORTH);
        panel_1.setBackground(new Color(255, 255, 153));
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

        Component glue = Box.createGlue();
        panel_1.add(glue);

        JButton btnClose = new JButton("");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //当前窗体在事件中，不是this对象
                FrmLogin.this.dispose();
            }
        });
        btnClose.setBorderPainted(false);//是否绘制边框
        btnClose.setContentAreaFilled(false);//不填充,则此按钮颜色不为灰色填充
        btnClose.setOpaque(false);//是否不透明
        btnClose.setFocusPainted(false);//是否绘制焦点,×的框就不会出来
        btnClose.setBackground(new Color(255, 255, 153));
        btnClose.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/关闭.png")));

        panel_1.add(btnClose);
    }

    private void login() {
        //1、获取文本框值的
        String name = txtID.getText().trim();
        String pwd = txtPwd.getText().trim();
        //2、数据验证
        if (name.length() < 2) {
            JOptionPane.showMessageDialog(null, "请输入合格的用户名");
            return;
        }
        if (pwd.length() < 6) {
            JOptionPane.showMessageDialog(null, "请输入合格的密码");
            return;
        }
        //3、传递数据，查询结果
        Employee emo = emodao.selectByEmoName(name);
        if (emo == null) {
            JOptionPane.showMessageDialog(null, "用户名错误！！");
            return;
        } else {
            //账号正确
            if (emo.getPpwd().equals(pwd)) {
                if (emo.getPstatu() == false) {
                    JOptionPane.showMessageDialog(null, "权限不足,登录失败！");
                    return;
                }
                //密码正确，允许登录
                ZuJie2 zhu = new ZuJie2(emo);
                zhu.setVisible(true);
                FrmLogin.this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "密码错误！！");
                return;
            }
        }
    }
}

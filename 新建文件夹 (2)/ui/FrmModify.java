package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

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

import org.omg.CORBA.StringHolder;

import dao.RepertoryDAO;
import dao.commodityDAO;
import entity.Repertory;
import entity.commodity;

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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class FrmModify extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField;
    private FrmCommodityinformation parent;
    private JComboBox comboBox_2;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmModify frame = new FrmModify();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmModify(FrmCommodityinformation frmList, String[] row) {
        this();
        this.parent = frmList;
        textField.setText(row[0]);
        textField.setEnabled(false);
        textField_1.setText(row[1]);
        textField_1.setEnabled(false);
        comboBox.setSelectedItem(row[2]);
        comboBox.setEnabled(false);
        comboBox_1.setSelectedItem(row[3]);
        comboBox_1.setEnabled(false);
        comboBox_2.setSelectedItem(row[4]);
        comboBox_2.setEnabled(false);
        textField_2.setText(row[5]);
        textField_3.setText(row[6]);

    }

    public FrmModify(FrmCommodityinformation frmList) {
        this();
        this.parent = frmList;
        textField.setVisible(false);
        lblNewLabel_1.setVisible(false);
    }

    static {
        // 允许设置外观
        setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public FrmModify() {
        setTitle("修改商品");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 552, 279);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "商品基本信息", TitledBorder.LEADING,
                TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), new Color(0, 0, 0)));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new GridLayout(0, 2, 10, 10));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        lblNewLabel_1 = new JLabel("商品编号：");
        lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_2.add(lblNewLabel_1);

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JLabel label = new JLabel("商品名称：");
        label.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_3.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        panel_3.add(textField_1);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("单    位：");
        label_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_6.add(label_2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"瓶", "袋", "罐", "箱", "盒"}));
        comboBox.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_6.add(comboBox);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("所在仓库：");
        label_3.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_7.add(label_3);

        comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("楷体", Font.PLAIN, 20));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"饮料", "酒类", "生活用品", "婴儿用品", "服装"}));
        panel_7.add(comboBox_1);

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("颜    色：");
        label_4.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(label_4);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{"无", "白", "黑", "绿", "蓝", "红", "黄"}));
        comboBox_2.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_8.add(comboBox_2);

        JPanel panel_10 = new JPanel();
        panel_1.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_7 = new JLabel("预设进价：");
        label_7.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_10.add(label_7);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_2.addKeyListener(new KeyListener() {
            int a = 0;

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub
                if (a >= 48 && a <= 57 || a == 81 || a == 46) {

                } else {
                    arg0.consume();//使键盘事件处理那些是非法数字
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
                a = arg0.getKeyCode();
            }
        });
        textField_2.setColumns(10);
        panel_10.add(textField_2);

        JPanel panel_11 = new JPanel();
        panel_1.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_8 = new JLabel("预设售价：");
        label_8.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_11.add(label_8);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_3.addKeyListener(new KeyListener() {
            int a = 0;

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub
                if (a >= 48 && a <= 57 || a == 81 || a == 46) {

                } else {
                    arg0.consume();//使键盘事件处理那些是非法数字
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
                a = arg0.getKeyCode();
            }
        });
        textField_3.setColumns(10);
        panel_11.add(textField_3);

        JPanel panel_12 = new JPanel();
        contentPane.add(panel_12, BorderLayout.CENTER);
        panel_12.setLayout(new BorderLayout(0, 0));

        JPanel panel_16 = new JPanel();
        panel_12.add(panel_16, BorderLayout.NORTH);

        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("") || textField_1.getText().equals("")
                        || textField_2.getText().equals("") || textField_3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "商品信息未填写完");
                } else {
                    String rsid = textField.getText();
                    String rname = textField_1.getText();
                    String runit = comboBox.getSelectedItem().toString();
                    String rtype = comboBox_1.getSelectedItem().toString();
                    String rcolor = comboBox_2.getSelectedItem().toString();
                    BigDecimal rprice = new BigDecimal(textField_2.getText());
                    BigDecimal rmprice = new BigDecimal(textField_3.getText());
                    RepertoryDAO dao = new RepertoryDAO();
                    Repertory com = new Repertory();
                    com.setRsid(rsid);
                    com.setRname(rname);
                    com.setRunit(runit);
                    com.setRtype(rtype);
                    com.setRcolor(rcolor);
                    com.setRprice(rprice);
                    com.setRmprice(rmprice);
                    if (rsid.length() == 0) {
                        int Id = dao.setr(com);
                        if (Id > 0) {
                            if (parent != null) {
                                parent.bindData();
                                FrmModify.this.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "代码错误");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "新增失败，请修复错误");
                        }
                    } else {
                        boolean flag = dao.doUpdate(com);
                        if (flag) {
                            parent.bindData();
                            FrmModify.this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "修改失败，请修复错误");
                        }
                    }
                }
            }
        });
        btnSure.setFocusPainted(false);
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(btnSure);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_16.add(horizontalStrut);

        JButton btnEsc = new JButton("退出");
        btnEsc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmModify.this.dispose();
            }
        });
        btnEsc.setFocusPainted(false);
        btnEsc.setBackground(new Color(135, 206, 250));
        btnEsc.setFont(new Font("楷体", Font.PLAIN, 20));
        panel_16.add(btnEsc);

    }
}

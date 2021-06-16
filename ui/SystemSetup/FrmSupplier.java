package ui.SystemSetup;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.EmployeeDAO;
import dao.SupplierDAO;
import entity.Employee;
import entity.Supplier;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class FrmSupplier extends JFrame {

    private JPanel contentPane;
    private JTextField txtTel;
    private JTextField txtPeople;
    private JTable table;
    private JTextField txtFindPeople;
    private JTextField txtFindTel;
    private JComboBox comFindGHS;
    private JButton btnSure;
    private JButton btnDelete;
    private JComboBox<String> comFindProv;
    private JComboBox<String> comFindAddr;
    //private JComboBox comFindProv;
    //private JComboBox comFindAddr;
    private JTextField txtBZ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmSupplier frame = new FrmSupplier();
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
    public FrmSupplier() {
        setVisible(true);
        setTitle("供货商信息");
        setIconImage(new ImageIcon("src/images/超市图标.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1156, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocation(254, 249);//绝对定位

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(10, 5, 10, 5));
        panel_1.setBackground(SystemColor.inactiveCaptionBorder);
        //panel_1.setBorder(new TitledBorder(null, "客户信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(0, 1, 10, 10));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(SystemColor.inactiveCaptionBorder);
        panel_6.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_2.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("供货商名称：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(lblNewLabel);

        JComboBox comGHS = new JComboBox();
        comGHS.setBackground(Color.WHITE);
        comGHS.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团"}));
        comGHS.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(comGHS);

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(SystemColor.inactiveCaptionBorder);
        panel_7.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_2.add(panel_7);
        panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("联系人：  ");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_7.add(label_1);

        txtPeople = new JTextField();
        txtPeople.setFont(new Font("宋体", Font.PLAIN, 20));
        txtPeople.setColumns(10);
        panel_7.add(txtPeople);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(SystemColor.inactiveCaptionBorder);
        panel_8.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_3.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label = new JLabel("联系电话：  ");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(label);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        panel_8.add(txtTel);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(SystemColor.inactiveCaptionBorder);
        panel_9.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_3.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        String[] pro = {"湖南省", "湖北省", "江西省", "四川省"};
        String[][] addre = {
                {"株洲市", "长沙市"},
                {"武汉市", "黄石市"},
                {"九江市", "南昌市"},
                {"自贡市", "德阳市"}
        };

        JLabel label_2 = new JLabel("联系地址：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(label_2);

        JComboBox<String> comProvince = new JComboBox<String>(pro);
        //JComboBox comProvince = new JComboBox(pro);
        comProvince.setBackground(Color.WHITE);
        comProvince.insertItemAt("请选择省", 0);
        comProvince.setSelectedIndex(0);
        //comProvince.setModel(new DefaultComboBoxModel(new String[] {"湖南省", "湖北省", "江西省", "福建省", "四川省"}));
        comProvince.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(comProvince);

        Component horizontalStrut_6 = Box.createHorizontalStrut(10);
        panel_9.add(horizontalStrut_6);

        JComboBox<String> comAddress = new JComboBox<String>();
        //JComboBox comAddress = new JComboBox();
        comAddress.setBackground(Color.WHITE);
        comAddress.setFont(new Font("宋体", Font.PLAIN, 20));
        //comAddress.setModel(new DefaultComboBoxModel(new String[] {"株洲市"}));
        panel_9.add(comAddress);

        //规格这个下拉列表，在选择发生改变的时候，要去填充“单位”下拉列表的值
        comProvince.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中了一个省");
                    //获取选中的值
                    int index = comProvince.getSelectedIndex();
                    //清除掉市下拉列表里面的值
                    comAddress.removeAllItems();
                    if (index == 0) {
//						String [] myAddress=addre[0];
//						for (String c : myAddress) {
//							comAddress.addItem(c.toString());
//						}
                        return;
                    }
                    //根据索引获取二维数组对应的市信息
                    String[] myaddre = addre[index - 1];
                    //清除掉市下拉列表里面的值
                    comAddress.removeAllItems();
                    for (String c : myaddre) {
                        comAddress.addItem(c.toString());
                    }

                } else {
                    System.out.println("成功替换了一个省份");
                }
            }
        });

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_13 = new JPanel();
        panel_13.setBackground(SystemColor.inactiveCaptionBorder);
        panel_13.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_4.add(panel_13);
        panel_13.setLayout(null);

        JLabel label_7 = new JLabel("备    注：");
        label_7.setBounds(0, 13, 120, 24);
        label_7.setBorder(new EmptyBorder(0, 0, 0, 20));
        label_7.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_13.add(label_7);

        txtBZ = new JTextField();
        txtBZ.setBounds(120, 0, 359, 50);
        txtBZ.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBZ.setColumns(10);
        panel_13.add(txtBZ);

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(SystemColor.inactiveCaptionBorder);
        panel_12.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_4.add(panel_12);
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));

        Component horizontalStrut_9 = Box.createHorizontalStrut(40);
        panel_12.add(horizontalStrut_9);

        JLabel label_6 = new JLabel("供货商状态：  ");
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(label_6);

        JRadioButton radioYes = new JRadioButton("使用");
        radioYes.setFocusPainted(false);
        radioYes.setContentAreaFilled(false);
        radioYes.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(radioYes);

        Component horizontalStrut_8 = Box.createHorizontalStrut(60);
        panel_12.add(horizontalStrut_8);

        JRadioButton radioNo = new JRadioButton("禁用");
        radioNo.setContentAreaFilled(false);
        radioNo.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(radioNo);

        //默认选中一个单选按钮
        radioYes.setSelected(true);
        ButtonGroup gp = new ButtonGroup();
        gp.add(radioYes);
        gp.add(radioNo);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 204));
        panel_1.add(panel_5);

        //添加一个确定修改按钮
        btnSure = new JButton("确定修改");
        btnSure.setIcon(new ImageIcon(FrmSupplier.class.getResource("/images/保存单据.png")));
        btnSure.setVisible(false);
        btnSure.setBackground(SystemColor.activeCaption);
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnSure);

        //文本框只能输入数字
        txtTel.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81) {
                    //System.out.println("是数字和退格键");
                } else {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                //System.out.println(keycode+"数字");
            }
        });

        JButton btnAdd = new JButton("增加");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = comGHS.getSelectedItem().toString();
                String people = txtPeople.getText().trim();
                String tel = txtTel.getText().trim();
                if (people.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入员工姓名");
                    return;
                }
                if (tel.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入员工联系电话");
                    return;
                }
                if (tel.length() != 11 || !tel.startsWith("1")) {
                    JOptionPane.showMessageDialog(null, "请输入正确的手机号码");
                    return;
                }
                System.out.println("获取的地址：" + comProvince.getSelectedItem().toString());
                if ("请选择省".equals(comProvince.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "请选择地址");
                    return;
                }
                String address = comProvince.getSelectedItem().toString() + comAddress.getSelectedItem().toString();
                String bz = txtBZ.getText().trim();
                SupplierDAO dao = new SupplierDAO();
                Supplier supplier = new Supplier();
                supplier.setSupname(name);
                supplier.setSuppeople(people);
                supplier.setSuptel(tel);
                supplier.setSupadress(address);
                supplier.setSupbz(bz);
                if (radioYes.isSelected()) {
                    supplier.setSupstatu(true);
                } else if (radioNo.isSelected()) {
                    supplier.setSupstatu(false);
                }
                int id = dao.doCreate(supplier);
                if (id > 0) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //清空表格
                    model.setRowCount(0);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "新增失败");
                }
                //清空增加供货商的输入框
                comGHS.setSelectedIndex(0);
                txtPeople.setText("");
                txtTel.setText("");
                comProvince.setSelectedIndex(0);
                comAddress.setSelectedItem("");
                txtBZ.setText("");
                btnSure.setVisible(false);
                btnAdd.setVisible(true);
                btnDelete.setVisible(true);
            }
        });
        btnAdd.setFocusPainted(false);
        btnAdd.setBackground(new Color(204, 255, 153));
        btnAdd.setIcon(new ImageIcon(FrmSupplier.class.getResource("/images/增加员工22.png")));
        btnAdd.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnAdd);

        Component horizontalStrut_4 = Box.createHorizontalStrut(50);
        panel_5.add(horizontalStrut_4);

        JButton btnUpdate = new JButton("修改");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取表格选中的行
                int rowIndex = table.getSelectedRow();
                //2、判断是否选中
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中你要修改的数据行");
                    return;
                }
                //3、获取选中行的数据
                //创建一维数组,长度就是列的数量
                String[] row = new String[table.getColumnCount()];
                for (int i = 0; i < table.getColumnCount(); i++) {
                    //数组第一个值----表格中的第一列
                    //数组第二个值----表格中的第二列
                    //……………………
                    row[i] = table.getValueAt(rowIndex, i).toString();
                }
                comGHS.setSelectedItem(row[0]);
                txtPeople.setText(row[1]);
                txtTel.setText(row[2]);
                String province = row[3].substring(0, 3);
                System.out.println("省：" + province);
                comProvince.setSelectedItem(province);
                String address = row[3].substring(3);
                System.out.println("市：" + address);
                comAddress.setSelectedItem(address);
                txtBZ.setText(row[4]);
                String zt = row[5];
                if ("使用".equals(zt)) {
                    radioYes.setSelected(true);
                } else if ("禁用".equals(zt)) {
                    radioNo.setSelected(true);
                }
                //隐藏按钮
                btnAdd.setVisible(false);
                btnDelete.setVisible(false);
                btnSure.setVisible(true);
                btnSure.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ghsName = comGHS.getSelectedItem().toString();
                        String peo = txtPeople.getText().trim();
                        String phone = txtTel.getText().trim();
//						String dz="";						
//						if(comProvince.getSelectedItem().equals("请选择省")) {
//							comAddress.insertItemAt("请选择市", 0);
//							comAddress.setSelectedIndex(0);
//							dz=comProvince.getSelectedItem().toString();
//							System.out.println("详细市地址："+comAddress.getSelectedItem().toString());
//						}else {
                        String dz = comProvince.getSelectedItem().toString() + comAddress.getSelectedItem().toString();
                        //}
                        String bz = txtBZ.getText().trim();

                        SupplierDAO dao = new SupplierDAO();
                        Supplier supplier = new Supplier();
                        List<Supplier> list = dao.selectID(row[0]);
                        for (Supplier s1 : list) {
                            int id = s1.getSupid();//获取对应的员工编号
                            supplier.setSupid(id);
                        }
                        supplier.setSupname(ghsName);
                        supplier.setSuppeople(peo);
                        supplier.setSuptel(phone);
                        System.out.println("地址：" + dz);
                        supplier.setSupadress(dz);
                        supplier.setSupbz(bz);
                        if (radioYes.isSelected()) {
                            supplier.setSupstatu(true);
                        } else if (radioNo.isSelected()) {
                            supplier.setSupstatu(true);
                        }
                        boolean flag = dao.doUpdate(supplier);
                        if (flag) {
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            //清空表格
                            model.setRowCount(0);
                            loadData();
                            System.out.println("修改成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "修改失败");
                        }
                        //清空增加供货商的输入框
                        comGHS.setSelectedIndex(0);
                        txtPeople.setText("");
                        txtTel.setText("");
                        comProvince.setSelectedIndex(0);
                        comAddress.setSelectedItem("");
                        txtBZ.setText("");
                        btnSure.setVisible(false);
                        btnAdd.setVisible(true);
                        btnDelete.setVisible(true);
                    }
                });
            }
        });
        btnUpdate.setFocusPainted(false);
        btnUpdate.setBackground(new Color(204, 255, 153));
        btnUpdate.setIcon(new ImageIcon(FrmSupplier.class.getResource("/images/修改员工22.png")));
        btnUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnUpdate);

        Component horizontalStrut_5 = Box.createHorizontalStrut(50);
        panel_5.add(horizontalStrut_5);

        btnDelete = new JButton("删除");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取选中行的索引
                int rowIndex = table.getSelectedRow();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中您要删除的行.");
                    return;
                }
                if (rowIndex >= 1) {
                    JOptionPane.showMessageDialog(null, "请确认是否删除该供货商(删除则将该供货商禁用)");
                }
                String[] row = new String[table.getColumnCount()];
                for (int i = 0; i < table.getColumnCount(); i++) {
                    //数组第一个值----表格中的第一列
                    //数组第二个值----表格中的第二列
                    //……………………
                    row[i] = table.getValueAt(rowIndex, i).toString();
                }
                //2、获取选中行的供货商名称
                String ghsName = table.getValueAt(rowIndex, 0).toString();
                System.out.println("供货商名称：" + ghsName);
                //3、调用DAO方法进行删除,不直接删除，删除成功只改变供货商状态----禁用
                SupplierDAO dao = new SupplierDAO();
                Supplier supplier = new Supplier();
                Boolean zt = false;
                supplier.setSupname(ghsName);
                supplier.setSupstatu(zt);
                boolean flag = dao.doUpdateZt(supplier);
                if (flag) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //清空表格
                    model.setRowCount(0);
                    loadData();
                    System.out.println("删除成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
        });
        btnDelete.setFocusPainted(false);
        btnDelete.setBackground(new Color(204, 255, 153));
        btnDelete.setIcon(new ImageIcon(FrmSupplier.class.getResource("/images/删 除员工22 .png")));
        btnDelete.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_5.add(btnDelete);


        JPanel panel_10 = new JPanel();
        panel.add(panel_10, BorderLayout.CENTER);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new EmptyBorder(5, 0, 10, 0));
        panel_11.setBackground(SystemColor.inactiveCaptionBorder);
        panel_10.add(panel_11, BorderLayout.NORTH);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel lblNewLabel_2 = new JLabel("供货商名称：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(lblNewLabel_2);

        comFindGHS = new JComboBox();
        comFindGHS.setMaximumSize(new Dimension(14, 32767));
        comFindGHS.setBackground(Color.WHITE);
        comFindGHS.setFont(new Font("宋体", Font.PLAIN, 20));
        comFindGHS.setModel(new DefaultComboBoxModel(new String[]{"普通供货商", "金星集团", "蒙牛奶业公司", "统一集团", "天冠集团", ""}));
        panel_11.add(comFindGHS);

        Component horizontalStrut = Box.createHorizontalStrut(10);
        panel_11.add(horizontalStrut);

        JLabel label_3 = new JLabel("联系人：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(label_3);

        txtFindPeople = new JTextField();
        txtFindPeople.setMaximumSize(new Dimension(14, 2147483647));
        txtFindPeople.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(txtFindPeople);
        txtFindPeople.setColumns(10);

        Component horizontalStrut_1 = Box.createHorizontalStrut(10);
        panel_11.add(horizontalStrut_1);

        JLabel label_4 = new JLabel("电话：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(label_4);

        txtFindTel = new JTextField();
        txtFindTel.setMinimumSize(new Dimension(25, 27));
        txtFindTel.setMaximumSize(new Dimension(25, 2147483647));
        txtFindTel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(txtFindTel);
        txtFindTel.setColumns(10);

        Component horizontalStrut_2 = Box.createHorizontalStrut(10);
        panel_11.add(horizontalStrut_2);

        JLabel label_5 = new JLabel("地址：");
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(label_5);

        comFindProv = new JComboBox<String>(pro);
        //comFindProv = new JComboBox(pro);
        comFindProv.insertItemAt("请选择省", 0);
        comFindProv.setSelectedIndex(0);
        comFindProv.setBackground(Color.WHITE);
        comFindProv.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(comFindProv);

        Component horizontalStrut_7 = Box.createHorizontalStrut(10);
        panel_11.add(horizontalStrut_7);

        comFindAddr = new JComboBox<String>();
        //comFindAddr = new JComboBox();
        comFindAddr.setBackground(Color.WHITE);
        comFindAddr.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(comFindAddr);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_11.add(horizontalStrut_3);

        comFindProv.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中了一个省");
                    //获取选中的值
                    int index = comFindProv.getSelectedIndex();
                    //清除掉市下拉列表里面的值
                    comFindAddr.removeAllItems();
                    if (index == 0) {
                        return;
                    }
                    //根据索引获取二维数组对应的市信息
                    String[] myaddress2 = addre[index - 1];
                    //清除掉市下拉列表里面的值
                    comFindAddr.removeAllItems();
                    for (String c : myaddress2) {
                        comFindAddr.addItem(c.toString());
                    }
                } else {
                    System.out.println("成功替换了一个省份");
                }
            }
        });

        JButton button = new JButton("查找");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moHu();
            }
        });
        button.setIcon(new ImageIcon(FrmSupplier.class.getResource("/images/查找22.png")));
        button.setFont(new Font("宋体", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.setBackground(new Color(204, 255, 153));
        panel_11.add(button);

        JScrollPane scrollPane = new JScrollPane();
        panel_10.add(scrollPane, BorderLayout.CENTER);

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//不可编辑
            }
        };
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                },
                new String[]{
                        "\u4F9B\u8D27\u5546\u540D\u79F0", "\u8054\u7CFB\u4EBA", "\u7535\u8BDD", "\u5730\u5740", "\u5907\u6CE8", "供货商状态"
                }
        ));
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.BOLD, 19));// 字体
            //hh.setBackground(SystemColor.inactiveCaptionBorder);// 前景颜色
            hh.setBackground(new Color(255, 255, 240));
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        }
        scrollPane.setViewportView(table);
        //给表格绑定数据（查询所有）
        loadData();
    }

    //模糊查询
    public void moHu() {
        String names = comFindGHS.getSelectedItem().toString();
        String peoples = txtFindPeople.getText().trim();
        String tels = txtFindTel.getText().trim();

        String dz = null;
        if (comFindProv.getSelectedIndex() > 0) {
            String pro = comFindProv.getSelectedItem().toString();
            String adr = comFindAddr.getSelectedItem().toString();
            dz = pro + adr;
        }

        System.out.println("地址：" + dz);
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> list = dao.selectByWord(names, peoples, tels, dz);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (list == null || list.isEmpty()) {
            return;
        }
        //一行一行的添加数据
        for (Supplier s : list) {
            Object[] row = {
                    s.getSupname(),
                    s.getSuppeople(),
                    s.getSuptel(),
                    s.getSupadress(),
                    s.getSupbz()
            };
            model.addRow(row);
        }
    }

    //加载数据到表格中
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //清空表格
        model.setRowCount(0);
        ///实例化DAO类
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> list = dao.selectAll();//不能单独写在页面最上头，否则第一次拿到的全部查询数据不会刷新
        for (Supplier s : list) {
            Object[] row = {
                    s.getSupname(),
                    s.getSuppeople(),
                    s.getSuptel(),
                    s.getSupadress(),
                    s.getSupbz(),
                    s.getSupstatu() ? "使用" : "禁用"
            };
            model.addRow(row);
        }
        fitColumn();
    }

    private void fitColumn() {//⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = table.getTableHeader();
        int rowCount = table.getRowCount();
        Enumeration columns = table.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer().getTableCellRendererComponent
                    (table, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) table.getCellRenderer(row, col).getTableCellRendererComponent
                        (table, table.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + table.getIntercellSpacing().width);
        }
    }
}

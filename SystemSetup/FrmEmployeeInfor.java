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
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dao.RepertoryDAO;
import entity.Employee;
import entity.Repertory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class FrmEmployeeInfor extends JFrame {


    private JPanel contentPane;
    private JTable table;
    private JTextField txtName;
    private JTextField txtBZ;
    private JTextField txtTel;
    private JComboBox comZW;
    private JComboBox comZhuangTai;
    private JButton btnDelete;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JTextField txtFindName;
    private JTextField txtFindTel;
    private JComboBox comFindZhiWu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmEmployeeInfor frame = new FrmEmployeeInfor();
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
    public FrmEmployeeInfor() {
        setVisible(true);
        setTitle("员工信息");
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
        panel_1.setBackground(new Color(255, 255, 204));
        panel_1.setBorder(new EmptyBorder(10, 5, 10, 5));
        //panel_1.setBorder(new TitledBorder(null, "员工信息", TitledBorder.LEADING, TitledBorder.TOP, new Font("宋体", Font.PLAIN, 20), null));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(4, 0, 0, 20));

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 255, 204));
        panel_8.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_4.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel label = new JLabel("员工姓名：");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_8.add(label);

        txtName = new JTextField();
        txtName.setFont(new Font("宋体", Font.PLAIN, 20));
        txtName.setColumns(10);
        panel_8.add(txtName);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 255, 204));
        panel_9.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_4.add(panel_9);
        panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("所任职务：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_9.add(label_1);

        comZW = new JComboBox();
        comZW.setModel(new DefaultComboBoxModel(new String[]{"收银员", "采购员", "仓管", "老板"}));
        comZW.setFont(new Font("宋体", Font.PLAIN, 20));
        comZW.setBackground(Color.WHITE);
        panel_9.add(comZW);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(255, 255, 204));
        panel_10.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_5.add(panel_10);
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

        JLabel label_2 = new JLabel("联系电话：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_10.add(label_2);

        txtTel = new JTextField();
        txtTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtTel.setColumns(10);
        panel_10.add(txtTel);

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(255, 255, 204));
        panel_11.setBorder(new EmptyBorder(0, 0, 0, 80));
        panel_5.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel label_3 = new JLabel("员工状态：");
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_11.add(label_3);

        comZhuangTai = new JComboBox();
        comZhuangTai.setModel(new DefaultComboBoxModel(new String[]{"在职", "离职"}));
        comZhuangTai.setFont(new Font("宋体", Font.PLAIN, 20));
        comZhuangTai.setBackground(Color.WHITE);
        panel_11.add(comZhuangTai);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 204));
        panel_1.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        JLabel label_4 = new JLabel("备    注：");
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_6.add(label_4);

        txtBZ = new JTextField();
        txtBZ.setFont(new Font("宋体", Font.PLAIN, 20));
        txtBZ.setColumns(10);
        panel_6.add(txtBZ);


        Component horizontalStrut = Box.createHorizontalStrut(80);
        panel_6.add(horizontalStrut);


        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(204, 255, 204));
        panel_1.add(panel_12);
        //添加一个确定修改按钮，先隐藏，点击修改按钮才会显示出来
        JButton btnSure = new JButton("确定修改");
        btnSure.setIcon(new ImageIcon(FrmEmployeeInfor.class.getResource("/images/保存单据.png")));
        btnSure.setFocusPainted(false);
        btnSure.setVisible(false);
        btnSure.setBackground(new Color(153, 153, 255));
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(btnSure);


        //文本框只能输入数字
        txtTel.addKeyListener(new KeyAdapter() {
            int keycode = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                if (keycode >= 48 && keycode <= 57 || keycode == 81) {
                    System.out.println("是数字和退格键");
                } else {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //只有keyPressed才能获取按下的键值
                keycode = e.getKeyCode();
                System.out.println(keycode + "数字");
            }
        });

        btnAdd = new JButton("增加员工");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText().trim();//名字
                if (name.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入将要增加的员工姓名");
                    return;
                }
                System.out.println("名字" + name);
                String zhiWu = comZW.getSelectedItem().toString();//职务
                String tel = txtTel.getText().trim();//电话
                if (tel.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入将要增加的员工联系电话");
                    return;
                }
                System.out.println("电话：" + tel);
                String zt = comZhuangTai.getSelectedItem().toString();//状态
                String bz = txtBZ.getText().trim();//备注
                //数据验证
                if (name.length() < 2 || name.length() > 18) {
                    JOptionPane.showMessageDialog(null, "请输入正确的用户名");
                    return;
                }
                if (tel.length() != 11 || !tel.startsWith("1")) {
                    JOptionPane.showMessageDialog(null, "请输入正确的手机号码");
                    return;
                }

                EmployeeDAO dao = new EmployeeDAO();
                Employee emo = new Employee();
                emo.setPname(name);
                emo.setPlphone(tel);
                java.util.Date aDate = new java.util.Date();//获得当前系统时间
                long time = aDate.getTime();//转成long类型
                String time2 = time + "";
                time2 = time2.substring(5, 11);//截取时间戳的4位数
                System.out.println(time2);
                emo.setPpwd(time2);
                emo.setPplace(zhiWu);
                Boolean zt1 = true;
                if ("在职".equals(zt)) {
                    emo.setPstatu(zt1);
                } else if ("离职".equals(zt)) {
                    zt1 = false;
                    emo.setPstatu(zt1);
                }
                emo.setPbz(bz);
                int Id = dao.doCreate(emo);
                System.out.println(Id);
                if (Id > 0) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //清空表格
                    model.setRowCount(0);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "新增失败");
                }
                //清空增加员工的输入框
                txtName.setText("");
                txtTel.setText("");
                txtBZ.setText("");
                comZW.setSelectedIndex(0);
                comZhuangTai.setSelectedIndex(0);
            }
        });
        btnAdd.setBackground(new Color(204, 255, 255));
        btnAdd.setFocusPainted(false);
        btnAdd.setIcon(new ImageIcon(FrmEmployeeInfor.class.getResource("/images/增加员工22.png")));
        btnAdd.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(btnAdd);

        Component horizontalStrut_1 = Box.createHorizontalStrut(40);
        panel_12.add(horizontalStrut_1);

        btnUpdate = new JButton("修改员工");
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


                txtName.setText(row[0]);
                comZW.setSelectedItem(row[1]);
                txtTel.setText(row[2]);
                comZhuangTai.setSelectedItem(row[3]);
                txtBZ.setText(row[4]);

                //隐藏增加员工按钮和删除按钮
                btnAdd.setVisible(false);
                btnDelete.setVisible(false);
                btnSure.setVisible(true);
                btnSure.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //获取文本框里的值
                        String uname = txtName.getText().trim();
                        String uZW = comZW.getSelectedItem().toString();//职务
                        String utel = txtTel.getText().trim();
                        String uZT = comZhuangTai.getSelectedItem().toString();//员工状态
                        String uBZ = txtBZ.getText().trim();

                        EmployeeDAO dao = new EmployeeDAO();
                        Employee employee = new Employee();
                        List<Employee> list = dao.selectID(row[0]);//不能单独写在页面最上头，否则第一次拿到的全部查询数据不会刷新
                        for (Employee e1 : list) {
                            int id = e1.getPsid();//获取对应的员工编号
                            employee.setPsid(id);
                        }
                        employee.setPname(uname);
                        employee.setPplace(uZW);
                        employee.setPlphone(utel);
                        Boolean zt = true;
                        if ("离职".equals(uZT)) {
                            zt = false;
                        }
                        employee.setPstatu(zt);
                        employee.setPbz(uBZ);
                        boolean flag = dao.doUpdate(employee);
                        if (flag) {
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            //清空表格
                            model.setRowCount(0);
                            loadData();

                        } else {
                            JOptionPane.showMessageDialog(null, "修改失败");
                        }
                        //清空增加员工的输入框
                        btnSure.setVisible(false);
                        txtName.setText("");
                        txtTel.setText("");
                        txtBZ.setText("");
                        comZW.setSelectedIndex(0);
                        comZhuangTai.setSelectedIndex(0);
                        //增加员工和删除按钮显示
                        btnAdd.setVisible(true);
                        btnDelete.setVisible(true);
                    }
                });
            }
        });

        btnUpdate.setBackground(new Color(204, 255, 255));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setIcon(new ImageIcon(FrmEmployeeInfor.class.getResource("/images/修改员工22.png")));
        btnUpdate.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(btnUpdate);

        Component horizontalStrut_2 = Box.createHorizontalStrut(40);
        panel_12.add(horizontalStrut_2);

        btnDelete = new JButton("删除员工");
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
                    JOptionPane.showMessageDialog(null, "请确认是否删除该员工(删除则将该该职工改为离职状态)");
                }
                String[] row = new String[table.getColumnCount()];
                for (int i = 0; i < table.getColumnCount(); i++) {
                    //数组第一个值----表格中的第一列
                    //数组第二个值----表格中的第二列
                    //……………………
                    row[i] = table.getValueAt(rowIndex, i).toString();
                }
                //2、获取选中行的员工名称
                String name = table.getValueAt(rowIndex, 0).toString();
                //3、调用DAO方法进行删除,不直接删除，删除成功只改变状态----离职
                Employee employee = new Employee();
                EmployeeDAO dao = new EmployeeDAO();
                Boolean zt = false;
                employee.setPname(row[0]);
                employee.setPstatu(zt);
                boolean flag = dao.doUpdateZt(employee);
                if (flag) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //清空表格
                    model.setRowCount(0);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }

        });
        btnDelete.setBackground(new Color(204, 255, 255));
        btnDelete.setFocusPainted(false);
        btnDelete.setIcon(new ImageIcon(FrmEmployeeInfor.class.getResource("/images/删 除员工22 .png")));
        btnDelete.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_12.add(btnDelete);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//不可编辑
            }
        };
        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "\u5458\u5DE5\u59D3\u540D", "\u804C\u52A1", "\u8054\u7CFB\u7535\u8BDD", "\u5458\u5DE5\u72B6\u6001", "\u5907\u6CE8"
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
            table.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        }
        scrollPane.setViewportView(table);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_3.setBackground(new Color(204, 255, 204));
        panel_2.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalStrut_7 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_7);

        JLabel label_7 = new JLabel("员工姓名：");
        label_7.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(label_7);

        txtFindName = new JTextField();
        txtFindName.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(txtFindName);
        txtFindName.setColumns(13);

        Component horizontalStrut_4 = Box.createHorizontalStrut(40);
        panel_3.add(horizontalStrut_4);

        JLabel label_6 = new JLabel("职务：");
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(label_6);

        comFindZhiWu = new JComboBox();
        comFindZhiWu.setBackground(Color.WHITE);
        comFindZhiWu.setModel(new DefaultComboBoxModel(new String[]{"收银员", "采购员", "仓管", "老板", ""}));
        comFindZhiWu.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(comFindZhiWu);

        Component horizontalStrut_5 = Box.createHorizontalStrut(40);
        panel_3.add(horizontalStrut_5);

        JLabel lblNewLabel = new JLabel("联系电话：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(lblNewLabel);

        txtFindTel = new JTextField();
        txtFindTel.setFont(new Font("宋体", Font.PLAIN, 20));
        txtFindTel.setColumns(18);
        panel_3.add(txtFindTel);

        Component horizontalStrut_6 = Box.createHorizontalStrut(40);
        panel_3.add(horizontalStrut_6);

        JButton btnChaXun = new JButton("查询");
        btnChaXun.setIcon(new ImageIcon(FrmEmployeeInfor.class.getResource("/images/查找22.png")));
        btnChaXun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moHu();
            }
        });
        btnChaXun.setFocusPainted(false);
        btnChaXun.setBackground(new Color(135, 206, 250));
        btnChaXun.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(btnChaXun);

        //调用加载数据的方法
        loadData();
    }

    //模糊查询
    public void moHu() {
        String names = txtFindName.getText().trim();
        String posts = comFindZhiWu.getSelectedItem().toString();
        String tels = txtFindTel.getText().trim();
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.selectByWord(names, posts, tels);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (list == null || list.isEmpty()) {
            return;
        }
        //一行一行的添加数据
        for (Employee e : list) {
            Object[] row = {
                    e.getPname(),
                    e.getPplace(),
                    e.getPlphone(),
                    e.getPstatu() ? "在职" : "离职",//	   >0则是true
                    e.getPbz()
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
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.selectAll();//不能单独写在页面最上头，否则第一次拿到的全部查询数据不会刷新
        for (Employee e : list) {
            Object[] row = {
                    e.getPname(),
                    e.getPplace(),
                    e.getPlphone(),
                    e.getPstatu() ? "在职" : "离职",
                    e.getPbz()
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

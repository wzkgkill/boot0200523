package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TabExpander;

import dao.InventoryDAO;
import dao.InventorylistDAO;
import dao.InventorylistsDAO;
import dao.RepertoryDAO;
import dao.commodityDAO;
import dao.warehousesDAO;
import entity.Inventory;
import entity.Inventorylist;
import entity.Inventorylists;
import entity.Repertory;
import entity.commodity;
import entity.purchase;
import entity.warehouses;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmInventoryAdd extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JTextField textField;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private FrmInventory quanju;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmInventoryAdd frame = new FrmInventoryAdd();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static {
        // ??????????????????
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

    public FrmInventoryAdd(FrmInventory xx) {
        this();
        quanju = xx;
    }

    /**
     * Create the frame.
     */
    public FrmInventoryAdd() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("???????????????");
        lblNewLabel_3.setFont(new Font("??????", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_3);

        java.util.Date aDate = new java.util.Date();// ????????????????????????
        long time = aDate.getTime();// ??????long??????
        String time2 = time + "";
        time2 = time2.substring(7, 11);// ??????????????????4??????
        Date bDate = new Date(time);// ??????sql?????????
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// ??????sql??????????????????
        String cc = sdf.format(bDate);
        cc = cc.substring(2);// ???????????????
        String dingDanID = cc + time2;// ?????????????????????
        Integer pandian = Integer.valueOf(dingDanID) / 2;
        JLabel lblNewLabel_4 = new JLabel(pandian + "");
        lblNewLabel_4.setFont(new Font("??????", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_4);

        Component horizontalStrut_1 = Box.createHorizontalStrut(40);
        panel_5.add(horizontalStrut_1);

        JLabel lblNewLabel_2 = new JLabel("??????????????????");
        lblNewLabel_2.setFont(new Font("??????", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("??????", Font.PLAIN, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"?????????", "??????", "?????????", "???????????????"}));

        comboBox.setMinimumSize(new Dimension(40, 21));
        panel_5.add(comboBox);

        Component horizontalGlue_2 = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue_2);

        Component horizontalGlue_1 = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue_1);

        Component horizontalGlue = Box.createHorizontalGlue();
        panel_2.add(horizontalGlue);

        JLabel lblNewLabel_5 = new JLabel("????????????");
        lblNewLabel_5.setFont(new Font("??????", Font.PLAIN, 16));
        panel_2.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setFont(new Font("??????", Font.PLAIN, 16));
        panel_2.add(lblNewLabel_6);

        Component horizontalStrut = Box.createHorizontalStrut(40);
        panel_2.add(horizontalStrut);

        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        JLabel lblNewLabel = new JLabel("??????:??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        lblNewLabel.setForeground(Color.RED);
        panel_3.add(lblNewLabel);

        JPanel panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(550, 10));
        contentPane.add(panel_6, BorderLayout.WEST);
        panel_6.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_6.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8, BorderLayout.NORTH);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("????????????");
        lblNewLabel_1.setFont(new Font("??????", Font.PLAIN, 16));
        panel_8.add(lblNewLabel_1);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_1.add(panel_9, BorderLayout.SOUTH);
        panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_7 = new JLabel("???????????????");
        lblNewLabel_7.setFont(new Font("??????", Font.PLAIN, 20));
        panel_9.add(lblNewLabel_7);

        textField = new JTextField();
        textField.setFont(new Font("??????", Font.PLAIN, 20));
        panel_9.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("??????");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String text = textField.getText().trim();
                bindData(text);
            }
        });
        btnNewButton.setFont(new Font("??????", Font.PLAIN, 20));
        panel_9.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        panel_6.add(scrollPane, BorderLayout.CENTER);

        String[] header = {"????????????", "????????????", "??????", "?????????", "????????????", "??????", "??????"};
        model = new DefaultTableModel(null, header);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // ?????????????????????
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    int x = table.getSelectedRow();
                    String a = table.getValueAt(x, 0) + "";
                    String s = table.getValueAt(x, 1) + "";
                    String d = table.getValueAt(x, 2) + "";
                    Integer f = Integer.valueOf(table.getValueAt(x, 3) + "");
                    String g = table.getValueAt(x, 4) + "";
                    BigDecimal h = new BigDecimal(table.getValueAt(x, 5) + "");
                    BigDecimal j = new BigDecimal(table.getValueAt(x, 6) + "");
                    Object[] cc = {a, s, d, f, g, h, j};
                    String rname = comboBox.getSelectedItem().toString();
                    model1.addRow(cc);
                    InventorylistsDAO aa = new InventorylistsDAO();
                    Inventorylists ss = new Inventorylists(lblNewLabel_4.getText(), rname, "??????", "4", "5", a, s, d, f,
                            g, h, j);
                    aa.update(ss);
                }

            }
        });

        scrollPane.setViewportView(table);
        // ????????????
        // RepertoryDAO dao = new RepertoryDAO();
        // List<Repertory> list = dao.select();
        // bindData(list);
        bindData();

        JPanel panel_7 = new JPanel();
        panel_7.setPreferredSize(new Dimension(550, 10));
        contentPane.add(panel_7, BorderLayout.EAST);
        panel_7.setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        panel_7.add(panel_10, BorderLayout.NORTH);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panel_11 = new JPanel();
        panel_10.add(panel_11, BorderLayout.NORTH);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

        JLabel lblNewLabel_8 = new JLabel("????????????");
        lblNewLabel_8.setFont(new Font("??????", Font.PLAIN, 16));
        panel_11.add(lblNewLabel_8);

        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_10.add(panel_12, BorderLayout.SOUTH);

        JButton button = new JButton("??????");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int aa = 0;
                for (int i = 0; i < model1.getRowCount(); i++) {
                    aa = Integer.valueOf(table.getValueAt(i, 3) + "") + aa;
                }
                InventorylistDAO a = new InventorylistDAO();
                String rname = comboBox.getSelectedItem().toString();
                String aaa = aa + "";
                String hh = model1.getRowCount() + "";
                Inventorylist s = new Inventorylist(lblNewLabel_4.getText(), rname, "??????", hh, aaa);
                a.update(s);

                quanju.bindData(a.select());
            }
        });
        button.setFont(new Font("??????", Font.PLAIN, 20));
        panel_12.add(button);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        panel_12.add(horizontalStrut_2);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_12.add(horizontalStrut_3);

        JButton btnNewButton_3 = new JButton("??????");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmInventoryAdd.this.dispose();
            }
        });
        btnNewButton_3.setFont(new Font("??????", Font.PLAIN, 20));
        panel_12.add(btnNewButton_3);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_7.add(scrollPane_1, BorderLayout.CENTER);

        String[] header2 = {"????????????", "????????????", "??????", "?????????", "????????????", "??????", "??????"};
        model1 = new DefaultTableModel(null, header2);
        table_1 = new JTable(model1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // ?????????????????????
                return false;

            }
        };

        scrollPane_1.setViewportView(table_1);
    }

    public void bindData(String key) {
        // ?????????????????????
        model.setRowCount(0);
        // 1????????????DAO???
        RepertoryDAO dao = new RepertoryDAO();
        // 2??????????????????????????????
        List<Repertory> list = null;
        if ("".equals(key)) {
            list = dao.selectAll();
        } else {
            list = dao.selectByAll(key);
        }
        // 3????????????????????????????????????????????????????????????
        for (Repertory aa : list) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            model.addRow(row);
        }

    }

    public void bindData() {
        // ????????????????????????
        model.setRowCount(0);
        // ?????????dao???
        RepertoryDAO dao = new RepertoryDAO();
        List<Repertory> list2 = dao.selectAll();
        // ?????????list??????,???????????????????????????
        for (Repertory aa : list2) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            // ?????????????????????????????????????????????model?????????
            model.addRow(row);
        }

        // ????????????????????????????????????????????????????????????????????????????????????????????????
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader headers = table.getTableHeader();
        int rowCount = table.getRowCount();
        Enumeration columns = table.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = headers.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) headers.getDefaultRenderer()
                    .getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) table.getCellRenderer(row, col)
                        .getTableCellRendererComponent(table, table.getValueAt(row, col), false, false, row, col)
                        .getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            headers.setResizingColumn(column); // ???????????????
            column.setWidth(width + table.getIntercellSpacing().width);
        }
    }

}

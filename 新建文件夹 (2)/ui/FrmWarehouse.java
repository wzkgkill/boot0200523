package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.RepertoryDAO;
import dao.purchaseDAO;
import dao.warehousesDAO;
import entity.Repertory;
import entity.purchase;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class FrmWarehouse extends JFrame {

    private JPanel contentPane;
    private JTable table_1;
    private JTable table;
    private JTextField textField;
    private DefaultTableModel model;
    private DefaultTableModel model1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmWarehouse frame = new FrmWarehouse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
    public FrmWarehouse() {
        setVisible(true);
        setTitle("仓库");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(null);
        panel_1.setBackground(Color.WHITE);
        panel.add(panel_1, BorderLayout.NORTH);

//		JLabel lblNewLabel = new JLabel("仓库：");
//		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
//		panel_1.add(lblNewLabel);

//		JComboBox comboBox = new JComboBox();
//		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] { "主仓库", "饮料库", "酒库", "日常用品库" }));
//		panel_1.add(comboBox);

        JLabel lblNewLabel_4 = new JLabel("仓库查询：");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("查询");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                bindData(text);
                model1.setRowCount(0);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(0, 153, 255));
        panel_1.add(btnNewButton_1);

        JLabel label_1 = new JLabel("（输入商品编号、名称）");
        label_1.setFont(new Font("宋体", Font.PLAIN, 13));
        panel_1.add(label_1);

        JLabel label = new JLabel("");
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_1.add(label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(0, 153, 204));
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        String[] header = {"商品编号", "商品名称", "单位", "库存量", "所在仓库", "进价", "售价"};
        model = new DefaultTableModel(null, header);

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 单元格不可编辑
                return false;
            }
        };
        table.setRowHeight(30);
        table.setFont(new Font("微软雅黑", Font.BOLD, 20));
        table.setBorder(null);
        scrollPane.setViewportView(table);
        // 给table绑定数据
//		RepertoryDAO dao = new RepertoryDAO();
//		List<Repertory> list = dao.select();
//		bindData(list);
        bindData();

        JPanel panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(10, 260));
        panel.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_2.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_6);

        JLabel lblNewLabel_3 = new JLabel("采购销售详情");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_3.add(lblNewLabel_3);

        Component verticalStrut_1 = Box.createVerticalStrut(30);
        verticalStrut_1.setBackground(Color.WHITE);
        panel_3.add(verticalStrut_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBorder(null);
        scrollPane_1.setBackground(new Color(0, 153, 204));
        panel_2.add(scrollPane_1, BorderLayout.CENTER);

        String[] header2 = {"采购时间", "采购单据", "经办人", "数量", "所在仓库", "进价", "售价"};
        model1 = new DefaultTableModel(null, header2);
        table_1 = new JTable(model1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 单元格不可编辑
                return false;
            }
        };
        table_1.setRowHeight(30);
        table_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        table_1.setBorder(null);
        scrollPane_1.setViewportView(table_1);
        // 给table绑定数据
        purchaseDAO dao2 = new purchaseDAO();
        List<purchase> list2 = dao2.select();
        bindData2(list2);
    }

    public void bindData2(List<purchase> list) {
        // ①清空原来的数据
        model1.setRowCount(0);
        // "商品编号", "商品名称", "单位", "库存量", "所在仓库", "进价", "售价"
        for (purchase aa : list) {
            Object[] row = {aa.getWorderdata(), aa.getWorder(), aa.getWpurchasing(), aa.getRsordersize(),
                    aa.getRwhere(), aa.getRprice(), aa.getRmprice()};

            // ④将一维数组（行）添加到表格的model对象中
            model1.addRow(row);
        }
    }

    //模糊查询
    public void bindData(String key) {
        // 清空原来的数据
        model.setRowCount(0);
        // 1、实例化DAO类
        RepertoryDAO dao = new RepertoryDAO();
        // 2、调用查询所有的方法
        List<Repertory> list = null;
        if ("".equals(key)) {
            list = dao.selectAll();
        } else {
            list = dao.selectByAll(key);
        }
        // 3、循环遍历每个实体类，实体类转成一维数组
        for (Repertory aa : list) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            model.addRow(row);
        }

    }

    //给表格绑定数据
    public void bindData() {
        // ①清空原来的数据
        model.setRowCount(0);
        //实例化dao类
        RepertoryDAO dao = new RepertoryDAO();
        List<Repertory> list2 = dao.selectAll();
        // ②遍历list集合,将数据绑定到表格中
        for (Repertory aa : list2) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRinventory(), aa.getRtype(),
                    aa.getRprice(), aa.getRmprice()};
            // ④将一维数组（行）添加到表格的model对象中
            model.addRow(row);
        }

        // ⑤单元格宽度自适应（跟随数据内容自动调整，必须写在绑定数据之后）
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
            headers.setResizingColumn(column); // 此行很重要
            column.setWidth(width + table.getIntercellSpacing().width);
        }
    }

}
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BorderFactory;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.RepertoryDAO;
import dao.commodityDAO;
import dao.warehousesDAO;
import entity.Repertory;
import entity.commodity;
import entity.warehouses;
import net.miginfocom.swing.MigLayout;

import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;

public class FrmCommodityinformation extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmCommodityinformation frame = new FrmCommodityinformation();
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
    public FrmCommodityinformation() {
        setTitle("商品信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(262, 239, 1143, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmAdd aa = new FrmAdd(FrmCommodityinformation.this);
                aa.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("修改");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中你要修改的数据行");
                    return;
                }
                String[] row = new String[table.getColumnCount()];
                for (int i = 0; i < table.getColumnCount(); i++) {
                    row[i] = table.getValueAt(rowIndex, i).toString();
                }
                FrmModify add = new FrmModify(FrmCommodityinformation.this, row);
                add.setVisible(true);
                add.setLocationRelativeTo(FrmCommodityinformation.this);
            }
        });

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(btnNewButton_1);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_3);

        JButton btnNewButton_8 = new JButton("退出");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmCommodityinformation.this.dispose();
            }
        });
        btnNewButton_8.setFont(new Font("宋体", Font.PLAIN, 20));
        panel.add(btnNewButton_8);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("商品信息查询：");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setMinimumSize(new Dimension(40, 21));
        textField.setMaximumSize(new Dimension(120, 20));
        textField.setColumns(10);
        panel_2.add(textField);

        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                bindData(text);
            }
        });
        btnNewButton_9.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnNewButton_9);

        JLabel label = new JLabel("（输入商品编号、名称）");
        label.setFont(new Font("宋体", Font.PLAIN, 13));
        panel_2.add(label);

        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane, BorderLayout.CENTER);

        String[] header = {"商品编号", "商品名称", "单位", "所在仓库", "颜色", "进价", "售价"};
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
//		List<Repertory> list = dao.select2();
        bindData();
    }

    // 模糊查询
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

    public void dsup() {
        model.setRowCount(0);
        RepertoryDAO dao = new RepertoryDAO();
        List<Repertory> aa = dao.selectAll();
        for (Repertory ss : aa) {
            Object[] dd = {ss.getRsid(), ss.getRname(), ss.getRunit(), ss.getRtype(), ss.getRcolor(),
                    ss.getRprice(), ss.getRmprice(),};
            model.addRow(dd);
        }
    }

    //绑定数据
    public void bindData() {
        // ①清空原来的数据
        model.setRowCount(0);
        //实例化dao类
        RepertoryDAO dao = new RepertoryDAO();
        List<Repertory> list2 = dao.selectAll();
        // ②遍历list集合,将数据绑定到表格中
        for (Repertory aa : list2) {
            Object[] row = {aa.getRsid(), aa.getRname(), aa.getRunit(), aa.getRtype(), aa.getRcolor(),
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
package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class FrmProcureUpdatePrice extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmProcureUpdatePrice frame = new FrmProcureUpdatePrice();
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
    public FrmProcureUpdatePrice() {
        setTitle("待定商品");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 910, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("以下红色块商品进价与预设进价有差异");
        lblNewLabel.setForeground(new Color(255, 51, 51));
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u9884\u8BBE\u8FDB\u4EF7", "\u5F53\u524D\u8FDB\u4EF7", "\u89C4\u683C\u578B\u53F7"
                }
        ));
        {
            //设置行高
            table.setRowHeight(30);
            //设置表头对象
            JTableHeader hh = table.getTableHeader();
            hh.setBorder(BorderFactory.createLineBorder(new Color(120, 192, 110)));// 边框
            hh.setBackground(new Color(120, 192, 110));// 背景颜色
            hh.setFont(new Font("楷体", Font.PLAIN, 19));// 字体
            //hh.setBackground(SystemColor.inactiveCaptionBorder);// 前景颜色
            hh.setBackground(new Color(255, 255, 240));
            hh.setPreferredSize(new Dimension(hh.getWidth(), (40)));//40 指的是表头的高度
            table.setTableHeader(hh);
            //设置表格内容居中
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, render);
            table.setFont(new Font("微软雅黑", Font.BOLD, 18));
        }
        scrollPane.setViewportView(table);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.SOUTH);

        JButton btnSure = new JButton("确定");
        btnSure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmProcureUpdatePrice.this.dispose();
                new FrmShenHe();

            }
        });
        btnSure.setBackground(new Color(135, 206, 250));
        btnSure.setFocusPainted(false);
        btnSure.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnSure);

        Component horizontalStrut = Box.createHorizontalStrut(200);
        panel_2.add(horizontalStrut);

        JButton btnDelete = new JButton("删除");
        btnDelete.setBackground(new Color(135, 206, 250));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取选中行的索引
                int rowIndex = table.getSelectedRow();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "请选中您要删除的行.");
                    return;
                }
//				//2、获取选中行的主键编号
//				String ID = table.getValueAt(rowIndex, 0).toString();
//				//3、调用DAO方法进行删除	
//				ProductDAO dao = new ProductDAO();
//				boolean flag = dao.doDelete(Integer.valueOf(ID));
//				//4、更新表格数据
//				//4.1  第一种方式：重新绑定数据到表格
//				//	①调用对应的方法（selectAll）
//				List<Product> list = dao.selectAll();
//				//	②调用表格数据绑定的方法
//				bindData(list);
//				//4.2  第二种方式：直接删除当前选中行				
//				bindData2();//再次调用分页的方法，更新下面分页的属性的值
            }

        });
        btnDelete.setFocusPainted(false);
        btnDelete.setFont(new Font("宋体", Font.PLAIN, 20));
        panel_2.add(btnDelete);
    }

}

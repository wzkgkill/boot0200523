package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.Box;

public class FrmGhsXuanFu2 extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private Popup pop = null;//1.创建空白的popup的悬浮
    private JButton btnChaZhao;
    private JPanel xuanFuMain;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmGhsXuanFu2 frame = new FrmGhsXuanFu2();
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
    public FrmGhsXuanFu2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 762, 377);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);

        btnChaZhao = new JButton("New button");
        btnChaZhao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(btnChaZhao);

            }
        });
        panel_1.add(btnChaZhao);
        cc();

    }

    //4.写一个不显示组件的窗口方法。下面所有组件都是你要显示在悬浮窗口上的组件
    public void cc() {
        xuanFuMain = new JPanel();
        JPanel panel3 = new JPanel();
        panel3.add(xuanFuMain, BorderLayout.CENTER);
        xuanFuMain.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        xuanFuMain.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                },
                new String[]{
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        scrollPane.setViewportView(table);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(SystemColor.inactiveCaptionBorder);
        xuanFuMain.add(btnPanel, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBackground(SystemColor.activeCaption);
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gu();

            }
        });
        btnPanel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gu();

            }
        });

        Component horizontalStrut = Box.createHorizontalStrut(100);
        btnPanel.add(horizontalStrut);
        btnPanel.add(btnNewButton_1);
    }

    //2.写一个触发的方法
    public void showPanel(Component owner) {//触发的方法。参数是你要让那个组件作为你的父级窗口 触发悬浮
        if (pop != null)
            pop.hide();
        //下面的组件，就是你要触发显示的那个组件
        Point show = new Point(0, btnChaZhao.getHeight());//接受二个int参数让他显示在父级窗口哪个位置，
        //第一个参数是x轴，0是在父级窗口对应的0，第二个是y轴，默认获取的是你要设置哪个组件的高度，并显示在他下方。
        SwingUtilities.convertPointToScreen(show, btnChaZhao);//显示在哪个组件的下方。

        pop = PopupFactory.getSharedInstance().getPopup(owner, xuanFuMain, show.x, show.y);//x和y都是int类型，以你定好的窗口位置，xy轴移动
        //这个上面的panel 就是你要显示的悬浮窗口
        pop.show();//悬浮开始的方法
    }

    //3.写一个关闭的方法
    public void gu() {

        pop.hide();//悬浮关闭的方法


    }
}

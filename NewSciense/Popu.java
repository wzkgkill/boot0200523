package NewSciense;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 悬浮
 *
 * @author lenovo
 */
public class Popu extends JFrame {

    private JPanel contentPane;
    private Popup pop = null;//1.创建空白的popup的悬浮
    private JButton btnNewButton;
    private JPanel panel;
    private JButton jb;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Popu frame = new Popu();
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
    public Popu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        System.out.println("1515" + "\t\t" + "55");
        btnNewButton = new JButton("New button");//这是我在主界面写的一个 触发显示悬浮的方法
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showPanel(btnNewButton);//显示悬浮窗口，显示在我要求显示的组件的下面，也就是你要的父级窗口
            }
        });
        cc();//5.将此方法 放在 可以被运行到的地方，因为运行了也不会显示。所有不会影响布局，他只会被 悬浮触发时候，才显示。
        contentPane.add(btnNewButton, BorderLayout.NORTH);

        btnNewButton_1 = new JButton("New button");//这是我在主界面写的一个触发关闭悬浮的方法
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gu();//关闭悬浮窗口
            }
        });
        contentPane.add(btnNewButton_1, BorderLayout.SOUTH);
    }

    //4.写一个不显示组件的窗口方法。下面所有组件都是你要显示在悬浮窗口上的组件
    public void cc() {
        panel = new JPanel();//创建一个面板 全局变量，然后在开始的方法里调用 并显示这个窗口，
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.red);
    }

    //2.写一个触发的方法
    public void showPanel(Component owner) {//触发的方法。参数是你要让那个组件作为你的父级窗口 触发悬浮
        if (pop != null)
            pop.hide();
        //下面的组件，就是你要触发显示的那个组件
        Point show = new Point(0, btnNewButton.getHeight());//接受二个int参数让他显示在父级窗口哪个位置，
        //第一个参数是x轴，0是在父级窗口对应的0，第二个是y轴，默认获取的是你要设置哪个组件的高度，并显示在他下方。
        SwingUtilities.convertPointToScreen(show, btnNewButton);//显示在哪个组件的下方。

        pop = PopupFactory.getSharedInstance().getPopup(owner, panel, show.x, show.y);//x和y都是int类型，以你定好的窗口位置，xy轴移动
        //这个上面的panel 就是你要显示的悬浮窗口
        pop.show();//悬浮开始的方法
    }

    //3.写一个关闭的方法
    public void gu() {

        pop.hide();//悬浮关闭的方法


    }

}

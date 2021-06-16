package NewSciense;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FrmDuiHuaKuang extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmDuiHuaKuang frame = new FrmDuiHuaKuang();
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
    public FrmDuiHuaKuang() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 560, 362);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);

        textField = new JTextField();
        String aa = textField.getText().toString();

//		static void showMessageDialog(Component parentComponent, 
//                Object message, 
//                String title, 
//                int messageType, 
//                Icon icon)
//		jf,
//        "Hello Information Message",
//        "消息标题",
//        JOptionPane.INFORMATION_MESSAGE
//————————————————
//版权声明：本文为CSDN博主「xietansheng」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/xietansheng/java/article/details/75948933
//			————————————————

        panel_3.add(textField);
        textField.setColumns(10);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);

        textField_1 = new JTextField();
        panel_4.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        //错误JOptionPane.ERROR_MESSAGE
        //JOptionPane.WARNING_MESSAGE 警告消息
        //JOptionPane.INFORMATION_MESSAGE 信息消息（默认）
        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (aa.length() < 3) {
                    JOptionPane.showMessageDialog(null,
                            "Hello Information Message",
                            "温馨提示",
                            JOptionPane.ERROR_MESSAGE,
                            null);
                }
            }
        });
        panel_2.add(btnNewButton);
    }

}

package NewSciense;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 树状图
 *
 * @author lenovo
 */
public class SwingJTree extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingJTree frame = new SwingJTree();
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
    public SwingJTree() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 824, 606);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);

        JTree tree = new JTree();
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("所有类别") {
                    {
                        DefaultMutableTreeNode node_1;
                        node_1 = new DefaultMutableTreeNode("食品类");
                        node_1.add(new DefaultMutableTreeNode("辣条"));
                        node_1.add(new DefaultMutableTreeNode("水"));
                        add(node_1);
                        node_1 = new DefaultMutableTreeNode("生活用品类");
                        node_1.add(new DefaultMutableTreeNode("牙膏"));
                        node_1.add(new DefaultMutableTreeNode("牙刷"));
                        add(node_1);
                    }
                }
        ));
        panel.add(tree);
    }

}

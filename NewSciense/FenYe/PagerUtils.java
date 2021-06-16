package NewSciense.FenYe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 显示分页的JPanel。整合了分页的样式和部分事件
 * 使用的时候可以和new Jpanel()一样
 *
 * @author SMILE
 */
public class PagerUtils extends JPanel {
    private Integer pageTotal = 0;//总条数
    private Integer pageSize = 10;//每页显示的条数
    private Integer pageCount = 0;//总页数
    private Integer pageNo = 1;//当前页码
    private JTextField txt_pageNo;
    private JButton btnPrev;
    private JButton btnNext;

    PagerFrame frame;
    private JLabel lblPageTotal;
    private JLabel lblpageCount;

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
        refresh();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 刷新控件的部分按钮状态
     */
    public void refresh() {
        txt_pageNo.setEditable(false);
        txt_pageNo.setFont(new Font("宋体", Font.BOLD, 15));
        txt_pageNo.setText(this.pageNo + "");
        if (pageNo == 1) {
            btnPrev.setEnabled(false);
        } else
            btnPrev.setEnabled(true);

        if (pageNo == pageCount) {
            btnNext.setEnabled(false);
        } else
            btnNext.setEnabled(true);

        pageCount = getPageCount();
        lblPageTotal.setText(pageTotal + "");
        lblpageCount.setText(pageCount + "");
    }

    /**
     * 带参构造方法
     *
     * @param total 总数量
     * @param size  分页的数量
     * @param frm   调用分页组件的窗体对象。必须继承PagerFrame对象才行
     */
    public PagerUtils(int size, PagerFrame frm) {
        this.frame = frm;
        this.pageSize = size;
        pageCount = getPageCount();


        JPanel pmain = this;
        pmain.setLayout(new BoxLayout(pmain, BoxLayout.X_AXIS));
        pmain.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 2));
        pmain.add(Box.createHorizontalStrut(20));
        pmain.add(new JLabel("共 "));
        lblPageTotal = new JLabel(pageTotal + "");
        lblPageTotal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        pmain.add(lblPageTotal);
        pmain.add(new JLabel(" 条记录，每页 "));
        JLabel lblpageSize = new JLabel(pageSize + "");
        pmain.add(lblpageSize);
        pmain.add(new JLabel(" 条，共 "));
        lblpageCount = new JLabel(pageCount + "");
        pmain.add(lblpageCount);
        pmain.add(new JLabel(" 页"));
        pmain.add(Box.createGlue());

        btnPrev = new JButton("上一页");
        btnPrev.setFont(new Font("宋体", Font.BOLD, 15));
        btnPrev.setFocusPainted(false);
        btnPrev.setBackground(new Color(255, 250, 250));
        btnPrev.setActionCommand("0");
        btnNext = new JButton("下一页");
        btnNext.setFont(new Font("宋体", Font.BOLD, 15));
        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(255, 250, 250));
        btnNext.setActionCommand("1");

        ButtonClick btnEvent = new ButtonClick();
        btnNext.addActionListener(btnEvent);
        btnPrev.addActionListener(btnEvent);

        txt_pageNo = new JTextField(pageNo + "");
        txt_pageNo.setHorizontalAlignment(JTextField.CENTER);
        txt_pageNo.setOpaque(false);
        txt_pageNo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        txt_pageNo.setPreferredSize(new Dimension(30, 30));
        //解决盒式布局中，文本框大小的问题。只要让setMaximumSize的尺寸
        //大于setPreferredSize尺寸，文本框的尺寸就按照PreferredSize设置的大小来
        txt_pageNo.setMaximumSize(new Dimension(31, 31));


        txt_pageNo.addKeyListener(new TextChange());
        pmain.add(btnPrev);
        pmain.add(Box.createHorizontalStrut(8));
        pmain.add(txt_pageNo);
        pmain.add(Box.createHorizontalStrut(8));
        pmain.add(btnNext);

        pmain.add(Box.createHorizontalStrut(20));
        SetFonts();
        refresh();
    }

    public void SetFonts() {
        Font font = new Font("微软雅黑", Font.BOLD, 15);
        Component[] arr = PagerUtils.this.getComponents();
        for (Component com : arr) {
            if (com instanceof JLabel) {
                JLabel lbl = (JLabel) com;
                lbl.setFont(font);
            }
        }
    }

    public Integer getPageCount() {
        if (pageTotal % pageSize == 0) {
            return pageTotal / pageSize;
        } else {
            return pageTotal / pageSize + 1;
        }
    }

    /**
     * 文本框回车事件监听器
     *
     * @author SMILE
     */
    class TextChange extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String txt = txt_pageNo.getText();
                if (!MyUtil.isNumber(txt)) {
                    JOptionPane.showMessageDialog(frame, "请输入正确的页码");
                    txt_pageNo.setText(pageNo + "");
                    return;
                }
                int no = Integer.parseInt(txt);
                if (no < 1 || no > pageCount) {
                    JOptionPane.showMessageDialog(frame, "请输入1-" + pageCount + "之间的数字");
                    txt_pageNo.setText(pageNo + "");
                    return;
                }
                pageNo = no;

                try {
                    frame.showPager(PagerUtils.this);
                } catch (Exception e2) {
                    System.out.println("错误信息" + e2.getMessage() + "。分页控件调用showPager方法报错");
                }
            }
        }
    }

    /**
     * 按钮点击事件监听器
     *
     * @author SMILE
     */
    class ButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            if (obj instanceof JButton) {
                JButton btn = (JButton) obj;
                //将按钮的命令参数转成数字类型，以此作为判断是不同按钮点击的效果
                int i = Integer.parseInt(btn.getActionCommand());
                if (i == 0) {
                    //上一页按钮
                    if (pageNo == 1) {
                        return;
                    }
                    pageNo -= 1;
                } else if (i == 1) {
                    //下一页按钮
                    if (pageNo == pageCount)
                        return;
                    pageNo += 1;
                }
                try {
                    frame.showPager(PagerUtils.this);
                    refresh();
                } catch (Exception e2) {
                    System.out.println("错误信息" + e2.getMessage() + "。上一页下一页；分页控件调用showPager方法报错");
                }
            }
        }

    }

}

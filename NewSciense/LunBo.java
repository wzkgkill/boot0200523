package NewSciense;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SwingLayout.FrmDAO;

public class LunBo extends JFrame {
    MyJpanel mp;
    int index;
    ImageIcon[] imgs = {
            new ImageIcon("src/images/枫叶.jpg"),
            new ImageIcon("src/images/云.jpg"),
            new ImageIcon("src/images/qq1.jpg"),
            new ImageIcon("src/images/u=2670394782,1800253317&fm=26&gp=0.jpg"),
            new ImageIcon("src/images/u=3536000110,472923256&fm=15&gp=0_jpg.png"),
    };

    public static void main(String[] args) {
        new LunBo();

    }

    //	@Override
//	public void diyStyle() {
//		
//		
//	}
    public LunBo() {
        mp = new MyJpanel();
        this.add(mp);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("窗口");
        this.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mp.repaint();
                System.out.println("88888888888888");
            }
        });
        timer.start();

    }

    class MyJpanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(imgs[index % imgs.length].getImage(), 0, 0, this);
            index++;
        }
    }
}

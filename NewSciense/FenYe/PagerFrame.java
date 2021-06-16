package NewSciense.FenYe;

import javax.swing.JFrame;

/**
 * 分页特殊父类窗体
 *
 * @author SMILEss
 */
public abstract class PagerFrame extends JFrame {
    /**
     * 必须重写该方法，分页控件才能自动完成数据加载
     *
     * @param pager
     */
    public abstract void showPager(PagerUtils pager);
}

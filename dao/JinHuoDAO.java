package dao;

import entity.JinHuo;
import util.BaseDao;

public class JinHuoDAO extends BaseDao {
    public Integer insert(JinHuo jh) {
        String sql = "insert into JinHuo values(?,?,?,?,?,?,?,?,?)";
        return super.update(sql, jh.getRorder(),
                jh.getRsid(),
                jh.getRname(),
                jh.getRspec(),
                jh.getRprice(),
                jh.getWaudit(),
                jh.getRnum(),
                jh.getMmoney(),
                jh.getDanqian());
    }
}

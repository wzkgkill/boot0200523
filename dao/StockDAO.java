package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.RepertoryDAO.RepertoryMapper;
import entity.Repertory;
import entity.Stock;
import util.BaseDao;
import util.RowMapper;

/**
 * 采购进货(详情表)
 *
 * @author lenovo
 */
public class StockDAO extends BaseDao {
    /**
     * 采购详情记录新增
     *
     * @param xq
     * @return 返回受影响的行数
     */
    public Integer doInsert(Stock xq) {
        String sql = "insert into stock values(null,?,?,?,?)";
        return super.update(sql, xq.getSorder(), xq.getSsid(), xq.getSprice(), xq.getSordersize());
    }

    //查询所有
    public List<Stock> selectAll() {
        String sql = "select * from stock order by sorder desc";
        return super.query(sql, new StorageMapper());
    }

    /**
     * 根据单号查找该单号一条信息
     *
     * @param worder
     * @return
     */
    public List<Stock> selectByWorder(String worder) {
        String sql = "select s.*,r.rname,r.runit from stock s inner join repertory r on s.ssid=r.rsid where s.sorder=? order by s.sid desc";
        return super.query(sql, new StorageRepertoryMapper(), worder);
    }
//	//查询所有
//			public List<Repertory> selectByWord(String keyword){
//				String sql="select * from repertory where rsid like ? or rname like ? order by rsid desc";
//				return super.query(sql, new RepertoryMapper(),"%"+keyword+"%","%"+keyword+"%");
//			}
    //public List<Stock>  selectByWord1(Stirng worder)

    /**
     * 单表查询的行映射实体类
     *
     * @author lenovo
     */
    class StorageMapper implements RowMapper<Stock> {

        @Override
        public Stock rowmap(ResultSet rs) throws SQLException {
            Stock list = new Stock(rs.getInt("sid"),
                    rs.getString("sorder"),
                    rs.getString("ssid"),
                    rs.getBigDecimal("sprice"),
                    rs.getInt("sordersize"));
            return list;
        }

    }

    /**
     * 两表联合查询的行映射实现类
     *
     * @author lenovo
     */
    class StorageRepertoryMapper implements RowMapper<Stock> {
        @Override
        public Stock rowmap(ResultSet rs) throws SQLException {
            Stock list = new Stock(
                    rs.getInt("sid"),
                    rs.getString("sorder"),
                    rs.getString("ssid"),
                    rs.getBigDecimal("sprice"),
                    rs.getInt("sordersize"));
            list.setName(rs.getString("rname"));
            list.setUnit(rs.getString("runit"));
            return list;

        }

    }
}

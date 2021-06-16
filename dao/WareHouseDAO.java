package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.RepertoryDAO.RepertoryMapper;
import entity.Repertory;
import entity.WareHouse;
import util.BaseDao;
import util.RowMapper;

public class WareHouseDAO extends BaseDao {
    /**
     * 采购记录新增
     *
     * @param wa
     * @return 返回新增的主键编号
     */
    public Integer doInsert(WareHouse wa) {
        String sql = "insert into wareHouse values(?,?,?,?,?,?)";
        return super.update(sql, wa.getWorder(),
                wa.getWorderdata(),
                wa.getWsource(),
                wa.getWypay(),
                wa.getWspaid(),
                wa.getWauditor());
    }

    /**
     * 采购单的查询结果
     * //	"单据号", "开单日期", "供货商名称", "应付金额", "实付金额","操作员"
     *
     * @return
     */
    public List<WareHouse> selectAll() {
        String sql = "select * from warehouse order by worderdata desc";
        return super.query(sql, new WareHouseMapper());
    }

    public List<WareHouse> selectByWord(String worder, Date start, Date down, String wsource) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String sql = "select * from warehouse where 1=1";
        if (worder != null && worder.length() > 0) {
            sb.append(" and worder like ?");
            list.add("%" + worder + "%");
        }
        if (wsource != null && wsource.length() > 0) {
            sb.append(" and wsource like ?");
            list.add("%" + wsource + "%");
        }
        if (start != null && down == null) {
            sb.append(" and worderdata>=?");
            list.add(start);
        } else if (start == null && down != null) {
            sb.append(" and worderdata<=?");
            list.add(down);
        } else if (start != null && down != null) {
            sb.append(" and (worderdata>=? and worderdata<=?)");
            list.add(start);
            list.add(down);
        }
        //list有序集合存储的是该SQL语句需要的参数信息
        Object[] arr = list.toArray();
        List<WareHouse> myresult = super.query(sql + sb.toString(), new WareHouseMapper(), arr);
        return myresult;
    }

    class WareHouseMapper implements RowMapper<WareHouse> {
        @Override
        public WareHouse rowmap(ResultSet rs) throws SQLException {
            return new WareHouse(rs.getString("worder"),
                    rs.getDate("worderdata"),
                    rs.getString("wsource"),
                    rs.getBigDecimal("wypay"),
                    rs.getBigDecimal("wspaid"),
                    rs.getString("wauditor"));
        }

    }
}

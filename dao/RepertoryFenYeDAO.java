package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Repertory;
import util.BaseDao;
import util.RowMapper;
import NewSciense.FenYe.PagerUtils;

public class RepertoryFenYeDAO extends BaseDao {
    //查询所有
    public List<Repertory> selectAll() {
        String sql = "select * from repertory order by rsid desc";
        return super.query(sql, new RepertoryMapper());
    }

    //查询所有
    public List<Repertory> selectByWord(String keyword) {
        String sql = "select * from repertory where rsid like ? or rname like ? order by rsid desc";
        return super.query(sql, new RepertoryMapper(), "%" + keyword + "%", "%" + keyword + "%");
    }

    //多条件组合查询的分页
    public List<Repertory> selectByPager(PagerUtils pager, String rsid, String rname, Integer min, Integer max) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String sql = "select * from repertory where 1=1";
        String sqlTotal = "select count(*) from repertory where 1=1";
        if (rsid != null) {
            sb.append(" and rsid like ?");
            list.add("%" + rsid + "%");
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            list.add("%" + rname + "%");
        }
        if (min != null && max == null) {
            sb.append(" and rprice>=?");
            list.add(min);
        } else if (min == null && max != null) {
            sb.append(" and rprice<=?");
            list.add(max);
        } else if (min != null && max != null) {
            sb.append(" and (rprice>=? and rprice<=?)");
            list.add(min);
            list.add(max);
        }

        //查询总记录数
        Integer total = super.query(sqlTotal + sb, new IntegerMapper(), list.toArray()).get(0);
        //赋值给分页控件
        pager.setPageTotal(total);
        System.out.println("总记录数：" + total);

        //结合分页,查询结果
        sb.append(" order by rsid desc limit ?,?");
        list.add((pager.getPageNo() - 1) * pager.getPageSize());
        list.add(pager.getPageSize());

        //list有序集合存储的是该SQL语句需要的参数信息
        Object[] arr = list.toArray();
        List<Repertory> myresult = super.query(sql + sb.toString(), new RepertoryMapper(), arr);
        System.out.println("当前页的数量：" + myresult.size());
        return myresult;
    }

    public int doCreate(Repertory re) {
        String sql = "insert into repertory values(?,?,?,?,?,?,?,?,?,?,?,?)";
        return super.update(sql, re.getRsid(),
                re.getRname(),
                re.getRtype(),
                re.getRspec(),
                re.getRprice(),
                re.getRmprice(),
                re.getRcap(),
                re.getRfloor(),
                re.getRinventory(),
                re.getRunit(),
                re.getRadress(),
                re.getRcolor());

    }

    /**
     * 根据商品编号更新库存数量
     *
     * @param re
     * @return返回受影响的行数
     */
    public Integer doUpdateKuCun(Repertory re) {
        //Rinventory库存
        String sql = "update repertory set rinventory=rinventory+? where rsid=?";
        return super.update(sql, re.getRinventory(), re.getRsid());
    }

    class IntegerMapper implements RowMapper<Integer> {
        @Override
        public Integer rowmap(ResultSet rs) throws SQLException {
            return rs.getInt(1);
        }
    }

    class RepertoryMapper implements RowMapper<Repertory> {

        @Override
        public Repertory rowmap(ResultSet rs) throws SQLException {
            return new Repertory(
                    rs.getString("rsid"),
                    rs.getString("rname"),
                    rs.getString("rtype"),
                    rs.getString("rspec"),
                    rs.getBigDecimal("rprice"),
                    rs.getBigDecimal("rmprice"),
                    rs.getInt("rcap"),
                    rs.getInt("rfloor"),
                    rs.getInt("rinventory"),
                    rs.getString("runit"),
                    rs.getString("radress"),
                    rs.getString("rcolor")
            );
        }

    }
}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.warehousesDAO.warehousesMapper;
import entity.Repertory;
import entity.commodity;
import entity.warehouses;
import util.RowMapper;

public class RepertoryDAO extends BaseDao {

    // 商品查询所有
    public List<Repertory> select2() {
        String sql = "select rsid,rname,runit,rtype,rcolor,rprice,rmprice from repertory order by rsid desc";
        return super.query(sql, new RepertoryMapper());
    }

    // 商品模糊查询
    public List<Repertory> selectByAll2(String keyword) {
        String sql = "select * from repertory where rsid like ? or rname like ? or rtype like? order by rsid desc";
        return super.query(sql, new RepertoryMapper(), "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    public int setr(Repertory a) {
        String sql = "INSERT INTO Repertory VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        Object[] param = {
                a.getRsid(), a.getRname(), a.getRtype(), a.getRspec(), a.getRprice(),
                a.getRmprice(), a.getRcap(), a.getRfloor(), a.getRinventory(), a.getRunit(), a.getRadress(),
                a.getRcolor()
        };
        return super.update(sql, param);
    }

    public boolean Update(Repertory a) {
        String sql = "INSERT INTO Repertory VALUES(?,?,?,?,?,?,?,?,?,?,?,?,);";
        Object[] param = {
                a.getRsid(), a.getRname(), a.getRtype(), a.getRspec(), a.getRprice(),
                a.getRmprice(), a.getRcap(), a.getRfloor(), a.getRinventory(), a.getRunit(), a.getRadress(),
                a.getRcolor()
        };
        return super.update(sql, param) > 0 ? true : false;

    }

    public boolean doUpdate(Repertory stu) {
        String sql = "UPDATE Repertory SET  rname= ? , runit= ? , rcolor= ? ,rtype= ? ,rprice= ? ,rmprice= ? WHERE rsid= ? ;";
        commodityDAO dao = new commodityDAO();
        int i = dao.update(sql, stu.getRname(), stu.getRunit(),
                stu.getRcolor(), stu.getRtype(), stu.getRprice(),
                stu.getRmprice(), stu.getRsid());
        System.out.println(i);
        return i > 0 ? true : false;
    }

    // 仓库查询所有
    public List<Repertory> select() {
        String sql = "select rsid,rname,runit,rinventory,rtype,rprice,rmprice from repertory order by rsid desc";
        return super.query(sql, new RepertoryMapper());
    }

    // 仓库模糊查询
    public List<Repertory> selectByAll(String keyword) {
        String sql = "select * from repertory where rsid like ? or rname like ? or rtype like? order by rsid desc";
        return super.query(sql, new RepertoryMapper(), "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    // 查询所有
    public List<Repertory> selectAll() {
        String sql = "select * from repertory order by rsid desc";
        return super.query(sql, new RepertoryMapper());
    }

    // 查询所有
    public List<Repertory> selectByWord(String keyword) {
        String sql = "select * from repertory where rsid like ? or rname like ? order by rsid desc";
        return super.query(sql, new RepertoryMapper(), "%" + keyword + "%", "%" + keyword + "%");
    }

    public List<Repertory> selectByWord(String rsid, String rname, Integer min, Integer max) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String sql = "select * from repertory where 1=1";
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
        // list有序集合存储的是该SQL语句需要的参数信息
        Object[] arr = list.toArray();
        List<Repertory> myresult = super.query(sql + sb.toString(), new RepertoryMapper(), arr);
        return myresult;
    }

    public int doCreate(Repertory re) {
        String sql = "insert into repertory values(?,?,?,?,?,?,?,?,?,?,?,?)";
        return super.update(sql, re.getRsid(), re.getRname(), re.getRtype(), re.getRspec(), re.getRprice(),
                re.getRmprice(), re.getRcap(), re.getRfloor(), re.getRinventory(), re.getRunit(), re.getRadress(),
                re.getRcolor());

    }

    /**
     * 根据商品编号更新库存数量
     *
     * @param re
     * @return返回受影响的行数
     */
    public Integer doUpdateKuCun(Repertory re) {
        // Rinventory库存
        String sql = "update repertory set rinventory=rinventory+? where rsid=?";
        return super.update(sql, re.getRinventory(), re.getRsid());
    }

    class RepertoryMapper implements RowMapper<Repertory> {

        @Override
        public Repertory rowmap(ResultSet rs) throws SQLException {
            return new Repertory(rs.getString("rsid"), rs.getString("rname"), rs.getString("rtype"),
                    rs.getString("rspec"), rs.getBigDecimal("rprice"), rs.getBigDecimal("rmprice"), rs.getInt("rcap"),
                    rs.getInt("rfloor"), rs.getInt("rinventory"), rs.getString("runit"), rs.getString("radress"),
                    rs.getString("rcolor"));
        }

    }
}

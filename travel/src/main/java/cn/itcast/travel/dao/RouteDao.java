package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-03
 * Time: 16:57
 */
public interface RouteDao {
    public int findTotalCount(int cid);
    public List<Route> findByPage(int cid,int start,int pageSize);
}

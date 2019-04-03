package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-03
 * Time: 17:05
 */
public interface RouteService {
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize);
}

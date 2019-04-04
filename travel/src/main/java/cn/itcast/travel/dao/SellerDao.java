package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-04
 * Time: 14:19
 */
public interface SellerDao {
    public Seller findById(int sid);
}

package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-04
 * Time: 16:46
 */
public interface FavoriteDao {
    public Favorite findByRidAndUid(int rid,int uid);

    int findCountByRid(int rid);

    void add(int i, int uid);
}

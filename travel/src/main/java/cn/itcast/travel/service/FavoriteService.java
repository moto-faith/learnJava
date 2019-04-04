package cn.itcast.travel.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-04
 * Time: 16:44
 */
public interface FavoriteService {
    public boolean isFavorite(String rid,int uid);
    void add(String rid, int uid);
}

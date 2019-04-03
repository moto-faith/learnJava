package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-03
 * Time: 14:58
 */
public interface CategoryDao {
    public List<Category> findAll();
}

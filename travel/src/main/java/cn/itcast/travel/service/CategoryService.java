package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-03
 * Time: 15:02
 */
public interface CategoryService {
    public List<Category> findAll();
}

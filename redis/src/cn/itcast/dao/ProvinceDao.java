package cn.itcast.dao;

import cn.itcast.domain.Province;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-28
 * Time: 18:22
 */
public interface ProvinceDao {
    public List<Province> findAll();
}

package cn.itcast.service;

import cn.itcast.domain.Province;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-28
 * Time: 18:23
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}

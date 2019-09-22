package com.myproject.ssm.dao;

import com.myproject.ssm.pojo.City;
import com.myproject.ssm.pojo.County;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;


public interface CityDao {

    public List<City> findAll();

    public City findById(String id);

    public City findCountyById(String id);

    public City findByIdAndName(String id, String name);

    public List<City> findBySearch(Map map);

    public void save(City city);

    public void update(City city);

    @Select("select * from tb_city")
    public List<City> FindCityAll();


    @Select("select * from tb_city where id = #{id}")
    @Results(value = {
            @Result(column = "id" , property = "id" ,id = true),
            @Result(column = "name" , property = "name"),
            @Result(column = "ishot" , property = "ishot"),
            @Result(column = "id" , property = "countyList",
                    many = @Many(select = "com.myproject.ssm.dao.CityDao.findCountyByCityId",fetchType= FetchType.LAZY))
    })
    public City findCityById(String id);

    @Select("select * from tb_county where city_id = #{city_id}")
    public List<County> findCountyByCityId(String city_id);

    @Insert("insert into tb_city(id,name,ishot) values(#{id},#{name},#{ishot})")
    public void InsertCity(City city) throws Exception;

    @Update("update tb_city set name = #{name},ishot = #{ishot} where id = #{id}")
    public void UpdateCity(City city) throws Exception;



}

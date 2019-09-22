package com.myproject.ssm.service;

import com.myproject.ssm.dao.CityDao;
import com.myproject.ssm.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> findAll(){

        return cityDao.findAll();
    }

    public City findById(String id) {
       return  cityDao.findById(id);
    }

    public City findCountyById(String id) {
        City city = cityDao.findCountyById(id);
        System.out.println(city.toString());
        return cityDao.findCountyById(id);
    }

    public City findByIdAndName(String id,String name){
        return cityDao.findByIdAndName(id,name);
    }

    public List<City> findBySearch(Map map){
        return cityDao.findBySearch(map);
    }

    public void save(City city){
        cityDao.save(city);
    }


    public void update(City city){
        cityDao.update(city);
    }

    public List<City> FindCtiyAll(){
        return cityDao.FindCityAll();
    }


    public void InsertCity(City city) throws Exception{
        if(city.getId() == null){
            throw  new Exception();
        }
        cityDao.InsertCity(city);
    }

    public void UpdateCity(City city) throws Exception{
        if(city.getId() == null){
            throw  new Exception();
        }
        cityDao.UpdateCity(city);
    }

    public City findCityById(String id){
        return cityDao.findCityById(id);
    }

}

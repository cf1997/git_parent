package com.myproject.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.ssm.pojo.City;
import com.myproject.ssm.service.CityService;
import com.myproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET)
    public String findAll() throws JsonProcessingException {

        List<City> list = null;
        try {
            list = cityService.findAll();
            for (City city : list) {
                System.out.println(city.getId()+city.getName()+city.getIshot());

            }
        } catch (Exception e) {
            e.printStackTrace();
          return  mapper.writeValueAsString(new Result(false,500,e.getMessage()));
        }
        return mapper.writeValueAsString(new Result(true,200,"查询成功",list));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String result(@PathVariable(value = "id") String id){

        String value = null;
        try {
            City city = cityService.findById(id);
            value = mapper.writeValueAsString(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    @RequestMapping(value = "/county/{id}",method = RequestMethod.GET)
    public String findCountyById(@PathVariable(value = "id") String id){

        String value = null;
        try {
           City city=  cityService.findCountyById(id);
            value = mapper.writeValueAsString(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String findByIdAndName(@RequestBody City city){

        String value = null;
        try {
            City Rcity=  cityService.findByIdAndName(city.getId(),city.getName());
            value = mapper.writeValueAsString(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String findBySearch(@RequestBody Map map){

        String value = null;
        try {
            List<City> list =  cityService.findBySearch(map);
            value = mapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody City city)  {

        String value = null;
        try {
            cityService.save(city);
            value = mapper.writeValueAsString(new Result(true,200,"增加成功"));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                value = mapper.writeValueAsString(new Result(false,500,"增加失败"));
                return value;
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        }
        return value;
    }


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<City> printJson(){

        List<City> list = new ArrayList<City>();
        City city = new City("1","湖南","1");
        list.add(city);
        list.add(new City("2","广东","1"));
        list.add(new City("3","湖北","1"));
        return list;
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public Result update(@RequestBody City city){
        try {
            cityService.update(city);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,500,"修改失败");
        }
        return new Result(true,200,"修改成功");
    }

    @RequestMapping(value = "/findCityAll",method = RequestMethod.GET)
    public List<City> FindCtiyAll(){
        return cityService.FindCtiyAll();
    }

    @RequestMapping(value = "/insertCity",method = RequestMethod.POST)
    public Result InsertCity(@RequestBody  City city){
        try {
            cityService.InsertCity(city);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,500,"添加失败");
        }

        return new Result(true,200,"添加成功");
    }


    @RequestMapping(value = "/updateCity",method = RequestMethod.POST)
    public Result UpdateCity(@RequestBody  City city){
        try {
            cityService.UpdateCity(city);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,500,"修改失败");
        }

        return new Result(true,200,"修改成功");
    }

    @RequestMapping(value = "/findCityById/{id}",method = RequestMethod.GET)
    public Result findCityById(@PathVariable String id){
        City city = null;
        try {
            city = cityService.findCityById(id);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,500,"查询失败");
        }

        return new Result(true,200,"查询成功",city);
    }

}

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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CityService cityService;


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

package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.example.Pojo.Page;
import com.example.controller.util.DataResponses;
import com.example.service.impl.IPagesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PageController {

    @Autowired
    private IPagesServiceImpl PagesService;

    @GetMapping
    public DataResponses getAll() {
        return new DataResponses(true, PagesService.list());
    }

    @PostMapping
    public DataResponses write(@RequestBody Page pages) {
        return new DataResponses(PagesService.save(pages));
    }

    @PutMapping
    public DataResponses update(@RequestBody Page pages) {
        return new DataResponses(PagesService.updateById(pages));
    }

    @DeleteMapping("{id}")
    public DataResponses delete(@PathVariable int id) {
        return new DataResponses(PagesService.removeById(id));
    }

    //按值查找
    @GetMapping("{username}")
    public DataResponses selectByName(@PathVariable String username) {
        LambdaQueryWrapper<Page>  pageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        pageLambdaQueryWrapper.eq(Page::getUsername,username);
        return new DataResponses(true, PagesService.list(pageLambdaQueryWrapper));
    }

    //模糊查询
    @GetMapping("/{column}/{condition}")
    public DataResponses getAll2(@PathVariable String column,@PathVariable String condition){

        String st = condition;
        SFunction<Page, String> getPage = null;
        if(column.equals("1")){
            getPage = Page::getUsername;
        }else if (column.equals("2")){
            getPage = Page::getTitle;
        }else {
            getPage = Page::getDate;
        }
        LambdaQueryWrapper<Page>  pageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        pageLambdaQueryWrapper.like(st != null,getPage,st);
        List<Page> list = PagesService.list(pageLambdaQueryWrapper);

        return new DataResponses(true,list);
    }

    //分页
    @GetMapping("/4/{page}")
    public DataResponses getByCount(@PathVariable int page){
        IPage<Page> page1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page(page,15);
        return new DataResponses(true,PagesService.page(page1,null).getRecords());
    }
}

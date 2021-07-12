package cn.ch06.hoteventtest.controller;

import cn.ch06.hoteventtest.entity.Hotevents;
import cn.ch06.hoteventtest.service.HoteventsService;
import cn.ch06.hoteventtest.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hotevents")
public class HoteventsController {
    @Autowired
    private HoteventsService hoteventsService;
    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> list(@RequestParam(required = false) String keyWord, @RequestParam(defaultValue = "1") Integer pageIndex){
        Map<String,Object> result=new HashMap<>();

        PageSupport page=new PageSupport();
        page.setCurrentPageNo(pageIndex);
        page.setPageSize(3);
        Integer count = hoteventsService.getCount(keyWord);
        page.setTotalCount(count);
        int totalPageCount = page.getTotalPageCount();

        List<Hotevents> hoteventsList = hoteventsService.getList(keyWord, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        result.put("hoteventsList",hoteventsList);
        result.put("page",page);
        result.put("keyWord",keyWord);
        return result;
    }
}

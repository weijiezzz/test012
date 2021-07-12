package cn.ch06.hoteventtest.service;

import cn.ch06.hoteventtest.entity.Hotevents;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoteventsService {
    public List<Hotevents> getList(String keyWord,Integer pageIndex,Integer pageSize);
    public Integer getCount(String keyWord);
}

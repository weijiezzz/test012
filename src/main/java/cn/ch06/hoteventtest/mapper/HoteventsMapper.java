package cn.ch06.hoteventtest.mapper;

import cn.ch06.hoteventtest.entity.Hotevents;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoteventsMapper {
    public List<Hotevents> getList(@Param("keyword")String keyWord,@Param("pageIndex")Integer pageIndex,@Param("pageSize") Integer pageSize);
    public Integer getCount(String keyWord);
}

package cn.ch06.hoteventtest.service;

import cn.ch06.hoteventtest.entity.Hotevents;
import cn.ch06.hoteventtest.mapper.HoteventsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoteventsServiceImpl implements HoteventsService {
    @Autowired
    private HoteventsMapper hoteventsMapper;
    @Override
    public List<Hotevents> getList(String keyWord, Integer pageIndex, Integer pageSize) {
        return hoteventsMapper.getList(keyWord, pageIndex, pageSize);
    }

    @Override
    public Integer getCount(String keyWord) {
        return hoteventsMapper.getCount(keyWord);
    }
}

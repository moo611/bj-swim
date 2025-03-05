package com.example.swim.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.swim.mapper.SwNotifyMapper;
import com.example.swim.domain.SwNotify;
import com.example.swim.service.ISwNotifyService;

/**
 * 通知Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-06
 */
@Service
public class SwNotifyServiceImpl implements ISwNotifyService
{
    @Autowired
    private SwNotifyMapper swNotifyMapper;

    /**
     * 查询通知
     *
     * @param id 通知主键
     * @return 通知
     */
    @Override
    public SwNotify selectSwNotifyById(Long id)
    {
        return swNotifyMapper.selectSwNotifyById(id);
    }

    /**
     * 查询通知列表
     *
     * @param swNotify 通知
     * @return 通知
     */
    @Override
    public List<SwNotify> selectSwNotifyList(SwNotify swNotify)
    {
        return swNotifyMapper.selectSwNotifyList(swNotify);
    }

    /**
     * 新增通知
     *
     * @param swNotify 通知
     * @return 结果
     */
    @Override
    public int insertSwNotify(SwNotify swNotify)
    {
        swNotify.setCreateTime(new Date());
        return swNotifyMapper.insertSwNotify(swNotify);
    }

    /**
     * 修改通知
     *
     * @param swNotify 通知
     * @return 结果
     */
    @Override
    public int updateSwNotify(SwNotify swNotify)
    {
        swNotify.setUpdateTime(new Date());
        return swNotifyMapper.updateSwNotify(swNotify);
    }

    /**
     * 批量删除通知
     *
     * @param ids 需要删除的通知主键
     * @return 结果
     */
    @Override
    public int deleteSwNotifyByIds(Long[] ids)
    {
        return swNotifyMapper.deleteSwNotifyByIds(ids);
    }

    /**
     * 删除通知信息
     *
     * @param id 通知主键
     * @return 结果
     */
    @Override
    public int deleteSwNotifyById(Long id)
    {
        return swNotifyMapper.deleteSwNotifyById(id);
    }
}

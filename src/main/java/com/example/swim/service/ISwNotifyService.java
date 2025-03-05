package com.example.swim.service;

import java.util.List;
import com.example.swim.domain.SwNotify;

/**
 * 通知Service接口
 *
 * @author ruoyi
 * @date 2024-11-06
 */
public interface ISwNotifyService
{
    /**
     * 查询通知
     *
     * @param id 通知主键
     * @return 通知
     */
    public SwNotify selectSwNotifyById(Long id);

    /**
     * 查询通知列表
     *
     * @param swNotify 通知
     * @return 通知集合
     */
    public List<SwNotify> selectSwNotifyList(SwNotify swNotify);

    /**
     * 新增通知
     *
     * @param swNotify 通知
     * @return 结果
     */
    public int insertSwNotify(SwNotify swNotify);

    /**
     * 修改通知
     *
     * @param swNotify 通知
     * @return 结果
     */
    public int updateSwNotify(SwNotify swNotify);

    /**
     * 批量删除通知
     *
     * @param ids 需要删除的通知主键集合
     * @return 结果
     */
    public int deleteSwNotifyByIds(Long[] ids);

    /**
     * 删除通知信息
     *
     * @param id 通知主键
     * @return 结果
     */
    public int deleteSwNotifyById(Long id);
}

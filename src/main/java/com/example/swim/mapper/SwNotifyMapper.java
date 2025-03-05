package com.example.swim.mapper;

import java.util.List;
import com.example.swim.domain.SwNotify;
import org.apache.ibatis.annotations.Mapper;

/**
 * 通知Mapper接口
 *
 * @author ruoyi
 * @date 2024-11-06
 */
@Mapper
public interface SwNotifyMapper
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
     * 删除通知
     *
     * @param id 通知主键
     * @return 结果
     */
    public int deleteSwNotifyById(Long id);

    /**
     * 批量删除通知
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwNotifyByIds(Long[] ids);
}

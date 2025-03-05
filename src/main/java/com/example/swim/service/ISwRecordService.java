package com.example.swim.service;

import java.util.List;
import com.example.swim.domain.SwRecord;

/**
 * 记录Service接口
 *
 * @author ruoyi
 * @date 2024-11-07
 */
public interface ISwRecordService
{
    /**
     * 查询记录
     *
     * @param id 记录主键
     * @return 记录
     */
    public SwRecord selectSwRecordById(Long id);

    /**
     * 查询记录列表
     *
     * @param swRecord 记录
     * @return 记录集合
     */
    public List<SwRecord> selectSwRecordList(SwRecord swRecord);

    /**
     * 新增记录
     *
     * @param swRecord 记录
     * @return 结果
     */
    public int insertSwRecord(SwRecord swRecord);

    /**
     * 修改记录
     *
     * @param swRecord 记录
     * @return 结果
     */
    public int updateSwRecord(SwRecord swRecord);

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的记录主键集合
     * @return 结果
     */
    public int deleteSwRecordByIds(Long[] ids);

    /**
     * 删除记录信息
     *
     * @param id 记录主键
     * @return 结果
     */
    public int deleteSwRecordById(Long id);
}

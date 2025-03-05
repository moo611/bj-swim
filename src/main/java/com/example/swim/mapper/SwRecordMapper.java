package com.example.swim.mapper;

import java.util.List;
import com.example.swim.domain.SwRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 记录Mapper接口
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Mapper
public interface SwRecordMapper
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

    SwRecord selectByDay(String day);

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
     * 删除记录
     *
     * @param id 记录主键
     * @return 结果
     */
    public int deleteSwRecordById(Long id);

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwRecordByIds(Long[] ids);
}

package com.example.swim.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.swim.mapper.SwRecordMapper;
import com.example.swim.domain.SwRecord;
import com.example.swim.service.ISwRecordService;

/**
 * 记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Service
public class SwRecordServiceImpl implements ISwRecordService
{
    @Autowired
    private SwRecordMapper swRecordMapper;

    /**
     * 查询记录
     *
     * @param id 记录主键
     * @return 记录
     */
    @Override
    public SwRecord selectSwRecordById(Long id)
    {
        return swRecordMapper.selectSwRecordById(id);
    }

    /**
     * 查询记录列表
     *
     * @param swRecord 记录
     * @return 记录
     */
    @Override
    public List<SwRecord> selectSwRecordList(SwRecord swRecord)
    {
        return swRecordMapper.selectSwRecordList(swRecord);
    }

    /**
     * 新增记录
     *
     * @param swRecord 记录
     * @return 结果
     */
    @Override
    public int insertSwRecord(SwRecord swRecord)
    {

        SwRecord old = swRecordMapper.selectByDay(swRecord.getDay());
        if (old!=null){

            old.setItems(swRecord.getItems());
            old.setUpdateTime(new Date());
            return swRecordMapper.updateSwRecord(old);
        }else{
            swRecord.setCreateTime(new Date());
            return swRecordMapper.insertSwRecord(swRecord);
        }

    }

    /**
     * 修改记录
     *
     * @param swRecord 记录
     * @return 结果
     */
    @Override
    public int updateSwRecord(SwRecord swRecord)
    {
        swRecord.setUpdateTime(new Date());
        return swRecordMapper.updateSwRecord(swRecord);
    }

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的记录主键
     * @return 结果
     */
    @Override
    public int deleteSwRecordByIds(Long[] ids)
    {
        return swRecordMapper.deleteSwRecordByIds(ids);
    }

    /**
     * 删除记录信息
     *
     * @param id 记录主键
     * @return 结果
     */
    @Override
    public int deleteSwRecordById(Long id)
    {
        return swRecordMapper.deleteSwRecordById(id);
    }
}

package com.example.swim.mapper;

import java.util.List;
import java.util.Map;

import com.example.swim.domain.SwUser;
import com.example.swim.domain.req.CountListReq;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人员Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Mapper
public interface SwUserMapper
{
    /**
     * 查询人员
     *
     * @param id 人员主键
     * @return 人员
     */
    public SwUser selectSwUserById(Long id);

    /**
     * 查询人员列表
     *
     * @param swUser 人员
     * @return 人员集合
     */
    public List<SwUser> selectSwUserList(SwUser swUser);

    /**
     * 新增人员
     *
     * @param swUser 人员
     * @return 结果
     */
    public int insertSwUser(SwUser swUser);

    /**
     * 修改人员
     *
     * @param swUser 人员
     * @return 结果
     */
    public int updateSwUser(SwUser swUser);

    /**
     * 删除人员
     *
     * @param id 人员主键
     * @return 结果
     */
    public int deleteSwUserById(Long id);

    /**
     * 批量删除人员
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwUserByIds(Long[] ids);

    int deleteByCardNoAndSex(Long cardNo, String sex);

    int count();

    SwUser getUser(String cardNo, String sex);

    SwUser selectSwUserByUsername(String username);

    List<Map<String, Integer>> getUserCount(CountListReq countListReq);

}

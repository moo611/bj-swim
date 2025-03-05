package com.example.swim.service;

import java.util.List;
import com.example.swim.domain.SwUser;

/**
 * 人员Service接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface ISwUserService
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
     * 批量删除人员
     *
     * @param ids 需要删除的人员主键集合
     * @return 结果
     */
    public int deleteSwUserByIds(Long[] ids);

    /**
     * 删除人员信息
     *
     * @param id 人员主键
     * @return 结果
     */
    public int deleteSwUserById(Long id);

    int deleteByCardNoAndSex(Long cardNo, String sex);

    int count();

    SwUser getUserInfo(String cardNo, String sex);
}

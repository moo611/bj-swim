package com.example.swim.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.swim.domain.SwAdmin;
import com.example.swim.domain.req.CountListReq;
import com.example.swim.mapper.SwAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.swim.mapper.SwUserMapper;
import com.example.swim.domain.SwUser;
import com.example.swim.service.ISwUserService;

/**
 * 人员Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class SwUserServiceImpl implements ISwUserService {
    @Autowired
    private SwUserMapper swUserMapper;
    @Autowired
    private SwAdminMapper swAdminMapper;
    /**
     * 查询人员
     *
     * @param id 人员主键
     * @return 人员
     */
    @Override
    public SwUser selectSwUserById(Long id) {
        return swUserMapper.selectSwUserById(id);
    }

    /**
     * 查询人员列表
     *
     * @param swUser 人员
     * @return 人员
     */
    @Override
    public List<SwUser> selectSwUserList(SwUser swUser) {
        return swUserMapper.selectSwUserList(swUser);
    }

    /**
     * 新增人员
     *
     * @param swUser 人员
     * @return 结果
     */
    @Override
    public int insertSwUser(SwUser swUser) {

        SwUser swUser1 = swUserMapper.selectSwUserByUsername(swUser.getUsername());
        if (swUser1!=null){

            return -32001;
        }

        SwAdmin swAdmin = swAdminMapper.selectSwAdminByUsername(swUser.getUsername());
        if (swAdmin == null){

            return -32002;
        }

        swUser.setCreateTime(new Date());
        return swUserMapper.insertSwUser(swUser);
    }

    /**
     * 修改人员
     *
     * @param swUser 人员
     * @return 结果
     */
    @Override
    public int updateSwUser(SwUser swUser) {
        swUser.setUpdateTime(new Date());
        return swUserMapper.updateSwUser(swUser);
    }

    /**
     * 批量删除人员
     *
     * @param ids 需要删除的人员主键
     * @return 结果
     */
    @Override
    public int deleteSwUserByIds(Long[] ids) {
        return swUserMapper.deleteSwUserByIds(ids);
    }

    /**
     * 删除人员信息
     *
     * @param id 人员主键
     * @return 结果
     */
    @Override
    public int deleteSwUserById(Long id) {
        return swUserMapper.deleteSwUserById(id);
    }

    @Override
    public int deleteByCardNoAndSex(Long cardNo, String sex) {
        return swUserMapper.deleteByCardNoAndSex(cardNo, sex);
    }

    @Override
    public int count() {
        return swUserMapper.count();
    }

    @Override
    public SwUser getUserInfo(String cardNo, String sex) {

        return swUserMapper.getUser(cardNo,sex);
    }

    @Override
    public List<Map<String, Integer>> getCount(CountListReq countListReq) {

        return swUserMapper.getUserCount(countListReq);

    }
}

package com.example.swim.service.impl;

import java.util.Date;
import java.util.List;

import com.example.swim.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.swim.mapper.SwAdminMapper;
import com.example.swim.domain.SwAdmin;
import com.example.swim.service.ISwAdminService;

/**
 * 管理员Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class SwAdminServiceImpl implements ISwAdminService
{
    @Autowired
    private SwAdminMapper swAdminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询管理员
     *
     * @param id 管理员主键
     * @return 管理员
     */
    @Override
    public SwAdmin selectSwAdminById(Long id)
    {
        return swAdminMapper.selectSwAdminById(id);
    }

    /**
     * 查询管理员列表
     *
     * @param swAdmin 管理员
     * @return 管理员
     */
    @Override
    public List<SwAdmin> selectSwAdminList(SwAdmin swAdmin)
    {
        return swAdminMapper.selectSwAdminList(swAdmin);
    }

    /**
     * 新增管理员
     *
     * @param swAdmin 管理员
     * @return 结果
     */
    @Override
    public int insertSwAdmin(SwAdmin swAdmin)
    {
        SwAdmin old = swAdminMapper.selectSwAdminByUsername(swAdmin.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(swAdmin.getPassword());
        swAdmin.setPassword(encodedPassword);
        swAdmin.setCreateTime(new Date());

        return swAdminMapper.insertSwAdmin(swAdmin);
    }

    /**
     * 修改管理员
     *
     * @param swAdmin 管理员
     * @return 结果
     */
    @Override
    public int updateSwAdmin(SwAdmin swAdmin)
    {
        SwAdmin old = swAdminMapper.selectSwAdminByUsername(swAdmin.getUsername());
        if (!old.getId().equals(swAdmin.getId())){
            return -32001;
        }
        if (swAdmin.getPassword()!=null && !swAdmin.getPassword().isEmpty()){
            String encodedPassword = passwordEncoder.encode(swAdmin.getPassword());
            swAdmin.setPassword(encodedPassword);
        }

        swAdmin.setUpdateTime(new Date());
        return swAdminMapper.updateSwAdmin(swAdmin);
    }

    /**
     * 批量删除管理员
     *
     * @param ids 需要删除的管理员主键
     * @return 结果
     */
    @Override
    public int deleteSwAdminByIds(Long[] ids)
    {
        return swAdminMapper.deleteSwAdminByIds(ids);
    }

    /**
     * 删除管理员信息
     *
     * @param id 管理员主键
     * @return 结果
     */
    @Override
    public int deleteSwAdminById(Long id)
    {
        return swAdminMapper.deleteSwAdminById(id);
    }

    @Override
    public SwAdmin selectSwAdminByUsername(String username) {




        return swAdminMapper.selectSwAdminByUsername(username);
    }
}

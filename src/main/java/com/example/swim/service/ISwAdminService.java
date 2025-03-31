package com.example.swim.service;

import java.util.List;
import com.example.swim.domain.SwAdmin;
import com.example.swim.domain.req.FaceAddReq;

/**
 * 管理员Service接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface ISwAdminService
{
    /**
     * 查询管理员
     *
     * @param id 管理员主键
     * @return 管理员
     */
    public SwAdmin selectSwAdminById(Long id);

    /**
     * 查询管理员列表
     *
     * @param swAdmin 管理员
     * @return 管理员集合
     */
    public List<SwAdmin> selectSwAdminList(SwAdmin swAdmin);

    /**
     * 新增管理员
     *
     * @param swAdmin 管理员
     * @return 结果
     */
    public int insertSwAdmin(SwAdmin swAdmin);

    /**
     * 修改管理员
     *
     * @param swAdmin 管理员
     * @return 结果
     */
    public int updateSwAdmin(SwAdmin swAdmin);

    /**
     * 批量删除管理员
     *
     * @param ids 需要删除的管理员主键集合
     * @return 结果
     */
    public int deleteSwAdminByIds(Long[] ids);

    /**
     * 删除管理员信息
     *
     * @param id 管理员主键
     * @return 结果
     */
    public int deleteSwAdminById(Long id);

    SwAdmin selectSwAdminByUsername(String username);

    int faceAdd(FaceAddReq faceAddReq);


    String faceCheck(FaceAddReq faceAddReq);

}

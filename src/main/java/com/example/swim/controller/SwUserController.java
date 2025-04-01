package com.example.swim.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.swim.domain.SwAdmin;
import com.example.swim.domain.base.AjaxResult;
import com.example.swim.domain.base.R;
import com.example.swim.domain.req.CountListReq;
import com.example.swim.domain.req.SwUserListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.swim.domain.SwUser;
import com.example.swim.service.ISwUserService;


/**
 * 人员Controller
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@RestController
@RequestMapping("/user")
public class SwUserController extends BaseController
{
    @Autowired
    private ISwUserService swUserService;

    /**
     * 查询人员列表
     */
    
    @GetMapping("/list")
    public R list(SwUserListReq swUserListReq)
    {
        PageHelper.startPage(swUserListReq.getPageNum(), swUserListReq.getPageSize());
        SwUser swUser = new SwUser();
        BeanUtils.copyProperties(swUserListReq, swUser);

        List<SwUser> swUsers = swUserService.selectSwUserList(swUser);
        if (swUsers.size() > 0) {
            PageInfo<SwUser> pageInfo = new PageInfo<>(swUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<SwUser>(Collections.emptyList()));
    }



    /**
     * 获取人员详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(swUserService.selectSwUserById(id));
    }

    /**
     * 新增人员
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody SwUser swUser)
    {

        int rows = swUserService.insertSwUser(swUser);
        if (rows == -32001){

            return AjaxResult.error("该学生已登记，不能重复登记");
        }
        if (rows == -32002){
            return AjaxResult.error("该学生不存在，请先在系统注册");
        }
        return toAjax(rows);
    }

    /**
     * 修改人员
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody SwUser swUser)
    {
        return toAjax(swUserService.updateSwUser(swUser));
    }

    /**
     * 删除人员
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(swUserService.deleteSwUserByIds(ids));
    }

    @GetMapping("/del")
    public AjaxResult del(@RequestParam("cardNo")Long cardNo,@RequestParam("sex")String sex){

        return toAjax(swUserService.deleteByCardNoAndSex(cardNo,sex));
    }


    @GetMapping("/count")
    private AjaxResult count(){


        return AjaxResult.success("success",swUserService.count());

    }

    @GetMapping("/info")
    private AjaxResult getInfo(@RequestParam("cardNo")String cardNo,@RequestParam("sex")String sex){

        return AjaxResult.success("success",swUserService.getUserInfo(cardNo,sex));

    }

    @PostMapping("/statics")
    private AjaxResult count(@RequestBody CountListReq countListReq){

        return AjaxResult.success(swUserService.getCount(countListReq));

    }

}

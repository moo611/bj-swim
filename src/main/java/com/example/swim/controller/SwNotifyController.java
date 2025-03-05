package com.example.swim.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.swim.domain.SwUser;
import com.example.swim.domain.base.AjaxResult;
import com.example.swim.domain.base.R;
import com.example.swim.domain.req.SwNotifyListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swim.domain.SwNotify;
import com.example.swim.service.ISwNotifyService;


/**
 * 通知Controller
 *
 * @author ruoyi
 * @date 2024-11-06
 */
@RestController
@RequestMapping("/notify")
public class SwNotifyController extends BaseController
{
    @Autowired
    private ISwNotifyService swNotifyService;

    /**
     * 查询通知列表
     */
    
    @GetMapping("/list")
    public R list(SwNotifyListReq swNotifyListReq)
    {
        PageHelper.startPage(swNotifyListReq.getPageNum(), swNotifyListReq.getPageSize());
        SwNotify swNotify = new SwNotify();
        BeanUtils.copyProperties(swNotifyListReq, swNotify);

        List<SwNotify> swNotifies = swNotifyService.selectSwNotifyList(swNotify);
        if (swNotifies.size() > 0) {
            PageInfo<SwNotify> pageInfo = new PageInfo<>(swNotifies);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<SwNotify>(Collections.emptyList()));
    }


    /**
     * 获取通知详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(swNotifyService.selectSwNotifyById(id));
    }

    /**
     * 新增通知
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody SwNotify swNotify)
    {
        return toAjax(swNotifyService.insertSwNotify(swNotify));
    }

    /**
     * 修改通知
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody SwNotify swNotify)
    {
        return toAjax(swNotifyService.updateSwNotify(swNotify));
    }

    /**
     * 删除通知
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(swNotifyService.deleteSwNotifyByIds(ids));
    }
}

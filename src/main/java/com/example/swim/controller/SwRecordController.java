package com.example.swim.controller;

import com.example.swim.domain.SwRecord;
import com.example.swim.domain.base.AjaxResult;
import com.example.swim.domain.base.R;
import com.example.swim.domain.req.SwRecordListReq;
import com.example.swim.service.ISwRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 记录Controller
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@RestController
@RequestMapping("/record")
public class SwRecordController extends BaseController {
    @Autowired
    private ISwRecordService swRecordService;

    /**
     * 查询记录列表
     */

    @GetMapping("/list")
    public R list(SwRecordListReq swRecordListReq) {
        PageHelper.startPage(swRecordListReq.getPageNum(), swRecordListReq.getPageSize());
        SwRecord swRecord = new SwRecord();
        BeanUtils.copyProperties(swRecordListReq, swRecord);

        List<SwRecord> swRecords = swRecordService.selectSwRecordList(swRecord);
        if (swRecords.size() > 0) {
            PageInfo<SwRecord> pageInfo = new PageInfo<>(swRecords);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<SwRecord>(Collections.emptyList()));
    }


    /**
     * 获取记录详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(swRecordService.selectSwRecordById(id));
    }

    /**
     * 新增记录
     */


    @PostMapping
    public AjaxResult add(@RequestBody SwRecord swRecord) {
        return toAjax(swRecordService.insertSwRecord(swRecord));
    }

    /**
     * 修改记录
     */


    @PutMapping
    public AjaxResult edit(@RequestBody SwRecord swRecord) {
        return toAjax(swRecordService.updateSwRecord(swRecord));
    }

    /**
     * 删除记录
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(swRecordService.deleteSwRecordByIds(ids));
    }
}

package com.example.swim.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.swim.config.auth.JwtUtil;
import com.example.swim.config.auth.MyUserDetailsService;
import com.example.swim.config.auth.UserUtil;
import com.example.swim.domain.base.AjaxResult;
import com.example.swim.domain.base.R;
import com.example.swim.domain.req.LoginReq;
import com.example.swim.domain.req.SwAdminListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swim.domain.SwAdmin;
import com.example.swim.service.ISwAdminService;


/**
 * 管理员Controller
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@RestController
@RequestMapping("/admin")
public class SwAdminController extends BaseController {
    @Autowired
    private ISwAdminService swAdminService;

    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        } catch (Exception e) {
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok", jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(SwAdminListReq swAdminListReq) {
        PageHelper.startPage(swAdminListReq.getPageNum(), swAdminListReq.getPageSize());
        SwAdmin swAdmin = new SwAdmin();
        BeanUtils.copyProperties(swAdminListReq, swAdmin);

        List<SwAdmin> swAdmins = swAdminService.selectSwAdminList(swAdmin);
        if (swAdmins.size() > 0) {
            PageInfo<SwAdmin> pageInfo = new PageInfo<>(swAdmins);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<SwAdmin>(Collections.emptyList()));
    }


    /**
     * 获取管理员详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(swAdminService.selectSwAdminById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo() {
        String username = UserUtil.getCurrentUsername();
        return success(swAdminService.selectSwAdminByUsername(username));
    }

    /**
     * 新增管理员
     */


    @PostMapping
    public AjaxResult add(@RequestBody SwAdmin swAdmin) {

        int res = swAdminService.insertSwAdmin(swAdmin);
        if (res == -32001) {
            return AjaxResult.error("用户名已存在");
        }

        return toAjax(res);

    }

    /**
     * 修改管理员
     */


    @PutMapping
    public AjaxResult edit(@RequestBody SwAdmin swAdmin) {

        int res = swAdminService.updateSwAdmin(swAdmin);
        if (res == -32001) {
            return AjaxResult.error("用户名已存在");
        }

        return toAjax(res);
    }

    /**
     * 删除管理员
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(swAdminService.deleteSwAdminByIds(ids));
    }
}

package com.example.swim.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.swim.domain.req.FaceAddReq;
import com.example.swim.domain.req.FaceAddRequest;
import com.example.swim.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.swim.mapper.SwAdminMapper;
import com.example.swim.domain.SwAdmin;
import com.example.swim.service.ISwAdminService;
import org.springframework.web.client.RestTemplate;

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
    RestTemplate restTemplate;
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

    @Override
    public int faceAdd(FaceAddReq faceAddReq) {


        String token = getAccessToken();

        FaceAddRequest faceAddRequest = new FaceAddRequest();
        faceAddRequest.setImage(faceAddReq.getImage().split(",")[1]);
        faceAddRequest.setImage_type("BASE64");
        faceAddRequest.setGroup_id("001");
        faceAddRequest.setUser_id(String.valueOf(faceAddReq.getUserId()));
        String faceToken = addFace(faceAddRequest, token);
        if (faceToken != null){

            SwAdmin swAdmin = swAdminMapper.selectSwAdminById(faceAddReq.getUserId());
            swAdmin.setFaceToken(faceToken);
            return swAdminMapper.updateSwAdmin(swAdmin);
        }

        return 0;
    }



    String clientId = "WmARO855SfOoTEbSB7BEW2aH";
    String clientSecret = "oKf6qZ3392hgmm1FJocwsWhIYBKUdfIg";

    private String TOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="+clientId+"&client_secret="+clientSecret;

    public String getAccessToken() {

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 创建请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            // 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    TOKEN_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class);

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            // 获取access_token字段
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取百度Access Token失败", e);
        }
    }

    private static final String FACE_ADD_URL = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add?access_token={accessToken}";

    public String addFace(FaceAddRequest request,String accessToken) {
        String faceToken = null;
        // 1. 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. 创建请求实体
        HttpEntity<FaceAddRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            // 3. 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    FACE_ADD_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class,
                    accessToken  // URI变量替换{accessToken}
            );

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            int errCode = jsonObject.getInteger("error_code");
            if (errCode == 0 && jsonObject.getJSONObject("result")!=null){
                faceToken = jsonObject.getJSONObject("result").getString("face_token");
            }
            return faceToken;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return faceToken;
        }
    }



    @Override
    public String faceCheck(FaceAddReq faceAddReq) {
        String token = getAccessToken();

        FaceAddRequest faceAddRequest = new FaceAddRequest();
        faceAddRequest.setImage(faceAddReq.getImage().split(",")[1]);
        faceAddRequest.setImage_type("BASE64");
        faceAddRequest.setGroup_id_list("001");

        return check(faceAddRequest, token);

    }

    private static final String FACE_SEARCH_URL = "https://aip.baidubce.com/rest/2.0/face/v3/search?access_token={accessToken}";

    private String check(FaceAddRequest request,String accessToken){
        String userId = null;
        // 1. 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. 创建请求实体
        HttpEntity<FaceAddRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            // 3. 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    FACE_SEARCH_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class,
                    accessToken  // URI变量替换{accessToken}
            );

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            int errCode = jsonObject.getInteger("error_code");
            if (errCode == 0 ){
                JSONArray userList = jsonObject.getJSONObject("result").getJSONArray("user_list");
                if (userList.size()>0){
                    JSONObject user = userList.getJSONObject(0);
                    int score = user.getInteger("score");
                    if (score>=80){
                        return user.getString("user_id");
                    }
                }

            }
            return userId;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return userId;
        }

    }
}

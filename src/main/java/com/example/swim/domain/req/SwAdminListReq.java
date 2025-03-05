package com.example.swim.domain.req;

import com.example.swim.domain.base.BaseReq;
import lombok.Data;

@Data
public class SwAdminListReq extends BaseReq {

    String nickname;

    String role;

    String studyNo;

    String sex;
}

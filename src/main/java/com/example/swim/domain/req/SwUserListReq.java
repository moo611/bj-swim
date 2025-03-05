package com.example.swim.domain.req;

import com.example.swim.domain.base.BaseReq;
import lombok.Data;

@Data
public class SwUserListReq extends BaseReq {

    String sex;

    String studyNo;

    String name;
}

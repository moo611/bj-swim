package com.example.swim.domain.req;

import com.example.swim.domain.base.BaseReq;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CountListReq implements Serializable {

    String startTime;

    String endTime;

}

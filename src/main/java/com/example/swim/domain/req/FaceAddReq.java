package com.example.swim.domain.req;

import lombok.Data;

import java.io.Serializable;
@Data
public class FaceAddReq implements Serializable {

    String image;

    Long userId;


}

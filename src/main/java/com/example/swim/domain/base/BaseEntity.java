package com.example.swim.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private transient String searchValue;
    private String createBy;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date createTime;
    private String updateBy;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date updateTime;
}

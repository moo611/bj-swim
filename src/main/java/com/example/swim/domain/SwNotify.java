package com.example.swim.domain;

import com.example.swim.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 通知对象 sw_notify
 *
 * @author ruoyi
 * @date 2024-11-06
 */
public class SwNotify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String title;

    /** $column.columnComment */
    
    private String content;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

   
}

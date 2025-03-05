package com.example.swim.domain;


import com.example.swim.domain.base.BaseEntity;

/**
 * 记录对象 sw_record
 *
 * @author ruoyi
 * @date 2024-11-07
 */
public class SwRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String day;

    /** $column.columnComment */
    
    private String items;

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
    public void setDay(String day)
    {
        this.day = day;
    }

    public String getDay()
    {
        return day;
    }
    public void setItems(String items)
    {
        this.items = items;
    }

    public String getItems()
    {
        return items;
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

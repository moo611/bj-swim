package com.example.swim.domain;


import com.example.swim.domain.base.BaseEntity;

/**
 * 人员对象 sw_user
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public class SwUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    /** 学号 */
    
    private String studyNo;

    /** 0男1女 */
    
    private String sex;

    /** $column.columnComment */
    
    private Long age;

    /** 手牌号 */
    
    private Long cardNo;

    /** 删除标识 */
    private String delFlag;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStudyNo(String studyNo)
    {
        this.studyNo = studyNo;
    }

    public String getStudyNo()
    {
        return studyNo;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setCardNo(Long cardNo)
    {
        this.cardNo = cardNo;
    }

    public Long getCardNo()
    {
        return cardNo;
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

package com.ruoyi.baofactory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料分类管理对象 matter_category_head
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public class MatterCategoryHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String matterCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String matterName;

    /** 物料尺寸 */
    @Excel(name = "物料尺寸")
    private String matterSize;

    /** 物料颜色 */
    @Excel(name = "物料颜色")
    private String matterColor;

    /** 物料规格 */
    @Excel(name = "物料规格")
    private String matterSpec;

    /** 物料种类等级1 */
    @Excel(name = "物料种类等级1")
    private String matterTypeLevel1;

    /** 物料种类等级2 */
    @Excel(name = "物料种类等级2")
    private String matterTypeLevel2;

    /** 数据状态（I代表生效 D代表删除 F代表冻结） */
    @Excel(name = "数据状态", readConverterExp = "I=代表生效,D=代表删除,F=代表冻结")
    private String dateStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMatterCode(String matterCode) 
    {
        this.matterCode = matterCode;
    }

    public String getMatterCode() 
    {
        return matterCode;
    }
    public void setMatterName(String matterName) 
    {
        this.matterName = matterName;
    }

    public String getMatterName() 
    {
        return matterName;
    }
    public void setMatterSize(String matterSize) 
    {
        this.matterSize = matterSize;
    }

    public String getMatterSize() 
    {
        return matterSize;
    }
    public void setMatterColor(String matterColor) 
    {
        this.matterColor = matterColor;
    }

    public String getMatterColor() 
    {
        return matterColor;
    }
    public void setMatterSpec(String matterSpec) 
    {
        this.matterSpec = matterSpec;
    }

    public String getMatterSpec() 
    {
        return matterSpec;
    }
    public void setMatterTypeLevel1(String matterTypeLevel1) 
    {
        this.matterTypeLevel1 = matterTypeLevel1;
    }

    public String getMatterTypeLevel1() 
    {
        return matterTypeLevel1;
    }
    public void setMatterTypeLevel2(String matterTypeLevel2) 
    {
        this.matterTypeLevel2 = matterTypeLevel2;
    }

    public String getMatterTypeLevel2() 
    {
        return matterTypeLevel2;
    }
    public void setDateStatus(String dateStatus) 
    {
        this.dateStatus = dateStatus;
    }

    public String getDateStatus() 
    {
        return dateStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("matterCode", getMatterCode())
            .append("matterName", getMatterName())
            .append("matterSize", getMatterSize())
            .append("matterColor", getMatterColor())
            .append("matterSpec", getMatterSpec())
            .append("matterTypeLevel1", getMatterTypeLevel1())
            .append("matterTypeLevel2", getMatterTypeLevel2())
            .append("dateStatus", getDateStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

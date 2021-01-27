package com.ruoyi.baofactory.service;

import com.ruoyi.baofactory.domain.MatterCategoryHead;

import java.util.List;

/**
 * 物料分类管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IMatterCategoryHeadService 
{
    /**
     * 查询物料分类管理
     * 
     * @param id 物料分类管理ID
     * @return 物料分类管理
     */
    public MatterCategoryHead selectMatterCategoryHeadById(Long id);

    /**
     * 查询物料分类管理列表
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 物料分类管理集合
     */
    public List<MatterCategoryHead> selectMatterCategoryHeadList(MatterCategoryHead matterCategoryHead);

    /**
     * 新增物料分类管理
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 结果
     */
    public int insertMatterCategoryHead(MatterCategoryHead matterCategoryHead);

    /**
     * 修改物料分类管理
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 结果
     */
    public int updateMatterCategoryHead(MatterCategoryHead matterCategoryHead);

    /**
     * 批量删除物料分类管理
     * 
     * @param ids 需要删除的物料分类管理ID
     * @return 结果
     */
    public int deleteMatterCategoryHeadByIds(Long[] ids);

    /**
     * 删除物料分类管理信息
     * 
     * @param id 物料分类管理ID
     * @return 结果
     */
    public int deleteMatterCategoryHeadById(Long id);
}

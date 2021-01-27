package com.ruoyi.baofactory.service;

import com.ruoyi.baofactory.domain.MatterManager;

import java.util.List;

/**
 * 物料管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
public interface IMatterManagerService 
{
    /**
     * 查询物料管理
     * 
     * @param id 物料管理ID
     * @return 物料管理
     */
    public MatterManager selectMatterManagerById(Long id);

    /**
     * 查询物料管理列表
     * 
     * @param matterManager 物料管理
     * @return 物料管理集合
     */
    public List<MatterManager> selectMatterManagerList(MatterManager matterManager);

    /**
     * 新增物料管理
     * 
     * @param matterManager 物料管理
     * @return 结果
     */
    public int insertMatterManager(MatterManager matterManager);

    /**
     * 修改物料管理
     * 
     * @param matterManager 物料管理
     * @return 结果
     */
    public int updateMatterManager(MatterManager matterManager);

    /**
     * 批量删除物料管理
     * 
     * @param ids 需要删除的物料管理ID
     * @return 结果
     */
    public int deleteMatterManagerByIds(Long[] ids);

    /**
     * 删除物料管理信息
     * 
     * @param id 物料管理ID
     * @return 结果
     */
    public int deleteMatterManagerById(Long id);
}

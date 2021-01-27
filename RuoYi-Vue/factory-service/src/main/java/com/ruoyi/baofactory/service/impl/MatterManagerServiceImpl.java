package com.ruoyi.baofactory.service.impl;

import java.util.List;

import com.ruoyi.baofactory.domain.MatterManager;
import com.ruoyi.baofactory.mapper.MatterManagerMapper;
import com.ruoyi.baofactory.service.IMatterManagerService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 物料管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
@Service
public class MatterManagerServiceImpl implements IMatterManagerService
{
    @Autowired
    private MatterManagerMapper matterManagerMapper;

    /**
     * 查询物料管理
     * 
     * @param id 物料管理ID
     * @return 物料管理
     */
    @Override
    public MatterManager selectMatterManagerById(Long id)
    {
        return matterManagerMapper.selectMatterManagerById(id);
    }

    /**
     * 查询物料管理列表
     * 
     * @param matterManager 物料管理
     * @return 物料管理
     */
    @Override
    public List<MatterManager> selectMatterManagerList(MatterManager matterManager)
    {
        return matterManagerMapper.selectMatterManagerList(matterManager);
    }

    /**
     * 新增物料管理
     * 
     * @param matterManager 物料管理
     * @return 结果
     */
    @Override
    public int insertMatterManager(MatterManager matterManager)
    {
        matterManager.setCreateTime(DateUtils.getNowDate());
        return matterManagerMapper.insertMatterManager(matterManager);
    }

    /**
     * 修改物料管理
     * 
     * @param matterManager 物料管理
     * @return 结果
     */
    @Override
    public int updateMatterManager(MatterManager matterManager)
    {
        matterManager.setUpdateTime(DateUtils.getNowDate());
        return matterManagerMapper.updateMatterManager(matterManager);
    }

    /**
     * 批量删除物料管理
     * 
     * @param ids 需要删除的物料管理ID
     * @return 结果
     */
    @Override
    public int deleteMatterManagerByIds(Long[] ids)
    {
        return matterManagerMapper.deleteMatterManagerByIds(ids);
    }

    /**
     * 删除物料管理信息
     * 
     * @param id 物料管理ID
     * @return 结果
     */
    @Override
    public int deleteMatterManagerById(Long id)
    {
        return matterManagerMapper.deleteMatterManagerById(id);
    }
}

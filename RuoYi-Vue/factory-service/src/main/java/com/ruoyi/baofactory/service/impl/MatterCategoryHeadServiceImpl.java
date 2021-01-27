package com.ruoyi.baofactory.service.impl;

import com.ruoyi.baofactory.domain.MatterCategoryHead;
import com.ruoyi.baofactory.mapper.MatterCategoryHeadMapper;
import com.ruoyi.baofactory.service.IMatterCategoryHeadService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物料分类管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class MatterCategoryHeadServiceImpl implements IMatterCategoryHeadService
{
    @Autowired
    private MatterCategoryHeadMapper matterCategoryHeadMapper;

    /**
     * 查询物料分类管理
     * 
     * @param id 物料分类管理ID
     * @return 物料分类管理
     */
    @Override
    public MatterCategoryHead selectMatterCategoryHeadById(Long id)
    {
        return matterCategoryHeadMapper.selectMatterCategoryHeadById(id);
    }

    /**
     * 查询物料分类管理列表
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 物料分类管理
     */
    @Override
    public List<MatterCategoryHead> selectMatterCategoryHeadList(MatterCategoryHead matterCategoryHead)
    {
        return matterCategoryHeadMapper.selectMatterCategoryHeadList(matterCategoryHead);
    }

    /**
     * 新增物料分类管理
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 结果
     */
    @Override
    public int insertMatterCategoryHead(MatterCategoryHead matterCategoryHead)
    {
        matterCategoryHead.setCreateTime(DateUtils.getNowDate());
        return matterCategoryHeadMapper.insertMatterCategoryHead(matterCategoryHead);
    }

    /**
     * 修改物料分类管理
     * 
     * @param matterCategoryHead 物料分类管理
     * @return 结果
     */
    @Override
    public int updateMatterCategoryHead(MatterCategoryHead matterCategoryHead)
    {
        matterCategoryHead.setUpdateTime(DateUtils.getNowDate());
        return matterCategoryHeadMapper.updateMatterCategoryHead(matterCategoryHead);
    }

    /**
     * 批量删除物料分类管理
     * 
     * @param ids 需要删除的物料分类管理ID
     * @return 结果
     */
    @Override
    public int deleteMatterCategoryHeadByIds(Long[] ids)
    {
        return matterCategoryHeadMapper.deleteMatterCategoryHeadByIds(ids);
    }

    /**
     * 删除物料分类管理信息
     * 
     * @param id 物料分类管理ID
     * @return 结果
     */
    @Override
    public int deleteMatterCategoryHeadById(Long id)
    {
        return matterCategoryHeadMapper.deleteMatterCategoryHeadById(id);
    }
}

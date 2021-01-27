package com.ruoyi.baofactory.controller;

import java.util.List;

import com.ruoyi.baofactory.domain.MatterCategoryHead;
import com.ruoyi.baofactory.service.IMatterCategoryHeadService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料分类管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@RestController
@RequestMapping("/matterCategory/head")
public class MatterCategoryHeadController extends BaseController
{
    @Autowired
    private IMatterCategoryHeadService matterCategoryHeadService;

    /**
     * 查询物料分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:list')")
    @GetMapping("/list")
    public TableDataInfo list(MatterCategoryHead matterCategoryHead)
    {
        startPage();
        List<MatterCategoryHead> list = matterCategoryHeadService.selectMatterCategoryHeadList(matterCategoryHead);
        return getDataTable(list);
    }

    /**
     * 导出物料分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:export')")
    @Log(title = "物料分类管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MatterCategoryHead matterCategoryHead)
    {
        List<MatterCategoryHead> list = matterCategoryHeadService.selectMatterCategoryHeadList(matterCategoryHead);
        ExcelUtil<MatterCategoryHead> util = new ExcelUtil<MatterCategoryHead>(MatterCategoryHead.class);
        return util.exportExcel(list, "head");
    }

    /**
     * 获取物料分类管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(matterCategoryHeadService.selectMatterCategoryHeadById(id));
    }

    /**
     * 新增物料分类管理
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:add')")
    @Log(title = "物料分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MatterCategoryHead matterCategoryHead)
    {
        return toAjax(matterCategoryHeadService.insertMatterCategoryHead(matterCategoryHead));
    }

    /**
     * 修改物料分类管理
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:edit')")
    @Log(title = "物料分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MatterCategoryHead matterCategoryHead)
    {
        return toAjax(matterCategoryHeadService.updateMatterCategoryHead(matterCategoryHead));
    }

    /**
     * 删除物料分类管理
     */
    @PreAuthorize("@ss.hasPermi('matterCategory:head:remove')")
    @Log(title = "物料分类管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(matterCategoryHeadService.deleteMatterCategoryHeadByIds(ids));
    }
}

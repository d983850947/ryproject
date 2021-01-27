package com.ruoyi.baofactory.controller;

import com.ruoyi.baofactory.domain.MatterManager;
import com.ruoyi.baofactory.service.IMatterManagerService;
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

import java.util.List;

/**
 * 物料管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
@RestController
@RequestMapping("/matter/manager")
public class MatterManagerController extends BaseController
{
    @Autowired
    private IMatterManagerService matterManagerService;

    /**
     * 查询物料管理列表
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(MatterManager matterManager)
    {
        startPage();
        List<MatterManager> list = matterManagerService.selectMatterManagerList(matterManager);
        return getDataTable(list);
    }

    /**
     * 导出物料管理列表
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:export')")
    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MatterManager matterManager)
    {
        List<MatterManager> list = matterManagerService.selectMatterManagerList(matterManager);
        ExcelUtil<MatterManager> util = new ExcelUtil<MatterManager>(MatterManager.class);
        return util.exportExcel(list, "manager");
    }

    /**
     * 获取物料管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(matterManagerService.selectMatterManagerById(id));
    }

    /**
     * 新增物料管理
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:add')")
    @Log(title = "物料管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MatterManager matterManager)
    {
        return toAjax(matterManagerService.insertMatterManager(matterManager));
    }

    /**
     * 修改物料管理
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:edit')")
    @Log(title = "物料管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MatterManager matterManager)
    {
        return toAjax(matterManagerService.updateMatterManager(matterManager));
    }

    /**
     * 删除物料管理
     */
    @PreAuthorize("@ss.hasPermi('matter:manager:remove')")
    @Log(title = "物料管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(matterManagerService.deleteMatterManagerByIds(ids));
    }
}

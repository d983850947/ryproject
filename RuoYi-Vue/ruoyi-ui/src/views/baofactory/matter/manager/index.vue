<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="物料编码" prop="matterCode">
        <el-input
          v-model="queryParams.matterCode"
          placeholder="请输入物料编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料名称" prop="matterName">
        <el-input
          v-model="queryParams.matterName"
          placeholder="请输入物料名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料尺寸" prop="matterSize">
        <el-input
          v-model="queryParams.matterSize"
          placeholder="请输入物料尺寸"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料颜色" prop="matterColor">
        <el-input
          v-model="queryParams.matterColor"
          placeholder="请输入物料颜色"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料规格" prop="matterSpec">
        <el-input
          v-model="queryParams.matterSpec"
          placeholder="请输入物料规格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料种类" prop="matterType">
        <el-select v-model="queryParams.matterType" placeholder="请选择物料种类" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="物料种类等级1" prop="matterTypeLevel1">
        <el-input
          v-model="queryParams.matterTypeLevel1"
          placeholder="请输入物料种类等级1"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料种类等级2" prop="matterTypeLevel2">
        <el-input
          v-model="queryParams.matterTypeLevel2"
          placeholder="请输入物料种类等级2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入物料价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设计师名称" prop="designer">
        <el-input
          v-model="queryParams.designer"
          placeholder="请输入设计师名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="版师名称" prop="fashionEditor">
        <el-input
          v-model="queryParams.fashionEditor"
          placeholder="请输入版师名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="裁床名称" prop="cuttingTable">
        <el-input
          v-model="queryParams.cuttingTable"
          placeholder="请输入裁床名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据状态" prop="dateStatus">
        <el-select v-model="queryParams.dateStatus" placeholder="请选择数据状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
		  plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:manager:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
		  plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:manager:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
		  plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:manager:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
		  plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:manager:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="id" align="center" prop="id" /> -->
      <el-table-column label="物料编码" align="center" prop="matterCode" />
      <el-table-column label="物料名称" align="center" prop="matterName" />
      <el-table-column label="物料尺寸" align="center" prop="matterSize" />
      <el-table-column label="物料颜色" align="center" prop="matterColor" />
      <el-table-column label="物料规格" align="center" prop="matterSpec" />
      <!--  <el-table-column label="物料种类" align="center" prop="matterType" />
      <el-table-column label="物料种类等级1" align="center" prop="matterTypeLevel1" />
      <el-table-column label="物料种类等级2" align="center" prop="matterTypeLevel2" />
      <el-table-column label="物料价格" align="center" prop="price" />
      <el-table-column label="设计师名称" align="center" prop="designer" />
      <el-table-column label="版师名称" align="center" prop="fashionEditor" />
      <el-table-column label="裁床名称" align="center" prop="cuttingTable" />
      <el-table-column label="数据状态" align="center" prop="dateStatus" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:manager:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:manager:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改物料管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="物料编码" prop="matterCode">
          <el-input v-model="form.matterCode" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="物料名称" prop="matterName">
          <el-input v-model="form.matterName" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="物料尺寸" prop="matterSize">
          <el-input v-model="form.matterSize" placeholder="请输入物料尺寸" />
        </el-form-item>
        <el-form-item label="物料颜色" prop="matterColor">
          <el-input v-model="form.matterColor" placeholder="请输入物料颜色" />
        </el-form-item>
        <el-form-item label="物料规格" prop="matterSpec">
          <el-input v-model="form.matterSpec" placeholder="请输入物料规格" />
        </el-form-item>

        <el-form-item label="物料种类" prop="matterType">
          <el-select v-model="form.matterType" placeholder="请选择物料种类">
            <el-option
              v-for="item in matterTypeList"
              :key="item.dictValue"
              :label="item.dictLabel"
              :value="item.dictValue">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="一级分类" prop="matterTypeLevel1">
           <el-select v-model="form.matterTypeLevel1" placeholder="请输入物料种类等级1">
            <el-option
              v-for="item in matterTypeLevel1List"
              :key="item.dictValue"
              :label="item.dictLabel"
              :value="item.dictValue">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="二级分类" prop="matterTypeLevel2">
          <el-select v-model="form.matterTypeLevel2" placeholder="请输入物料种类等级2">
            <el-option
              v-for="item in matterTypeLevel2List"
              :key="item.dictValue"
              :label="item.dictLabel"
              :value="item.dictValue">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="物料价格(元)" prop="price">
          <el-input v-model="form.price" placeholder="请输入物料价格" />
        </el-form-item>
        <el-form-item label="设计师名称" prop="designer">
          <el-input v-model="form.designer" placeholder="请输入设计师名称" />
        </el-form-item>
        <el-form-item label="版师名称" prop="fashionEditor">
          <el-input v-model="form.fashionEditor" placeholder="请输入版师名称" />
        </el-form-item>
        <el-form-item label="裁床名称" prop="cuttingTable">
          <el-input v-model="form.cuttingTable" placeholder="请输入裁床名称" />
        </el-form-item>
        <el-form-item label="数据状态">
          <el-radio-group v-model="form.dateStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listManager, getManager, delManager, addManager, updateManager, exportManager } from "@/api/baofactory/matter/manager";
import { getDicts } from "@/api/system/dict/data";

export default {
  name: "Manager",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 物料管理表格数据
      managerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        matterCode: null,
        matterName: null,
        matterSize: null,
        matterColor: null,
        matterSpec: null,
        matterType: null,
        matterTypeLevel1: null,
        matterTypeLevel2: null,
        price: null,
        designer: null,
        fashionEditor: null,
        cuttingTable: null,
        dateStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      //下拉框:物料种类
      matterTypeList:[],
      //下拉框:物料种类等级1
      matterTypeLevel1List:[],
      //下拉框:物料种类等级2
      matterTypeLevel2List:[],
      //测试字段
      testf:[]
    };
  },
  created() {
    this.getList();
    //初始化下拉框数据
    this.initSelectDrop();
  },
  methods: {
    /** 查询物料管理列表 */
    getList() {
      this.loading = true;
      listManager(this.queryParams).then(response => {
        this.managerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        matterCode: null,
        matterName: null,
        matterSize: null,
        matterColor: null,
        matterSpec: null,
        matterType: null,
        matterTypeLevel1: null,
        matterTypeLevel2: null,
        price: null,
        designer: null,
        fashionEditor: null,
        cuttingTable: null,
        dateStatus: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加物料管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getManager(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改物料管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateManager(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManager(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除物料管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delManager(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有物料管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportManager(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },
    //下拉框初始化
    initSelectDrop(){
      getDicts('matter_type').then(response => {
        //下拉框:物料种类
        this.matterTypeList = response.data;
      });
       getDicts('matter_type_level1').then(response => {
        //下拉框:物料种类
        this.matterTypeLevel1List = response.data;
      });
       getDicts('matter_type_level2').then(response => {
        //下拉框:物料种类
        this.matterTypeLevel2List = response.data;
      });
    }
  }
};
</script>

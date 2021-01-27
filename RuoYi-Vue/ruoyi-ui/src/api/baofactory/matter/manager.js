import request from '@/utils/request'

// 查询物料管理列表
export function listManager(query) {
  return request({
    url: '/matter/manager/list',
    method: 'get',
    params: query
  })
}

// 查询物料管理详细
export function getManager(id) {
  return request({
    url: '/matter/manager/' + id,
    method: 'get'
  })
}

// 新增物料管理
export function addManager(data) {
  return request({
    url: '/matter/manager',
    method: 'post',
    data: data
  })
}

// 修改物料管理
export function updateManager(data) {
  return request({
    url: '/matter/manager',
    method: 'put',
    data: data
  })
}

// 删除物料管理
export function delManager(id) {
  return request({
    url: '/matter/manager/' + id,
    method: 'delete'
  })
}

// 导出物料管理
export function exportManager(query) {
  return request({
    url: '/matter/manager/export',
    method: 'get',
    params: query
  })
}
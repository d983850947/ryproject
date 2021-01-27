import request from '@/utils/request'

// 查询物料分类管理列表
export function listHead(query) {
  return request({
    url: '/matterCategory/head/list',
    method: 'get',
    params: query
  })
}

// 查询物料分类管理详细
export function getHead(id) {
  return request({
    url: '/matterCategory/head/' + id,
    method: 'get'
  })
}

// 新增物料分类管理
export function addHead(data) {
  return request({
    url: '/matterCategory/head',
    method: 'post',
    data: data
  })
}

// 修改物料分类管理
export function updateHead(data) {
  return request({
    url: '/matterCategory/head',
    method: 'put',
    data: data
  })
}

// 删除物料分类管理
export function delHead(id) {
  return request({
    url: '/matterCategory/head/' + id,
    method: 'delete'
  })
}

// 导出物料分类管理
export function exportHead(query) {
  return request({
    url: '/matterCategory/head/export',
    method: 'get',
    params: query
  })
}
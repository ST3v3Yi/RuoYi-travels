import request from '@/utils/request'

// 查询路线评分列表
export function listRouteRating(query) {
  return request({
    url: '/routeRating/routeRating/list',
    method: 'get',
    params: query
  })
}

// 查询路线评分详细
export function getRouteRating(routeId) {
  return request({
    url: '/routeRating/routeRating/' + routeId,
    method: 'get'
  })
}

// 新增路线评分
export function addRouteRating(data) {
  return request({
    url: '/routeRating/routeRating',
    method: 'post',
    data: data
  })
}

// 修改路线评分
export function updateRouteRating(data) {
  return request({
    url: '/routeRating/routeRating',
    method: 'put',
    data: data
  })
}

// 删除路线评分
export function delRouteRating(routeId) {
  return request({
    url: '/routeRating/routeRating/' + routeId,
    method: 'delete'
  })
}

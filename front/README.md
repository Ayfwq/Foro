# front — 坊市 Foro 前端

三套静态站点，无构建步骤，改完文件刷新页面即可生效。

| 目录 | 端口 | 入口 | 说明 |
|---|---|---|---|
| `portal/` | 18080 | `index.html` | 商城前台：首页、搜索、购物车、确认订单、支付、支付结果、登录 |
| `admin/` | 18081 | `items.html` | 商品管理、用户管理 |
| `console/` | 18082 | `index.html` | 运营控制台，含 ECharts 看板与登出流程 |

## 技术形态

原生多页 HTML + Vue（`js/vue.js` 本地引入）+ Element UI + axios，没有 npm 依赖，也不需要打包。

## 与后端联调

页面内 `axios.defaults.baseURL = "/api"`，登录后 token 存在 `sessionStorage`，请求头携带 `authorization`。

nginx 负责静态托管和代理：

```
浏览器 → /api/xxx → nginx 去掉 /api → http://localhost:8080/xxx → 网关 → 各服务
```

## 启动

1. 复制 `nginx.conf` 到 nginx 的 `conf/` 目录；
2. 把 `__FRONT_DIR__` 替换成本目录的绝对路径；
3. 启动 nginx，访问 `http://localhost:18080`。

## 主题

品牌色为青绿 `#0d9488`（深色 `#0f766e`），各站点通过 `css/foro-theme.css` 覆盖原有配色与字体，原始样式文件保持未改动，需要回退时删除该覆盖文件即可。

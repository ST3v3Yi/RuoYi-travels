package com.ruoyi.travels.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.travels.domain.*;
import com.ruoyi.travels.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 路线Controller
 * 
 * @author Yifun
 * @date 2023-03-11
 */
@RestController
@RequestMapping("/route/route")
public class RouteController extends BaseController
{
    @Autowired
    private IRouteService routeService;

    @Autowired
    private IRouteRatingService routeRatingService;

    @Autowired
    private ISpotService spotService;

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IRouteTagService routeTagService;

    /**
     * 查询路线列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @GetMapping("/list")
    public TableDataInfo list(Route route)
    {
        startPage();
        List<Route> list = routeService.selectRouteList(route);
        return getDataTable(list);
    }

    /**
     * 查询发布路线列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @GetMapping("/routeList")
    public TableDataInfo routeList()
    {
        startPage();
        List<Route> list = routeService.selectReleasedRouteList();
        return getDataTable(list);
    }

    /**
     * 获取相应天数限制内的列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @PostMapping("/listByDay")
    public AjaxResult getListByDay(@RequestBody Route route)
    {
        return success(routeService.selectRouteByDay(route));
    }

    /**
     * 获取相应花费限制内的列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @PostMapping("/listByPrice")
    public AjaxResult getListByPrice(@RequestBody Route route)
    {
        return success(routeService.selectRouteByPrice(route));
    }

    /**
     * 获取路线详细信息
     */
    @PreAuthorize("@ss.hasPermi('route:route:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(routeService.selectRouteById(id));
    }

    /**
     * 获取相应用户的路线攻略
     */
    @PreAuthorize("@ss.hasPermi('route:route:query')")
    @GetMapping(value = "/user/{userId}")
    public AjaxResult getUserRoute(@PathVariable("userId") Long userId)
    {
        return success(routeService.selectRouteByUserId(userId));
    }

    /**
     * 获取用户路线数量
     */
    @PreAuthorize("@ss.hasPermi('route:route:query')")
    @GetMapping(value = "/userRoute/{userId}")
    public AjaxResult getUserRouteNum(@PathVariable("userId") Long userId)
    {
        return success(routeService.selectRouteNumByUserId(userId));
    }

    /**
     * 导出路线列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:export')")
    @Log(title = "路线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Route route)
    {
        List<Route> list = routeService.selectRouteList(route);
        ExcelUtil<Route> util = new ExcelUtil<Route>(Route.class);
        util.exportExcel(response, list, "路线数据");
    }

    /**
     * 新增路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:add')")
    @Log(title = "路线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Route route)
    {
        List<Spot> spotList = spotService.selectSpotList(null);
        List<String> spotName = spotList.stream().map(Spot::getSpotName).collect(Collectors.toList());
        List<Hotel> hotelList = hotelService.selectHotelList(null);
        List<String> hotelName = hotelList.stream().map(Hotel::getHotelName).collect(Collectors.toList());
        List<String> tagList = new ArrayList<>();
        tagList.addAll(spotName);
        tagList.addAll(hotelName);
        Long id = routeService.selectMAXId() + 1;
        System.out.println("id是" + id);
        route.setId(id);
        System.out.println(route.getId());
        for (String tag : tagList) {
            if (route.getContent().contains(tag)) {
                RouteTag routeTag = new RouteTag();
                routeTag.setRouteId(route.getId());
                routeTag.setTag(tag);
                routeTagService.insertRouteTag(routeTag);
            }
        }
        return toAjax(routeService.insertRoute(route));
    }

    /**
     * 修改路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:edit')")
    @Log(title = "路线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Route route)
    {
        return toAjax(routeService.updateRoute(route));
    }

    /**
     * 删除路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:remove')")
    @Log(title = "路线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(routeService.deleteRouteByIds(ids));
    }

    /**
     * 上传路线封面图
     */
    @Log(title = "路线封面图", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public AjaxResult uploadCoverImg(@RequestParam("coverImg") MultipartFile file) throws Exception
    {
        if (!file.isEmpty())
        {
            String coverImg = FileUploadUtils.upload(RuoYiConfig.getImagePath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imgUrl", coverImg);
            return ajax;
        }
        return error("上传图片异常，请联系管理员");
    }

    /**
     * 首页封面路线攻略推荐算法
     *
     * 获取走马灯展示图片列表
     * 获取一定数量的景点和路线封面图作展示
     * 获取逻辑：
     * 1.对于景点，采用随机推荐    取 2
     * 2.对于路线攻略，采用[优先推荐]    取 4
     *
     * [优先推荐]：根据路线的收藏数量和评论数以及发布时间作为评判标准
     * 评判标准：
     *  1.收藏数   权重10
     *  2.评论    权重3
     *  3.回复    权重1
     *  4.发表时间 —— 距今10天内100% / 距今30天内80% / 距今60天内30% / 距今90天内10% / 距今90天以上2%
     *  5.路线攻略评分 —— 之间将上述权重乘以相应平均分
     *
     */
//    @PreAuthorize("@ss.hasPermi('route:route:query')")
    @GetMapping(value = "/home/route")
    public AjaxResult getHomeRoute() {
        // 查询所有待推荐路线
        List<RecRoute> routeList = routeService.selectRecRoute();
        // 获取当前时间
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String nowDate = formatter.format(date);
        LocalDate currentDate = LocalDate.parse(nowDate);
        for (RecRoute route : routeList) {
            // 初始化权重
            route.setWeight(BigDecimal.ZERO);
            // 计算初始权重
            BigDecimal weight = BigDecimal.valueOf(route.getCounts() * 10 + route.getCommentsCount() * 3 + route.getReplyCount());
            // 计算日期差
            String releaseTime = formatter.format(route.getReleaseTime());
            LocalDate releaseDate = LocalDate.parse(releaseTime);
            Integer dateGap = Math.toIntExact(ChronoUnit.DAYS.between(releaseDate, currentDate));
            route.setDateGap(dateGap);
            // 根据日期差重新计算权重
            if (dateGap > 10 && dateGap <= 30) {
                weight = weight.multiply(BigDecimal.valueOf(0.8));
            } else if (dateGap > 30 && dateGap <= 60) {
                weight = weight.multiply(BigDecimal.valueOf(0.3));
            } else if (dateGap > 60 && dateGap <= 90) {
                weight = weight.multiply(BigDecimal.valueOf(0.1));
            } else if (dateGap > 90) {
                weight = weight.multiply(BigDecimal.valueOf(0.02));
            }
            // 获取路线平均分
            BigDecimal avgRating = routeRatingService.selectAVGRatingByRouteId(route.getId());
            if (avgRating != null) {
                weight = weight.multiply(avgRating);
            }
            route.setWeight(weight);
        }
        // 对处理过的list进行排序并取前4位[权重从大到小，权重相同取距今最近]
        List<RecRoute> sortedList = routeList.stream()
                .sorted(Comparator
                    .comparing(RecRoute::getWeight)
                    .reversed()
                    .thenComparing(RecRoute::getDateGap))
                .limit(4)
                .collect(Collectors.toList());
        return success(sortedList);
    }
}

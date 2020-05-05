package com.hero.ms.service.tree.rest;


import com.hero.ms.common.pojo.ResponseResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.TblProCode;
import com.hero.ms.service.tree.service.impl.ProTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yejx
 * @Date 2019/6/8 22:10
 */
@RestController
@RequestMapping("/proType")
//@CrossOrigin  //解决跨域（方案一）
@Api(value = "proType", description = "省份接口")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")})
public class ProTypeRest {

    private static final Logger logger = LoggerFactory.getLogger(ProTypeRest.class);

    @Resource(name = "proTypeServiceImpl")
    private ProTypeServiceImpl proTypeService;

    @ApiOperation(value = "查询所有省份", notes = "查询所有省份", response = ResponseResult.class)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseResult findAll(){
        ResponseResult rr = new ResponseResult();
        List<TblProCode> proList = null;
        try {
            proList = proTypeService.findAll();
            if (proList.isEmpty()) {
                rr.setMSG("暂无数据！");
            } else {
                rr.setMSG("查询成功！");
                rr.setDATA(proList);
            }
        } catch (Exception e) {
            logger.error("省份查询失败：" + e.getMessage());
            rr = new ResponseResult(false, StatusCode.CODE_3000.getKey(), StatusCode.CODE_3000.getDesc());
            rr.setSUCCESS(false);
            rr.setSTATUS(StatusCode.CODE_3000.getKey());
            rr.setMSG(StatusCode.CODE_3000.getDesc());
        }
        return rr;
    }

}

package com.hero.ms.service.tree.rest;

import com.hero.ms.common.pojo.MsgCode;
import com.hero.ms.common.pojo.ResponseResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.TblTreeCode;
import com.hero.ms.service.tree.service.TreeCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
@Log
@RestController
@RequestMapping("/tree")
//@CrossOrigin  //解决跨域（方案一）
@Api(value = "tree", description = "树形字典接口")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")})
public class TreeCodeRest {

    @Resource(name = "TreeCodeServiceImpl")
    private TreeCodeService treeCodeService;

    /**
     * 根据类型获取树
     *
     * @return
     */
    @ApiOperation(value = "条件查询树形字典", notes = "条件查询树形字典", response = ResponseResult.class)
    @RequestMapping(value = "/getTreeCodeInfo", method = RequestMethod.GET)
    public ResponseResult getTreeCodeInfo(@RequestParam(required = false) String proId, @RequestParam String codeType) {
        ResponseResult rr = new ResponseResult();

        if (StringUtils.isEmpty(codeType)) {
            log.severe(StatusCode.CODE_1000.getDesc());
            rr.setSTATUS(StatusCode.CODE_1000.getKey());
            rr.setMSG(StatusCode.CODE_1000.getDesc());
            return rr;
        }
        try {
            List<TblTreeCode> root = new ArrayList<>();
            List<TblTreeCode> tblTreeCodeList = treeCodeService.findRoot(proId, codeType);
            for (TblTreeCode tblTreeCode : tblTreeCodeList) {
                root.add(tblTreeCode);
                List<TblTreeCode> children = treeCodeService.findChildren(proId, codeType, tblTreeCode.getCodeId());
                tblTreeCode.setChildren(children);

                for (TblTreeCode child : children) {
                    List<TblTreeCode> children2 = treeCodeService.findChildren(proId, codeType, child.getCodeId());
                    child.setChildren(children2);
                    /*for (TblTreeCode child2 : children2) {
                        List<TblTreeCode> children3 = treeCodeService.findChildren(codeType, proId, child2.getCodeId());
                        child2.setChildren(children3);
                    }*/
                }
            }
            rr.setDATA(root);
        } catch (Exception e) {
            log.severe(e.getMessage());
            rr = new ResponseResult(MsgCode.FAILURE.getKey(), StatusCode.CODE_3000.getKey(), StatusCode.CODE_3000.getDesc());
        }
        return rr;
    }

    /*@RequestMapping("/findTreeByCodeType")
    public ResponseResult findTree(@RequestParam Map<String, String> param) {
        ResponseResult rr = new ResponseResult();
        try {
            List<TblTreeCode> root = new ArrayList<>();
            List<TblTreeCode> tblTreeCodeList = treeCodeService.findRoot(param.get("proId"), param.get("codeType"));
            for (TblTreeCode tblTreeCode : tblTreeCodeList) {
                root.add(tblTreeCode);
                List<TblTreeCode> children = treeCodeService.findChildren(param.get("proId"), param.get("codeType"), tblTreeCode.getCodeId());
                tblTreeCode.setChildren(children);

                for (TblTreeCode child : children) {
                    List<TblTreeCode> children2 = treeCodeService.findChildren(param.get("proId"), param.get("codeType"), child.getCodeId());
                    child.setChildren(children2);
                }
            }
            rr.setSUCCESS(true);
            rr.setMSG("加载许可数据成功");
            rr.setDATA(root);
        } catch (Exception e) {
            log.severe(e.getMessage());
            rr.setSUCCESS(false);
            rr.setSTATUS(StatusCode.CODE_1000.getKey());
            rr.setMSG("加载许可数据失败");
        }
        return rr;
    }*/

    @ApiOperation(value = "条件模糊查询", notes = "条件模糊查询", response = ResponseResult.class)
    @RequestMapping(value = "/findByWord", method = RequestMethod.GET)
    public ResponseResult findByWord(@RequestParam Map<String, String> param) {
        ResponseResult rr = new ResponseResult();
        try {
            List<TblTreeCode> tblTreeCodeList = treeCodeService.findByWord(param.get("codeName"));
            rr.setSUCCESS(MsgCode.DEFAULT.getKey());
            rr.setMSG("加载许可数据成功");
            rr.setDATA(tblTreeCodeList);
        } catch (Exception e) {
            log.severe("异步搜索：" + e.getMessage());
            rr.setSUCCESS(MsgCode.FAILURE.getKey());
            rr.setMSG("加载许可数据失败");
        }
        return rr;
    }

}

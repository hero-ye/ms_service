package com.hero.ms.service.tree.rest;

import com.hero.ms.common.pojo.ServiceResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.TblTreeCode;
import com.hero.ms.service.tree.service.TreeCodeService;
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
public class TreeCodeRest {


    @Resource(name = "TreeCodeServiceImpl")
    private TreeCodeService treeCodeService;

    /**
     * 根据类型获取树
     *
     * @return
     */
    @RequestMapping(value = "/getTreeCodeInfo", method = RequestMethod.GET)
    public ServiceResult getTreeCodeInfo(@RequestParam(required = false) String proId, @RequestParam String codeType) {
        ServiceResult sr = new ServiceResult();

        if (StringUtils.isEmpty(codeType)) {
            log.info(StatusCode.CODE_1000.getDesc());
            sr.setSTATUS(StatusCode.CODE_1000.getKey());
            sr.setMSG(StatusCode.CODE_1000.getDesc());
            return sr;
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
            sr.setSUCCESS(true);
            sr.setMSG(StatusCode.DEFAULT.getDesc());
            sr.setDATA(root);
        } catch (Exception e) {
            log.severe(e.getMessage());
            sr.setSTATUS(StatusCode.CODE_3000.getKey());
            sr.setMSG(StatusCode.CODE_3000.getDesc());
        }
        return sr;
    }

    /*@RequestMapping("/findTreeByCodeType")
    public ServiceResult findTree(@RequestParam Map<String, String> param) {
        ServiceResult sr = new ServiceResult();
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
            sr.setSUCCESS(true);
            sr.setMSG("加载许可数据成功");
            sr.setDATA(root);
        } catch (Exception e) {
            log.severe(e.getMessage());
            sr.setSUCCESS(false);
            sr.setSTATUS(StatusCode.CODE_1000.getKey());
            sr.setMSG("加载许可数据失败");
        }
        return sr;
    }*/

    @RequestMapping(value = "/findByWord", method = RequestMethod.GET)
    public ServiceResult findByWord(@RequestParam Map<String, String> param) {
        ServiceResult sr = new ServiceResult();
        try {
            List<TblTreeCode> tblTreeCodeList = treeCodeService.findByWord(param.get("codeName"));
            sr.setSUCCESS(true);
            sr.setMSG("加载许可数据成功");
            sr.setDATA(tblTreeCodeList);
        } catch (Exception e) {
            log.severe("异步搜索：" + e.getMessage());
            sr.setSUCCESS(false);
            sr.setMSG("加载许可数据失败");
        }
        return sr;
    }

}

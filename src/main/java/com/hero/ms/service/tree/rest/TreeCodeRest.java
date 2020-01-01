package com.hero.ms.service.tree.rest;

import com.hero.ms.common.pojo.ServiceResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.TreeCode;
import com.hero.ms.service.tree.service.TreeCodeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
@RestController
@RequestMapping("/tree")
//@CrossOrigin  //解决跨域（方案一）
public class TreeCodeRest {

    private static final Logger log = LoggerFactory.getLogger(TreeCodeRest.class);

    @Resource(name = "TreeCodeServiceImpl")
    private TreeCodeService treeCodeService;

    /**
     * 根据类型获取树
     *
     * @return
     */
    @RequestMapping(value = "/getTreeCodeInfo", method = RequestMethod.GET)
    public ServiceResult getTreeCodeInfo(@RequestParam String codeType, @RequestParam(required = false) String proId) {
        ServiceResult sr = new ServiceResult();

        if (StringUtils.isEmpty(codeType)) {
            log.info(StatusCode.CODE_1000.getDesc());
            sr.setSTATUS(StatusCode.CODE_1000.getKey());
            sr.setMSG(StatusCode.CODE_1000.getDesc());
            return sr;
        }
        try {
            List<TreeCode> root = new ArrayList<>();
            List<TreeCode> treeCodeList = treeCodeService.findRoot(codeType, proId);
            for (TreeCode treeCode : treeCodeList) {
                root.add(treeCode);
                List<TreeCode> children = treeCodeService.findChildren(codeType, proId, treeCode.getCodeId());
                treeCode.setChildren(children);

                for (TreeCode child : children) {
                    List<TreeCode> children2 = treeCodeService.findChildren(codeType, proId, child.getCodeId());
                    child.setChildren(children2);
                    /*for (TreeCode child2 : children2) {
                        List<TreeCode> children3 = treeCodeService.findChildren(codeType, proId, child2.getCodeId());
                        child2.setChildren(children3);
                    }*/
                }
            }
            sr.setSUCCESS(true);
            sr.setMSG(StatusCode.DEFAULT.getDesc());
            sr.setDATA(root);
        } catch (Exception e) {
            log.error(e.getMessage());
            sr.setSTATUS(StatusCode.CODE_3000.getKey());
            sr.setMSG(StatusCode.CODE_3000.getDesc());
        }
        return sr;
    }

}

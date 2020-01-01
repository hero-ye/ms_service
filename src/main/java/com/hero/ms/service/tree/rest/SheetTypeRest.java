package com.hero.ms.service.tree.rest;

import com.hero.ms.common.pojo.ServiceResult;
import com.hero.ms.common.pojo.StatusCode;
import com.hero.ms.service.tree.entity.SheetType;
import com.hero.ms.service.tree.service.impl.SheetTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yejx
 * @date 2019-6-2 14:49
 */
@RestController
@RequestMapping("/sheetType")
public class SheetTypeRest {

    private static final Logger log = LoggerFactory.getLogger(SheetTypeRest.class);

    @Resource(name = "sheetTypeServiceImpl")
    private SheetTypeServiceImpl sheetTypeService;

    @RequestMapping("/findTreeByCodeType")
    public ServiceResult findTree(@RequestParam Map<String, String> param) {
        ServiceResult sr = new ServiceResult();
        try {
            List<SheetType> root = new ArrayList<>();
            List<SheetType> sheetTypeList = sheetTypeService.findRoot(param.get("proId"), param.get("codeType"));
            for (SheetType sheetType : sheetTypeList) {
                root.add(sheetType);
                List<SheetType> children = sheetTypeService.findChildren(param.get("proId"), param.get("codeType"), sheetType.getId());
                sheetType.setChildren(children);

                for (SheetType child : children) {
                    List<SheetType> children2 = sheetTypeService.findChildren(param.get("proId"), param.get("codeType"), child.getId());
                    child.setChildren(children2);
                }
            }
            sr.setSUCCESS(true);
            sr.setMSG("加载许可数据成功");
            sr.setDATA(root);
        } catch (Exception e) {
            sr.setSUCCESS(false);
            sr.setSTATUS(StatusCode.CODE_1000.getKey());
            sr.setMSG("加载许可数据失败");
        }

        return sr;
    }

    @RequestMapping(value = "/findByWord", method = RequestMethod.POST)
    public ServiceResult findByWord(@RequestParam Map<String, String> param) {
        ServiceResult sr = new ServiceResult();
        try {
            List<SheetType> sheetTypeList = sheetTypeService.findByWord(param.get("codeName"));
            sr.setSUCCESS(true);
            sr.setMSG("加载许可数据成功");
            sr.setDATA(sheetTypeList);
        } catch (Exception e) {
            log.error("异步搜索：" + e.getMessage());
            sr.setSUCCESS(false);
            sr.setMSG("加载许可数据失败");
        }
        return sr;
    }


}

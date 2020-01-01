package com.hero.ms.service.common.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yejx
 * @date 2019-5-18 18:47
 */
@Controller
@RequestMapping("/common")
public class CommonRest {

    @RequestMapping("/index")
    public String index() {
        return "common/page/index";
    }

    @RequestMapping("/permission")
    public String permission() {
        return "permission/page/permission";
    }

    @RequestMapping("/assignPermission")
    public String assignPermission() {
        return "permission/page/assignPermission";
    }

    @RequestMapping("/sheettype")
    public String sheettype() {
        return "tree/page/tree";
    }


}

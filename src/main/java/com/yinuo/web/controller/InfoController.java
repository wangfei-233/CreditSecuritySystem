package com.yinuo.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinuo.common.annotation.Log;
import com.yinuo.common.controller.BaseController;
import com.yinuo.common.domain.QueryRequest;
import com.yinuo.system.domain.Dict;
import com.yinuo.system.service.DictService;
import com.yinuo.web.domain.Info;
import com.yinuo.web.service.InfoService;

@Controller
public class InfoController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InfoService InfoService;
    
    @Autowired
    private DictService dictService;
    
    @RequestMapping("info")
    @RequiresPermissions("info:list")
    public String index(Model model,QueryRequest request) {
    	log.info("{}","info");
    	Dict dict = new Dict();
    	dict.setFieldName("info_type");
    	dict.setTableName("t_info");
    	List<Dict> dicts = dictService.findAllDicts(dict, request);
    	model.addAttribute("types", dicts);
        return "web/info/info";
    }
    
    @Log("获取内容信息")
    @RequestMapping("info/list")
    @RequiresPermissions("info:list")
    @ResponseBody
    public Map<String, Object> infoList(QueryRequest request, Info info) {
        return super.selectByPageNumSize(request, () -> this.InfoService.findInfoWithNameAndInfoType(info));
    }


//    @Log("新增用户")
//    @RequiresPermissions("user:add")
//    @RequestMapping("user/add")
//    @ResponseBody
//    public ResponseBo addUser(User user, Long[] roles) {
//        try {
//            if (ON.equalsIgnoreCase(user.getStatus()))
//                user.setStatus(User.STATUS_VALID);
//            else
//                user.setStatus(User.STATUS_LOCK);
//            this.userService.addUser(user, roles);
//            return ResponseBo.ok("新增用户成功！");
//        } catch (Exception e) {
//            log.error("新增用户失败", e);
//            return ResponseBo.error("新增用户失败，请联系网站管理员！");
//        }
//    }

//    @Log("修改用户")
//    @RequiresPermissions("user:update")
//    @RequestMapping("user/update")
//    @ResponseBody
//    public ResponseBo updateUser(User user, Long[] rolesSelect) {
//        try {
//            if (ON.equalsIgnoreCase(user.getStatus()))
//                user.setStatus(User.STATUS_VALID);
//            else
//                user.setStatus(User.STATUS_LOCK);
//            this.userService.updateUser(user, rolesSelect);
//            return ResponseBo.ok("修改用户成功！");
//        } catch (Exception e) {
//            log.error("修改用户失败", e);
//            return ResponseBo.error("修改用户失败，请联系网站管理员！");
//        }
//    }

//    @Log("删除用户")
//    @RequiresPermissions("user:delete")
//    @RequestMapping("user/delete")
//    @ResponseBody
//    public ResponseBo deleteUsers(String ids) {
//        try {
//            this.userService.deleteUsers(ids);
//            return ResponseBo.ok("删除用户成功！");
//        } catch (Exception e) {
//            log.error("删除用户失败", e);
//            return ResponseBo.error("删除用户失败，请联系网站管理员！");
//        }
//    }

}

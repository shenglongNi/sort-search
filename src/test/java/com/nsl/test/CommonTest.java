package com.nsl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ni
 * @date 2022-01-18 16:05
 * @description 通用测试类
 */
public class CommonTest {


    @Test
    public void genTreeDataTest() {

        String rawData = "[{\"id\":1,\"label\":\"系统管理\",\"orderNum\":1,\"parentId\":0},{\"id\":2,\"label\":\"权限管理\",\"orderNum\":2,\"parentId\":0},{\"id\":3,\"label\":\"字典管理\",\"orderNum\":1,\"parentId\":1},{\"id\":4,\"label\":\"参数管理\",\"orderNum\":2,\"parentId\":1},{\"id\":5,\"label\":\"岗位管理\",\"orderNum\":1,\"parentId\":2},{\"id\":6,\"label\":\"部门管理\",\"orderNum\":2,\"parentId\":2},{\"id\":7,\"label\":\"菜单管理\",\"orderNum\":3,\"parentId\":2},{\"id\":8,\"label\":\"角色管理\",\"orderNum\":4,\"parentId\":2},{\"id\":9,\"label\":\"用户管理\",\"orderNum\":5,\"parentId\":2},{\"id\":10,\"label\":\"dvAdmin官网\",\"orderNum\":9,\"parentId\":0},{\"id\":11,\"label\":\"文件管理\",\"orderNum\":3,\"parentId\":1},{\"id\":13,\"label\":\"用户新增\",\"orderNum\":1,\"parentId\":9},{\"id\":14,\"label\":\"用户修改\",\"orderNum\":2,\"parentId\":9},{\"id\":15,\"label\":\"用户删除\",\"orderNum\":3,\"parentId\":9},{\"id\":16,\"label\":\"用户导出\",\"orderNum\":4,\"parentId\":9},{\"id\":17,\"label\":\"用户导入\",\"orderNum\":5,\"parentId\":9},{\"id\":18,\"label\":\"重置密码\",\"orderNum\":6,\"parentId\":9},{\"id\":19,\"label\":\"角色新增\",\"orderNum\":1,\"parentId\":8},{\"id\":20,\"label\":\"角色修改\",\"orderNum\":2,\"parentId\":8},{\"id\":21,\"label\":\"删除角色\",\"orderNum\":3,\"parentId\":8},{\"id\":22,\"label\":\"角色导出\",\"orderNum\":4,\"parentId\":8},{\"id\":23,\"label\":\"菜单新增\",\"orderNum\":1,\"parentId\":7},{\"id\":24,\"label\":\"菜单修改\",\"orderNum\":2,\"parentId\":7},{\"id\":25,\"label\":\"菜单删除\",\"orderNum\":3,\"parentId\":7},{\"id\":26,\"label\":\"部门新增\",\"orderNum\":1,\"parentId\":6},{\"id\":27,\"label\":\"部门修改\",\"orderNum\":2,\"parentId\":6},{\"id\":28,\"label\":\"部门删除\",\"orderNum\":3,\"parentId\":6},{\"id\":29,\"label\":\"岗位新增\",\"orderNum\":1,\"parentId\":5},{\"id\":30,\"label\":\"岗位修改\",\"orderNum\":2,\"parentId\":5},{\"id\":31,\"label\":\"岗位删除\",\"orderNum\":3,\"parentId\":5},{\"id\":32,\"label\":\"岗位导出\",\"orderNum\":4,\"parentId\":5},{\"id\":33,\"label\":\"字典新增\",\"orderNum\":1,\"parentId\":3},{\"id\":34,\"label\":\"字典修改\",\"orderNum\":2,\"parentId\":3},{\"id\":35,\"label\":\"字典删除\",\"orderNum\":3,\"parentId\":3},{\"id\":36,\"label\":\"字典导出\",\"orderNum\":4,\"parentId\":3},{\"id\":37,\"label\":\"清理缓存\",\"orderNum\":5,\"parentId\":3},{\"id\":38,\"label\":\"参数新增\",\"orderNum\":1,\"parentId\":4},{\"id\":39,\"label\":\"参数修改\",\"orderNum\":2,\"parentId\":4},{\"id\":40,\"label\":\"参数删除\",\"orderNum\":3,\"parentId\":4},{\"id\":41,\"label\":\"参数导出\",\"orderNum\":4,\"parentId\":4},{\"id\":42,\"label\":\"清理缓存\",\"orderNum\":5,\"parentId\":4},{\"id\":43,\"label\":\"文件上传\",\"orderNum\":1,\"parentId\":11},{\"id\":44,\"label\":\"文件删除\",\"orderNum\":2,\"parentId\":11},{\"id\":45,\"label\":\"清理废弃文件\",\"orderNum\":3,\"parentId\":11},{\"id\":46,\"label\":\"文件下载\",\"orderNum\":4,\"parentId\":11},{\"id\":47,\"label\":\"通知公告\",\"orderNum\":4,\"parentId\":1},{\"id\":48,\"label\":\"发布公告\",\"orderNum\":1,\"parentId\":47},{\"id\":49,\"label\":\"修改公告\",\"orderNum\":2,\"parentId\":47},{\"id\":50,\"label\":\"删除公告\",\"orderNum\":3,\"parentId\":47},{\"id\":51,\"label\":\"公告导出\",\"orderNum\":4,\"parentId\":47},{\"id\":52,\"label\":\"字典查询\",\"orderNum\":0,\"parentId\":3},{\"id\":53,\"label\":\"参数查询\",\"orderNum\":0,\"parentId\":4},{\"id\":54,\"label\":\"文件查询\",\"orderNum\":0,\"parentId\":11},{\"id\":55,\"label\":\"公告查询\",\"orderNum\":0,\"parentId\":47},{\"id\":56,\"label\":\"岗位查询\",\"orderNum\":0,\"parentId\":5},{\"id\":57,\"label\":\"部门查询\",\"orderNum\":0,\"parentId\":6},{\"id\":58,\"label\":\"菜单查询\",\"orderNum\":0,\"parentId\":7},{\"id\":59,\"label\":\"角色查询\",\"orderNum\":0,\"parentId\":8},{\"id\":60,\"label\":\"用户查询\",\"orderNum\":0,\"parentId\":9},{\"id\":61,\"label\":\"日志管理\",\"orderNum\":5,\"parentId\":1},{\"id\":62,\"label\":\"登录日志\",\"orderNum\":1,\"parentId\":61},{\"id\":63,\"label\":\"操作日志\",\"orderNum\":2,\"parentId\":61},{\"id\":64,\"label\":\"登录日志查询\",\"orderNum\":1,\"parentId\":62},{\"id\":65,\"label\":\"操作日志查询\",\"orderNum\":1,\"parentId\":63},{\"id\":66,\"label\":\"系统监控\",\"orderNum\":3,\"parentId\":0},{\"id\":70,\"label\":\"定时任务\",\"orderNum\":2,\"parentId\":66},{\"id\":71,\"label\":\"任务查询\",\"orderNum\":1,\"parentId\":70},{\"id\":72,\"label\":\"任务新增\",\"orderNum\":2,\"parentId\":70},{\"id\":73,\"label\":\"任务修改\",\"orderNum\":3,\"parentId\":70},{\"id\":74,\"label\":\"任务删除\",\"orderNum\":4,\"parentId\":70},{\"id\":75,\"label\":\"任务单次执行\",\"orderNum\":6,\"parentId\":70},{\"id\":76,\"label\":\"任务导出\",\"orderNum\":5,\"parentId\":70},{\"id\":77,\"label\":\"登录日志导出\",\"orderNum\":2,\"parentId\":62},{\"id\":78,\"label\":\"操作日志导出\",\"orderNum\":2,\"parentId\":63},{\"id\":79,\"label\":\"定时日志\",\"orderNum\":3,\"parentId\":61},{\"id\":80,\"label\":\"定时日志查询\",\"orderNum\":1,\"parentId\":79},{\"id\":81,\"label\":\"定时日志导出\",\"orderNum\":2,\"parentId\":79},{\"id\":82,\"label\":\"系统工具\",\"orderNum\":4,\"parentId\":0},{\"id\":83,\"label\":\"表单构建\",\"orderNum\":1,\"parentId\":82},{\"id\":84,\"label\":\"系统接口\",\"orderNum\":2,\"parentId\":82},{\"id\":85,\"label\":\"操作日志批量删除\",\"orderNum\":3,\"parentId\":63},{\"id\":86,\"label\":\"操作日志清空\",\"orderNum\":4,\"parentId\":63},{\"id\":87,\"label\":\"登录日志批量删除\",\"orderNum\":3,\"parentId\":62},{\"id\":88,\"label\":\"登录日志清空\",\"orderNum\":4,\"parentId\":62},{\"id\":90,\"label\":\"定时日志批量删除\",\"orderNum\":3,\"parentId\":79},{\"id\":91,\"label\":\"定时日志清空\",\"orderNum\":4,\"parentId\":79},{\"id\":92,\"label\":\"服务监控\",\"orderNum\":3,\"parentId\":66},{\"id\":93,\"label\":\"服务监控查询\",\"orderNum\":1,\"parentId\":92},{\"id\":94,\"label\":\"修改服务器信息\",\"orderNum\":2,\"parentId\":92},{\"id\":95,\"label\":\"修改监控信息\",\"orderNum\":3,\"parentId\":92},{\"id\":96,\"label\":\"清空监控记录\",\"orderNum\":4,\"parentId\":92},{\"id\":97,\"label\":\"首页\",\"orderNum\":0,\"parentId\":0}]";

        JSONArray jsonData = JSONArray.parseArray(rawData);

        //获取rootId
        Integer rootId = jsonData.stream().map(item -> ((JSONObject) item).getInteger("parentId")).min(Comparator.comparing(item -> item)).get();

        List<JSONObject> retData = jsonData.stream().filter(item -> toJSONObject(item).getInteger("parentId") == 0).map(item -> convert(toJSONObject(item), jsonData)).collect(Collectors.toList());

        System.out.println(retData);
    }

    private JSONObject convert(JSONObject obj, JSONArray rawData) {

        for (Object jsonObj : rawData) {
            if (toJSONObject(jsonObj).getInteger("parentId") == obj.getInteger("id")) {
                JSONArray arr = obj.getJSONArray("children");
                if (arr == null) {
                    arr = new JSONArray();
                    obj.put("children", arr);
                }
                arr.add(toJSONObject(jsonObj));
                convert(toJSONObject(jsonObj), rawData);
            }
        }

        return obj;
    }


    private static JSONObject toJSONObject(Object jsonObj) {
        return (JSONObject) jsonObj;
    }

}

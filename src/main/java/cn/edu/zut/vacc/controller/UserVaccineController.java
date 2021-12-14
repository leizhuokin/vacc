package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.po.UserVaccine;
import cn.edu.zut.vacc.service.UserService;
import cn.edu.zut.vacc.service.UserVaccineService;
import cn.edu.zut.vacc.vo.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/user-vaccine")
public class UserVaccineController {
    @Autowired
    UserVaccineService userVaccineService;

    /**
     *查询所有用户
     * @return
     */
    @PostMapping("/list")
    public List<UserVaccine> list(){
        return userVaccineService.list();
    }
    @PostMapping("/selectUVAll")
    @ResponseBody
    public IPage<UserVaccine> selectUVAll(Page<UserVaccine> page){
        IPage<UserVaccine> userIPage=userVaccineService.selectUVAll(page);
        return userIPage;
    }
    /**
     * 模糊查询
     * @param page
     * @param id
     * @return
     */
    @RequestMapping("/queryUserName")
    @ResponseBody
    public IPage<UserVaccine> queryUserName(Page<UserVaccine> page,Integer id){
        IPage<UserVaccine> userIPage=userVaccineService.queryUVserName(page,id);
        return userIPage;
    }
    /**
     * 添加数据
     * @param userVaccine
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public int UVadd(UserVaccine userVaccine){
        int i = userVaccineService.UVadd(userVaccine);
        if (i >= 1) {
            return i;
        }else {
            return 0;
        }
    }

    /**
     * 更新数据
     * @param userVaccine
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUVser(UserVaccine userVaccine){
        System.out.println("执行了 updateUser");
        int i = userVaccineService.updateUVser(userVaccine);
        if (i >= 1) {
            return i;
        }else {
            return 0;
        }
    }

    /**
     * 根据id删除数据
     * @param
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(UserVaccine userVaccine){
        int i = userVaccineService.deleteUVser(userVaccine);
        if (i >=1) {
            return i;
        }else {
            return 0;
        }
    }

    @PostMapping("/batch")
    public Result addBatch(@RequestBody  List<UserVaccine> userVaccine){
        return userVaccineService.saveBatch(userVaccine)?Result.ok("保存成功"):Result.error("保存失败");

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteBatch(@RequestBody List<Integer> ids){
        return userVaccineService.removeByIds(ids)?Result.ok("删除成功"):Result.error("删除失败");

    }

}

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
     * 添加数据
     * @param userVaccine
     * @return
     */
    @PostMapping
    public Result add(@RequestBody UserVaccine userVaccine){
        return userVaccineService.save(userVaccine)?Result.ok("保存成功"):Result.error("保存失败");

    }

    /**
     * 更新数据
     * @param userVaccine
     * @return
     */
    @PutMapping
    public Result update(@RequestBody  UserVaccine userVaccine){
        return userVaccineService.updateById(userVaccine)?Result.ok("修改成功"):Result.error("修改失败");

    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return userVaccineService.removeById(id)?Result.ok("删除成功"):Result.error("删除失败");

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

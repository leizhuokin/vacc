package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.service.UserService;
import cn.edu.zut.vacc.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wang
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    @PostMapping
    public Result add(@RequestBody  User user){
        return userService.save(user)?Result.ok("保存成功"):Result.error("保存失败");

    }
    @PutMapping
    public Result update(@RequestBody  User user){
        return userService.updateById(user)?Result.ok("修改成功"):Result.error("修改失败");

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return userService.removeById(id)?Result.ok("删除成功"):Result.error("删除失败");

    }
    @PostMapping("/batch")
    public Result addBatch(@RequestBody  List<User> user){
        return userService.saveBatch(user)?Result.ok("保存成功"):Result.error("保存失败");

    }
    @DeleteMapping
    public Result deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids)?Result.ok("删除成功"):Result.error("删除失败");

    }
}


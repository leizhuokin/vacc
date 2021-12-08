package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.service.UserService;
import cn.edu.zut.vacc.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user前端控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 查询所有用户
     * @return
     */
    @PostMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    /**
     * 根据id查询用户
     * @param ids
     * @return
     */
    @PostMapping("/listByIds")
    public List<User> listById(@RequestBody List<Integer> ids){
        return userService.listByIds(ids);
    }
    /**
     * 添加数据
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@RequestBody  User user){
        return userService.save(user)?Result.ok("保存成功"):Result.error("保存失败");

    }
    @PostMapping("/batch")
    public Result addBatch(@RequestBody  List<User> user){
        return userService.saveBatch(user)?Result.ok("保存成功"):Result.error("保存失败");

    }
    /**
     * 更新数据
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody  User user){
        return userService.updateById(user)?Result.ok("修改成功"):Result.error("修改失败");

    }
    /**
     * 根据Id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return userService.removeById(id)?Result.ok("删除成功"):Result.error("删除失败");

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids)?Result.ok("删除成功"):Result.error("删除失败");
    }
    /**
     * 多表连接查询数据(疫苗接种情况查询)
     */
    @PostMapping("/listAll")
    public  List<User> listAll(){
        return userService.listAll();
    }
}

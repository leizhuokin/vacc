package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.po.Result;
import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有记录
     * @return
     */
    @GetMapping("/getAllUser")
    public Page<User> getAllUser() {
        List<User> list = userService.list();
        for (User user : list) {
            log.info(user.toString());
        }
        //构建分页对象
        Page<User> userPage = new Page<>(2,2);
        //第一个参数为分页对象，第二个为查询条件（可以不写）
        Page<User> page = userService.page(userPage, null);
        log.info("总页码：" + page.getPages());
        log.info("总记录数：" + page.getTotal());
        return page;
    }

    /**
     * 根据id获取数据
     * @param
     * @return
     */
    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    public Result getUserById(@RequestBody User user){
        log.info("收到了请求：" + user.getId());
        User userSelect = userService.getById(user.getId());
        log.info("查到了对象：" + userSelect);
        return Result.ok(userSelect);
    }

    /**
     * 根据id更新数据
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody User user){
        boolean ret = userService.updateById(user);
        if (!ret){
            return Result.build(-1,"更新失败");
        }
        return Result.ok();
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result saveUser(@RequestBody User user){
        try {
            boolean ret = userService.save(user);
            if (!ret){
                return Result.build(-1,"新增失败");
            }
            return Result.ok();
        } catch (Exception e) {
            return Result.build(-1,e.getMessage());
        }
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/delete")
    public Result deleteUser(@RequestBody User user){
        try {
            boolean ret = userService.removeById(user.getId());
            if (!ret){
                return Result.build(-1,"删除失败");
            }
            return Result.ok();
        } catch (Exception e) {
            return Result.build(-1,e.getMessage());
        }
    }
}


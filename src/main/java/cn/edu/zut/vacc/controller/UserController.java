package cn.edu.zut.vacc.controller;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * user前端控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ModelAndView login(String username, String password, ModelAndView mav){
        Boolean result = userService.login(username,password);
        if(result){
            List<User> users = userService.list();
            mav.setViewName("menu");
            mav.addObject("msg","登录成功");
            mav.addObject("users",users);
        }else{
            mav.setViewName("index");
            mav.addObject("msg","用户名或密码错误");
        }
        return mav;
    }
    /**
     * 分页查询查询所有用户
     * @return
     */
    @PostMapping("/selectUserAll")
    @ResponseBody
    public IPage<User> selectUserAll(Page<User> page){
        IPage<User> userIPage=userService.selectUserAll(page);
        return userIPage;
    }

    /**
     * 模糊查询
     * @param page
     * @param number
     * @return
     */
    @RequestMapping("/queryUserName")
    @ResponseBody
    public IPage<User> queryUserName(Page<User> page,String number){
        IPage<User> userIPage=userService.queryUserName(page,number);
        return userIPage;
    }

    /**
     * 添加数据
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public int add(User user){
        int i = userService.add(user);
        if (i >= 1) {
            return i;
        }else {
            return 0;
        }
    }
    /**
     * 更新数据
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public int update(User user){
        int i = userService.updateUser(user);
        if (i >= 1) {
            return i;
        }else {
            return 0;
      }
    }
    /**
     * 根据Id删除数据
     * @param
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(User user){
        int i = userService.deleteUser(user);
        if (i >=1) {
            return i;
        }else {
            return 0;
        }
    }
    /**
     * 多表连接查询数据(疫苗接种情况查询)
     */
    @PostMapping("/listAll")
    public  List<User> listAll(){
        return userService.listAll();
    }
}

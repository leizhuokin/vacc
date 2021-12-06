package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

}

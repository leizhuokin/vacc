package cn.edu.zut.vacc.service.impl;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.mapper.UserMapper;
import cn.edu.zut.vacc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

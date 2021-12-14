package cn.edu.zut.vacc.service.impl;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.mapper.UserMapper;
import cn.edu.zut.vacc.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public Boolean login(String username, String password) {
        User user = userMapper.login(username);
        return user!=null && user.getPassword().equals(password);
    }

    @Override
    public IPage<User> selectUserAll(Page<User> page) {
        return userMapper.selectUserAll(page);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public IPage<User> queryUserName(Page<User> page,String number) {
        IPage<User> userIPage = userMapper.queryUserName(page,number);
        return userIPage;
    }

    @Override
    public int add(User user) {
        return userMapper.addUser(user);
    }
}

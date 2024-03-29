package cn.edu.zut.vacc.service;

import cn.edu.zut.vacc.po.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2021-12-05
 */
@Mapper
public interface UserService extends IService<User> {

    List<User> listAll();

    Boolean login(String username, String password);

    IPage<User> selectUserAll(Page<User> page);

    int updateUser(User user);

    int deleteUser(User user);

    IPage<User> queryUserName(Page<User> page,String number);

    int add(User user);
}

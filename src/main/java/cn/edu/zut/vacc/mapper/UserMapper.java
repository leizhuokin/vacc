package cn.edu.zut.vacc.mapper;

import cn.edu.zut.vacc.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> listAll();

    User login(String username);

    IPage<User> selectUserAll(Page<User> page);

    int updateUser(User user);
}

package cn.edu.zut.vacc.mapper;

import cn.edu.zut.vacc.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}

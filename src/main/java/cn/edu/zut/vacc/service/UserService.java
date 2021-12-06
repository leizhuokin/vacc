package cn.edu.zut.vacc.service;

import cn.edu.zut.vacc.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Mapper
public interface UserService extends IService<User> {

}

package cn.edu.zut.vacc.service;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.po.Vaccine;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface VaccineService extends IService<Vaccine> {
    IPage<Vaccine> selectVaccineAll(Page<Vaccine> page);
}

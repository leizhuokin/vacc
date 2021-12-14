package cn.edu.zut.vacc.mapper;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.po.UserVaccine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
public interface UserVaccineMapper extends BaseMapper<UserVaccine> {

    IPage<UserVaccine> selectUVAll(Page<UserVaccine> page);

    int updateUVser(UserVaccine userVaccine);

    int UVadd(UserVaccine userVaccine);

    IPage<UserVaccine> queryUVserName(Page<UserVaccine> page, String inoculationTime);

    int deleteUVser(UserVaccine userVaccine);
}

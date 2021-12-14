package cn.edu.zut.vacc.service.impl;

import cn.edu.zut.vacc.mapper.VaccineMapper;
import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.po.UserVaccine;
import cn.edu.zut.vacc.mapper.UserVaccineMapper;
import cn.edu.zut.vacc.service.UserVaccineService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserVaccineServiceImpl extends ServiceImpl<UserVaccineMapper, UserVaccine> implements UserVaccineService {
    @Autowired
    UserVaccineMapper uservaccineMapper;
    @Override
    public IPage<UserVaccine> selectUVAll(Page<UserVaccine> page) {
        return uservaccineMapper.selectUVAll(page);
    }
    @Override
    public int updateUVser(UserVaccine userVaccine) {
        return uservaccineMapper.updateUVser(userVaccine);
    }
    @Override
    public int deleteUVser(UserVaccine userVaccine) {
        return uservaccineMapper.deleteUVser(userVaccine);
    }
    @Override
    public IPage<UserVaccine> queryUVserName(Page<UserVaccine> page,String inoculationTime) {
        IPage<UserVaccine> userIPage = uservaccineMapper.queryUVserName(page,inoculationTime);
        return userIPage;
    }
    @Override
    public int UVadd(UserVaccine userVaccine) {
        return uservaccineMapper.UVadd(userVaccine);
    }
}

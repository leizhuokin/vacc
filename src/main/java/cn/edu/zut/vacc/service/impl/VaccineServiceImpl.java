package cn.edu.zut.vacc.service.impl;

import cn.edu.zut.vacc.mapper.UserMapper;
import cn.edu.zut.vacc.po.Vaccine;
import cn.edu.zut.vacc.mapper.VaccineMapper;
import cn.edu.zut.vacc.service.VaccineService;
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
public class VaccineServiceImpl extends ServiceImpl<VaccineMapper, Vaccine> implements VaccineService {
    @Autowired
    VaccineMapper vaccineMapper;
    @Override
    public IPage<Vaccine> selectVaccineAll(Page<Vaccine> page) {
        return vaccineMapper.selectVaccineAll(page);
    }
}

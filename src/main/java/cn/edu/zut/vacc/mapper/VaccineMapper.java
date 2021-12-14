package cn.edu.zut.vacc.mapper;

import cn.edu.zut.vacc.po.User;
import cn.edu.zut.vacc.po.Vaccine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Mapper
public interface VaccineMapper extends BaseMapper<Vaccine> {
    IPage<Vaccine> selectVaccineAll(Page<Vaccine> page);

    int updateVaccine(Vaccine vaccine);

    int deleteVaccine(Vaccine vaccine);

    IPage<Vaccine> queryVaccineName(Page<Vaccine> page, String vno);

    int addVaccine(Vaccine vaccine);
}

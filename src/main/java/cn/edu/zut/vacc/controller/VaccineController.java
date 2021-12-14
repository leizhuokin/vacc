package cn.edu.zut.vacc.controller;


import cn.edu.zut.vacc.po.UserVaccine;
import cn.edu.zut.vacc.po.Vaccine;
import cn.edu.zut.vacc.service.VaccineService;
import cn.edu.zut.vacc.vo.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    /**
     * 模糊查询
     * @param page
     * @param vno
     * @return
     */
    @RequestMapping("/queryVaccineName")
    @ResponseBody
    public IPage<Vaccine> queryVaccineName(Page<Vaccine> page,String vno){
        IPage<Vaccine> userIPage=vaccineService.queryVaccineName(page,vno);
        return userIPage;
    }
    /**
     * 添加数据
     * @param Vaccine
     * @return
     */
    @RequestMapping("/addVaccine")
    @ResponseBody
    public int addVaccine(Vaccine Vaccine){
        int i = vaccineService.addVaccine(Vaccine);
        if (i >= 1) {
            return i;
        }else {
            return 0;
        }
    }
    @PostMapping("/selectVaccineAll")
    @ResponseBody
    public IPage<Vaccine> selectVaccineAll(Page<Vaccine> page){
        IPage<Vaccine> vaccineIPage=vaccineService.selectVaccineAll(page);
        return vaccineIPage;
    }

    /**
     * 更新数据
     * @param vaccine
     * @return
     */
    @RequestMapping("/updateVaccine")
    @ResponseBody
    public int updateVaccine(Vaccine vaccine){
        System.out.println("执行了 updateUser");
        int i = vaccineService.updateVaccine(vaccine);
        if (i >= 1) {
            return i;
        }else {
            return 0;
        }
    }

    /**
     * 根据id删除数据
     * @param
     * @return
     */
    @RequestMapping("/deleteVaccine")
    @ResponseBody
    public int deleteVaccine(Vaccine Vaccine){
        int i = vaccineService.deleteVaccine(Vaccine);
        if (i >=1) {
            return i;
        }else {
            return 0;
        }
    }

}

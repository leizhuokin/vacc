package cn.edu.zut.vacc.controller;


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
    @PostMapping("/list")
    public List<Vaccine> list(){
        return vaccineService.list();
    }

    /**
     * 添加数据
     * @param vaccine
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Vaccine vaccine){
        return vaccineService.save(vaccine)?Result.ok("保存成功"):Result.error("保存失败");

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
    @PutMapping
    public Result update(@RequestBody  Vaccine vaccine){
        return vaccineService.updateById(vaccine)?Result.ok("修改成功"):Result.error("修改失败");

    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return vaccineService.removeById(id)?Result.ok("删除成功"):Result.error("删除失败");

    }
    @PostMapping("/batch")
    public Result addBatch(@RequestBody  List<Vaccine> vaccine){
        return vaccineService.saveBatch(vaccine)?Result.ok("保存成功"):Result.error("保存失败");

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteBatch(@RequestBody List<Integer> ids){
        return vaccineService.removeByIds(ids)?Result.ok("删除成功"):Result.error("删除失败");

    }
}

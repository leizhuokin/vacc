package cn.edu.zut.vacc.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_vaccine")
public class UserVaccine extends Model<UserVaccine> {

    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接种时间
     */
    @TableField("inoculation_time")
    private LocalDateTime inoculationTime;

    /**
     * 接种人员ID
     */
    @TableField("uid")
    private Integer uid;

    /**
     * 疫苗ID
     */
    @TableField("vid")
    private Integer vid;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}

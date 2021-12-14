package cn.edu.zut.vacc.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.sql.Date;
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
@TableName("vaccine")
public class Vaccine extends Model<Vaccine> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "vid", type = IdType.AUTO)
    private Integer vid;

    /**
     * 疫苗编号
     */
    @TableField("vno")
    private String vno;

    /**
     * 疫苗名称
     */
    @TableField("vname")
    private String vname;

    /**
     * 疫苗类别
     */
    @TableField("ssex")
    private String ssex;

    /**
     * 生产日期
     */
    @TableField("pro_time")
    private Date proTime;

    /**
     * 有效期
     */
    @TableField("exp")
    private String exp;


    @Override
    public Serializable pkVal() {
        return this.vid;
    }

}

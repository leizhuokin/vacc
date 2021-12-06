package cn.edu.zut.vacc.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("user")
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 身份证号码
     */
    @TableField("number")
    private String number;

    /**
     * 密码：加密存储
     */
    @TableField("password")
    private String password;

    /**
     * 昵称：保证唯一
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 性别：默认为0保密,1为男，2为女
     */
    @TableField("gender")
    private Boolean gender;

    /**
     * 手机号：保证唯一
     */
    @TableField("phone")
    private String phone;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 预约时间
     */
    @TableField("order_time")
    private LocalDateTime orderTime;


    @Override
    public Serializable pkVal() {
        return this.uid;
    }

    public Serializable getId() {return null;
    }
}

package cn.edu.zut.vacc.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer gender;

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
    private Date birthday;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 预约时间
     */
    @TableField("order_time")
    private Date orderTime;

}

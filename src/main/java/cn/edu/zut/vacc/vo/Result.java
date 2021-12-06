package cn.edu.zut.vacc.vo;
import lombok.Data;

/**
 * @author ：王志恒（1024044696@qq.com）
 * @date ：Created in 2021/12/5 16:52
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result ok(String msg,Object data){
        return new Result(200,msg,data);
    }
    public static Result ok(String msg){
        return new Result(200,msg);
    }
    public static Result error(String msg){
        return new Result(1,msg);
    }
    public static Result error(Integer code,String msg){
        return new Result(code,msg);
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

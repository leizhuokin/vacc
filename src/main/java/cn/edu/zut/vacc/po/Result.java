package cn.edu.zut.vacc.po;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ：王志恒（1024044696@qq.com）
 * @date ：Created in 2021/12/6 9:32
 * @description：
 * @modified By：
 * @version:
 */
public class Result {
    private static final ObjectMapper MAPPER =new ObjectMapper();
    private Integer status;
    private String mgs;
    private Object data;
    public  Result(){
    }
    public Result(Integer status,String mgs ,Object data){
        this.status=status;
        this.mgs=mgs;
        this.data=data;
    }
    public Result(Object data){
        this.status=0;
        this.mgs="OK";
        this.data=data;
    }
    public static Result ok(){
        return new Result(null);
    }
    public static Result ok(Object data){
        return new Result(data);
    }
    public static Result build(Integer status ,String mgs){
        return new Result(status,mgs,null);
    }
    public static Result build(Integer status,String mgs,Object data){
        return new Result(status,mgs,data);
    }
}


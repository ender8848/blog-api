package blog.api.common;


import blog.api.enums.HttpStatus;
import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    public static <T> Result<T> success(HttpStatus httpStatus,T object){
        Result r = new Result();
        r.code = httpStatus.status();
        r.msg = httpStatus.msg();
        r.data = object;
        return r;
    }


    public static <T> Result<T> success(HttpStatus httpStatus){
        Result r = new Result();
        r.code = httpStatus.status();
        r.msg = httpStatus.msg();
        return r;
    }

    public static <T> Result<T> error(HttpStatus httpStatus){
        Result r = new Result();
        r.code = httpStatus.status();
        r.msg = httpStatus.msg();
        return r;
    }

}

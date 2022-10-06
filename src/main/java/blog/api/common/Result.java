package blog.api.common;


import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据



    public static <T> Result<T> success(Integer code,String msg,T object) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static <T> Result<T> error(Integer code,String msg) {
        Result r = new Result();
        r.code = code;
        r.msg = msg;
        return r;
    }
}

package per.javee.hitit.common.method;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 通用Response数据返回值的包装类.
 */
@Data
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 3641988897219827606L;
    private int code = 200;
    private String message = "";
    private T data;

    public ResponseData() {
    }

    private ResponseData(T data) {
        this.data = data;
    }

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static  <T>  ResponseData<T>  instance(T data) {
        return new ResponseData<>(data);
    }

    @SuppressWarnings("rawtypes")
	public static ResponseData instance(int code, String message) {
        ResponseData<ArrayList> responseData = new ResponseData<>(code, message);
        responseData.setData(new ArrayList());
        return responseData;
    }

    public static <T> ResponseData<T> instance(int code, String message,T data) {
        ResponseData<T> responseData = new ResponseData<>(code, message);
        responseData.setData(data);
        return responseData;
    }

}

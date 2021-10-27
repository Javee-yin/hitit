package per.javee.hitit.common.entity;

import lombok.Data;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/27 17:40
 * @Description:
 */
@Data
public class StringReturnData {
    private String data;

    private StringReturnData(String data) {
        this.data = data;
    }
    public static StringReturnData instance(String data) {
        return new StringReturnData(data);
    }

}

package response;


/**
 * @program: alibaba.cloud.common
 * @description: 通用返回枚举
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
public enum ResponseEnum {

    SUCCESS(200, "成功"),
    FAILED(100, "失败");

    private Integer code;

    private String msg;

    ResponseEnum() {
    }

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

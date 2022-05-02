package response;

/**
 * @program: alibaba.cloud.message
 * @description: 通用返回对象
 * @author: JianSong Ye
 * @create: 2022-05-02 16:30
 **/
public class ResponseMessage {

    public Integer code;
    public String msg;
    public Object data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMessage(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 通用成功返回
     *
     * @return ResponseMessage
     */
    public static ResponseMessage success() {
        return new ResponseMessage(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    /**
     * 通用失败返回
     *
     * @return ResponseMessage
     */
    public static ResponseMessage fail() {
        return new ResponseMessage(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg());
    }

    /**
     * 通用成功返回
     *
     * @param data 返回的数据
     * @return ResponseMessage
     */
    public static ResponseMessage success(Object data) {
        return new ResponseMessage(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

}

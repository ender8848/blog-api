package blog.api.enums;

public enum HttpStatus {
    SUCCESS(200, "请求成功"),
    FAIL(400, "请求失败"),
    UNAUTHORIZED(401, "无权权限");

    private int status;
    private String msg;

    HttpStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int status() {
        return status;
    }

    public String msg() {
        return msg;
    }
}

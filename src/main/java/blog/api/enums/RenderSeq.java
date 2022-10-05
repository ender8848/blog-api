package blog.api.enums;

public enum RenderSeq {
    BY_ID(0, "按id从大到小排序"),
    BY_UPDATE_TIME(1, "按修改时间从近到远排序");

    private int code;
    private String desc;

    RenderSeq(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}

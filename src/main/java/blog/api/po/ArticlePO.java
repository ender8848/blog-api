package blog.api.po;

import java.util.Date;

public class ArticlePO {
    private Long id;

    private Long user_id;

    private String title;

    private Long sort_id;

    private Long view_count;

    private Long thumb_count;

    private Long comment_count;

    private Date create_time;

    private Date update_time;

    private Integer status;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getSort_id() {
        return sort_id;
    }

    public void setSort_id(Long sort_id) {
        this.sort_id = sort_id;
    }

    public Long getView_count() {
        return view_count;
    }

    public void setView_count(Long view_count) {
        this.view_count = view_count;
    }

    public Long getThumb_count() {
        return thumb_count;
    }

    public void setThumb_count(Long thumb_count) {
        this.thumb_count = thumb_count;
    }

    public Long getComment_count() {
        return comment_count;
    }

    public void setComment_count(Long comment_count) {
        this.comment_count = comment_count;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
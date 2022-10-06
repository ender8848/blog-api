package blog.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleDTO {
    private long user_id;
    String title;
    String content;
    long sort_id;
    List<Long> label_id_list;
}

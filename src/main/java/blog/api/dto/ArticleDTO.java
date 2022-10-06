package blog.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleDTO {
    private Long user_id;
    private Long article_id;
    String title;
    String content;
    long sort_id;
    List<Long> label_id_list;
}

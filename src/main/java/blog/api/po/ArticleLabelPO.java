package blog.api.po;

import lombok.Data;

@Data
public class ArticleLabelPO {
    private long id;
    private long article_id;
    private long label_id;
}

package blog.api.dto;

import lombok.Data;

@Data
public class SortDTO {
    private long user_id;
    private String name;
    private String alias;
    private String description;
    private long parent_id;
}

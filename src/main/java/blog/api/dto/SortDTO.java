package blog.api.dto;

import lombok.Data;

@Data
public class SortDTO {
    private Long sort_id;
    private Long user_id;
    private String name;
    private String alias;
    private String description;
    private Long parent_id;
}

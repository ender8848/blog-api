package blog.api.service;

import blog.api.po.SortPO;

/* 后台服务 */
public interface BackgroundService {
    public boolean isValidUser(String username, long password);

    public SortPO addSort(long userId, String name, String alias, String description, Long parentId);

    public SortPO editSort(long sortId, String name, String alias, String description, Long parentId);
}

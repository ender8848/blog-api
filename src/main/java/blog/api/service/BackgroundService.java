package blog.api.service;

import blog.api.enums.HttpStatus;

/* 后台服务 */
public interface BackgroundService {
    public HttpStatus checkUser(String username, long password);
}

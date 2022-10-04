-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint(20)                    NOT NULL COMMENT '用户id',
    `ip`          bigint(255)                   NOT NULL COMMENT '用户IP',
    `username`    VARCHAR(32)                   NOT NULL COMMENT '用户名',
    `nickname`    VARCHAR(32)                   NOT NULL COMMENT '用户昵称',
    `password`    bigint(20)                    NOT NULL COMMENT '用户密码',
    `email`       varchar(255)                  NOT NULL COMMENT '用户邮箱',
    `image`       varchar(255) COLLATE utf8_bin NOT NULL COMMENT '头像',
    `birthday`    datetime                      NOT NULL COMMENT '用户生日',
    `age`         bigint(20)                    NOT NULL COMMENT '用户年龄',
    `sex`         varchar(2) COLLATE utf8_bin   NOT NULL COMMENT '性别',
    `phone`       varchar(11) COLLATE utf8_bin  NOT NULL COMMENT '手机号',
    `status`      int(11)                       NOT NULL DEFAULT '1' COMMENT '状态 0:禁用，1:正常',
    `creat_time`  datetime                               DEFAULT NULL COMMENT '注册时间',
    `update_time` datetime                               DEFAULT NULL COMMENT '信息修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='用户';

-- 文章表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
    `id`            bigint(20)    NOT NULL COMMENT '博文id',
    `user_id`       bigint(20)    NOT NULL COMMENT '发表用户ID',
    `title`         VARCHAR(1024) NOT NULL COMMENT '博文标题',
    `sort_id`       bigint(20)    NOT NULL COMMENT '对应类别id',
    `content`       longtext      NOT NULL COMMENT '博文内容',
    `view_count`         bigint(20)    NOT NULL COMMENT '浏览量',
    `thumb_count`         bigint(20)    NOT NULL COMMENT '点赞量',
    `comment_count` bigint(20)    NOT NULL COMMENT '评论总数',
    `create_time`   datetime               DEFAULT NULL COMMENT '发表时间',
    `update_time`   datetime      NOT NULL COMMENT '更新时间',
    `status`        int(11)       NOT NULL DEFAULT '1' COMMENT '状态0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='博文';


-- 评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`
(
    `id`          bigint(20)   NOT NULL COMMENT '评论id',
    `create_time` datetime              DEFAULT NULL COMMENT '评论时间',
    `thumb`       bigint(20)   NOT NULL COMMENT '点赞量',
    `name`        VARCHAR(32)  NOT NULL COMMENT '评论昵称',
    `email`       varchar(255) NOT NULL COMMENT '评论邮箱',
    `article_id`  bigint(20)   NOT NULL COMMENT '评论文章ID',
    `content`     text         NOT NULL COMMENT '评论内容',
    `parent_id`   bigint(20)   NOT NULL COMMENT '父评论ID',
    `status`      int(11)      NOT NULL DEFAULT '1' COMMENT '状态0未审评 1 审批通过',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='评论';

-- 分类表
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`
(
    `id`          bigint(20) NOT NULL COMMENT '类别id',
    `name`        VARCHAR(32) COMMENT '分类名称',
    `alias`       VARCHAR(32) COMMENT '分类别名',
    `description` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '类别描述',
    `parent_id`   bigint(20) NOT NULL COMMENT '父分类ID',
    `create_time` datetime                      DEFAULT NULL COMMENT '创建时间',
    `status`      int(11)    NOT NULL           DEFAULT '1' COMMENT '分类0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='分类';

-- 标签表
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`
(
    `id`          bigint(20) NOT NULL COMMENT '标签id',
    `name`        VARCHAR(32) COMMENT '标签名称',
    `alias`       VARCHAR(32) COMMENT '标签别名',
    `description` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '标签描述',
    `create_time` datetime                      DEFAULT NULL COMMENT '创建时间',
    `status`      int(11)    NOT NULL           DEFAULT '1' COMMENT '标签0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='标签';


-- 博文标签关联表
DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label`
(
    `id`         bigint(20) NOT NULL COMMENT 'id',
    `article_id` bigint(20) NOT NULL COMMENT '博文id',
    `label_id`   bigint(20) NOT NULL COMMENT '标签id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin COMMENT ='博文标签关系表';
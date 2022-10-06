-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint(20)  NOT NULL COMMENT '用户id',
    `ip`          VARCHAR(32) NOT NULL COMMENT '用户IP',
    `username`    VARCHAR(32) NOT NULL COMMENT '用户名',
    `nickname`    VARCHAR(32) NOT NULL COMMENT '用户昵称',
    `password`    bigint(20)  NOT NULL COMMENT '用户密码',
    `email`       varchar(255) COMMENT '用户邮箱',
    `image`       varchar(255) COMMENT '头像',
    `birthday`    datetime COMMENT '用户生日',
    `age`         bigint(20) COMMENT '用户年龄',
    `sex`         varchar(2) COMMENT '性别',
    `phone`       varchar(11) COMMENT '手机号',
    `status`      int(11)     NOT NULL DEFAULT 1 COMMENT '状态 0:禁用，1:正常',
    `create_time` datetime    NOT NULL DEFAULT now() COMMENT '注册时间',
    `update_time` datetime             DEFAULT NULL COMMENT '信息修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户';

-- 文章表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
    `id`            bigint(20)    NOT NULL COMMENT '博文id',
    `user_id`       bigint(20)    NOT NULL COMMENT '发表用户ID',
    `title`         VARCHAR(1024) NOT NULL COMMENT '博文标题',
    `sort_id`       bigint(20)    NOT NULL COMMENT '对应类别id',
    `content`       longtext      NOT NULL COMMENT '博文内容',
    `view_count`    bigint(20)    NOT NULL DEFAULT 0 COMMENT '浏览量',
    `thumb_count`   bigint(20)    NOT NULL DEFAULT 0 COMMENT '点赞量',
    `comment_count` bigint(20)    NOT NULL DEFAULT 0 COMMENT '评论总数',
    `create_time`   datetime      NOT NULL DEFAULT now() COMMENT '发表时间',
    `update_time`   datetime               DEFAULT NULL COMMENT '更新时间',
    `status`        int(11)       NOT NULL DEFAULT 1 COMMENT '状态0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='博文';

# 简单的文章数据
INSERT INTO `article` (`id`, `user_id`, `title`, `sort_id`, `content`, `view_count`, `thumb_count`, `comment_count`, `create_time`, `update_time`, `status`) VALUES (1, 1, '星球学习', 1, '加入星球后，有任何编程方面的问题都可以 1 对 1 向鱼皮提问 ，鱼皮和大厂嘉宾会帮你解决编程学习的困惑。说明自己的情况后，鱼皮会为你定制目标和学习计划，让你始终知道下一步该做什么，不再迷茫！\r\n\r\n鱼皮已经公开回答过的问题大家都能浏览和评论，可以获得更中肯的建议。对大家普遍比较关心的问题，鱼皮会专门写文章来全面地解答。比如选择读研还是就业这个问题，鱼皮结合自己的经历写了一篇 6000 字的文章：', 0, 0, 0, '2022-10-06 09:22:53', NULL, 1);
INSERT INTO `article` (`id`, `user_id`, `title`, `sort_id`, `content`, `view_count`, `thumb_count`, `comment_count`, `create_time`, `update_time`, `status`) VALUES (2, 1, 'Go学习', 1, 'Go 语言的发展越来越好了，很多大厂使用 Go 作为主要开发语言，也有很多人开始学习 Go，准备转 Go 开发。\n那么，怎么学呢？\n我发现，在互联网时代，学习的困难不是说没有资料，而是资料太多，不知道应该看哪个，从哪开始看。\n所以，我整理了一份 Go 学习路线，这份学习路线不以数量取胜，努力做到精简。从基础到进阶，从理论到实战，一共包括以下几个内容：\n\n入门教程\n进阶教程\n书籍推荐\nWeb 开发\n练手', 0, 0, 0, '2022-10-06 10:21:40', NULL, 1);
INSERT INTO `article` (`id`, `user_id`, `title`, `sort_id`, `content`, `view_count`, `thumb_count`, `comment_count`, `create_time`, `update_time`, `status`) VALUES (3, 1, 'Java', 1, '入门：Java SE基础-->Java Web(含数据库+H5+js+vue)\r\n\r\n中级：Maven-->Git-->SSM框架 -->MybatisPlus-->Spring Boot-->传智健康【项目实战】\r\n\r\n进阶：Spring Cloud(微服务开发,学这一套就够了) 也可分技术点学： (Dubbo-->Zookeeper-->RabbitMQ-->RocketMQ-->Docker-->Redis -->MongoDB-->搜索技术Elasticsearch-->MySQL进阶）\r\n\r\n项目：SaaSiHRM【企业服务】-->好客租房【生活服务】-->万信金融【金融行业】-->闪聚支付【聚合支付】-->权限管理一体化解决方案-->短信网关平台\r\n\r\n以上技术，足以支撑找一份好的java开发工作。', 0, 0, 0, '2022-10-06 13:21:38', NULL, 1);

-- 评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`
(
    `id`          bigint(20)   NOT NULL COMMENT '评论id',
    `create_time` datetime     NOT NULL DEFAULT now() COMMENT '评论时间',
    `thumb_count` bigint(20)   NOT NULL COMMENT '点赞量',
    `name`        VARCHAR(32)  NOT NULL COMMENT '评论昵称',
    `email`       varchar(255) NOT NULL COMMENT '评论邮箱',
    `article_id`  bigint(20)   NOT NULL COMMENT '评论文章ID',
    `user_id`     bigint(20)   NOT NULL COMMENT '发表用户ID',
    `content`     text         NOT NULL COMMENT '评论内容',
    `parent_id`   bigint(20)   NOT NULL DEFAULT -1 COMMENT '父评论ID',
    `status`      int(11)      NOT NULL DEFAULT 0 COMMENT '状态0未审评 1 审批通过',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='评论';

-- 分类表
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`
(
    `id`          bigint(20) NOT NULL COMMENT '类别id',
    `user_id`     bigint(20) NOT NULL COMMENT '发表用户ID',
    `name`        VARCHAR(32) COMMENT '分类名称',
    `alias`       VARCHAR(32) COMMENT '分类别名',
    `description` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类别描述',
    `parent_id`   bigint(20)                       DEFAULT NULL COMMENT '父分类ID',
    `create_time` datetime   NOT NULL              DEFAULT now() COMMENT '创建时间',
    `status`      int(11)    NOT NULL              DEFAULT 1 COMMENT '分类0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='分类';

-- 标签表
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`
(
    `id`          bigint(20) NOT NULL COMMENT '标签id',
    `user_id`     bigint(20) NOT NULL COMMENT '发表用户ID',
    `name`        VARCHAR(32) COMMENT '标签名称',
    `alias`       VARCHAR(32) COMMENT '标签别名',
    `description` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标签描述',
    `create_time` datetime   NOT NULL              DEFAULT now() COMMENT '创建时间',
    `status`      int(11)    NOT NULL              DEFAULT 1 COMMENT '标签0 已删除 1 未删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='标签';


-- 博文标签关联表
DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label`
(
    `id`         bigint(20) NOT NULL COMMENT 'id',
    `article_id` bigint(20) NOT NULL COMMENT '博文id',
    `label_id`   bigint(20) NOT NULL COMMENT '标签id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='博文标签关系表';
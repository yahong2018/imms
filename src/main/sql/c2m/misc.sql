drop table media;

CREATE TABLE `media`  (
  `record_id`                      char(36)            NOT NULL,
  `media_type`                     varchar(10)         NOT NULL,            -- 类型：Pad需要根据类型来显示图片或者播放视频
  `belong_to_id`                   char(36)            NOT NULL,
  `media_url`                      varchar(255)        NOT NULL,
  `media_name`                     varchar(100)        NOT NULL,
  `media_size`                     int                 NOT NULL,
  `media_description`              varchar(250)        NULL ,

  PRIMARY KEY (`record_id`),
  INDEX IDX_MEDIA_0 (`media_name`),
  INDEX IDX_MEDIA_1 (`belong_to_id`)
) COMMENT = '多媒体';

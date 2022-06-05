package com.alibaba.cloud.users.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @program: alibaba-cloud-parent
 * @description:
 * @author: JianSong Ye
 * @create: 2022-05-17 20:51
 **/
@Data
@TableName("t_user")
public class UserEntity extends Model<UserEntity> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "gender")
    private Integer gender;

    @TableField(value = "telephone")
    private String telephone;

    @TableField(value = "register_date")
    private Date registerDate;

    @TableField(value = "address")
    private String address;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "create_user")
    private String createUser;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "update_user")
    private String updateUser;

    @TableField(value = "status")
    private Integer status;


}

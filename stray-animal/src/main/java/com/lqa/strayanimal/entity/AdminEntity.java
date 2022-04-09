package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 管理员
 * @author 10411
 */
@Data
@TableName("admin")
@ApiModel
public class AdminEntity implements Serializable, UserDetails {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "管理员名")
    private String username;

    @ApiModelProperty(notes = "头像")
    private String avatar;

    @ApiModelProperty(notes = "密码")
    private String password;

    @ApiModelProperty(notes = "邮箱")
    private String mail;

    @ApiModelProperty(notes = "状态")
    private boolean enabled;

    @ApiModelProperty(notes = "角色组")
    private List<RoleEntity> roleEntityList;

    /**
     * 返回用户所有角色
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roleEntityList.size());
        for (RoleEntity roleEntity : roleEntityList) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return authorities;
    }

    /**
     * 账号是否过期
     * @return true未过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否锁定
     * @return true未锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     * @return true未过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

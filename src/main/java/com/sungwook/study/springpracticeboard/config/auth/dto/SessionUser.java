package com.sungwook.study.springpracticeboard.config.auth.dto;

import com.sungwook.study.springpracticeboard.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    // 인증된 사용자 정보 저장
    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}

package com.liuencier.security.core.social.connect;

import com.liuencier.security.core.social.api.QQ;
import com.liuencier.security.core.social.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class QQAdapter implements ApiAdapter<QQ> {
    // 测试 api 是否可用
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        // values 包含 connection 需要的数据项
        QQUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl());
        values.setProfileUrl(null); // 主页地址
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }
    // 在微博这种可以使用---do nothing
    @Override
    public void updateStatus(QQ api, String message) {

    }
}

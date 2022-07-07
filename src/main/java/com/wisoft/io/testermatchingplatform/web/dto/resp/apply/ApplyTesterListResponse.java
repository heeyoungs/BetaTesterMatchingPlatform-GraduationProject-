package com.wisoft.io.testermatchingplatform.web.dto.resp.apply;

import com.wisoft.io.testermatchingplatform.domain.apply.Apply;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplyTesterListResponse {
    private String testerName;
    private boolean isApprove;

    public static ApplyTesterListResponse from(final Apply apply){
        boolean isApprove = false;
        if (apply.getPermissionTime() != null) isApprove = true;
        return new ApplyTesterListResponse(
                apply.getTester().getNickname(),
                isApprove
        );
    }
}

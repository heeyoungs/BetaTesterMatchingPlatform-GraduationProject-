package com.wisoft.io.testermatchingplatform.web.dto.resp.apply;

import com.wisoft.io.testermatchingplatform.domain.apply.Apply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ApplyTesterDetailResponse {

    private Date registerTime;
    private boolean isApprove;
    private String testerName;
    private String requireConditionSubmitRef;
    private String preferenceConditionSubmitRef;

    public static ApplyTesterDetailResponse from(final Apply apply){
        boolean isApprove = false;
        if (apply.getPermissionTime() != null) isApprove =true;
        return new ApplyTesterDetailResponse(
                apply.getRegisterTime(),
                isApprove,
                apply.getTester().getNickname(),
                apply.getRequireConditionSubmitRef(),
                apply.getPreferenceConditionSubmitRef()
        );
    }
}

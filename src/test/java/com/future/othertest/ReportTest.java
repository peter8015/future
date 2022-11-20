package com.future.othertest;

import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.rds.v3.RdsClient;
import com.huaweicloud.sdk.rds.v3.model.ListSlowLogsRequest;
import com.huaweicloud.sdk.rds.v3.model.ListSlowLogsResponse;
import com.huaweicloud.sdk.rds.v3.region.RdsRegion;

public class ReportTest {

    public static void main(String[] args) {
        String ak = "CJIZZZUGAYPVQZFLXDB3";
        String sk = "FfGcAy9DJK4BjvNnfYNhJH2kVjZs4qNGiPYvJ4mH";

        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        RdsClient client = RdsClient.newBuilder()
                .withCredential(auth)
                .withRegion(RdsRegion.valueOf("cn-north-4"))
                .build();w
        ListSlowLogsRequest request = new ListSlowLogsRequest();
        request.withInstanceId("c6566e65489c44b0936936ba1a71caa2in01");
        request.withStartDate("2022-10-01T10:41:14+0800");
        request.withEndDate("2022-10-25T10:41:14+0800");

        try {
            ListSlowLogsResponse response = client.listSlowLogs(request);
            System.out.println(response.toString());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }
}


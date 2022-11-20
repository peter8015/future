package com.future.service;


/* 导入依赖模块 */
// 日志打印
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 认证信息
import com.huaweicloud.sdk.core.auth.BasicCredentials;
// 服务响应异常类
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
// Http配置
import com.huaweicloud.sdk.core.http.HttpConfig;
import com.huaweicloud.sdk.vpc.v2.VpcClient;
// 导入 request 和 response 类
import com.huaweicloud.sdk.vpc.v2.model.ListVpcsRequest;
import com.huaweicloud.sdk.vpc.v2.model.ListVpcsResponse;


public class TestHw {
    private static final Logger logger = LoggerFactory.getLogger(TestHw.class);

    public static void listVpcs(VpcClient client) {
        try {
            // 实例化ListVpcsRequest请求对象，调用listVpcs接口
            ListVpcsResponse listVpcsResponse = client.listVpcs(new ListVpcsRequest().withLimit(1));
            // 输出json格式的字符串响应
            logger.info(listVpcsResponse.toString());
        } catch (ServiceResponseException e) {
            logger.error("HttpStatusCode: " + e.getHttpStatusCode());
            logger.error("RequestId: " + e.getRequestId());
            logger.error("ErrorCode: " + e.getErrorCode());
            logger.error("ErrorMsg: " + e.getErrorMsg());
        }
    }

    public static void main(String[] args) {
        String ak = "00uMxmmvKeHhozaY";
        String sk = "WWMkvSS6rzjLtWHl2L16JAHFJgV9ueJnJpbCRH3ZVJ8KksPxcS4Ad1hBrVpYcKkqG18IZmkSoluyk9z1Ph3IkpNO8ogyEsKZia5EaTea7eNrBYu3A6uZlPOAinyTPZX4mzaQF4o4AiHUIuA6voSS3LtjpI2AQFwVxOUOxAyOybtdcCcz2laLBGAB0h1BCvFmzEzjbzI6Hf6qalgGOI7SMsbMKX2hSLtaLqQD0uqu0fdnr7NDUMuC8wnXw3S75sXm";
        String endpoint = "cn-north-4";
        String projectId = "{your project id}";

        // 配置客户端属性
        HttpConfig config = HttpConfig.getDefaultHttpConfig();
        config.withIgnoreSSLVerification(true);

        // 创建认证
        BasicCredentials auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk)
                .withProjectId(projectId);

        // 创建VpcClient实例
        VpcClient vpcClient = VpcClient.newBuilder()
                .withHttpConfig(config)
                .withCredential(auth)
                .withEndpoint(endpoint)
                .build();

        listVpcs(vpcClient);
    }
}
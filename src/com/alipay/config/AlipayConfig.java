package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016080600181852";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzfCaPDN3/Dm2ujGQ+YwKTIkNocNXZtppJ/k6obUI3wD5oOjIz/JWYHv4q/d6ctQ0AIvpwgSkvluTLYtYA4BqjDaKo6cm2iLkv88KDcKdaTSxspwyP4Ul04x7gwFknmLDVmuZBdaNvCKLDnfXwnGVMWNffW7M8Iqtm4pQ0B6sfow+DKatF+MHmdp5H2CleJ5mb9GdECxKk4O6qAkwjK4Q4aA8Dx/rflB790L6nsZsdbiFNzK7Jrchd5cLgOOn7W1FsgTcLv+LyOF9Q0w196ovdAuVJAsQ+Po0tYlFPbcq6/oPcyH4Nmzg4NvdHcVB7RrVf39d49f8wCthWK6uSwSYtAgMBAAECggEAZ6w7nX9iL3RHGH6RXJPWJeSxqP8cFzBpeHoDNzg8+nT51zxeSTcJtZ+ZUn3nev79LmoF3LxObOWs7Gn/kOvhlvNGVGkOEXhx92fGoCOPFxLiqTPohqcrxe92o32XQc7pvchGXeM0bus/EN0J9VxxCqN6tdKC+iZQeRJBZrhTOOcAYOtukFjCJIOYphE/2bALK2drTeuMZkYdKq7gelO5DAAzz75cYmU2ZzmaVaXO3X8w4I3VUfl5ngR/qlkfP3mEu+TOutBRc7VHW2Ab1RpXXWC7Bs2BIDDx4NCbAAJRfAU7SsZ2SU+nbr09PJVCZJmu/Agse0+0SRY4LHGQJA4wRQKBgQDaASHufbdIIEZCFbhm4+5spEZetf1BAfWLlDDggA3loJEyUpAIXQ7Rr6jQky0dM/CujI+/HMHdeou9V0FE6baLk+g1TIMMtHiFIaqMXDMNg/s0tg2iFptizjrZbUyqyh6gxRzws5/r0gIwE6Zry45TSEtiaxCwML2LJSdyuz6Q9wKBgQDSxF3GezvaRL8xYj2xE9uditFIRS/9Btj/FlvYD7IF9I2ywehX4+0D6gIFhkja+IXkbFJJaQvXCVD9Jn92Npio1psV44TX/9NgJ5L7G67typS8TAARsJnMfMxgbt1cFepd+D7qpMwVV4UZJzzbi1R2Czk2TqIf2Xmdim8aCmIc+wKBgE+oeEiX4T/WozWEkEPwZ2+FOz1iTG7Tk3B0LsPppqpQWJ3Fs2GK915BTHMiRCrWjsyJCgFwNZqDK8p8tpnCuHQaEJBhK8WZsCwdWB8/lVwL7N+e4i5nClI5PyGxoYEKp9RhEikVyYq2yxvcIkRjNddSpFELBCcNOEU+x0JSDxOTAoGAGYTbEdAT9B6Ew7bwX0NXQODw6/4sjEdK+L+9SRDFbkEo8u7VcebP6LxpmD+lDJYwp/KRl//XBidDnhMONcLwgujRCDpu+DQqZKcF/c9hQ7tWfOH61Cl8xayKllZ2CNNCeDQ5cfGYIDFjlSMSFEbvaAd92tx0dsS/G9sKDq4ZKQcCgYAQBDz7jLuve9/oGuAz9nKiYEAl/7zoG/P/2BnQOOP1sKWpObvODUNvrqJ063o1SJCvvoKTNfDOqnZMzl+6R1LnMb+wGqpT8OES78hv62UCwv2wjvpCwow8ZmyLSzDUW+KGnf6Wjj1xkKQS8zgw5Y/aniZotKEYg89g8YC5zUmkag==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxizToFP8AKPtWILj47mOR2aCBwAIHWOM5C4UFAUTjG3F9crbE1zxdgSHZUvso90mxCiDN3//QZs8jCHZ8/vZ8kUkPJe3R7+/xw1RtlX6K45uT9cViT8ZuSIiW3RH/lzCdncbwjU37UVSwQ/yrWlGICWz9+3kv9Z6LpzSgcupZbMSTv6VQSlFdva0Ru1VVHffD1M2DXJzZpwM1aIWpLgi/+Z3yBCG4W/zgjKAZZT47zZPS1JJN1GyKmhIsKKGhkjkv0xNOi8nkapgswLTQS/wUt+uTpiofOw5KTcJsZvJBkgEGglEIm/K9+FNYp+BjPWPqXSaUErLgh60HgP+B9PJpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
/*	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";*/

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/goods/retuenurl";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


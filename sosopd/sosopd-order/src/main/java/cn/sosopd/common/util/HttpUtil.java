
package cn.sosopd.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import cn.sosopd.common.exception.extend.NetworkException;
import cn.sosopd.common.util.StringUtil;
import cn.sosopd.common.util.SystemProperties;
import cn.sosopd.constant.DelimiterConsts;

/**
 * HttpClient 4.5 工具类
 * 
 * @author lcp
 *
 */

public class HttpUtil {
    private static final String CONTENT_TYPE = "Content-Type";

    private static final String CONTENT_TYPE_CHARSET = "charset";

    private static final String SET_COOKIE = "Set-Cookie";

    private static final String LOCATION = "Location";

    private static final String RESPONE_SUCCESS_MESSAGE = "OK";

    /** Http 代理地址 */
    private static final String HTTP_AGENT_ADDRESS_PROPERTY = "http.agent.address";
    /** Http 代理端口 */
    private static final String HTTP_AGENT_PORT_PROPERTY = "http.agent.port";
    /** Http 默认代理端口 */
    private static final int DEFAULT_HTTP_AGENT_PORT = 8888;
    /** Http 默认代理方案 */
    private static final String DEFAULT_HTTP_AGENT_SCHEME = "http";

    /** Https 默认协议 */
    private static final String DEFAULT_HTTPS_PROTOCOL = "TLSv1.2";

    private HttpUtil() {
    }

    private static HttpClient createHttpClient(boolean isSSL) throws NetworkException {
        HttpClientBuilder builder = HttpClientBuilder.create();
        if (isSSL) {
            builder.setSSLContext(believeAllCertificate());
        }
        return builder.build();
    }

    private static void setNecessaryHeader(HttpRequestBase httpMethod) {
        httpMethod.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36");
        httpMethod.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpMethod.setHeader("Accept-Encoding", "gzip, deflate");
        httpMethod.setHeader("Connection", "keep-alive");
        httpMethod.setHeader("Accept", "*/*");
    }

    private static RequestConfig buildRequestConfig() {
        // 设置重定向为false
        Builder configBuilder = RequestConfig.custom().setRedirectsEnabled(false);
        // 代理地址
        String agenAddress = SystemProperties.getProperty(HTTP_AGENT_ADDRESS_PROPERTY);
        if (StringUtils.isNotBlank(agenAddress)) {
            // 设置代理（127.0.0.1）用于抓包工具
            HttpHost proxy = new HttpHost(agenAddress,
                    SystemProperties.getProperty(HTTP_AGENT_PORT_PROPERTY, DEFAULT_HTTP_AGENT_PORT),
                    DEFAULT_HTTP_AGENT_SCHEME);
            configBuilder.setProxy(proxy);
        }

        return configBuilder.build();
    }

    /**
     * 信任 https SSL 所有的证书
     * 
     * @param clientBuilder
     * @throws NetworkException
     */
    private static SSLContext believeAllCertificate() throws NetworkException {
        try {
            return new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).useProtocol(DEFAULT_HTTPS_PROTOCOL).build();
        } catch (Exception e) {
            throw new NetworkException("网络异常-信任证书", e);
        }
    }

    /**
     * 关闭连接
     * 
     * @param method
     * @param response
     * @throws NetworkException
     */
    private static void close(HttpRequestBase method, HttpResponse response) throws NetworkException {

        try {
            if (response != null) {
                EntityUtils.consume(response.getEntity());
            }
            if (method != null) {
                method.releaseConnection();
            }
        } catch (IOException e) {
            throw new NetworkException("网络异常", e);
        }
    }

    private static void isUrl(String url) throws NetworkException {
        if (StringUtils.isBlank(url)) {
            throw new NetworkException(String.format("请求地址异常,%s", url));
        }
    }

    private static void setHeander(HttpRequestBase method, Map<String, String> headers) {
        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                method.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    private static UrlEncodedFormEntity paramsMapToObj(Map<String, String> params) {
        List<NameValuePair> parameters = new ArrayList<>();
        if (null != params) {
            for (String key : params.keySet()) {
                parameters.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        return new UrlEncodedFormEntity(parameters, Consts.UTF_8);
    }

    private static HttpResEntity getRquestResultData(HttpResponse response) throws ParseException, IOException {
        HttpResEntity resEntity = new HttpResEntity();
        Header contentType = response.getFirstHeader(CONTENT_TYPE);
        if (null != contentType) {
            String[] arr = contentType.getValue().split(DelimiterConsts.SEMICOLON);
            for (String e : arr) {
                if (e.contains(CONTENT_TYPE_CHARSET)) {
                    resEntity.setCharset(e.split(DelimiterConsts.EQUAL)[1]);
                    break;
                }
            }
        }
        resEntity.setByteData(EntityUtils.toByteArray(response.getEntity()));
        resEntity.setStatus(response.getStatusLine().getStatusCode());
        resEntity.setCookieHeaders(response.getHeaders(SET_COOKIE));
        if (response.getFirstHeader(LOCATION) != null) {
            resEntity.setLocation(response.getFirstHeader(LOCATION).getValue());
        }
        resEntity.setMsg(RESPONE_SUCCESS_MESSAGE);
        return resEntity;
    }

    /**
     * 请求逻辑的公共方法 （请求体的设置放在各个具体方法中 get没有请求体的设置）
     * 
     * @param isSSL
     *            http or https
     * @param hasDefaultHeader
     *            是否设置默认请求头
     * @param url
     *            请求路径（仅仅是路径,不包含请求数据的部分）
     * @param methods
     *            请求url 的方式 (包含请求体中的数据)
     * @param headers
     *            请求的头
     * @param urlParams
     *            请求的路径上的参数
     * @return
     * @throws NetworkException
     */
    private static HttpResEntity baseRequest(boolean isSSL, boolean hasDefaultHeader, String url,
            HttpRequestBase methods, Map<String, String> headers, Map<String, String> urlParams)
            throws NetworkException {
        HttpResponse response = null;
        try {
            isUrl(url);
            HttpClient httpClient = createHttpClient(isSSL);
            if (urlParams != null) {
                url = StringUtil.appendStr(url, DelimiterConsts.QUESTION,
                        EntityUtils.toString(paramsMapToObj(urlParams)));
            }
            methods.setURI(URI.create(url));
            methods.setConfig(buildRequestConfig());
            if (hasDefaultHeader) {
                setNecessaryHeader(methods);
            }
            setHeander(methods, headers);
            response = httpClient.execute(methods);
            if (response == null) {
                throw new NetworkException("网络异常:返回 null");
            }
            int state = response.getStatusLine().getStatusCode();
            if (state != HttpStatus.SC_OK && state != HttpStatus.SC_MOVED_TEMPORARILY
                    && state != HttpStatus.SC_SEE_OTHER) {
                throw new NetworkException(String.format("url:%s,请求状态异常，status:%s", url, state));
            }
            return getRquestResultData(response);
        } catch (NetworkException e) {
            throw e;
        } catch (Exception e) {
            throw new NetworkException("网络异常", e);
        } finally {
            close(methods, response);
        }
    }

    private static HttpResEntity postBase(boolean isSSL, boolean hasDefaultHeader, String url,
            Map<String, String> headers, Map<String, String> urlParams, HttpEntity params) throws NetworkException {
        HttpPost post = new HttpPost();
        post.setEntity(params);
        return baseRequest(isSSL, hasDefaultHeader, url, post, headers, urlParams);
    }

    /**
     * Map<String,String> put 请求
     * 
     * @throws NetworkException
     */
    public static HttpResEntity post(boolean isSSL, boolean hasDefaultHeader, String url, Map<String, String> headers,
            Map<String, String> urlParams, Map<String, String> params) throws NetworkException {
        return postBase(isSSL, hasDefaultHeader, url, headers, urlParams, paramsMapToObj(params));
    }

    /**
     * String put 请求
     * 
     * @throws NetworkException
     */
    public static HttpResEntity post(boolean isSSL, String url, Map<String, String> headers,
            Map<String, String> urlParams, String params) throws NetworkException {
        StringEntity entity = new StringEntity(params, Consts.UTF_8);
        return postBase(isSSL, true, url, headers, urlParams, entity);
    }

    /**
     * 一个文件上传 post
     * 
     * @throws NetworkException
     */
    public static HttpResEntity doPostUpLoad(boolean isSSL, String url, Map<String, String> headers, String name,
            InputStream fileStream, String fileType, Map<String, String> otherParmes) throws NetworkException {
        // 传入文件
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        if (fileStream != null) {
            builder.addBinaryBody(name, fileStream, ContentType.create(fileType), System.currentTimeMillis() + ".jpg");
        }
        // 其他参数
        if (null != otherParmes) {
            for (String key : otherParmes.keySet()) {
                StringBody paramsName = new StringBody(otherParmes.get(key),
                        ContentType.create("text/plain", Consts.UTF_8));
                builder.addPart(key, paramsName);
            }
        }
        return postBase(isSSL, true, url, headers, null, builder.build());
    }

    /**
     * byte 数组 pust
     * 
     * @throws NetworkException
     */
    public static HttpResEntity doPost(boolean isSSL, String url, Map<String, String> headers, byte[] bytes)
            throws NetworkException {
        return postBase(isSSL, true, url, headers, null, new ByteArrayEntity(bytes));
    }

    private static HttpResEntity putBase(boolean isSSL, boolean hasDefaultHeader, String url,
            Map<String, String> headers, Map<String, String> urlParams, HttpEntity params) throws NetworkException {
        HttpPut put = new HttpPut();
        put.setEntity(params);
        return baseRequest(isSSL, hasDefaultHeader, url, put, headers, urlParams);
    }

    public static HttpResEntity put(boolean isSSL, boolean hasDefaultHeader, String url, Map<String, String> headers,
            Map<String, String> urlParams, Map<String, String> params) throws NetworkException {
        return putBase(isSSL, hasDefaultHeader, url, headers, urlParams, paramsMapToObj(params));
    }

    public static HttpResEntity put(boolean isSSL, String url, Map<String, String> headers,
            Map<String, String> urlParams, String params) throws NetworkException {
        StringEntity entity = new StringEntity(params, Consts.UTF_8);
        return putBase(isSSL, true, url, headers, urlParams, entity);
    }

    public static HttpResEntity put(boolean isSSL, String url, Map<String, String> headers,
            Map<String, String> urlParams, byte[] bytes) throws NetworkException {
        return putBase(isSSL, true, url, headers, urlParams, new ByteArrayEntity(bytes));
    }

    public static HttpResEntity get(boolean isSSL, boolean hasDefaultHeader, String url, Map<String, String> headers,
            Map<String, String> urlParams) throws NetworkException {
        return baseRequest(isSSL, hasDefaultHeader, url, new HttpGet(), headers, urlParams);
    }

}

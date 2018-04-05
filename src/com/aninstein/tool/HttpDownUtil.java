package com.aninstein.tool;

import com.aninstein.po.Common;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTTP工具类.
 *
 * @author 慈祥的昌老师
 */
public class HttpDownUtil {

    String fileName;

    String path;

    String url;


    public String getFileName() {
        return fileName;
    }

    public HttpDownUtil setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getPath() {
        return path;
    }

    public HttpDownUtil setPath(String path) {
        this.path = path;
        return this;
    }

    //随机名称
    public HttpDownUtil setCasualPath() {
        this.path = Common.DOWNFILEPATH+new Date().getTime();
        CreateFileUtil.createDir(this.path);
        return this;
    }

    public String getUrl() {
        return url;
    }

    public String getPathAndFileName() {
        return path+"\\"+fileName;
    }

    public HttpDownUtil setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getFileNameByUrl(){
        if(this.url!=null&&!this.url.equals("")){
            String regEx = ".+/(.+)$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(this.url);
            if (!m.find()) {
                return new Date().getTime()+".xls";//返回一个按照时间来排序的名字
            }
            return m.group(1);
        }
        return null;
    }

    public void download() throws IOException {
        downloadFile(this.path+"\\"+this.fileName,this.url);
    }

    /**
     * 默认编码方式 -UTF8
     */
    private static final String DEFAULT_ENCODE = "utf-8";


    /**
     * 构造方法
     */
    public HttpDownUtil() {
        // empty constructor for some tools that need an instance object of the
        // class
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url 请求地址
     * @return 内容字符串
     */
    public static String getUrlAsString(String url) throws Exception {
        return getUrlAsString(url, null, DEFAULT_ENCODE);
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 内容字符串
     */
    public static String getUrlAsString(String url, Map<String, String> params) throws Exception {
        return getUrlAsString(url, params, DEFAULT_ENCODE);
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param encode 编码方式
     * @return 内容字符串
     */
    public static String getUrlAsString(String url, Map<String, String> params, String encode) throws Exception {
        // 开始时间
        long t1 = System.currentTimeMillis();
        // 获得HttpGet对象
        HttpGet httpGet = getHttpGet(url, params, encode);
        // 调试信息
        System.out.println("url:" + url);
        System.out.println("params:" + params.toString());
        System.out.println("encode:" + encode);
        // 发送请求
        String result = executeHttpRequest(httpGet, null);
        // 结束时间
        long t2 = System.currentTimeMillis();
        // 调试信息
        System.out.println("result:" + result);
        System.out.println("consume time:" + ((t2 - t1)));
        // 返回结果
        return result;
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url 请求地址
     * @return 内容字符串
     */
    public static String postUrlAsString(String url) throws Exception {
        return postUrlAsString(url, null, null, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 内容字符串
     */
    public static String postUrlAsString(String url, Map<String, String> params) throws Exception {
        return postUrlAsString(url, params, null, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url       请求地址
     * @param params    请求参数
     * @param reqHeader 请求头内容
     * @return 内容字符串
     * @throws Exception
     */
    public static String postUrlAsString(String url, Map<String, String> params, Map<String, String> reqHeader) throws Exception {
        return postUrlAsString(url, params, reqHeader, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url       请求地址
     * @param params    请求参数
     * @param reqHeader 请求头内容
     * @param encode    编码方式
     * @return 内容字符串
     * @throws Exception
     */
    public static String postUrlAsString(String url, Map<String, String> params, Map<String, String> reqHeader, String encode) throws Exception {
        // 开始时间
        long t1 = System.currentTimeMillis();
        // 获得HttpPost对象
        HttpPost httpPost = getHttpPost(url, params, encode);
        // 发送请求
        String result = executeHttpRequest(httpPost, reqHeader);
        // 结束时间
        long t2 = System.currentTimeMillis();
        // 调试信息
        System.out.println("url:" + url);
        System.out.println("params:" + params.toString());
        System.out.println("reqHeader:" + reqHeader);
        System.out.println("encode:" + encode);
        System.out.println("result:" + result);
        System.out.println("consume time:" + ((t2 - t1)));
        // 返回结果
        return result;
    }

    /**
     * 获得HttpGet对象
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param encode 编码方式
     * @return HttpGet对象
     */
    private static HttpGet getHttpGet(String url, Map<String, String> params, String encode) {
        StringBuffer buf = new StringBuffer(url);
        if (params != null) {
            // 地址增加?或者&
            String flag = (url.indexOf('?') == -1) ? "?" : "&";
            // 添加参数
            for (String name : params.keySet()) {
                buf.append(flag);
                buf.append(name);
                buf.append("=");
                try {
                    String param = params.get(name);
                    if (param == null) {
                        param = "";
                    }
                    buf.append(URLEncoder.encode(param, encode));
                } catch (UnsupportedEncodingException e) {
                    System.out.println("URLEncoder Error,encode=" + encode + ",param=" + params.get(name)+"  Exception:"+e.getMessage());
                }
                flag = "&";
            }
        }
        HttpGet httpGet = new HttpGet(buf.toString());
        return httpGet;
    }

    /**
     * 获得HttpPost对象
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param encode 编码方式
     * @return HttpPost对象
     */
    private static HttpPost getHttpPost(String url, Map<String, String> params, String encode) {
        HttpPost httpPost = new HttpPost(url);
        if (params != null) {
            List<NameValuePair> form = new ArrayList<NameValuePair>();
            for (String name : params.keySet()) {
                form.add(new BasicNameValuePair(name, params.get(name)));
            }
            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, encode);
                httpPost.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                System.out.println("UrlEncodedFormEntity Error,encode=" + encode + ",form=" + form+"  Exception:"+e.getMessage());
            }
        }
        return httpPost;
    }

    /**
     * 执行HTTP请求
     *
     * @param request   请求对象
     * @param reqHeader 请求头信息
     * @return 内容字符串
     */
    private static String executeHttpRequest(HttpUriRequest request, Map<String, String> reqHeader) throws Exception {
        HttpClient client = null;
        String result = null;
        try {
            // 创建HttpClient对象
            client = new DefaultHttpClient();
            // 设置连接超时时间
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60);
            // 设置Socket超时时间
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 36600);
            // 设置请求头信息
            if (reqHeader != null) {
                for (String name : reqHeader.keySet()) {
                    request.addHeader(name, reqHeader.get(name));
                }
            }
            // 获得返回结果
            HttpResponse response = client.execute(request);
            // 如果成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
            }
            // 如果失败
            else {
                StringBuffer errorMsg = new StringBuffer();
                errorMsg.append("httpStatus:");
                errorMsg.append(response.getStatusLine().getStatusCode());
                errorMsg.append(response.getStatusLine().getReasonPhrase());
                errorMsg.append(", Header: ");
                Header[] headers = response.getAllHeaders();
                for (Header header : headers) {
                    errorMsg.append(header.getName());
                    errorMsg.append(":");
                    errorMsg.append(header.getValue());
                }
                System.out.println("HttpResonse Error:" + errorMsg);
            }
        } catch (Exception e) {
            System.out.println("http连接异常"+"  Exception:"+e.getMessage());
            throw new Exception("http连接异常");
        } finally {
            try {
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
                System.out.println("finally HttpClient shutdown error"+"  Exception:"+e.getMessage());
            }
        }
        return result;
    }

    /**
     * 下载文件保存到本地
     *
     * @param path 文件保存位置
     * @param url  文件地址
     * @throws IOException
     */
    public static void downloadFile(String path,String url) throws IOException {
        System.out.println("path:" + path);
        System.out.println("url:" + url);
        HttpClient client = null;
        try {
            // 创建HttpClient对象
            client = new DefaultHttpClient();
            // 获得HttpGet对象
            HttpGet httpGet = getHttpGet(url, null, null);
            // 发送请求获得返回结果
            HttpResponse response = client.execute(httpGet);
            // 如果成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                byte[] result = EntityUtils.toByteArray(response.getEntity());
                BufferedOutputStream bw = null;
                try {
                    // 创建文件对象
                    File f = new File(path);
                    // 创建文件路径
                    if (!f.getParentFile().exists()) f.getParentFile().mkdirs();
                    // 写入文件
                    bw = new BufferedOutputStream(new FileOutputStream(path));
                    bw.write(result);
                } catch (Exception e) {
                    System.out.println("保存文件错误,path=" + path + ",url=" + url+"  Exception:"+e.getMessage());
                } finally {
                    try {
                        if (bw != null) bw.close();
                    } catch (Exception e) {
                        System.out.println("finally BufferedOutputStream shutdown close"+"  Exception:"+e.getMessage());
                    }
                }
            }
            // 如果失败
            else {
                StringBuffer errorMsg = new StringBuffer();
                errorMsg.append("httpStatus:");
                errorMsg.append(response.getStatusLine().getStatusCode());
                errorMsg.append(response.getStatusLine().getReasonPhrase());
                errorMsg.append(", Header: ");
                Header[] headers = response.getAllHeaders();
                for (Header header : headers) {
                    errorMsg.append(header.getName());
                    errorMsg.append(":");
                    errorMsg.append(header.getValue());
                }
                System.out.println("HttpResonse Error:" + errorMsg);
            }
        } catch (ClientProtocolException e) {
            System.out.println("下载文件保存到本地,http连接异常,path=" + path + ",url=" + url+"  Exception:"+e.getMessage());
            throw e;
        } catch (IOException e) {
            System.out.println("下载文件保存到本地,文件操作异常,path=" + path + ",url=" + url+"  Exception:"+e.getMessage());
            throw e;
        } finally {
            try {
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
                System.out.println("finally HttpClient shutdown error"+"  Exception:"+e.getMessage());
            }
        }
    }
}
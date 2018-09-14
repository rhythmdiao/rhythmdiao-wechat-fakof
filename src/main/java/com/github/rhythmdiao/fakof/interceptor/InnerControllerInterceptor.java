package com.github.rhythmdiao.fakof.interceptor;

import com.github.rhythmdiao.fakof.WechatConfig;
import com.github.rhythmdiao.fakof.util.CheckUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rhyth
 * 业务控制器拦截器
 */
@Component
public class InnerControllerInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(InnerControllerInterceptor.class);

    @Resource
    private WechatConfig wechatConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final String signature = request.getParameter("signature");
        final String timestamp = request.getParameter("timestamp");
        final String nonce = request.getParameter("nonce");
        final String echostr = request.getParameter("echostr");
        final String method = request.getMethod();
        if (Strings.isBlank(signature) || Strings.isBlank(timestamp) || Strings.isBlank(nonce)) {
            LOG.info("invalid request");
            return false;
        }

        if (HttpMethod.GET.matches(method) && Strings.isBlank(echostr)) {
            LOG.info("empty echostr");
            return false;
        }

        return CheckUtil.checkSignature(wechatConfig.getToken(), signature, timestamp, nonce);
    }
}

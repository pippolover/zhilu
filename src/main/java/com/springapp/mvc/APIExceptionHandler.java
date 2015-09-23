/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.springapp.mvc;

import com.springapp.mvc.api.APIResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author midang
 * @version $Id: APIExceptionHandler.java, v 0.1 2014年12月18日 下午3:35:10 midang Exp $
 */
public abstract class APIExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(APIExceptionHandler.class);

    @ExceptionHandler({ Throwable.class })
    protected APIResult exception(Throwable e) {

        String messageId = String.format("APIException[id=%d]", System.currentTimeMillis());
        logger.error(messageId, e);

        String errorMessageSummary = StringUtils.isEmpty(e.getMessage()) ? e.getClass()
            .getSimpleName() : e.getMessage();

        return new APIResult(false, String.format("%s: %s", messageId, errorMessageSummary));
    }
}

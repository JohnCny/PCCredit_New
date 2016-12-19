package com.cardpay.basic.common.propertyeditor;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.beans.PropertyEditorSupport;

/**
 * 类型转化类,防止跨脚本攻击，往web页面注入html代码或者script代码
 * @author johnmyiqn on 2016-10-10 16:54
 **/
public class StringEscapeEditor extends PropertyEditorSupport {
    /**
     * 编码HTML
     */
    private boolean escapeHTML;
    /**
     * 编码JavaScript
     */
    private boolean escapeJavaScript;

    public StringEscapeEditor() {
        super();
    }

    public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript) {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    @Override
    public void setAsText(String text){
        if (text == null) {
            setValue(null);
        } else {
            String value = text;
            if (escapeHTML) {
                value = HtmlUtils.htmlEscape(value);
            }
            if (escapeJavaScript) {
                value = JavaScriptUtils.javaScriptEscape(value);
            }
            setValue(value);
        }
    }
}

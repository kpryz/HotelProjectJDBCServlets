package com.lv339.service;

import javax.servlet.http.HttpServletRequest;

public class MessageForOutput {
    private static MessageType msgType;
    private static String msg;

    public static void setMessageToRequest(HttpServletRequest request) {
        if (msgType == MessageType.MSG_ERROR) {
            request.setAttribute("Error", msg);
        } else {
            request.setAttribute("Msg", msg);
        }
    }

    public static MessageType getMsgType() {
        return msgType;
    }

    public static void setMsgTypeError() {
        MessageForOutput.msgType = MessageType.MSG_ERROR;
    }

    public static void setMsgTypeInfo() {
        MessageForOutput.msgType = MessageType.MSG_INFO;
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        MessageForOutput.msg = msg;
    }
}

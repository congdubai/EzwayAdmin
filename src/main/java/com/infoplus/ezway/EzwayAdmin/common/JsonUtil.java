package com.infoplus.ezway.EzwayAdmin.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {

    }

    // Tạo ObjectNode
    public static ObjectNode genNode() {
        return objectMapper.createObjectNode();
    }

    public static ObjectNode toObjectNode(String jsonString) throws JsonProcessingException {
        return (ObjectNode) objectMapper.readTree(jsonString);
    }

    public static ObjectMapper objectMapper() {
        return objectMapper;
    }

    // Phương thức để chuyển đổi đối tượng thành chuỗi JSON với định dạng đẹp
    @SneakyThrows
    public static String toPrettyJson(Object object) {
        if (object == null) {
            return null;
        }

        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE); // Use system line feed indenter

        return objectMapper.writer(prettyPrinter).writeValueAsString(object);
    }

}

package cn.sosopd.common.validator;

import java.util.HashMap;
import java.util.Map;

public class BeanValidatorResult {

    public boolean result = true;

    public final Map<String, String> messages = new HashMap<String, String>();

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void addMessage(String property, String message) {
        messages.put(property, message);
    }

}
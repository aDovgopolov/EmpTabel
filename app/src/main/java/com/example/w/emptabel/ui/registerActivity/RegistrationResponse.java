package com.example.w.emptabel.ui.registerActivity;

 import com.google.gson.annotations.Expose;
 import com.google.gson.annotations.SerializedName;
 import java.util.List;

public class RegistrationResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("error_msg")
    @Expose
    private String errorMsg;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
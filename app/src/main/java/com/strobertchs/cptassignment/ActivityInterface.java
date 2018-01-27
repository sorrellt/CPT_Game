package com.strobertchs.cptassignment;

import java.sql.ResultSet;

public interface ActivityInterface {
    public void onLogin();
    public void onLoginFail();
    public void onRegister();
    public void onRegisterFail();
    public void eventConfirm();
    public void onmondayload(ResultSet rs);
    public void ontuesdayload(ResultSet rs);
    public void onwednesdayload(ResultSet rs);
    public void onthursdayload(ResultSet rs);
    public void onfridayload(ResultSet rs);
}

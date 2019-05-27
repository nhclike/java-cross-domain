package com.nhc.ajaxserver;

public class ResultBean {
   private String data;

   public ResultBean(String data){
       this.setData(data);
   }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

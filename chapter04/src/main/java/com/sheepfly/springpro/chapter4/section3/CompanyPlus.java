package com.sheepfly.springpro.chapter4.section3;

import org.example.beans.entity.Company;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CompanyPlus extends Company implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        if (super.getName() == null) {
            System.out.println("没有公司名称，将设置为默认名称");
            super.setName("张三的公司");
        } else {
            System.out.println("公司名称:" + super.getName());
        }
    }

    @Override
    public void destroy() throws Exception {
        super.setName("end");
        System.out.println("销毁完成 com.sheepfly.springpro.chapter4.section3.CompanyPlus.destroy");
    }
}

package com.ex.views;

import com.ex.service.TestService;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("request")
//@RequestScoped
//@ManagedBean
//@ViewScoped
public class BasicView {

    @Autowired
    TestService testService;

    public BasicView() {
        System.out.println("creating");
    }

    public TreeNode getRoot() {
        return testService.getRoot();
    }
}

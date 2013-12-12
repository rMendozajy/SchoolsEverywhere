package com.searchschool.jsf.web;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="WELCOME")
@SessionScoped
public class WelcomeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> images;

    public WelcomeManagedBean() {
        images = new ArrayList<String>();
        images.add("inicial1.jpg");
        images.add("secundaria1.jpg");
        images.add("inicial2.jpg");
        images.add("inicial3.jpg");
        images.add("inicial5.jpg");
        images.add("inicial6.jpg");
        images.add("inicial7.jpg");
        
    }

    public List<String> getImages() {
        return images;
    }
}
        
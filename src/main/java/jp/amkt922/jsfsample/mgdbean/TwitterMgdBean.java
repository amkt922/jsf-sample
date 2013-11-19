/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.amkt922.jsfsample.mgdbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Size;

/**
 *
 * @author p
 */
@ManagedBean
@RequestScoped
public class TwitterMgdBean {
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 過去のつぶやき
     */
    private static final List<String> tweets = new ArrayList<String>();
    /**
     * つぶやき
     */
    @Size(min = 0, max = 140, message = "140文字以内で入力してください")
    private String tweet;
    /**
     * Creates a new instance of TwitterMgdBean
     */
    public TwitterMgdBean() {
    }

    public String getTweet() { return tweet; }

    public void setTweet(String tweet) { this.tweet = tweet; }

    public List<String> tweets() { return this.tweets; }

    public String doTweet() {
        this.tweets.add(this.tweet);
        this.tweet = "";
        return "";
    }
}

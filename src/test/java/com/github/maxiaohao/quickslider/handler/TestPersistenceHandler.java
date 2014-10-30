package com.github.maxiaohao.quickslider.handler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.maxiaohao.quickslider.model.Container;
import com.github.maxiaohao.quickslider.model.Item;
import com.github.maxiaohao.quickslider.model.Slide;

public class TestPersistenceHandler {

    @Before
    public void setUp() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }


    @Test
    public final void test() {
        // mocking
        Container ret = new Container();

        ret.addStyle("position", "relative");
        ret.addStyle("top", "0px");
        ret.addStyle("left", "0px");
        ret.addStyle("width", "680px");
        ret.addStyle("height", "320px");

        Slide s1 = new Slide();
        s1.setSlideId(1);
        s1.setSlideName("aaa");
        s1.setToolTip("zzzzz");
        s1.setDisplayOrder(110);
        s1.addStyle("background-image", "url(http://58.210.71.181/sandbox/centered-logo/ct-logo-mid.png)");
        s1.addStyle("background-repeat", "no-repeat;");

        Item item11 = new Item();
        item11.setHtml("<p>11 进口量接口送</p>");
        item11.addStyle("position", "absolute");
        item11.addStyle("left", "30px");
        item11.addStyle("top", "20px");
        item11.addStyle("border", "2px solid black");
        item11.addStyle("background", "#89D955");
        item11.addStyle("width", "200px");
        item11.addStyle("height", "20px");
        s1.addItem(item11);

        Item item12 = new Item();
        item12.setHtml("<a href='#'>12 a link</a>");
        item12.addStyle("position", "absolute");
        item12.addStyle("left", "200px");
        item12.addStyle("top", "70px");
        s1.addItem(item12);

        ret.addSlide(s1);

        Slide s2 = new Slide();
        s1.setSlideId(2);
        s1.setSlideName("bbb");
        s1.setToolTip("zzzzz!!");
        s1.setDisplayOrder(120);

        Item item21 = new Item();
        item21.setHtml("21 <table border=1><tr><td>zzz</td></tr></table><p>离开</p>家<b>速度快</b>理发加<a href=''>3rd_l45453453453454354ink</a>");
        item21.addStyle("position", "absolute");
        item21.addStyle("left", "300px");
        item21.addStyle("top", "3px");
        item21.addStyle("border", "2px solid black");
        item21.addStyle("background", "orange");
        item21.addStyle("width", "3350px");
        item21.addStyle("height", "8px");
        s2.addItem(item21);

        Item item22 = new Item();
        item22.setHtml("22 <a href='#'><h2>another link</h2></a>");
        item22.addStyle("position", "absolute");
        item22.addStyle("left", "400px");
        item22.addStyle("top", "80px");
        s2.addItem(item22);

        ret.addSlide(s2);

        PersistenceHandler.getInstance().addContainer(ret);
        PersistenceHandler.getInstance().saveAll();
    }

}

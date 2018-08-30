package com.github.rhythmdiao.fakof;

import com.github.rhythmdiao.domain.menu.Menu;
import com.github.rhythmdiao.service.fakof.RoomService;
import com.github.rhythmdiao.util.LocalCache;
import com.github.rhythmdiao.util.client.HttpPostClient;
import com.github.rhythmdiao.util.client.HttpProperty;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);

    @Value("${wechat.url}")
    private String url;

    @Resource
    private RoomService roomService;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void createMenu() throws InterruptedException {
        Thread.sleep(3000);
        Menu menu = new Menu();
        Menu.Button button1 = new Menu.Button();
        button1.setName("test");
        Menu.Button subButton1 = new Menu.Button();
        subButton1.setName("subtest");
        subButton1.setType("sacncode_waitmsg");
        subButton1.setKey("rselfmenu_0_0");
        subButton1.setSub_button(new ArrayList<>());
        List<Menu.Button> sub_button = Lists.newArrayList();
        sub_button.add(subButton1);
        button1.setSub_button(sub_button);
        List<Menu.Button> button = Lists.newArrayList();
        button.add(button1);
        menu.setButton(button);
        String parameter = GSON.toJson(menu);

        HttpPostClient httpPostClient = new HttpPostClient("https", url);
        HttpProperty httpProperty = new HttpProperty();
        httpProperty.setBody(parameter);
        String response = httpPostClient.execute("/menu/create?access_token=" + String.valueOf(LocalCache.get("access_token")), httpProperty);
        Map map = GSON.fromJson(response, HashMap.class);
        LOG.info(map.toString());
    }

    @Test
    public void createRoom() throws InterruptedException {

    }
}

package com.example.rank.service.serviceimpl;

import com.example.rank.model.rank;
import com.example.rank.param.RankParam;
import com.example.rank.service.rankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class rankServiceImplTest {
    @Resource
    private rankService rankService;
    @Test
    public void getRankByType() {
        RankParam rankParam=new RankParam();
        rankParam.setSortType("heat");
        List<rank> list=rankService.getRankByType(rankParam);
        List<rank> list2=rankService.getRankByHeat();
        for(rank rank:list){
            System.out.print(rank.getHeat());
        }
        System.out.print("**************************************************");
        for(rank rank:list2){
            System.out.print(rank.getHeat());
        }
    }
}
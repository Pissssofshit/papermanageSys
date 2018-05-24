package com.example.rank.service.serviceimpl;

import com.example.rank.dao.rankMapper;

import com.example.rank.model.rank;
import com.example.rank.param.RankParam;
import com.example.rank.service.rankService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class rankServiceImpl implements rankService {
    @Resource
    private rankMapper rankMapper;
    @Override
    public List<rank> getRankByType(RankParam rankParam) {
     /*   System.out.print(rankParam.getSortType());*/
        return rankMapper.getRankBySortType(rankParam.getSortType());



    }

    @Override
    public List<rank> getRankByHeat() {

        List<rank> ranks=new ArrayList<>();

        ranks=rankMapper.getRank();
        for(int i=0;i<ranks.size();i++){
            rank rank=(rank)ranks.get(i);

            Random random = new Random();
            rank.setHeat(rank.getHeat()*(random.nextInt(100)+1));
            System.out.print(rank.getHeat()+"qqqqqqqqqqqqqqqqqqqqqqq");
            rankMapper.updateHeat(rank.getId(),rank.getHeat());
        }
        Collections.sort(ranks, new Comparator<rank>() {
            @Override
            public int compare(rank o1, rank o2) {
                if(o1.getHeat()<o2.getHeat()){
                    return 1;
                }
                if(o1.getHeat()==o2.getHeat()){
                    return 0;
                }
                return -1;
            }
        });

        return ranks;
    }

}

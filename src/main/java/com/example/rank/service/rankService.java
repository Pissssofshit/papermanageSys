package com.example.rank.service;



import com.example.rank.model.rank;
import com.example.rank.param.RankParam;

import java.util.List;

public interface rankService {
        List<rank> getRankByType(RankParam rankParam);
        List<rank> getRankByHeat();
}

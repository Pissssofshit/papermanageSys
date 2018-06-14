package com.example.rank.service.serviceimpl;

import com.example.rank.dao.LogCheckPaperMapper;
import com.example.rank.model.LogCheckPaper;
import com.example.rank.param.LogCheckPaperParam;
import com.example.rank.service.LogCheckPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LogCheckPaperServiceImpl implements LogCheckPaperService {
    @Resource
    LogCheckPaperMapper logCheckPaperMapper;


    @Override
    public List<LogCheckPaper> getLogs(LogCheckPaperParam param) {

        return logCheckPaperMapper.getLogs(param);
    }

    @Override
    public void addLogs(LogCheckPaperParam param) {
        logCheckPaperMapper.add(param);
    }

    @Override
    public int getTotal() {
        return  logCheckPaperMapper.gettotal();
    }
}

package com.example.rank.service;

import com.example.rank.model.LogCheckPaper;
import com.example.rank.param.LogCheckPaperParam;

import java.util.List;

public interface LogCheckPaperService {
    List<LogCheckPaper> getLogs(LogCheckPaperParam param);
    void addLogs(LogCheckPaperParam param);
    int getTotal();
}

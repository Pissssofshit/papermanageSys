package com.example.rank.dao;

import com.example.rank.model.LogCheckPaper;
import com.example.rank.param.LogCheckPaperParam;

import java.util.List;

public interface LogCheckPaperMapper {
   List<LogCheckPaper> getLogs(LogCheckPaperParam param);
   void add(LogCheckPaperParam param);
   int gettotal();
}
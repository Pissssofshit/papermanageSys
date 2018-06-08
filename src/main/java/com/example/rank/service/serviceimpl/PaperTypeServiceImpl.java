package com.example.rank.service.serviceimpl;

import com.example.rank.dao.PaperTypeMapper;
import com.example.rank.model.PaperType;
import com.example.rank.param.AddPaperTypeParam;
import com.example.rank.param.DeletePaperTypeParam;
import com.example.rank.service.PaperTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperTypeServiceImpl implements PaperTypeService {
    @Resource
    PaperTypeMapper paperTypeMapper;
    @Override
    public void addPaperType(AddPaperTypeParam param) {
         paperTypeMapper.add(param);
    }

    @Override
    public void deletePaperType(DeletePaperTypeParam param) {
        paperTypeMapper.delete(param);
    }

    @Override
    public List<PaperType> getPaperTypes(Long userId) {
        return paperTypeMapper.getPaperTypes(userId);
    }
}

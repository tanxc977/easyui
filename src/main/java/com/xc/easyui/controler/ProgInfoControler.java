package com.xc.easyui.controler;

import com.xc.easyui.dao.ProgInfoRepository;
import com.xc.easyui.entity.ProgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  *@className ProgInfoControler
  *@author xc
  *@date 2019/1/19 21:57
  *@description TODO
  *@version 1.0
  **/
@Controller
@RequestMapping("/prog")
public class ProgInfoControler {

    @Autowired
    private ProgInfoRepository progInfoRepository;

    @ResponseBody
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam(value = "ids") String ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String[] idsStr = ids.split(",");

        for (int i = 0; i < idsStr.length; i++) {
            progInfoRepository.deleteById(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);

        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Map<String, Object> save(ProgInfo progInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        progInfoRepository.save(progInfo);
        resultMap.put("success", true);
        return resultMap;
    }

//    @ResponseBody
//    @RequestMapping("/list2")
//    public Map<String,Object> progInfoList(ProgInfo progInfo, @RequestParam(value = "page", required = false) Integer page,
//                                           @RequestParam(value = "rows", required = false) Integer rows){
//        Sort sort = new Sort(Sort.Direction.DESC, "progName");
//        Pageable pageable = PageRequest.of(page-1, rows, sort);
//
//        List<ProgInfo> progInfoList;
//        Page<ProgInfo> progInfos;
//        Long count;
//        if(progInfo.getProgName() != null  && !"".equals(progInfo.getProgName())){
//            progInfos = progInfoRepository.findAllByProgName(progInfo.getProgName(),pageable);
//            count = progInfoRepository.countByProgName(progInfo.getProgName());
//        }else {
//            Specification<ProgInfo> sprog = new Specification<ProgInfo>() {
//                @Override
//                public Predicate toPredicate(Root<ProgInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                    return null;
//                }
//            };
//            progInfos = progInfoRepository.findAll(sprog,pageable);
//            count = progInfoRepository.count(sprog);
//        }
//
//        progInfoList = progInfos.getContent();
//
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap.put("rows", progInfoList);
//        resultMap.put("total", count);
//        resultMap.put("success", true);
//        return resultMap;
//
//    }

    @RequestMapping("/crud")
    public String getProgInfoCrud(){
        return "progInfoCrud";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> progInfoList2(ProgInfo progInfo, @RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "rows", required = false) Integer rows){

        Pageable pageable = PageRequest.of(page-1, rows);

        Page<ProgInfo> progInfos = progInfoRepository.findAll(ProgInfoSpecification.getSpecification(progInfo),pageable);

        long count = progInfos.getTotalElements();

        List<ProgInfo> progInfoList = progInfos.getContent();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", progInfoList);
        resultMap.put("total", count);
        resultMap.put("success", true);
        return resultMap;

    }
}

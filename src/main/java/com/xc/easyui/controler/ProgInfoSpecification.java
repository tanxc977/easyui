package com.xc.easyui.controler;

import com.xc.easyui.entity.ProgInfo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
  *@className ProgInfoSpecification
  *@author xc
  *@date 2019/1/20 15:14
  *@description TODO
  *@version 1.0
  **/
public class ProgInfoSpecification {


    public static Specification<ProgInfo> getSpecification(ProgInfo progInfo){
        return new Specification<ProgInfo>() {
            @Override
            public Predicate toPredicate(Root<ProgInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!= progInfo.getProgName() && !"".equals(progInfo.getProgName())){
                    list.add(criteriaBuilder.equal(root.get("progName").as(String.class),progInfo.getProgName()));

                }
                if(null!= progInfo.getAuthor() && !"".equals(progInfo.getAuthor())){
                    list.add(criteriaBuilder.equal(root.get("author").as(String.class),progInfo.getAuthor()));

                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}

package com.xc.easyui.dao;

import com.xc.easyui.entity.ProgInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author xc
 * @version 1.0
 * @className ProgInfoRepository
 * @description TODO
 * @date 2019/1/19 21:56
 **/
@Transactional
public interface ProgInfoRepository extends PagingAndSortingRepository<ProgInfo, Integer>, JpaSpecificationExecutor<ProgInfo> {
    Page<ProgInfo> findAllByProgName(String progName, Pageable pageable);
    Long countByProgName(String progName);
    ProgInfo findProgInfoBySeqNo(Integer seqNo);

    @Override
    Page<ProgInfo> findAll(Specification<ProgInfo> sprog, Pageable pageable);
}

package com.xhh.sell_lx.repository;

import com.xhh.sell_lx.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 廖师兄
 * 2017-07-23 23:04
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}

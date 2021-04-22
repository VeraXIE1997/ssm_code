package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

public interface PromotionAdService {
    /**
     * 分页查询广告信息
     * @return
     */
    PageInfo<PromotionAd> findAllAdByPage(PromotionAdVO promotionAdVO);

    /**
     * 添加广告
     * @param promotionAd
     */
    void savePromotionAd(PromotionAd promotionAd);

    /**
     * 修改广告
     * @param promotionAd
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 广告动态上下线
     * @param id
     * @param status
     */
    void  updatePromotionAdStatus(int id,int status);

    /**
     * 根据id查询广告信息
     * @param id
     * @return
     */
    PromotionAd findPromotionAdById(int id);
}

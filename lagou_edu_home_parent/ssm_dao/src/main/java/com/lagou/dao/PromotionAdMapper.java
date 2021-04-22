package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {
    /**
     * 分页查询广告信息
     * @return
     */
    List<PromotionAd> findAllAdByPage();

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
     * @param promotionAd
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);

    /**
     * 根据id回显广告信息
     * @param id
     * @return
     */
    PromotionAd findPromotionAdById(int id);
}

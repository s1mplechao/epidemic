package coronavirus.dao;

import coronavirus.bean.Sign;

public interface SignDao {
    /**
     * 保存签到信息
     * 
     * @param sign 签到信息
     * @return 是否成功
     */
    int saveSign(Sign sign);

    /**
     * 保存签到信息
     * 
     * @param sign 签到信息
     * @return 是否成功
     */
    int saveSignHB(Sign sign);

    /**
     * 更新签到信息
     * 
     * @param sign 签到信息
     * @return 是否成功
     */
    int updateSign(Sign sign);

    /**
     * 查询签到信息
     * 
     * @param ybUserid 易班id
     * @return 签到信息
     */
    Sign getSign(String ybUserid);
}

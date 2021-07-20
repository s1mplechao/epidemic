package coronavirus.dao;

import java.util.List;

import coronavirus.bean.Message;
import coronavirus.bean.Msg;

public interface MessageDao {
    /**
     * 获取所有通知
     * 
     * @return 通知List
     */
    List<Msg> listMsgs(String ybUserid);

    /**
     * 获取某个通知
     * 
     * @param id 通知id
     * @return 通知
     */
    Msg getMsg(String ybUserid, int id);

    /**
     * 统计学院阅读通知数
     * 
     * @param ybCollegename 学院
     * @param id            通知id
     * @return 学院阅读数量
     */
    int countCollegeReadMsg(String ybCollegename, int id);

    /**
     * 添加通知阅读记录
     * 
     * @param message 阅读信息
     */
    int saveMessage(Message message);

}

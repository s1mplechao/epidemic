package coronavirus.bean;

import java.util.Date;

/**
 * 通知
 *
 * @author hui
 */
public class Msg {
    // 通知ID
    private Integer id;
    // 通知标题
    private String title;
    // 发布时间
    private Date date;
    // 通知内容
    private String content;
    // 是否已读
    private int isRead;

    public Msg() {
        // 初始化阅读状态为0
        this.isRead = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Msg [id=" + id + ", title=" + title + ", date=" + date + ", isRead=" + isRead + "]";
    }

}

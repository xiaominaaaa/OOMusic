package cn.OOMusic.pojo;

import java.util.List;

/**
 * 返回结果类
 * @param <T> 返回的结果
 */
public class Example<T> {
    private List<T> list;
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
}

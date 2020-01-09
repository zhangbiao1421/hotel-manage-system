package com.imooc.jxc.common;


import java.util.List;

/**
 * 分页实体
 * Created by CH on 2016/2/26.
 */
public class PageInfo<T> extends com.github.pagehelper.PageInfo {


    public PageInfo() {
        super();
    }

    public PageInfo(List<T> list) {
        super(list);
    }

    public PageInfo(List<T> list, int navigatePages) {
        super(list, navigatePages);
    }

    private int pageIndex;


    @Override
    public int getPageNum() {
        if (super.getPageNum() == 0)
            return 1;
        return super.getPageNum();
    }

    @Override
    public int getPageSize() {
        if (super.getPageSize() == 0)
            return 10;
        return super.getPageSize();
    }

    public int getPageIndex() {
        int index = getPageNum();
        if (index > 0)
            return index - 1;
        return getPageNum();
    }

    public void setPageIndex(int pageIndex) {
        pageIndex = +1;
        setPageNum(pageIndex);
    }
}
